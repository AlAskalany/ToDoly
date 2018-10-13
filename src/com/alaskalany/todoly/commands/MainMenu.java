package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

public class MainMenu {

  private TaskManager taskManager;

  public MainMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    // print menu title
    System.out.println("ToDoly");
    System.out.println("1- Add a task");
    System.out.println("2- List all tasks");
    System.out.println("3- Save and quit");
    System.out.println();

    // prompt user for input
    String input = new PromptInputHandler().invoke();
    handleMainMenuInput(input);
  }

  /**
   * Handle the input from use for the main menu
   *
   * @param input User input from the console
   */
  private void handleMainMenuInput(String input) {

    switch (Integer.valueOf(input)) {
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
        System.out.println("Enter a valid input.");

        // prompt user for input
        System.out.print("Enter a choice: ");
        new MainMenu(taskManager).invoke();

        break;
    }
  }

  private class PromptInputHandler {

    public String invoke() {
      System.out.print("Enter a choice: ");
      Scanner scanner = new Scanner(System.in);
      return scanner.next();
    }
  }
}
