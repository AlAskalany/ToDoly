package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

class SaveAndQuit extends Command {

  public SaveAndQuit() {
    this(null);
  }

  private SaveAndQuit(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    System.exit(0);
  }
}
