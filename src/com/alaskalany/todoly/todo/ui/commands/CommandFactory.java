package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;

public class CommandFactory {

  public final Ui ui;

  public CommandFactory(Ui ui) {

    this.ui = ui;
  }

  /**
   * Command: Add task
   *
   * @return {@link AddTaskCommand}
   */
  public Command create(Ui.CommandType commandType) {

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
