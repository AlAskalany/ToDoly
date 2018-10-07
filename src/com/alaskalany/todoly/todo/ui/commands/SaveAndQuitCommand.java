package com.alaskalany.todoly.todo.ui.commands;

public class SaveAndQuitCommand {

  private SaveAndQuitCommand() {

  }

  public static SaveAndQuitCommand create() {

    return new SaveAndQuitCommand();
  }

  public void invoke() {

    System.exit(0);
  }
}
