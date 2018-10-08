package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;

public class SaveAndQuitCommand extends Command {

  public SaveAndQuitCommand(UiImpl uiImpl) {
    super(uiImpl);
  }

  public static SaveAndQuitCommand create(UiImpl uiImpl) {

    return new SaveAndQuitCommand(uiImpl);
  }

  public void invoke() {

    System.exit(0);
  }

  @Override
  public void invoke(Integer valueOf) {

  }

  @Override
  public void handleInput(String input, Integer taskIndex, UiImpl ui) {

  }
}
