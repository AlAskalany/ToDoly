package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.commands.uicommands.AddTaskCommand;
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

  /**
   * Command: Add task
   *
   * @return {@link AddTaskCommand}
   */
  @Override
  public AddTaskCommand addTask() {
    return AddTaskCommand.create();
  }

  /**
   * Command: Edit selected task
   *
   * @return {@link EditSelectedTaskCommand}
   */
  @Override
  public EditSelectedTaskCommand editSelectedTask() {
    return EditTaskTitleCommand.create();
  }

  /**
   * Command: Edit task due date
   *
   * @return {@link EditTaskDueDateCommand}
   */
  @Override
  public EditTaskDueDateCommand edtTaskDueDate() {
    return EditTaskDueDateCommand.create();
  }

  /**
   * Command: Edit task project
   *
   * @return {@link EditTaskProjectCommand}
   */
  @Override
  public EditTaskProjectCommand editTaskProject() {
    return EditTaskProjectCommand.create();
  }

  /**
   * Command: Edit task status
   *
   * @return {@link EditTaskStatusCommand}
   */
  @Override
  public EditTaskStatusCommand editTaskStatus() {
    return EditTaskStatusCommand.create();
  }

  /**
   * Command: Edit task title
   *
   * @return {@link EditTaskTitleCommand}
   */
  @Override
  public EditTaskTitleCommand editTaskTitle() {
    return EditTaskTitleCommand.create();
  }

  /**
   * Command: List all tasks by due date
   *
   * @return {@link ListAllTasksByDueDateCommand}
   */
  @Override
  public ListAllTasksByDueDateCommand listAllTasksByDueDate() {
    return ListAllTasksByDueDateCommand.create();
  }

  /**
   * Command: List all tasks by project
   *
   * @return {@link ListAllTasksByProjectCommand}
   */
  @Override
  public ListAllTasksByProjectCommand listAllTasksByProject() {
    return ListAllTasksByProjectCommand.create();
  }

  /**
   * Command: List all tasks
   *
   * @return {@link ListAllTasksCommand}
   */
  @Override
  public ListAllTasksCommand listAllTasks() {
    return ListAllTasksCommand.create();
  }

  /**
   * Command: Main menu
   *
   * @return {@link MainMenuCommand}
   */
  @Override
  public MainMenuCommand mainMenu() {
    return ListAllTasksCommand.create();
  }

  /**
   * Command: Save and quit application
   *
   * @return {@link SaveAndQuitCommand}
   */
  @Override
  public SaveAndQuitCommand saveAndQuit() {
    return SaveAndQuitCommand.create();
  }

  /**
   * Command: Select task or return to main menu
   *
   * @return {@link SelectTaskOrMainMenuCommand}
   */
  @Override
  public SelectTaskOrMainMenuCommand selectTaskOrMainMenu() {
    return SelectTaskOrMainMenuCommand.create();
  }
}
