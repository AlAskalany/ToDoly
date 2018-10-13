package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class EditTaskTitleMenu extends Command {

  private Integer taskIndex;

  public EditTaskTitleMenu(Integer taskIndex, TaskManager taskManager) {
    super(taskManager);
    this.taskIndex = taskIndex;
  }

  public void invoke() {
    // prompt user for input

    String input = promptForInput("New title: ");

    taskManager.getTask(taskIndex).setTitle(input);
    print("Task title modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();

  }
}
