package com.devepos.adt.cst.ui.internal.codesearch;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.content.PlainTextContentHandler;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.codesearch.result.CodeSearchResult;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;
import com.sap.adt.communication.message.HeadersFactory;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.ris.model.facets.IFacetsFactory;
import com.sap.adt.ris.model.virtualfolders.IObject;
import com.sap.adt.ris.model.virtualfolders.IVirtualFolder;
import com.sap.adt.ris.model.virtualfolders.IVirtualFoldersResult;
import com.sap.adt.ris.search.objectproperties.AdtRisVfsObjectPropertiesServiceFactory;
import com.sap.adt.ris.search.virtualfolders.AdtRisVirtualFoldersServiceFactory;
import com.sap.adt.ris.search.virtualfolders.IAdtRisVirtualFoldersRequestParameters;
import com.sap.adt.tools.core.atom.AdtAtomUtilFactory;
import com.sap.adt.tools.core.atom.IAdtAtomUtil;
import com.sap.adt.tools.core.model.util.ServiceNotAvailableException;

/**
 * Code search query that is using only available ADT API's from SAP
 */
@SuppressWarnings("restriction")
public class ClientBasedCodeSearchQuery extends AbstractCodeSearchQuery {

  private IAdtAtomUtil atomUtil;

  public ClientBasedCodeSearchQuery(CodeSearchQuerySpecification querySpecs) {
    super(querySpecs);
    this.searchResult = new CodeSearchResult(this);
    this.atomUtil = AdtAtomUtilFactory.createAtomUtil();
  }

  @Override
  public boolean canRerun() {
    return super.canRerun();
  }

  @Override
  public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
    ((CodeSearchResult) getSearchResult()).reset();
    finished = false;

    var startTime = System.currentTimeMillis();

    var destination = DestinationUtil.getDestinationId(getProject());

    monitor.beginTask("", 100);

    // fetch packages for current scope
    var packageSearchMonitor = monitor.slice(5);
    packageSearchMonitor.beginTask("", 5);
    monitor.setTaskName("Determine Scope...");
    var packages = new PackageLoader(destination, monitor, getQuerySpecs()).loadPackages();
    packageSearchMonitor.worked(5);
    int objectCount = packages.stream()
        .reduce(0, (subTotal, p) -> subTotal + p.getObjectCount(), Integer::sum);
    searchResult.setObjectScopeCount(objectCount);

    var numJobs = CodeSearchUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ICodeSearchPrefs.MAX_CLIENT_SEARCH_JOBS);
    var chunks = splitList(packages, (int) Math.ceil((double) packages.size() / numJobs));

    var executor = Executors.newFixedThreadPool(numJobs);
    List<Future<IStatus>> futures = new ArrayList<>();
    // monitor.beginTask("Searching Objects", objectCount);

    var objectMonitor = monitor.slice(95);
    objectMonitor.beginTask("", objectCount);
    monitor.setTaskName(String.format("Searching objects... (%d packages)", chunks.size()));

    try {
      for (var chunk : chunks) {
        futures.add(executor.submit(() -> runSearchTask(objectMonitor, destination, chunk)));
      }

      for (Future<IStatus> future : futures) {
        IStatus result = future.get(); // Wait for each to finish
        if (!result.isOK()) {
          return result; // Fail fast
        }
      }

      System.out.println("Duration: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
      finished = true;
      return Status.OK_STATUS;
    } catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
      if (e.getCause() instanceof OperationCanceledException) {
        return Status.CANCEL_STATUS;
      }
      return new Status(IStatus.ERROR, CodeSearchUIPlugin.PLUGIN_ID,
          "Error during parallel execution", e);
    } finally {
      executor.shutdown();
    }

  }

  private static <T> List<List<T>> splitList(List<T> list, int chunkSize) {
    List<List<T>> chunks = new ArrayList<>();
    for (int i = 0; i < list.size(); i += chunkSize) {
      chunks.add(list.subList(i, Math.min(list.size(), i + chunkSize)));
    }
    return chunks;
  }

  private IStatus runSearchTask(IProgressMonitor m, String destination, List<AdtPackage> chunk) {
    var codeSearchResult = ICodeSearchFactory.eINSTANCE.createCodeSearchResult();
    try {

      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destination);
      var pattern = Pattern.compile(getQuerySpecs().getPatterns().split(System.lineSeparator())[0]);

      var matchCount = 0;
      var searchedLines = 0;
      var searchedObjects = 0;
      var searchedSources = 0;

      for (var p : chunk) {
        var objects = new PackageContentLoader(destination, m, querySpecs).loadObjects(p);
        for (var o : objects) {
          var uri = atomUtil.findAtomLinkAsUri(o.getLinks(),
              "http://www.sap.com/adt/relations/objects");
          var searchObject = ICodeSearchFactory.eINSTANCE.createCodeSearchObject();
          searchObject.setUri(uri.toString());
          var adtMainObj = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
          adtMainObj.setType(IAdtObjectTypeConstants.CLASS);
          adtMainObj.setName(o.getName());
          adtMainObj.setUri(uri.toString());
          searchObject.setAdtMainObject(adtMainObj);

          var getClassContent = URI.create(uri.toString() + "/source/main");
          var resource = AdtRestResourceFactory.createRestResourceFactory()
              .createRestResource(getClassContent, session);
          resource.addContentHandler(new PlainTextContentHandler());
          var headerField = HeadersFactory.newField("Accept", new String[] { "text/plain" });
          var requestHeaders = HeadersFactory.newHeaders();
          requestHeaders.addField(headerField);
          var source = resource.get(m, requestHeaders, String.class);

          var sourceLines = source.split("\r\n");
          for (int i = 0; i < sourceLines.length; i++) {
            var line = sourceLines[i];
            final var matcher = pattern.matcher(line);
            while (matcher.find()) {
              var begin = matcher.start();
              var endOffset = matcher.end();
              var match = ICodeSearchFactory.eINSTANCE.createCodeSearchMatch();
              match.setUri(String.format("%s#start=%d,%d;end=%d,%d", getClassContent.toString(),
                  i + 1, begin, i + 1, endOffset));
              match.setSnippet(line);
              searchObject.getMatches().add(match);
              matchCount++;
            }
          }
          // final var matcher = pattern.matcher(source);
          // while (matcher.find()) {
          // var group = matcher.group();
          // var begin = matcher.start();
          // var endOffset = matcher.end();
          // matchCount.set(matchCount.get() + 1);
          // }
          m.worked(1);
          searchedObjects++;
          searchedSources++;
          searchedLines += sourceLines.length;
          if (!searchObject.getMatches().isEmpty()) {
            codeSearchResult.getSearchObjects().add(searchObject);
          }
        }
      }
      codeSearchResult.setNumberOfResults(matchCount);
      codeSearchResult.setLinesOfSearchedCode(searchedLines);
      codeSearchResult.setNumberOfSearchedObjects(searchedObjects);
      codeSearchResult.setNumberOfSearchedSources(searchedSources);
    } finally {
      ((CodeSearchResult) getSearchResult()).addResult(codeSearchResult, -1);
    }
    return Status.OK_STATUS;
  }

  private List<AdtPackage> getPackageHierarchy(String uri, IProgressMonitor m, String destination) {
    try {
      var objectPropertiesService = AdtRisVfsObjectPropertiesServiceFactory
          .createVfsObjectPropertiesService(destination);
      var packageFacet = IFacetsFactory.eINSTANCE.createFacet();
      packageFacet.setKey("package");
      var objProperties = objectPropertiesService.readObjectProperties(URI.create(uri),
          List.of(packageFacet), m);
      return objProperties.getObjectPropertiesForFacet("package")
          .stream()
          .map(p -> new AdtPackage(p.uri.toString(), p.name, p.displayName, 0, null))
          .collect(Collectors.toList());

    } catch (ServiceNotAvailableException e) {
      e.printStackTrace();
    }
    return null;
  }

  private class AdtObject {
    private String uri;
    private String name;
    private String type;
    private AdtPackage parent;
    private String displayName;

    public AdtObject(String uri, String name, String displayName, String type, AdtPackage parent) {
      this.uri = uri;
      this.name = name;
      this.displayName = displayName;
      this.type = type;
      this.parent = parent;
    }

    public String getUri() {
      return uri;
    }

    public String getName() {
      return name;
    }

    public AdtPackage getParent() {
      return parent;
    }
  }

  private interface ISubObjectLoader {
    void load(IProgressMonitor monitor, String destination, CodeSearchQuerySpecification specs);
  }

  private class AdtPackage extends AdtObject {
    private int objectCount;
    private List<AdtPackage> subPackages;
    private boolean hasSubPackages;
    private List<AdtPackage> hierarchy;
    private ISubObjectLoader subPackageLoader;

    public AdtPackage(String uri, String name, String displayName, int objectCount,
        AdtPackage parent) {
      super(uri, name, displayName, IAdtObjectTypeConstants.PACKAGE, parent);
      this.objectCount = objectCount;
    }

    public boolean isHasSubPackages() {
      return hasSubPackages;
    }

    public void setHasSubPackages(boolean hasSubPackages) {
      this.hasSubPackages = hasSubPackages;
    }

    public void setSubPackageLoader(ISubObjectLoader loader) {
      this.subPackageLoader = loader;
    }

    public ISubObjectLoader getSubPackageLoader() {
      return subPackageLoader;
    }

    public int getObjectCount() {
      return objectCount;
    }

    public List<AdtPackage> getSubPackages() {
      if (subPackages == null) {
        subPackages = new ArrayList<>();
      }
      return subPackages;
    }

    public void setHierarchy(List<AdtPackage> hierarchy) {
      this.hierarchy = hierarchy;
    }

    public List<AdtPackage> getHierarchy() {
      return hierarchy;
    }

  }

  private class ScopeService {
    private String destination;
    private CodeSearchQuerySpecification specs;
    private IProgressMonitor monitor;
    private List<String> excludedFilters;

    public ScopeService(String destination, IProgressMonitor monitor,
        CodeSearchQuerySpecification specs) {
      this.destination = destination;
      this.monitor = monitor;
      this.specs = specs;
    }

    public void setExcludedFilters(List<String> excludedFilters) {
      this.excludedFilters = excludedFilters;
    }

    public IAdtRisVirtualFoldersRequestParameters buildFolderRequestParams() {
      var params = AdtRisVirtualFoldersServiceFactory.createVirtualFolderRequestParameters();
      var objectNames = specs.getObjectNames().split(" ");
      if (objectNames.length > 0) {
        params.setObjectSearchPattern(objectNames[0]);
      } else {
        params.setObjectSearchPattern("*");
      }
      specs.getObjectScopeFilters().forEach((key, value) -> {
        if (excludedFilters != null && excludedFilters.contains(key)) {
          return;
        }
        var values = ((String) value).split(",");
        if (FilterName.PACKAGE.getUriParamName().equals(key)) {
          Stream.of(values)
              .forEach(v -> params.addPreselection(FilterName.PACKAGE.getContentAssistName(), v));
          // } else if (FilterName.OBJECT_TYPE.getUriParamName().equals(key)) {
          // Stream.of(values)
          // .forEach(
          // v -> params.addPreselection(FilterName.OBJECT_TYPE.getContentAssistName(), v));
        } else if (FilterName.OWNER.getUriParamName().equals(key)) {
          Stream.of(values)
              .forEach(v -> params.addPreselection(FilterName.OWNER.getUriParamName(), v));
        }
      });
      params.addPreselection("type", "clas");
      // if (!specs.getObjectScopeFilters().containsKey(FilterName.OBJECT_TYPE.getUriParamName())) {
      // // add all possible types to type filter
      // CodeSearchRelevantWbTypesUtil.getPossibleValuesForTypeFilter(getProject())
      // .forEach(type -> params.addPreselection(FilterName.OBJECT_TYPE.getContentAssistName(),
      // type));
      // }
      return params;
    }

    public IVirtualFoldersResult fetchFolderContent(IAdtRisVirtualFoldersRequestParameters params) {
      try {
        System.out.println("Fetching virtual folder content " + params.toString());
        var service = AdtRisVirtualFoldersServiceFactory
            .createVirtualFoldersSearchService(destination);
        // var info = service.getInfo(params, monitor);
        return service.getContent(params, monitor);
      } catch (ServiceNotAvailableException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }
  }

  private class PackageLoader {
    private ScopeService scopeService;
    private IProgressMonitor monitor;
    private String destination;

    public PackageLoader(String destination, IProgressMonitor monitor,
        CodeSearchQuerySpecification specs) {
      scopeService = new ScopeService(destination, monitor, specs);
      this.monitor = monitor;
      this.destination = destination;
    }

    public List<AdtPackage> loadPackages() {
      var rootPackages = getRootPackages();
      scopeService.setExcludedFilters(List.of(FilterName.PACKAGE.getUriParamName()));
      for (var pack : rootPackages) {
        getPackageHierarchy(pack.getUri(), scopeService.monitor, scopeService.destination);
      }
      filterDuplicatePackages(rootPackages);
      for (var pack : rootPackages) {
        if (pack.isHasSubPackages()) {
          pack.setSubPackageLoader((monitor, destination, specs) -> getSubPackages(pack,
              new ScopeService(destination, monitor, specs)));
        }
      }

      return rootPackages;
    }

    private void filterDuplicatePackages(List<AdtPackage> rootPackages) {
      // TODO: Ignore for now and live with potential redundant object searches
    }

    private void getSubPackages(AdtPackage pack, ScopeService scopeService) {
      var subPackageReqParams = scopeService.buildFolderRequestParams();
      subPackageReqParams.addPreselection("package", pack.getName());
      subPackageReqParams.setWantedFacets(List.of("package"));
      var subFoldersResponse = scopeService.fetchFolderContent(subPackageReqParams);
      if (subFoldersResponse != null) {
        for (var f : subFoldersResponse.getVirtualFolder()) {
          var subPackage = new AdtPackage(getPackageUri(f), f.getName(), f.getDisplayName(),
              f.getCounter(), null);
          if (f.isHasChildrenOfSameFacet()) {
            subPackage.setHasSubPackages(true);
            getSubPackages(subPackage, scopeService);
          }
          pack.getSubPackages().add(subPackage);
        }
      }
    }

    private List<AdtPackage> getRootPackages() {
      var folderSearchParams = scopeService.buildFolderRequestParams();
      folderSearchParams.setWantedFacets(List.of("package"));
      var packageResponse = scopeService.fetchFolderContent(folderSearchParams);
      List<AdtPackage> packages = new ArrayList<>();
      if (packageResponse != null) {
        for (var f : packageResponse.getVirtualFolder()) {
          // REVISIT: why is this contained in the result???
          if (f.getName().startsWith("..")) {
            continue;
          }
          var uri = getPackageUri(f);
          var p = new AdtPackage(uri, f.getName(), f.getDisplayName(), f.getCounter(), null);
          if (uri != null) {
            var hierarchy = getPackageHierarchy(uri, monitor, destination);
            p.setHierarchy(hierarchy);
          }
          p.setHasSubPackages(f.isHasChildrenOfSameFacet());
          packages.add(p);
        }
      }
      return packages;
    }

    private String getPackageUri(IVirtualFolder f) {
      var uri = atomUtil.findAtomLinkAsUri(f.getLinks(),
          "http://www.sap.com/adt/relations/packages", "application/vnd.sap.sapgui");
      return uri != null ? uri.toString() : null;
    }
  }

  private class PackageContentLoader {

    private ScopeService scopeService;

    public PackageContentLoader(String destination, IProgressMonitor monitor,
        CodeSearchQuerySpecification specs) {
      scopeService = new ScopeService(destination, monitor, specs);
      scopeService.setExcludedFilters(List.of(FilterName.PACKAGE.getUriParamName()));
    }

    public List<IObject> loadObjects(AdtPackage pack) {

      var folderSearchParams = scopeService.buildFolderRequestParams();
      folderSearchParams.addPreselection("package", pack.getName());

      var objectResponse = scopeService.fetchFolderContent(folderSearchParams);
      return objectResponse != null ? objectResponse.getObject() : null;
    }

  }
}