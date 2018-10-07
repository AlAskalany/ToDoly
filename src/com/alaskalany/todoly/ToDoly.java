package com.alaskalany.todoly;

import com.alaskalany.todoly.parsing.DateParserModule;
import com.alaskalany.todoly.todo.projectlist.ProjectListModule;
import com.alaskalany.todoly.todo.tasklist.TaskListModule;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import com.alaskalany.todoly.todo.taskmanager.TaskManagerModule;
import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.UiModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 */
public class ToDoly {

  /**
   * @param args Arguments
   */
  public static void main(String[] args) {

    Injector injector = Guice
        .createInjector(new TaskManagerModule(), new TaskListModule(), new ProjectListModule(),
            new UiModule(), new DateParserModule());
    TaskManager taskManager = injector.getInstance(TaskManager.class);
    Ui ui = injector.getInstance(Ui.class);
    ui.mainMenu();
  }
}
