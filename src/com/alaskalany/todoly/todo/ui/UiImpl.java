package com.alaskalany.todoly.todo.ui;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import com.alaskalany.todoly.todo.ui.commands.CommandFactory;
import com.alaskalany.todoly.todo.ui.commands.CommandFactoryImpl;
import com.alaskalany.todoly.todo.ui.commands.uicommands.Command;
import javax.inject.Inject;
import org.jetbrains.annotations.Contract;

public class UiImpl implements Ui {

  public static boolean FROM_LIST_BY_DUE_DATE = false;
  public static boolean FROM_LIST_BY_PROJECT = true;
  // Commands
  private final Command editTaskTitleCommand;
  private final Command listAllTasksByProjectCommand;
  private final Command editSelectedTaskCommand;
  private final Command listAllTasksByDueDateCommand;
  private final Command mainMenuCommand;
  private final Command listAllTasksCommand;
  private final Command addTaskCommand;
  private final Command editTaskProjectCommand;
  private final Command editTaskDueDateCommand;
  private final Command editTaskStatusCommand;
  private final Command saveAndQuitCommand;
  private final Command selectTaskOrMainMenuCommand;
  @Inject
  private TaskManager taskManager;
  @Inject
  private DateParser dateParser;
  private Integer valueOf;
  private Integer taskIndex;
  private String input;

  public UiImpl() {

    CommandFactory factory = new CommandFactoryImpl(this);
    editTaskTitleCommand = factory.getCommand(CommandType.EDIT_TASK_TITLE);
    listAllTasksByProjectCommand = factory.getCommand(CommandType.LIST_ALL_TASKS_BY_PROJECT);
    editSelectedTaskCommand = factory.getCommand(CommandType.EDIT_SELECTED_TASK);
    listAllTasksByDueDateCommand = factory.getCommand(CommandType.LIST_ALL_TASKS_BY_DUE_DATE);
    mainMenuCommand = factory.getCommand(CommandType.MAIN_MENU);
    listAllTasksCommand = factory.getCommand(CommandType.LIST_ALL_TASKS);
    addTaskCommand = factory.getCommand(CommandType.ADD_TASK);
    editTaskProjectCommand = factory.getCommand(CommandType.EDIT_TASK_PROJECT);
    editTaskDueDateCommand = factory.getCommand(CommandType.EDIT_TASK_DUE_DATE);
    editTaskStatusCommand = factory.getCommand(CommandType.EDIT_TASK_STATUS);
    saveAndQuitCommand = factory.getCommand(CommandType.SAVE_AND_QUIT);
    selectTaskOrMainMenuCommand = factory.getCommand(CommandType.SELECT_OR_MAIN_MENU);
  }

  @Override
  public void mainMenu() {

    mainMenuCommand.invoke();
  }

  @Override
  public TaskManager getTaskManager() {

    return taskManager;
  }

  @Override
  public DateParser getDateParser() {

    return dateParser;
  }

  @Override
  public void addTask() {

    addTaskCommand.invoke();
  }

  @Override
  @Contract(value = "_ -> param1", pure = true)
  public String getTaskTitle(String input) {

    return input;
  }

  @Override
  public void listAllTasks() {

    listAllTasksCommand.invoke();
  }

  @Override
  public void listAllTasksByProject() {

    listAllTasksByProjectCommand.invoke();
  }

  @Override
  public void selectTaskOrMainMenu() {

    selectTaskOrMainMenuCommand.invoke();
  }

  @Override
  public void editSelectedTask() {

    setValueOf(Integer.valueOf(input));

    editSelectedTaskCommand.invoke();
  }

  @Override
  public boolean isTaskIndexValid() {

    setTaskIndex(taskIndex);

    return taskManager.isTaskIndexValid(taskIndex);
  }

  @Override
  public void editTaskDueDate() {

    editTaskDueDateCommand.invoke();
  }

  @Override
  public void editTaskProject() {

    editTaskProjectCommand.invoke();
  }

  @Override
  public void editTaskStatus() {

    editTaskStatusCommand.invoke();
  }

  @Override
  public void editTaskTitle() {

    editTaskTitleCommand.invoke();
  }

  @Override
  public void listAllTasksByDueDate() {

    listAllTasksByDueDateCommand.invoke();
  }

  @Override
  public void saveAndQuit() {

    saveAndQuitCommand.invoke();
  }

  @Override
  public Integer getValueOf() {

    return valueOf;
  }

  @Override
  public void setValueOf(Integer valueOf) {

    this.valueOf = valueOf;
  }

  @Override
  public Integer getTaskIndex() {

    return valueOf;
  }

  @Override
  public void setTaskIndex(Integer taskIndex) {

    this.taskIndex = taskIndex;
  }

  @Override
  public String getInput() {

    return input;
  }

  @Override
  public void setInput(String input) {

    this.input = input;
  }

  public enum CommandType {
    ADD_TASK, EDIT_SELECTED_TASK, EDIT_TASK_DUE_DATE, EDIT_TASK_PROJECT, EDIT_TASK_STATUS, EDIT_TASK_TITLE,
    LIST_ALL_TASKS, LIST_ALL_TASKS_BY_DUE_DATE, LIST_ALL_TASKS_BY_PROJECT, MAIN_MENU, SAVE_AND_QUIT,
    SELECT_OR_MAIN_MENU
  }
}