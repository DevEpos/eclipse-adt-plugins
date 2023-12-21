package com.sap.adt.methodeditor.ui.internal.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import com.sap.adt.tools.abapsource.ui.sources.editors.AbapSourceSinglePageEditor;
import com.sap.adt.tools.abapsource.ui.sources.editors.IAbapSourcePage;
import com.sap.adt.tools.core.content.AdtObjectContentHandler;

@SuppressWarnings("restriction")
public class ClassMethodEditor extends AbapSourceSinglePageEditor {
  private IFile file;
  // private IAdtFunctionModuleFileServices functionModuleFileService;
  // private IAdtFunctionGroupFileServices functionGroupFileService;

  public ClassMethodEditor() {
    file = null;
    // this.functionModuleFileService = null;
    // this.functionGroupFileService = null;
    // this.functionModuleFileService =
    // FunctionsPlugin.getDefault().createAdtFunctionModuleFileServices();
    // this.functionGroupFileService =
    // FunctionsPlugin.getDefault().createAdtFunctionGroupFileServices();
  }

  public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
    file = getFileForEditorInput(input);
    project = file.getProject();
    // final IFile modelFile = this.getModelFile();
    // try {
    // SfsUtilFactory.createSfsUtil()
    // .addDevelopmentObjectToSfs(modelFile, (IProgressMonitor) new NullProgressMonitor());
    // super.init(site, input);
    // this.setPartName(this.getEditorTitle());
    // } catch (final PartInitException e) {
    // throw e;
    // } catch (final Exception e2) {
    // throw new PartInitException(e2.getLocalizedMessage(), (Throwable) e2);
    // }

  }

  public IAbapSourcePage createAdtPage(final int pageIndex) {
    // return (IAbapSourcePage) new FunctionModuleSourcePage((AbapSourceMultiPageEditor) this);
    return null;
  }

  public boolean supportsOutline() {
    return true;
  }

  public String getFeatureNameForInitialCheck() {
    throw new IllegalStateException("unexpected case. Method should never be called");
  }

  public List<String> getFeatureNamesForInitialCheck() {
    final List<String> features = new ArrayList<String>();
    features.add("functionModules");
    features.add("functions");
    return features;
  }

  public String getFeatureNamespaceForInitialCheck() {
    return "COM.SAP.ADT.FUNCTIONS";
  }

  public IFile getSourceFile() {
    try {
      return this.getFunctionModuleSourceFile(this.getFunctionGroupName(),
          this.getFunctionModuleName());
    } catch (final Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  public IFile getModelFile() {
    // if (this.project == null || this.file == null) {
    // return null;
    // }
    // try {
    // return this.getFunctionModulePropertiesFile(this.getFunctionGroupName(),
    // this.getFunctionModuleName());
    // } catch (final Exception e) {
    // throw new IllegalStateException(e.getMessage(), e);
    // }
    return null;
  }

  private String getFunctionModuleName() {
    // return this.functionModuleFileService.getFunctionModuleName(this.file);
    return "";
  }

  private String getFunctionGroupName() {
    // return this.functionGroupFileService.getDecodedSourceBasedObjectName(this.file);
    return "";
  }

  private IFile getFunctionModuleSourceFile(final String functionGroupName,
      final String functionModuleName) throws CoreException {
    // return this.functionModuleFileService.getFunctionModuleSourceFile(this.project,
    // this.getFunctionGroupName(), this.getFunctionModuleName(), false);
    return null;
  }

  private IFile getFunctionModulePropertiesFile(final String functionGroupName,
      final String functionModuleName) throws CoreException {
    // return this.functionModuleFileService.getFunctionModulePropertiesFile(this.project,
    // this.getFunctionGroupName(), this.getFunctionModuleName(), false);
    return null;
  }

  protected AdtObjectContentHandler<?> getAdtObjectContentHandler() {
    // return (AdtObjectContentHandler<?>) FunctionsPlugin.getDefault()
    // .createFunctionModuleContentHandler();
    return null;
  }

  public boolean isNonMainObject() {
    return true;
  }

  public List<IFile> getAllFiles() {
    // try {
    // final List<IFile> allFiles = new ArrayList<IFile>();
    // IFile file = this.file;
    // if (file == null) {
    // file = this.getCompoundFile();
    // }
    // if (file == null) {
    // return Collections.emptyList();
    // }
    // final IContainer folder = file.getParent();
    // if (folder.exists()) {
    // folder.accept((IResourceVisitor) new IResourceVisitor() {
    // public boolean visit(final IResource resource) throws CoreException {
    // if (resource instanceof IFile) {
    // allFiles.add(resource);
    // }
    // return true;
    // }
    // }, 1, 0);
    // }
    // return allFiles;
    // } catch (final Exception e) {
    // throw new RuntimeException(e);
    // }
    return null;
  }
}