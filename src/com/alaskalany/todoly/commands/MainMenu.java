package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

public class MainMenu extends Command {

  public MainMenu(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    // print menu title
    print("ToDoly");
    print("1- Add a task");
    print("2- List all tasks");
    print("3- Save and quit");
    printLineBreak();

    // prompt user for input
    String input = promptForInput("Enter a choice: ");
    handleMainMenuInput(input);
  }

  /**
   * Handle the input from use for the main menu
   *
   * @param input User input from the console
   */
  private void handleMainMenuInput(String input) {

    switch (inputToInteger(input)) {
      case 1:

        new AddTaskMenu(taskManager).invoke();
        break;
      case 2:
        new ListAllTasksMenu(taskManager).invoke();

        break;
      case 3:

        new SaveAndQuit().invoke();
        break;
      default:
        print("Enter a valid input.");

        // prompt user for input
        prompt("Enter a choice");
        new MainMenu(taskManager).invoke();

        break;
    }
  }

}
