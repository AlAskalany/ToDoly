package com.alaskalany.todoly.cli.addtaskmenu;

import com.alaskalany.todoly.cli.mainmenu.MainMenu;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import java.util.ArrayList;
import javax.inject.Inject;

public class AddTaskMenuImpl extends AddTaskMenu {

  @Inject
  private MainMenu mainMenu;
  @Inject
  private TaskManager taskManager;

  @Inject
  public AddTaskMenuImpl(String title) {

    super(title);
  }

  @Override
  protected void setOptions(ArrayList<String> options) {

  }

  @Override
  protected void displayBody() {

  }

  @Override
  protected String setPrompt() {

    return "Enter task name";
  }

  @Override
  public void onInput(String taskTitle) {

    taskManager.addTask(taskTitle);
    mainMenu.display();
  }
}
