package com.alaskalany.todoly;

import com.alaskalany.todoly.cli.Cli;
import com.alaskalany.todoly.todo.Project;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class ToDoly {

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {
        Cli cli = new Cli();
        String userInput = cli.getTaskTitleFromUser();
        System.out.println(userInput);
        Date taskDueDate = cli.getTaskDueDateFromUser();
        System.out.println(taskDueDate);
        boolean taskStatus = cli.getTaskStatusFromUser();
        System.out.println(taskStatus);
        int selectedOption = cli.getSelectedOptionFromUser(3);
        System.out.println(selectedOption);

        Project project1 = new Project();
        project1.setTitle("Project 1");
        Project project2 = new Project();
        project2.setTitle("Project 2");
        Project project3 = new Project();
        project3.setTitle("Project 3");

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        System.out.println();

        cli.showProjectsListToUser(projects);

        Project selectedProject = cli.getSelectedProjectFromUser(projects);

        System.out.println(selectedProject.getTitle());


    }

}
