package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import com.alaskalany.todoly.todo.project.Project;
import java.util.ArrayList;

class ListAllTasksByProjectMenu extends Command {

  ListAllTasksByProjectMenu(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    // print menu title
    print("All Tasks List - By Project");
    printLineBreak();
    ArrayList<Project> projects = getProjects();
    projects.forEach(this::printProjectTasks);
    ArrayList<String> tasksWithNoProject = getAllWithNoProject();
    printLineBreak();
    print("Tasks with no project:");
    printLineBreak();
    tasksWithNoProject.forEach(task -> printTaskWithIndex(tasksWithNoProject, task));
    printLineBreak();
    new SelectTaskOrMainMenu(taskManager).invoke();
  }
}
