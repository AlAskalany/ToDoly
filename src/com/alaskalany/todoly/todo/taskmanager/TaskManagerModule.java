package com.alaskalany.todoly.todo.taskmanager;

import com.google.inject.AbstractModule;

public class TaskManagerModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(TaskManager.class).to(TaskManagerImpl.class);
  }
}
