package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.Project;
import com.alaskalany.todoly.todo.Task;
import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.ArrayList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class ListAllTasksByProjectCommand implements Command {

  private final Ui ui;

  private ListAllTasksByProjectCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static ListAllTasksByProjectCommand create(Ui ui) {

    return new ListAllTasksByProjectCommand(ui);
  }

  public void invoke(Integer taskIndex) {

    Ui.FROM_LIST_BY_PROJECT = true;
    System.out.println(TaskListByProjectMenu.ALL_TASKS_LIST_BY_PROJECT.getValue());
    System.out.println();
    ArrayList<Project> projects;
    projects = ui.getTaskManager().getAllProjects();
    projects.forEach(project -> {
      String projectTitle = project.getTitle();
      System.out.println(projectTitle);
      System.out.println();
      ArrayList<Task> allTasks = project.getAllTasks();
      allTasks
          .forEach(task -> {
            int indexOfTask = allTasks.indexOf(task);
            int taskNumber = indexOfTask + 1;
            System.out.println(taskNumber + "- " + task);
          });
    });
    ArrayList<String> tasksWithNoProject = ui.getTaskManager().getAllWithNoProject();
    System.out.println();
    System.out.println(TaskListByProjectMenu.TASKS_WITH_NO_PROJECT.getValue());
    System.out.println();
    tasksWithNoProject
        .forEach(task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
    System.out.println();
    ui.Command(CommandType.SELECT_OR_MAIN_MENU).invoke(taskIndex);
  }

  public enum TaskListByProjectMenu {
    ALL_TASKS_LIST_BY_PROJECT("All Tasks List - By Project"), TASKS_WITH_NO_PROJECT(
        "Tasks with no project:");
    private String value;

    TaskListByProjectMenu(String value) {

      this.value = value;
    }

    @Contract(pure = true)
    public String getValue() {

      return value;
    }
  }
}
