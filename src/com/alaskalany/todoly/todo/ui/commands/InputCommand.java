package com.alaskalany.todoly.todo.ui.commands;

public interface InputCommand extends Command {

  void handleInput(Integer taskIndex);
}
