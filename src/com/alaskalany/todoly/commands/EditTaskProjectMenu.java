package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

class EditTaskProjectMenu extends Command {

  private Integer taskIndex;

  public EditTaskProjectMenu(Integer taskIndex,
      TaskManager taskManager) {
    super(taskManager);
    this.taskIndex = taskIndex;
  }

  public void invoke() {
    // prompt user for input

    String input = promptForInput("New Project: ");
    if (!projectExists(input)) {
      createProject(input);
    }
    addTaskToProject(input, taskIndex);
    print("Task Project modified");
    new EditSelectedTaskMenu(taskIndex, taskManager).invoke();
  }
}
