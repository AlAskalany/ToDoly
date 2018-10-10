package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ListAllTasksCommand implements InputCommand {

  private final Ui ui;

  private ListAllTasksCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static ListAllTasksCommand create(Ui ui) {

    return new ListAllTasksCommand(ui);
  }

  public void invoke() {

    System.out.println(ListAllTasksMenu.LIST_ALL_TASKS_BY.getValue());
    System.out.println(ListAllTasksMenu.DUE_DATE.getValue());
    System.out.println(ListAllTasksMenu.PROJECT.getValue());
    System.out.print(MainMenuCommand.MainMenu.ENTER_A_CHOICE.getValue());
    Scanner scanner = new Scanner(System.in);
    String input;
    input = scanner.nextLine();
    ui.setInput(input);
    handleInput();
  }

  @Override
  public void handleInput() {

    switch (Integer.valueOf(ui.getInput())) {
      case 1:
        ui.listAllTasksByDueDate();
        break;
      case 2:
        ui.listAllTasksByProject();
        break;
      default:
        break;
    }
  }

  public enum ListAllTasksMenu {
    DUE_DATE("1- Due date"), LIST_ALL_TASKS_BY("List all tasks by:"), PROJECT("2- Project");
    private String value;

    ListAllTasksMenu(String value) {

      this.value = value;
    }

    @Contract(pure = true)
    public String getValue() {

      return value;
    }
  }
}
