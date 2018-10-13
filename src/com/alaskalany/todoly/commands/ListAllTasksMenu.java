package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

class ListAllTasksMenu extends Command {

  ListAllTasksMenu(TaskManager taskManager) {
    super(taskManager);
  }

  public void invoke() {
    // print menu title
    print("List all tasks by:");
    print("1- Due date");
    print("2- Project");
    String input = promptForInput("Enter a choice: ");
    handleListAllTasksInput(input);
  }

  /**
   * Handle user selection of due date or project to sort tasks by
   *
   * @param input "1" to sort tasks by due date or "2" to sort tasks by project
   */
  private void handleListAllTasksInput(String input) {
    switch (inputToInteger(input)) {
      case 1:
        new ListAllTasksByDueDateMenu(taskManager).invoke();
        break;
      case 2:
        new ListAllTasksByProjectMenu(taskManager).invoke();
        break;
      default:
        break;
    }
  }
}
