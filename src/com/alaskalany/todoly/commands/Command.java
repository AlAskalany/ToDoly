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
    System.out.print(s + ":> ");
  }

  @Contract(" -> new")
  @NotNull
  private Scanner getScanner() {
    return new Scanner(System.in);
  }

  private String getInput(@NotNull Scanner scanner) {
    return scanner.nextLine();
  }

  private String getInputString() {
    Scanner scanner = getScanner();
    return getInput(scanner);
  }

  LocalDate getLocalDate(String input) {
    DateParser dateParser = new DateParser();
    return dateParser.getDateFromString(input);
  }

  boolean projectExists(String input) {
    return taskManager.doesProjectExist(input);
  }

  void createProject(String input) {
    taskManager.createProject(input);
  }

  void addTaskToProject(String input, Integer taskIndex) {
    taskManager.addTaskToProject(taskIndex, input);
  }

  ArrayList<String> getTasksStringsByDueDate() {
    return taskManager.getAllTasksByDueDate();
  }

  void printTaskWithIndex(ArrayList<String> tasks, String task) {
    System.out.println((tasks.indexOf(task) + 1) + "- " + task);
  }

  void printLineBreak() {
    System.out.println();
  }

  ArrayList<Project> getProjects() {
    ArrayList<Project> projects;
    projects = taskManager.getAllProjects();
    return projects;
  }

  ArrayList<String> getAllWithNoProject() {
    return taskManager.getAllWithNoProject();
  }

  void printProjectTasks(Project project) {
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

  @NotNull Integer inputToInteger(String input) {
    return Integer.valueOf(input);
  }

  void addTask(String taskTitle) {
    taskManager.addTask(taskTitle);
  }

  String promptForInput(String prompt) {
    prompt(prompt);
    return getInputString();
  }
}
