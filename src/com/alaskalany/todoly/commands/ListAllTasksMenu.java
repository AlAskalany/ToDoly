package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class ListAllTasksMenu {

  private TaskManager taskManager;

  ListAllTasksMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    // print menu title
    System.out.println("List all tasks by:");
    System.out.println("1- Due date");
    System.out.println("2- Project");

    // prompt user for input
    System.out.print("Enter a choice: ");
    Scanner scanner = new Scanner(System.in);
    String input;
    input = scanner.nextLine();
    handleListAllTasksInput(input);
  }

  /**
   * Handle user selection of due date or project to sort tasks by
   *
   * @param input "1" to sort tasks by due date or "2" to sort tasks by project
   */
  private void handleListAllTasksInput(String input) {

    switch (Integer.valueOf(input)) {
      case 1:
        new ListAllTasksByDueDateMenu(taskManager).invoke();

        break;
      case 2:
        new ListAllTasksByProjectMenu(taskManager).invoke();

        break;
      default:
        break;
    }
  }
}
