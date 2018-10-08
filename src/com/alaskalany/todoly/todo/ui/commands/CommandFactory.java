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

/**
 * Command Factory
 */
public interface CommandFactory {

  /**
   * Command: Add task
   *
   * @return {@link AddTaskCommand}
   */
  AddTaskCommand addTask();

  /**
   * Command: Edit selected task
   *
   * @return {@link EditSelectedTaskCommand}
   */
  EditSelectedTaskCommand editSelectedTask();

  /**
   * Command: Edit task due date
   *
   * @return {@link EditTaskDueDateCommand}
   */
  EditTaskDueDateCommand edtTaskDueDate();

  /**
   * Command: Edit task project
   *
   * @return {@link EditTaskProjectCommand}
   */
  EditTaskProjectCommand editTaskProject();

  /**
   * Command: Edit task status
   *
   * @return {@link EditTaskStatusCommand}
   */
  EditTaskStatusCommand editTaskStatus();

  /**
   * Command: Edit task title
   *
   * @return {@link EditTaskTitleCommand}
   */
  EditTaskTitleCommand editTaskTitle();

  /**
   * Command: List all tasks by due date
   *
   * @return {@link ListAllTasksByDueDateCommand}
   */
  ListAllTasksByDueDateCommand listAllTasksByDueDate();

  /**
   * Command: List all tasks by project
   *
   * @return {@link ListAllTasksByProjectCommand}
   */
  ListAllTasksByProjectCommand listAllTasksByProject();

  /**
   * Command: List all tasks
   *
   * @return {@link ListAllTasksCommand}
   */
  ListAllTasksCommand listAllTasks();

  /**
   * Command: Main menu
   *
   * @return {@link MainMenuCommand}
   */
  MainMenuCommand mainMenu();

  /**
   * Command: Save and quit application
   *
   * @return {@link SaveAndQuitCommand}
   */
  SaveAndQuitCommand saveAndQuit();

  /**
   * Command: Select task or return to main menu
   *
   * @return {@link SelectTaskOrMainMenuCommand}
   */
  SelectTaskOrMainMenuCommand selectTaskOrMainMenu();
}
