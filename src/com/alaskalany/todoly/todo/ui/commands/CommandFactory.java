package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import com.alaskalany.todoly.todo.ui.commands.uicommands.AddTaskCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.Command;

/**
 * Command Factory
 */
public interface CommandFactory {

  /**
   * Command: Add task
   *
   * @return {@link AddTaskCommand}
   */
  <T extends Command> T getCommand(UiImpl.CommandType commandType);
}
