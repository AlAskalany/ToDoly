package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class EditTaskProjectMenu {

  private Integer taskIndex;
  private TaskManager taskManager;

  public EditTaskProjectMenu(Integer taskIndex,
      TaskManager taskManager) {
    this.taskIndex = taskIndex;
    this.taskManager = taskManager;
  }

  public void invoke() {
    // prompt user for input
    // prompt user for input
    System.out.print("New Project: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (!taskManager.doesProjectExist(input)) {
      taskManager.createProject(input);
    }
    taskManager.addTaskToProject(taskIndex, input);
    System.out.println("Task Project modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();

  }
}
