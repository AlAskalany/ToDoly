package com.alaskalany.todoly.todo.ui.commands.uicommands;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class SaveAndQuitCommand implements Command {

  private SaveAndQuitCommand() {

  }

  @NotNull
  @Contract(" -> new")
  public static SaveAndQuitCommand create() {

    return new SaveAndQuitCommand();
  }

  public void invoke() {

    System.exit(0);
  }
}
