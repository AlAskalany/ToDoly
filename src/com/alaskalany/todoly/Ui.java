package com.alaskalany.todoly;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.TaskManager;
import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;

/**
 * Console user interface for ToDoly application
 */
class Ui {

  /**
   * Task manager
   */
  private final TaskManager taskManager;

  /**
   * Console user interface for ToDoly application
   *
   * @param taskManager {@link TaskManager} tasks manager
   */
  Ui(@SuppressWarnings("SameParameterValue") TaskManager taskManager) {

    this.taskManager = taskManager;
  }

  /**
   * Show main menu to user on the console
   */
  void mainMenu() {

    // print menu title
    System.out.println("ToDoly");
    System.out.println("1- Add a task");
    System.out.println("2- List all tasks");
    System.out.println("3- Save and quit");
    System.out.println();

    // prompt user for input
    System.out.print("Enter a choice: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    handleMainMenuInput(input);
  }

  /**
   * Handle the input from use for the main menu
   *
   * @param input User input from the console
   */
  private void handleMainMenuInput(String input) {

    switch (Integer.valueOf(input)) {
      case 1:
        addTask();
        break;
      case 2:
        listAllTasks();
        break;
      case 3:
        saveAndQuit();
        break;
      default:
        System.out.println("Enter a valid input.");

        // prompt user for input
        System.out.print("Enter a choice: ");
        mainMenu();
        break;
    }
  }

  /**
   * Add a new task with a title
   */
  private void addTask() {

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("\n");
    String input;

    // prompt user for input
    System.out.print("Enter task name:");
    input = scanner.next();
    String taskTitle = getTaskTitle(input);
    taskManager.addTask(taskTitle);
    mainMenu();
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

  /**
   * List all tasks
   */
  private void listAllTasks() {

    // print menu title
    System.out.println("List all tasks by:");
    System.out.println("1- Due date");
    System.out.println("2- Project");

    // prompt user for input
    System.out.print("Enter a choice: ");
    Scanner scanner = new Scanner(System.in);
    String input;
    input = scanner.nextLine();
    handleListAllTasksInput(input);
  }

  /**
   * Handle user selection of due date or project to sort tasks by
   *
   * @param input "1" to sort tasks by due date or "2" to sort tasks by project
   */
  private void handleListAllTasksInput(String input) {

    switch (Integer.valueOf(input)) {
      case 1:
        listAllTasksByDueDate();
        break;
      case 2:
        listAllTasksByProject();
        break;
      default:
        break;
    }
  }

  /**
   * List all tasks grouped by project
   */
  private void listAllTasksByProject() {

    // print menu title
    System.out.println("All Tasks List - By Project");
    System.out.println();
    ArrayList<Project> projects;
    projects = taskManager.getAllProjects();
    projects.forEach(project -> {
      String projectTitle = project.getTitle();
      System.out.println(projectTitle);
      System.out.println();
      ArrayList<Task> allTasks = project.getAllTasks();
      allTasks
          .forEach(task -> {
            int indexOfTask = allTasks.indexOf(task);
            int taskNumber = indexOfTask + 1;
            System.out.println(taskNumber + "- " + task);
          });
    });
    ArrayList<String> tasksWithNoProject = taskManager.getAllWithNoProject();
    System.out.println();
    System.out.println("Tasks with no project:");
    System.out.println();
    tasksWithNoProject
        .forEach(task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
    System.out.println();
    selectTaskOrMainMenu();
  }

  /**
   * Go to main menu if input is "0" or edit a task of a given index
   */
  private void selectTaskOrMainMenu() {

    // prompt user for input
    String input = promptAndGetInput("Enter task number to edit or 0 for main menu");
    handleSelectTaskOrMainMenu(input);
  }

  /**
   * Go to main menu if input is "0" or edit a task of a given index
   *
   * @param input User input from the console
   */
  private void handleSelectTaskOrMainMenu(String input) {

    switch (Integer.valueOf(input)) {
      case 0:
        mainMenu();
        break;
      default:
        editSelectedTask(Integer.valueOf(input));
        break;
    }
  }

  /**
   * Edit the selected task
   *
   * @param taskIndex Index of the selected task
   */
  private void editSelectedTask(Integer taskIndex) {

    // print menu title
    System.out.println("Editing Task:" + taskManager.getTaskTitle(taskIndex));
    System.out.println("1- Title");
    System.out.println("2- Status");
    System.out.println("3- Project");
    System.out.println("4- Due date");

    // prompt user for input
    String input = promptAndGetInput("Enter a choice or 0 for main menu: ");
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
        mainMenu();
        break;
      case 1:
        editTaskTitle(taskIndex);
        break;
      case 2:
        editTaskStatus(taskIndex);
        break;
      case 3:
        editTaskProject(taskIndex);
        break;
      case 4:
        editTaskDueDate(taskIndex);
        break;
      default:
        break;
    }
  }

  /**
   * Edit due date of the task of a given index
   *
   * @param taskIndex Index of the task
   */
  private void editTaskDueDate(Integer taskIndex) {

    // prompt user for input
    String input = promptAndGetInput("New Due date: ");
    DateParser dateParser = new DateParser();
    LocalDate dueDate = dateParser.getDateFromString(input);
    taskManager.getTask(taskIndex).setDueDate(dueDate);
    System.out.println("Task Due date modified");
    editSelectedTask(taskIndex);
  }

  /**
   * Edit project of the task of a given index
   *
   * @param taskIndex Index of the task
   */
  private void editTaskProject(Integer taskIndex) {

    // prompt user for input
    String input = promptAndGetInput("New Project: ");
    if (!taskManager.doesProjectExist(input)) {
      taskManager.createProject(input);
    }
    taskManager.addTaskToProject(taskIndex, input);
    System.out.println("Task Project modified");
    editSelectedTask(taskIndex);
  }

  /**
   * Edit status of the task of a given index
   *
   * @param taskIndex Index of the task
   */
  private void editTaskStatus(Integer taskIndex) {

    // prompt user for input
    String input = promptAndGetInput("New Status: ");
    taskManager.getTask(taskIndex).setTitle(input);
    System.out.println("Task title modified");
    editSelectedTask(taskIndex);
  }

  /**
   * Edit title of the task of a given index
   *
   * @param taskIndex Index of the task
   */
  private void editTaskTitle(Integer taskIndex) {
    String input = promptAndGetInput("New title: ");

    taskManager.getTask(taskIndex).setTitle(input);
    System.out.println("Task title modified");
    editSelectedTask(taskIndex);
  }

  private String promptAndGetInput(String s) {
    // prompt user for input
    System.out.print(s);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  /**
   * List all tasks sorted by due date
   */
  private void listAllTasksByDueDate() {

    // print menu title
    System.out.println("All Tasks List - By Due Date");
    System.out.println();
    ArrayList<String> tasks = taskManager.getAllTasksByDueDate();
    tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
    System.out.println();
    selectTaskOrMainMenu();
  }

  /**
   * Save changes and quit the application
   */
  private void saveAndQuit() {

    System.exit(0);
  }
}