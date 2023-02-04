package com.devepos.adt.base.ui.internal.projectexplorer.node;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.base.ui.projectexplorer.node.IAbapRepositoryFolderNode;

/**
 * Proxy class to access properties of a ABAP repository node
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
class AbapRepositoryFolderProxy implements IAbapRepositoryFolderNode {

  private final IProject project;
  private final String category;
  private final String type;
  private final String user;
  private final List<String> packages;

  public AbapRepositoryFolderProxy(final IProject project, final String category, final String type,
      final String user, final List<String> packages) {
    this.project = project;
    this.category = category;
    this.type = type;
    this.user = user;
    this.packages = packages;
  }

  @Override
  public String getCategory() {
    return category;
  }

  @Override
  public List<String> getPackages() {
    return packages;
  }

  @Override
  public IProject getProject() {
    return project;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public String getUser() {
    return user;
  }

}
