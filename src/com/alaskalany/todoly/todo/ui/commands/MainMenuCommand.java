package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class MainMenuCommand implements InputCommand {

  private static final String ENTER_A_VALID_INPUT = "Enter a valid input.";
  private final Ui ui;
  private String input;

  private MainMenuCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static MainMenuCommand create(Ui ui) {

    return new MainMenuCommand(ui);
  }

  void setInput(String input) {

    this.input = input;
  }

  public void invoke(Integer taskIndex) {

    System.out.println("ToDoly");

    System.out.println("1- Add a task");

    System.out.println("2- List all tasks");

    System.out.println("3- Save and quit");
    System.out.println();

    System.out.print("Enter a choice: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    handleInput(Integer.valueOf(input));
  }

  @Override
  public void handleInput(Integer taskIndex) {

    switch (Integer.valueOf(input)) {
      case 1:
        ui.Command(CommandType.ADD_TASK).invoke(taskIndex);
        break;
      case 2:
        ui.Command(CommandType.LIST_ALL_TASKS).invoke(taskIndex);
        break;
      case 3:
        ui.Command(CommandType.SAVE_AND_QUIT).invoke(taskIndex);
        break;
      default:
        System.out.println(ENTER_A_VALID_INPUT);

        System.out.print("Enter a choice: ");
        invoke(taskIndex);
        break;
    }
  }
}
