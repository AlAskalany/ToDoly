package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class SelectTaskOrMainMenuCommand implements InputCommand {

  private final Ui ui;

  private SelectTaskOrMainMenuCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static SelectTaskOrMainMenuCommand create(Ui ui) {

    return new SelectTaskOrMainMenuCommand(ui);
  }

  public void invoke() {

    System.out.print(
        ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    ui.setInput(input);
    handleInput();
  }

  @Override
  public void handleInput() {

    switch (Integer.valueOf(ui.getInput())) {
      case 0:
        ui.mainMenu();
        break;
      default:
        ui.editSelectedTask();
        break;
    }
  }
}
