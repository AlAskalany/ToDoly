package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;

class AddTaskMenu {

  private TaskManager taskManager;

  AddTaskMenu(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public void invoke() {
    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("\n");
    String input;

    // prompt user for input
    System.out.print("Enter task name:");
    input = scanner.next();
    String taskTitle = getTaskTitle(input);
    taskManager.addTask(taskTitle);
    new MainMenu(taskManager).invoke();

  }

  /**
   * Get the title of a task
   *
   * @param input Title of the task
   *
   * @return Title of the task
   */
  @Contract(value = "_ -> param1", pure = true)
  private String getTaskTitle(String input) {

    return input;
  }
}
