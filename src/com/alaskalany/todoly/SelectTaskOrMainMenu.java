package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class SelectTaskOrMainMenu {

  private TaskManager taskManager;

  SelectTaskOrMainMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    // prompt user for input
    // prompt user for input
    System.out.print("Enter task number to edit or 0 for main menu");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    handleSelectTaskOrMainMenu(input);
  }

  /**
   * Go to main menu if input is "0" or edit a task of a given index
   *
   * @param input User input from the console
   */
  private void handleSelectTaskOrMainMenu(String input) {

    switch (Integer.valueOf(input)) {
      case 0:
        new MainMenu(taskManager).invoke();

        break;
      default:
        new EditSelectedTaskMenu(Integer.valueOf(input), taskManager).invoke();

        break;
    }
  }
}
