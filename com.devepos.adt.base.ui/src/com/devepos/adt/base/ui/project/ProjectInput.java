package com.devepos.adt.base.ui.project;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.internal.AdtBaseUIPlugin;
import com.devepos.adt.base.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.ui.AbapProjectProposalProvider;
import com.sap.adt.tools.core.ui.dialogs.AbapProjectSelectionDialog;
import com.sap.adt.util.ui.SWTUtil;

/**
 * Input composite for entering the name of an ABAP Project
 *
 * @author stockbal
 */
public class ProjectInput {

    private final IAbapProjectProvider projectProvider;
    private Text projectField;
    private DataBindingContext dbc;
    private final List<IValidator<IProject>> projectValidators = new ArrayList<>();

    public ProjectInput() {
        this(new AbapProjectProxy(null));
    }

    public ProjectInput(final IAbapProjectProvider projectProvider) {
        this.projectProvider = projectProvider;

    }

    public IAbapProjectProvider getProjectProvider() {
        return projectProvider;
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

    /**
     * Creates the controls for the project input
     *
     * @param parent the parent composite
     */
    public void createControl(final Composite parent) {
        final Composite projectInputRoot = new Composite(parent, SWT.NONE);
        GridLayoutFactory.swtDefaults().numColumns(3).applyTo(projectInputRoot);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(projectInputRoot);

        final Label projectInputLabel = new Label(projectInputRoot, SWT.NONE);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectInputLabel);
        projectInputLabel.setText(Messages.ProjectInput_Project_xfld);
        SWTUtil.setMandatory(projectInputLabel, true);

        projectField = new Text(projectInputRoot, SWT.BORDER);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(projectField);
        // register project proposal provider
        new AbapProjectProposalProvider(projectField);
        SWTUtil.addTextEditMenu(projectField);

        final Button projectBrowseButton = new Button(projectInputRoot, SWT.PUSH);
        projectBrowseButton.setText(Messages.ProjectInput_BrowseProjects_xbut);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectBrowseButton);
        SWTUtil.setButtonWidthHint(projectBrowseButton);
        projectBrowseButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                final IProject project = projectProvider.getProject();
                final IProject resultProject = AbapProjectSelectionDialog.open(parent.getShell(), project);
                if (resultProject != null) {
                    projectField.setText(resultProject.getName());
                }
            }
        });
        parent.addDisposeListener(e -> {
            if (dbc != null) {
                dbc.dispose();
            }
        });
    }

    /**
     * Creates necessary bindings in the input
     *
     * @return the created context with the bindings
     */
    public DataBindingContext createBindings() {
        if (dbc != null) {
            dbc.dispose();
        }
        dbc = new DataBindingContext();
        return createBindings(dbc);
    }

    /**
     * Creates bindings in the given {@link DataBindingContext}
     *
     * @param dbc the DataBindingContext for the bindings
     */
    public DataBindingContext createBindings(final DataBindingContext dbc) {
        if (dbc == null) {
            return null;
        }

        final IConverter<String, IProject> convertStringToProject = IConverter.create(String.class, IProject.class,
            projectName -> {
                if (projectName == null || "".equals(projectName)) { //$NON-NLS-1$
                    return null;
                }
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
            });
        final UpdateValueStrategy<IProject, String> targetUpdateStrategy = UpdateValueStrategy.create(IConverter.create(
            IProject.class, String.class, project -> project != null ? project.getName() : ""));
        final UpdateValueStrategy<String, IProject> modelUpdateStrategy = UpdateValueStrategy.create(
            convertStringToProject);
        modelUpdateStrategy.setAfterGetValidator(projectName -> {
            if (StringUtil.isBlank(projectName)) {
                return new Status(IStatus.ERROR, AdtBaseUIPlugin.PLUGIN_ID, IStatus.INFO,
                    Messages.ProjectInput_NoProjectEntered_xmsg, null);
            }
            return ValidationStatus.ok();
        });
        modelUpdateStrategy.setAfterConvertValidator(this::validateProject);

        final IObservableValue<String> projectInputTarget = WidgetProperties.text(SWT.Modify).observe(projectField);
        final IObservableValue<IProject> projectModel = PojoProperties.value("project", IProject.class) //$NON-NLS-1$
            .observe(projectProvider);
        dbc.bindValue(projectInputTarget, projectModel, modelUpdateStrategy, targetUpdateStrategy);
        return dbc;
    }

    /**
     * Adds the given validator to the list of project validators
     *
     * @param validator validator which is to be used for project validation
     */
    public void addProjectValidator(final IValidator<IProject> validator) {
        projectValidators.add(validator);
    }

    /*
     * Validates the given project
     */
    private IStatus validateProject(final IProject project) {
        if (project == null) {
            // project does not exist
            return ValidationStatus.error(Messages.ProjectInput_ProjectDoesNotExist_xmsg);
        }
        for (final IValidator<IProject> validator : projectValidators) {
            final IStatus validationStatus = validator.validate(project);
            if (!validationStatus.isOK()) {
                return validationStatus;
            }
        }
        return ValidationStatus.ok();
    }

}
