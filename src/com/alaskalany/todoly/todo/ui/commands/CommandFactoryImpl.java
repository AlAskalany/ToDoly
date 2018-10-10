package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.UiImpl;
import com.alaskalany.todoly.todo.ui.commands.uicommands.AddTaskCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.Command;
import com.alaskalany.todoly.todo.ui.commands.uicommands.EditSelectedTaskCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.EditTaskDueDateCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.EditTaskProjectCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.EditTaskStatusCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.EditTaskTitleCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.ListAllTasksByDueDateCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.ListAllTasksByProjectCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.ListAllTasksCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.MainMenuCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.SaveAndQuitCommand;
import com.alaskalany.todoly.todo.ui.commands.uicommands.SelectTaskOrMainMenuCommand;

public class CommandFactoryImpl implements CommandFactory {

  private final Ui ui;

  public CommandFactoryImpl(Ui ui) {

    this.ui = ui;
  }

  /**
   * Command: Add task
   *
   * @return {@link AddTaskCommand}
   */
  @Override
  public Command getCommand(UiImpl.CommandType commandType) {

    switch (commandType) {
      case ADD_TASK:
        return AddTaskCommand.create(ui);
      case MAIN_MENU:
        return MainMenuCommand.create(ui);
      case SAVE_AND_QUIT:
        return SaveAndQuitCommand.create();
      case LIST_ALL_TASKS:
        return ListAllTasksCommand.create(ui);
      case EDIT_TASK_TITLE:
        return EditTaskTitleCommand.create(ui);
      case EDIT_TASK_STATUS:
        return EditTaskStatusCommand.create(ui);
      case EDIT_TASK_PROJECT:
        return EditTaskProjectCommand.create(ui);
      case EDIT_SELECTED_TASK:
        return EditSelectedTaskCommand.create(ui);
      case EDIT_TASK_DUE_DATE:
        return EditTaskDueDateCommand.create(ui);
      case SELECT_OR_MAIN_MENU:
        return SelectTaskOrMainMenuCommand.create(ui);
      case LIST_ALL_TASKS_BY_PROJECT:
        return ListAllTasksByProjectCommand.create(ui);
      case LIST_ALL_TASKS_BY_DUE_DATE:
        return ListAllTasksByDueDateCommand.create(ui);
      default:
        throw new IllegalArgumentException("Command type not supported.");
    }
  }
}
