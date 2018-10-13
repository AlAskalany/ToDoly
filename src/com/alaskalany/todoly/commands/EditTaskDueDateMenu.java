package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;
import java.time.LocalDate;

class EditTaskDueDateMenu extends Command {

  private Integer taskIndex;

  public EditTaskDueDateMenu(Integer taskIndex, TaskManager taskManager) {
    super(taskManager);
    this.taskIndex = taskIndex;
  }

  public void invoke() {
    String input = promptForInput("New Due date: ");
    LocalDate dueDate = getLocalDate(input);
    taskManager.getTask(taskIndex).setDueDate(dueDate);
    print("Task Due date modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();
  }
}
