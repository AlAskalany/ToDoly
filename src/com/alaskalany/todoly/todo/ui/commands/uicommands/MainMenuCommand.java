package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MainMenuCommand implements InputCommand {

  private static final String ENTER_A_VALID_INPUT = "Enter a valid input.";
  private final Ui ui;
  private String input;

  private MainMenuCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static MainMenuCommand create(Ui ui) {

    return new MainMenuCommand(ui);
  }

  public String getInput() {

    return input;
  }

  public void setInput(String input) {

    this.input = input;
  }

  public void invoke() {

    System.out.println(MainMenu.TO_DOLY.getValue());
    System.out.println(MainMenu.ADD_A_TASK.getValue());
    System.out.println(MainMenu.LIST_ALL_TASKS.getValue());
    System.out.println(MainMenu.SAVE_AND_QUIT.getValue());
    System.out.println();
    System.out.print(MainMenu.ENTER_A_CHOICE.getValue());
    Scanner scanner = new Scanner(System.in);
    setInput(scanner.next());
    ui.setInput(input);
    handleInput();
  }

  @Override
  public void handleInput() {

    switch (Integer.valueOf(input)) {
      case 1:
        ui.addTask();
        break;
      case 2:
        ui.listAllTasks();
        break;
      case 3:
        ui.saveAndQuit();
        break;
      default:
        System.out.println(ENTER_A_VALID_INPUT);
        System.out.print(MainMenu.ENTER_A_CHOICE.getValue());
        invoke();
        break;
    }
  }

  public enum MainMenu {
    ADD_A_TASK("1- Add a task"), LIST_ALL_TASKS("2- List all tasks"), SAVE_AND_QUIT(
        "3- Save and quit"), ENTER_A_CHOICE("Enter a choice: "), TO_DOLY("ToDoly");
    private String value;

    MainMenu(String value) {

      this.value = value;
    }

    @Contract(pure = true)
    public String getValue() {

      return value;
    }
  }
}
