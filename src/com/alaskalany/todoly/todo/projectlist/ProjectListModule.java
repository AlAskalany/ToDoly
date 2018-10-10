package com.alaskalany.todoly.todo.projectlist;

import com.google.inject.AbstractModule;

public class ProjectListModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(ProjectList.class).to(ProjectListImpl.class);
  }
}
