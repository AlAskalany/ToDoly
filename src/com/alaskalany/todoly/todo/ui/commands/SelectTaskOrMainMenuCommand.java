package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class SelectTaskOrMainMenuCommand implements InputCommand {

  private final Ui ui;

  private SelectTaskOrMainMenuCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static SelectTaskOrMainMenuCommand create(Ui ui) {

    return new SelectTaskOrMainMenuCommand(ui);
  }

  public void invoke(Integer taskIndex) {

    System.out.print(
        ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    handleInput(Integer.valueOf(input));
  }

  @Override
  public void handleInput(Integer taskIndex) {

    switch (taskIndex) {
      case 0:
        ui.Command(CommandType.MAIN_MENU).invoke(taskIndex);
        break;
      default:
        ui.Command(CommandType.EDIT_SELECTED_TASK).invoke(taskIndex);
        break;
    }
  }
}
