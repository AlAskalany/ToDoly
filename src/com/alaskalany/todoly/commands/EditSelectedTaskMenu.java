package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.todo.TaskManager;

class EditSelectedTaskMenu extends Command{

  private Integer taskIndex;

  public EditSelectedTaskMenu(Integer taskIndex, TaskManager taskManager) {
    super(taskManager);
    this.taskIndex = taskIndex;
  }

  public void invoke() {
    print("Editing Task:" + taskManager.getTaskTitle(taskIndex));
    print("1- Title");
    print("2- Status");
    print("3- Project");
    print("4- Due date");
    String input = promptForInput("Enter a choice or 0 for main menu: ");
    handleEditSelectedTask(input, taskIndex);
  }

  /**
   * Handle user input
   *
   * @param input     User input from console
   * @param taskIndex Index of a task selected by the user
   */
  private void handleEditSelectedTask(String input, Integer taskIndex) {
    switch (inputToInteger(input)) {
      case 0:
        new MainMenu(taskManager).invoke();
        break;
      case 1:
        new EditTaskTitleMenu(taskIndex, taskManager).invoke();
        break;
      case 2:
        new EditTaskStatusMenu(taskIndex, taskManager).invoke();
        break;
      case 3:
        new EditTaskProjectMenu(taskIndex, taskManager).invoke();
        break;
      case 4:
        new EditTaskDueDateMenu(taskIndex, taskManager).invoke();
        break;
      default:
        break;
    }
  }
}
