package com.alaskalany.todoly;

import com.alaskalany.todoly.cli.Cli;
import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class ToDoly {

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {

        Cli cli = new Cli();
        printMessage("Enter task title: ");
        Scanner scanner = new Scanner(System.in);
        printInput(scanner);
        taskDueDateUi(scanner);
        taskStatusUi(scanner);
        selectOptionUi(scanner);
        ArrayList<Project> projects = initProjectsList();
        showProjectsUi(projects);
        selectProjectUi(scanner, projects);
    }

    private static void selectProjectUi(Scanner scanner, ArrayList<Project> projects) {

        int lastOption = projects.size();
        int result2;
        System.out.println("Enter selection from 1 to " + lastOption + ": ");
        int selectedOption2 = inputToInteger(scanner);
        if (selectedOption2 >= 1 && selectedOption2 <= lastOption) {
            result2 = selectedOption2;
        } else {
            System.out.println("Please enter a valid selection.");
            result2 = 0;
        }
        int inputInt = result2;
        if (inputInt == 0) {
            //getSelectedProjectFromUser(projects, input);
        }
        int projectIndex = inputInt - 1;
        Project selectedProject = projects.get(projectIndex);
        System.out.println(selectedProject.getTitle());
    }

    private static void showProjectsUi(ArrayList<Project> projects) {

        System.out.println();
        System.out.println("Projects List");
        System.out.println();
        projects.forEach(project -> {
            int projectOptionNumber = projects.indexOf(project) + 1;
            String projectTitle = project.getTitle();
            System.out.println(projectOptionNumber + "- " + projectTitle);
        });
    }

    private static void selectOptionUi(Scanner scanner) {

        int result1;
        printMessage("Enter selection from 1 to " + 3 + ": ");
        int selectedOption1 = inputToInteger(scanner);
        if (selectedOption1 >= 1 && selectedOption1 <= 3) {
            result1 = selectedOption1;
        } else {
            System.out.println("Please enter a valid selection.");
            result1 = 0;
        }
        int selectedOption = result1;
        System.out.println(selectedOption);
    }

    private static void taskDueDateUi(Scanner scanner) {

        printMessage("Enter task due date: ");
        DateParser dateParser = new DateParser();
        Date taskDueDate = dateParser.getDateFromString(getUserInput(scanner));
        System.out.println(taskDueDate);
    }

    private static void taskStatusUi(Scanner scanner) {

        boolean result;
        printMessage("Enter task status: ");
        if (getUserInput(scanner).equals("done")) {
            result = true;
        } else {
            result = false;
        }
        boolean taskStatus = result;
        System.out.println(taskStatus);
    }

    private static ArrayList<Project> initProjectsList() {

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(createProject("Project 1"));
        projects.add(createProject("Project 2"));
        projects.add(createProject("Project 3"));
        return projects;
    }

    private static Project createProject(String s) {

        Project project1 = new Project();
        project1.setTitle(s);
        return project1;
    }

    private static int inputToInteger(Scanner scanner) {

        return Integer.parseInt(getUserInput(scanner));
    }

    private static String getUserInput(Scanner scanner) {

        return scanner.nextLine();
    }

    private static void printInput(Scanner scanner) {

        String userInput = getUserInput(scanner);
        System.out.println(userInput);
    }

    private static void printMessage(String s) {

        System.out.print(s);
    }
}
