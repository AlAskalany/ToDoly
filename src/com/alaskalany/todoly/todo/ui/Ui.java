package com.alaskalany.todoly.todo.ui;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import org.jetbrains.annotations.Contract;

public interface Ui {

  void mainMenu();

  TaskManager getTaskManager();

  DateParser getDateParser();

  void addTask();

  @Contract(value = "_ -> param1", pure = true)
  String getTaskTitle(String input);

  void listAllTasks();

  void listAllTasksByProject();

  void selectTaskOrMainMenu();

  void editSelectedTask();

  boolean isTaskIndexValid();

  void editTaskDueDate();

  void editTaskProject();

  void editTaskStatus();

  void editTaskTitle();

  void listAllTasksByDueDate();

  void saveAndQuit();

  Integer getValueOf();

  void setValueOf(Integer valueOf);

  Integer getTaskIndex();

  void setTaskIndex(Integer taskIndex);

  String getInput();

  void setInput(String input);
}
