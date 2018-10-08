package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;

public abstract class Command {

  protected final UiImpl uiImpl;

  public Command(UiImpl uiImpl) {
    this.uiImpl = uiImpl;
  }

  public void invoke() {
    invoke(null);
  }

  public abstract void invoke(Integer valueOf);

  public abstract void handleInput(Integer taskIndex);

  public abstract void handleInput(Integer taskIndex, UiImpl ui);

  public abstract void handleInput(String input);

  public abstract void handleInput(String input, Integer taskIndex, UiImpl ui);

  public abstract void handleInput(String input, UiImpl ui);
}
