package com.alaskalany.todoly.commands;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.TaskManager;
import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Command {

  protected TaskManager taskManager;

  public Command(TaskManager taskManager) {
    this.taskManager = taskManager;
  }

  public abstract void invoke();

  protected void print(String s) {
    System.out.println(s);
  }

  protected void prompt(String s) {
    System.out.print(s);
  }

  @NotNull
  protected Scanner getScanner() {
    return new Scanner(System.in);
  }

  protected String getInput(Scanner scanner) {
    return scanner.nextLine();
  }

  protected String getInputString() {
    Scanner scanner = getScanner();
    return getInput(scanner);
  }

  protected LocalDate getLocalDate(String input) {
    DateParser dateParser = new DateParser();
    return dateParser.getDateFromString(input);
  }

  protected boolean projectExists(String input) {
    return taskManager.doesProjectExist(input);
  }

  protected void createProject(String input) {
    taskManager.createProject(input);
  }

  protected void addTaskToProject(String input, Integer taskIndex) {
    taskManager.addTaskToProject(taskIndex, input);
  }

  protected ArrayList<String> getTasksStringsByDueDate() {
    return taskManager.getAllTasksByDueDate();
  }

  protected void printTaskWithIndex(ArrayList<String> tasks, String task) {
    System.out.println((tasks.indexOf(task) + 1) + "- " + task);
  }

  protected void printLineBreak() {
    System.out.println();
  }

  protected ArrayList<Project> getProjects() {
    ArrayList<Project> projects;
    projects = taskManager.getAllProjects();
    return projects;
  }

  protected ArrayList<String> getAllWithNoProject() {
    return taskManager.getAllWithNoProject();
  }

  protected void printProjectTasks(Project project) {
    String projectTitle = project.getTitle();
    print(projectTitle);
    printLineBreak();
    ArrayList<Task> allTasks = project.getAllTasks();
    allTasks
        .forEach(task -> {
          int indexOfTask = allTasks.indexOf(task);
          int taskNumber = indexOfTask + 1;
          print(taskNumber + "- " + task);
        });
  }

  @NotNull
  protected Integer inputToInteger(String input) {
    return Integer.valueOf(input);
  }

  protected void addTask(String taskTitle) {
    taskManager.addTask(taskTitle);
  }

  protected String promptForInput(String prompt) {
    prompt(prompt);
    return getInputString();
  }
}
