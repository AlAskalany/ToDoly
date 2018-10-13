package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;
import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.util.ArrayList;

class ListAllTasksByProjectMenu {

  private TaskManager taskManager;

  ListAllTasksByProjectMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    // print menu title
    System.out.println("All Tasks List - By Project");
    System.out.println();
    ArrayList<Project> projects;
    projects = taskManager.getAllProjects();
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
    ArrayList<String> tasksWithNoProject = taskManager.getAllWithNoProject();
    System.out.println();
    System.out.println("Tasks with no project:");
    System.out.println();
    tasksWithNoProject
        .forEach(
            task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
    System.out.println();
    new SelectTaskOrMainMenu(taskManager).invoke();

  }
}
