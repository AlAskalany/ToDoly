package com.alaskalany.todoly.todo.tasklist;

import com.google.inject.AbstractModule;

public class TaskListModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(TaskList.class).to(TaskListImpl.class);
  }
}
