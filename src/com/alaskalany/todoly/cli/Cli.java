package com.alaskalany.todoly.cli;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cli {
    public String getTaskTitleFromUser() {
        System.out.print("Enter task title: ");
        Scanner scanner = new Scanner(System.in);
        String taskTitle = scanner.nextLine();
        return taskTitle;
    }

    public Date getTaskDueDateFromUser() {
        System.out.print("Enter task due date: ");
        Scanner scanner = new Scanner(System.in);
        String dueDateString = scanner.nextLine();
        DateParser dateParser = new DateParser();
        return dateParser.getDateFromString(dueDateString);
    }

    public String getProjectTitleFromUser() {
        System.out.print("Enter project title: ");
        Scanner scanner = new Scanner(System.in);
        String projectTitle = scanner.nextLine();
        return projectTitle;
    }

    public boolean getTaskStatusFromUser() {
        System.out.print("Enter task status: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("done")) {
            return true;
        } else {
            return false;
        }
    }

    public int getSelectedOptionFromUser(int lastOption) {
        System.out.println("Enter selection from 1 to " + lastOption + ": ");
        Scanner scanner = new Scanner(System.in);
        int selectedOption = Integer.parseInt(scanner.nextLine());
        if (selectedOption >= 1 && selectedOption <= lastOption) {
            return selectedOption;
        } else {
            System.out.println("Please enter a valid selection.");
            return 0;
        }
    }

    public Project getSelectedProjectFromUser(ArrayList<Project> projects) {
        int input = getSelectedOptionFromUser(projects.size() - 1);
        if (input == 0) {
            getSelectedProjectFromUser(projects);
        }
        int projectIndex = input - 1;
        return projects.get(projectIndex);
    }

    public void showProjectsListToUser(ArrayList<Project> projects) {
        System.out.println("Projects List");
        System.out.println();
        projects.forEach(project -> {
            int projectOptionNumber = projects.indexOf(project) + 1;
            String projectTitle = project.getTitle();
            System.out.println(projectOptionNumber + "- " + projectTitle);
        });
    }
}
