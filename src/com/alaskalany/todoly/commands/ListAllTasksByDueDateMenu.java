package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.ArrayList;

class ListAllTasksByDueDateMenu extends Command {

  ListAllTasksByDueDateMenu(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    print("All Tasks List - By Due Date");
    printLineBreak();
    ArrayList<String> tasks = getTasksStringsByDueDate();
    tasks.forEach(task -> printTaskWithIndex(tasks, task));
    printLineBreak();
    new SelectTaskOrMainMenu(taskManager).invoke();
  }
}
