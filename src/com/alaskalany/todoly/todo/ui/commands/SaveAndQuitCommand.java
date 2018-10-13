package com.alaskalany.todoly.todo.ui.commands;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class SaveAndQuitCommand implements Command {

  private SaveAndQuitCommand() {

  }

  @NotNull
  @Contract(" -> new")
  static SaveAndQuitCommand create() {

    return new SaveAndQuitCommand();
  }

  public void invoke(Integer taskIndex) {

    System.exit(0);
  }
}
