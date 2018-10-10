package com.alaskalany.todoly.cli.tasklistduedatemenu;

import com.google.inject.AbstractModule;

public class TaskListDueDateMenuModule extends AbstractModule {

  @Override
  public void configure() {

    bind(TaskListDueDateMenu.class).to(TaskListDueDateMenuImpl.class);
  }
}
