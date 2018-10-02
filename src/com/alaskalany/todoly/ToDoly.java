package com.alaskalany.todoly;

import com.alaskalany.todoly.parsing.DateParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class ToDoly {

    private static TaskManager taskManager = new TaskManager();

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {

        mainMenu();
    }

    private static void mainMenu() {

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

    private static void handleMainMenuInput(String input) {

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
                break;
        }
    }

    private static void addTask() {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String input;
        System.out.print("Enter task name:");
        input = scanner.next();
        String taskTitle = getTaskTitle(input);
        taskManager.addTask(taskTitle);
        mainMenu();
    }

    private static String getTaskTitle(String input) {

        return input;
    }

    private static void listAllTasks() {

        System.out.println("List all tasks by:");
        System.out.println("1- Due date");
        System.out.println("2- Project");
        System.out.print("Enter a choice: ");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        handleListAllTasksInput(input);
    }

    private static void handleListAllTasksInput(String input) {

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

    private static void listAllTasksByProject() {

        System.out.println("All Tasks List - By Project");
        System.out.println();
        ArrayList<String> tasksWithProject = taskManager.getAllTasksWithAProject();
        ArrayList<String> tasksWithNoProject = taskManager.getAllWithNoProject();
        tasksWithProject.forEach(task -> System.out.println((tasksWithProject.indexOf(task) + 1) + "- " + task));
        System.out.println();
        System.out.println("Tasks with no project:");
        System.out.println();
        tasksWithNoProject.forEach(task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
        System.out.println();
        selectTaskOrMainMenu();
    }

    private static void selectTaskOrMainMenu() {

        System.out.print("Enter task number to edit or 0 for main menu");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleSelectTaskOrMainMenu(input);
    }

    private static void handleSelectTaskOrMainMenu(String input) {

        switch (Integer.valueOf(input)) {
            case 0:
                mainMenu();
                break;
            default:
                editSelectedTask(Integer.valueOf(input));
                break;
        }
    }

    private static void editSelectedTask(Integer valueOf) {

        System.out.println("Editing Task:" + taskManager.getTaskTitle(valueOf ));
        System.out.println("1- Title");
        System.out.println("2- Status");
        System.out.println("3- Project");
        System.out.println("4- Due date");
        System.out.print("Enter a choice or 0 for main menu: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        handleEditSelectedTask(input, valueOf);
    }

    private static void handleEditSelectedTask(String input, Integer taskIndex) {

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

    private static void editTaskDueDate(Integer taskIndex) {

        System.out.print("New Due date: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DateParser dateParser = new DateParser();
        Date dueDate = dateParser.getDateFromString(input);
        taskManager.getTask(taskIndex).setDueDate(dueDate);
        System.out.println("Task Due date modified");
        editSelectedTask(taskIndex);
    }

    private static void editTaskProject(Integer taskIndex) {

        System.out.print("New Project: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!taskManager.doesProjectExist(input)) {
            taskManager.createProject(input);
        }
        taskManager.addTaskToProject(taskIndex, input);
        taskManager.getTask(taskIndex).setTitle(input);
        System.out.println("Task Project modified");
        editSelectedTask(taskIndex);
    }

    private static void editTaskStatus(Integer taskIndex) {

        System.out.print("New Status: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        taskManager.getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        editSelectedTask(taskIndex);
    }

    private static void editTaskTitle(Integer taskIndex) {

        System.out.print("New title: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        taskManager.getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        editSelectedTask(taskIndex);
    }

    private static void listAllTasksByDueDate() {

        System.out.println("All Tasks List - By Due Date");
        System.out.println();
        ArrayList<String> tasks = taskManager.getAllTasksByDueDate();
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
        System.out.println();
        selectTaskOrMainMenu();
    }

    private static void saveAndQuit() {

        System.exit(0);
    }
}
