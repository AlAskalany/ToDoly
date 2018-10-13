package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class ListAllTasksCommand implements InputCommand {

  private final Ui ui;

  private ListAllTasksCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static ListAllTasksCommand create(Ui ui) {

    return new ListAllTasksCommand(ui);
  }

  public void invoke(Integer taskIndex) {

    System.out.println(ListAllTasksMenu.LIST_ALL_TASKS_BY.getValue());
    System.out.println(ListAllTasksMenu.DUE_DATE.getValue());
    System.out.println(ListAllTasksMenu.PROJECT.getValue());

    System.out.print("Enter a valid choice to display tasks by due date or project.");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    handleInput(Integer.valueOf(input));
  }

  @Override
  public void handleInput(Integer taskIndex) {

    switch (Integer.valueOf(ui.getInput())) {
      case 1:
        ui.Command(CommandType.LIST_ALL_TASKS_BY_DUE_DATE).invoke(taskIndex);
        break;
      case 2:
        ui.Command(CommandType.LIST_ALL_TASKS_BY_PROJECT).invoke(taskIndex);
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
