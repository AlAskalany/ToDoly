package com.alaskalany.todoly.todo.ui;

import static com.alaskalany.todoly.todo.ui.Ui.CommandType.ADD_TASK;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.EDIT_SELECTED_TASK;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.EDIT_TASK_DUE_DATE;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.EDIT_TASK_PROJECT;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.EDIT_TASK_STATUS;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.EDIT_TASK_TITLE;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.LIST_ALL_TASKS;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.LIST_ALL_TASKS_BY_DUE_DATE;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.LIST_ALL_TASKS_BY_PROJECT;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.MAIN_MENU;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.SAVE_AND_QUIT;
import static com.alaskalany.todoly.todo.ui.Ui.CommandType.SELECT_OR_MAIN_MENU;

import com.alaskalany.todoly.Utils.DateParser;
import com.alaskalany.todoly.todo.TaskManager;
import com.alaskalany.todoly.todo.ui.commands.Command;
import com.alaskalany.todoly.todo.ui.commands.CommandFactory;
import java.util.HashMap;

public class Ui {

  public static boolean FROM_LIST_BY_DUE_DATE = false;
  public static boolean FROM_LIST_BY_PROJECT = true;
  private HashMap<CommandType, Command> commands;
  private TaskManager taskManager;
  private DateParser dateParser;
  private String input;

  public Ui() {

    taskManager = new TaskManager();
    dateParser = new DateParser();

    commands = new HashMap<>();

    CommandFactory cmdFactory = new CommandFactory(this);
    addCommand(cmdFactory, EDIT_TASK_TITLE);
    addCommand(cmdFactory, LIST_ALL_TASKS_BY_PROJECT);
    addCommand(cmdFactory, EDIT_SELECTED_TASK);
    addCommand(cmdFactory, LIST_ALL_TASKS_BY_DUE_DATE);
    addCommand(cmdFactory, MAIN_MENU);
    addCommand(cmdFactory, LIST_ALL_TASKS);
    addCommand(cmdFactory, ADD_TASK);
    addCommand(cmdFactory, EDIT_TASK_PROJECT);
    addCommand(cmdFactory, EDIT_TASK_DUE_DATE);
    addCommand(cmdFactory, EDIT_TASK_STATUS);
    addCommand(cmdFactory, SAVE_AND_QUIT);
    addCommand(cmdFactory, SELECT_OR_MAIN_MENU);
  }

  public Command Command(CommandType type) {
    return commands.get(type);
  }

  public void addCommand(CommandFactory cmdFactory, CommandType editTaskTitle) {
    commands.put(editTaskTitle, cmdFactory.create(editTaskTitle));
  }

  public TaskManager getTaskManager() {

    return taskManager;
  }

  public DateParser getDateParser() {

    return dateParser;
  }

  public String getInput() {

    return input;
  }

  public void setInput(String input) {

    this.input = input;
  }

  public enum CommandType {
    ADD_TASK, EDIT_SELECTED_TASK, EDIT_TASK_DUE_DATE, EDIT_TASK_PROJECT, EDIT_TASK_STATUS, EDIT_TASK_TITLE,
    LIST_ALL_TASKS, LIST_ALL_TASKS_BY_DUE_DATE, LIST_ALL_TASKS_BY_PROJECT, MAIN_MENU, SAVE_AND_QUIT,
    SELECT_OR_MAIN_MENU
  }
}