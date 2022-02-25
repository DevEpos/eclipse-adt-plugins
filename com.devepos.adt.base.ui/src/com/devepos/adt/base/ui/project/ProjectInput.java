package com.devepos.adt.base.ui.project;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.IStatusChangeListener;
import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.ui.AbapProjectProposalProvider;
import com.sap.adt.tools.core.ui.dialogs.AbapProjectSelectionDialog;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;
import com.sap.adt.util.ui.swt.IAdtSWTUtil;

/**
 * Input composite for entering the name of an ABAP Project
 *
 * @author Ludwig Stockbauer-Muhr
 */
@SuppressWarnings("restriction")
public class ProjectInput {

  private final IAbapProjectProvider projectProvider;
  private Text projectField;
  private IProject project;
  private final Set<IValidator<IProject>> projectValidators = new HashSet<>();
  private final Set<IStatusChangeListener> statusChangeListeners = new HashSet<>();
  private boolean ensureLoggedOn;

  /**
   * Creates new project input
   */
  public ProjectInput() {
    this(new AbapProjectProxy(null), false);
  }

  /**
   * Creates new project input
   *
   * @param ensureLoggedOn ensures that the logged on status will also be checked
   *                       if a valid project was chosen
   *
   */
  public ProjectInput(final boolean ensureLoggedOn) {
    this(new AbapProjectProxy(null), ensureLoggedOn);
  }

  /**
   * Creates new project input
   *
   * @param projectProvider ABAP project provider which will be updated from the
   *                        text input of this control
   * @param ensureLoggedOn  ensures that the logged on status will also be checked
   *                        if a valid project was chosen
   */
  public ProjectInput(final IAbapProjectProvider projectProvider, final boolean ensureLoggedOn) {
    if (projectProvider == null) {
      throw new IllegalArgumentException("Parameter 'projectProvider' cannot be null!");
    }
    this.projectProvider = projectProvider;
    this.ensureLoggedOn = ensureLoggedOn;
  }

  /**
   * Adds the given validator to the list of project validators
   *
   * @param validator validator which is to be used for project validation
   */
  public void addProjectValidator(final IValidator<IProject> validator) {
    projectValidators.add(validator);
  }

  /**
   * Adds the given status change listener
   *
   * @param l the listener to be added
   */
  public void addStatusChangeListener(final IStatusChangeListener l) {
    statusChangeListeners.add(l);
  }

  /**
   * Creates the controls for the project input
   *
   * @param parent the parent composite
   */
  public void createControl(final Composite parent) {
    createControl(parent, new Point(0, 0));
  }

  /**
   * Creates the controls for the project input
   *
   * @param parent  the parent composite
   * @param margins the margins for the container that will hold the controls of the project input
   */
  public void createControl(final Composite parent, final Point margins) {
    IAdtSWTUtil swtUtil = AdtSWTUtilFactory.getOrCreateSWTUtil();
    final Composite projectInputRoot = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().margins(margins).numColumns(3).applyTo(projectInputRoot);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, false)
        .applyTo(projectInputRoot);

    final Label projectInputLabel = new Label(projectInputRoot, SWT.NONE);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectInputLabel);
    projectInputLabel.setText(Messages.ProjectInput_Project_xfld);
    swtUtil.setMandatory(projectInputLabel, true);

    projectField = new Text(projectInputRoot, SWT.BORDER);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .grab(true, false)
        .applyTo(projectField);
    // register project proposal provider
    new AbapProjectProposalProvider(projectField);
    swtUtil.addTextEditMenu(projectField);

    projectField.addModifyListener(l -> {
      IStatus projectStatus = validateProject(projectField.getText());
      projectProvider.setProject(project);
      fireStatusChange(projectStatus);
    });

    final Button projectBrowseButton = new Button(projectInputRoot, SWT.PUSH);
    projectBrowseButton.setText(Messages.ProjectInput_BrowseProjects_xbut);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectBrowseButton);
    swtUtil.setButtonWidthHint(projectBrowseButton);
    projectBrowseButton.addSelectionListener(widgetSelectedAdapter(e -> {
      final IProject project = projectProvider.getProject();
      final IProject resultProject = AbapProjectSelectionDialog.open(parent.getShell(), project);
      if (resultProject != null) {
        projectField.setText(resultProject.getName());
      }
    }));
  }

  /**
   * Retrieves the project provider connected to the project input
   *
   * @return the project provider connected to the project input
   */
  public IAbapProjectProvider getProjectProvider() {
    return projectProvider;
  }

  /**
   * Removes the given project validator
   *
   * @param v the validator to be removed
   */
  public void removeProjectValidator(final IValidator<IProject> v) {
    projectValidators.remove(v);
  }

  /**
   * Removes the given status change listener
   *
   * @param l the listener to be removed
   */
  public void removeStatusChangeListener(final IStatusChangeListener l) {
    statusChangeListeners.remove(l);
  }

  /**
   * Sets the given {@code projectName} in the project input field
   *
   * @param projectName the project name to be set in the project input field
   */
  public void setProjectName(final String projectName) {
    final String newProjectNameValue = projectName != null ? projectName : "";
    if (projectField != null && !projectField.isDisposed()) {
      projectField.setText(newProjectNameValue);
    }
  }

  private IProject convertToProject(final String projectName) {
    // check if there is an ABAP project which matches the entered name
    final IProject[] abapProjects = ProjectUtil.getAbapProjects();
    String availableProjectName = null;
    for (final IProject project : abapProjects) {
      if (project.getName().equalsIgnoreCase(projectName)) {
        availableProjectName = project.getName();
        break;
      }
    }
    if (availableProjectName != null) {
      return ResourcesPlugin.getWorkspace().getRoot().getProject(availableProjectName);
    }
    return null;
  }

  private void fireStatusChange(final IStatus projectStatus) {
    for (IStatusChangeListener l : statusChangeListeners) {
      l.statusChanged(projectStatus);
    }
  }

  /*
   * Validates the given project
   */
  private IStatus validateProject(final String projectName) {
    project = null;
    if (StringUtil.isBlank(projectName)) {
      return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
          Messages.ProjectInput_NoProjectEntered_xmsg, null);
    }
    project = convertToProject(projectName);
    if (project == null) {
      // project does not exist
      return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID,
          Messages.ProjectInput_ProjectDoesNotExist_xmsg, null);
    }
    if (ensureLoggedOn) {
      IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(project);
      if (!loggedOnStatus.isOK()) {
        project = null;
        return loggedOnStatus;
      }
    }
    for (final IValidator<IProject> validator : projectValidators) {
      final IStatus validationStatus = validator.validate(project);
      if (!validationStatus.isOK()) {
        project = null;
        return validationStatus;
      }
    }

    return Status.OK_STATUS;
  }
}
