package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.TaskManager;
import java.util.Scanner;

class EditSelectedTaskMenu {

  private Integer taskIndex;
  private TaskManager taskManager;

  public EditSelectedTaskMenu(Integer taskIndex, TaskManager taskManager) {
    this.taskIndex = taskIndex;
    this.taskManager = taskManager;
  }

  public void invoke() {
    // print menu title
    System.out.println("Editing Task:" + taskManager.getTaskTitle(taskIndex));
    System.out.println("1- Title");
    System.out.println("2- Status");
    System.out.println("3- Project");
    System.out.println("4- Due date");

    // prompt user for input
    // prompt user for input
    System.out.print("Enter a choice or 0 for main menu: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    handleEditSelectedTask(input, taskIndex);
  }

  /**
   * Handle user input
   *
   * @param input     User input from console
   * @param taskIndex Index of a task selected by the user
   */
  private void handleEditSelectedTask(String input, Integer taskIndex) {

    switch (Integer.valueOf(input)) {
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
