package com.alaskalany.todoly.todo.ui;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;

public abstract class Ui {

  public abstract void mainMenu();

  public abstract TaskManager getTaskManager();

  public abstract DateParser getDateParser();
}
