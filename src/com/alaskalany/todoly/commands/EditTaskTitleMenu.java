package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class EditTaskTitleMenu {

  private Integer taskIndex;
  private TaskManager taskManager;

  public EditTaskTitleMenu(Integer taskIndex, TaskManager taskManager) {
    this.taskIndex = taskIndex;
    this.taskManager = taskManager;
  }

  public void invoke() {
    // prompt user for input
    System.out.print("New title: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    taskManager.getTask(taskIndex).setTitle(input);
    System.out.println("Task title modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();

  }
}
