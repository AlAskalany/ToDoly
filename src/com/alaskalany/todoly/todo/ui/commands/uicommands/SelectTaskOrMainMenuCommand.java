package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.Scanner;

public class SelectTaskOrMainMenuCommand extends Command {

  private SelectTaskOrMainMenuCommand(UiImpl uiImpl) {
    super(uiImpl);
  }

  public static SelectTaskOrMainMenuCommand create(UiImpl uiImpl) {

    return new SelectTaskOrMainMenuCommand(uiImpl);
  }

  public void invoke() {

    System.out.print(
        ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    handleInput(input, uiImpl);
  }

  @Override
  public void invoke(Integer valueOf) {

  }

  @Override
  public void handleInput(Integer taskIndex) {

  }

  @Override
  public void handleInput(Integer taskIndex, UiImpl ui) {

  }

  @Override
  public void handleInput(String input) {

  }

  @Override
  public void handleInput(String input, Integer taskIndex, UiImpl ui) {

  }

  @Override
  public void handleInput(String input, UiImpl ui) {

    switch (Integer.valueOf(input)) {
      case 0:
        ui.mainMenu();
        break;
      default:
        ui.editSelectedTask(Integer.valueOf(input));
        break;
    }
  }
}
