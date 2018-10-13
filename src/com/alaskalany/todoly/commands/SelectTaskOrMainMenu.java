package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class SelectTaskOrMainMenu extends Command {

  SelectTaskOrMainMenu(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    // prompt user for input
    // prompt user for input

    String input = promptForInput("Enter task number to edit or 0 for main menu");
    handleSelectTaskOrMainMenu(input);
  }

  /**
   * Go to main menu if input is "0" or edit a task of a given index
   *
   * @param input User input from the console
   */
  private void handleSelectTaskOrMainMenu(String input) {

    switch (inputToInteger(input)) {
      case 0:
        new MainMenu(taskManager).invoke();
        break;
      default:
        new EditSelectedTaskMenu(inputToInteger(input), taskManager).invoke();
        break;
    }
  }
}
