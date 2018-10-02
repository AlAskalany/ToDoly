package com.alaskalany.todoly;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.Project;
import com.alaskalany.todoly.todo.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ui {

    private final TaskManager taskManager;

    public Ui(TaskManager taskManager) {

        this.taskManager = taskManager;
    }

    void mainMenu() {

        System.out.println("ToDoly");
        System.out.println("1- Add a task");
        System.out.println("2- List all tasks");
        System.out.println("3- Save and quit");
        System.out.println();
        System.out.print("Enter a choice: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        handleMainMenuInput(input);
    }

    void handleMainMenuInput(String input) {

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
                System.out.print("Enter a choice: ");
                mainMenu();
                break;
        }
    }

    void addTask() {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String input;
        System.out.print("Enter task name:");
        input = scanner.next();
        String taskTitle = getTaskTitle(input);
        taskManager.addTask(taskTitle);
        mainMenu();
    }

    String getTaskTitle(String input) {

        return input;
    }

    void listAllTasks() {

        System.out.println("List all tasks by:");
        System.out.println("1- Due date");
        System.out.println("2- Project");
        System.out.print("Enter a choice: ");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        handleListAllTasksInput(input);
    }

    void handleListAllTasksInput(String input) {

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

    void listAllTasksByProject() {

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
        tasksWithNoProject.forEach(task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
        System.out.println();
        selectTaskOrMainMenu();
    }

    void selectTaskOrMainMenu() {

        System.out.print("Enter task number to edit or 0 for main menu");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleSelectTaskOrMainMenu(input);
    }

    void handleSelectTaskOrMainMenu(String input) {

        switch (Integer.valueOf(input)) {
            case 0:
                mainMenu();
                break;
            default:
                editSelectedTask(Integer.valueOf(input));
                break;
        }
    }

    void editSelectedTask(Integer valueOf) {

        System.out.println("Editing Task:" + taskManager.getTaskTitle(valueOf));
        System.out.println("1- Title");
        System.out.println("2- Status");
        System.out.println("3- Project");
        System.out.println("4- Due date");
        System.out.print("Enter a choice or 0 for main menu: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleEditSelectedTask(input, valueOf);
    }

    void handleEditSelectedTask(String input, Integer taskIndex) {

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

    void editTaskDueDate(Integer taskIndex) {

        System.out.print("New Due date: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DateParser dateParser = new DateParser();
        Date dueDate = dateParser.getDateFromString(input);
        taskManager.getTask(taskIndex).setDueDate(dueDate);
        System.out.println("Task Due date modified");
        editSelectedTask(taskIndex);
    }

    void editTaskProject(Integer taskIndex) {

        System.out.print("New Project: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!taskManager.doesProjectExist(input)) {
            taskManager.createProject(input);
        }
        taskManager.addTaskToProject(taskIndex, input);
        System.out.println("Task Project modified");
        editSelectedTask(taskIndex);
    }

    void editTaskStatus(Integer taskIndex) {

        System.out.print("New Status: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        taskManager.getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        editSelectedTask(taskIndex);
    }

    void editTaskTitle(Integer taskIndex) {

        System.out.print("New title: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        taskManager.getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        editSelectedTask(taskIndex);
    }

    void listAllTasksByDueDate() {

        System.out.println("All Tasks List - By Due Date");
        System.out.println();
        ArrayList<String> tasks = taskManager.getAllTasksByDueDate();
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
        System.out.println();
        selectTaskOrMainMenu();
    }

    void saveAndQuit() {

        System.exit(0);
    }
}