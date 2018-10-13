package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

class AddTaskMenu extends Command {

  AddTaskMenu(TaskManager taskManager) {
    super(taskManager);
  }

  @Override
  public void invoke() {
    // prompt user for input
    String taskTitle = promptForInput("Enter task name:");
    addTask(taskTitle);
    new MainMenu(taskManager).invoke();
  }
}
