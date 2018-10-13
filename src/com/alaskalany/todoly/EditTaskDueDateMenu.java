package com.alaskalany.todoly;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.TaskManager;
import java.time.LocalDate;
import java.util.Scanner;

class EditTaskDueDateMenu {

  private Integer taskIndex;
  private TaskManager taskManager;

  public EditTaskDueDateMenu(Integer taskIndex,
      TaskManager taskManager) {
    this.taskIndex = taskIndex;
    this.taskManager = taskManager;
  }

  public void invoke() {
    // prompt user for input
    // prompt user for input
    System.out.print("New Due date: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    DateParser dateParser = new DateParser();
    LocalDate dueDate = dateParser.getDateFromString(input);
    taskManager.getTask(taskIndex).setDueDate(dueDate);
    System.out.println("Task Due date modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();

  }
}
