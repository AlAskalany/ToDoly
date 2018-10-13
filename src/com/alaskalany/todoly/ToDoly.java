package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;

/**
 *
 */
public class ToDoly {

  private static final TaskManager taskManager = new TaskManager();

  /**
   * @param args Arguments
   */
  public static void main(String[] args) {

    new MainMenu(taskManager).invoke();

  }
}
