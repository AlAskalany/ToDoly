package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.ArrayList;

class ListAllTasksByDueDateMenu {

  private TaskManager taskManager;

  ListAllTasksByDueDateMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    // print menu title
    System.out.println("All Tasks List - By Due Date");
    System.out.println();
    ArrayList<String> tasks = taskManager.getAllTasksByDueDate();
    tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
    System.out.println();
    new SelectTaskOrMainMenu(taskManager).invoke();

  }
}
