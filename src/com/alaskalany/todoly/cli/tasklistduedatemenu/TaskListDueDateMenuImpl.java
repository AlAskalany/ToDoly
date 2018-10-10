package com.alaskalany.todoly.cli.tasklistduedatemenu;

import com.alaskalany.todoly.cli.mainmenu.MainMenu;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import java.util.ArrayList;
import javax.inject.Inject;

public class TaskListDueDateMenuImpl extends TaskListDueDateMenu {

  @Inject
  private TaskManager taskManager;
  @Inject
  private MainMenu mainMenu;

  @Inject
  public TaskListDueDateMenuImpl(String title) {

    super(title);
  }

  @Override
  protected void setOptions(ArrayList<String> options) {

  }

  @Override
  protected void displayBody() {

    taskManager.getAllProjects().forEach(project -> {
      System.out.println(project.getTitle());
      System.out.println();
      project.getAllTasks()
          .forEach(task -> System.out.println(project.getAllTasks().indexOf(task) + "- " + task));
    });
    taskManager.getAllWithNoProject().forEach(task -> System.out
        .println((1 + taskManager.getAllWithNoProject().indexOf(task)) + "- " + task));
  }

  @Override
  protected String setPrompt() {

    return "Enter task number to edit, or 0 to go to main menu";
  }

  @Override
  public void onInput(String input) {

    if (input.equals("0")) {
      mainMenu.display();
    }
  }
}
