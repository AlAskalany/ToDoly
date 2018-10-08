package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.UiImpl;

import java.util.ArrayList;

public class ListAllTasksByProjectCommand extends Command {

    private ListAllTasksByProjectCommand(Ui ui) {

        super(ui);
    }

    public static ListAllTasksByProjectCommand create(Ui ui) {

        return new ListAllTasksByProjectCommand(ui);
    }

    public void invoke() {

        UiImpl.FROM_LIST_BY_PROJECT = true;
        System.out.println(TaskListByProjectMenu.ALL_TASKS_LIST_BY_PROJECT.getValue());
        System.out.println();
        ArrayList<Project> projects;
        projects = ui.getTaskManager().getAllProjects();
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
        ArrayList<String> tasksWithNoProject = ui.getTaskManager().getAllWithNoProject();
        System.out.println();
        System.out.println(TaskListByProjectMenu.TASKS_WITH_NO_PROJECT.getValue());
        System.out.println();
        tasksWithNoProject
                .forEach(task -> System.out.println((tasksWithNoProject.indexOf(task) + 1) + "- " + task));
        System.out.println();
        ui.selectTaskOrMainMenu();
    }

    @Override
    public void invoke(Integer valueOf) {

    }

    @Override
    public void handleInput(Integer taskIndex) {

    }

    @Override
    public void handleInput(Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input) {

    }

    @Override
    public void handleInput(String input, Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input, Ui ui) {

    }

    public enum TaskListByProjectMenu {
        ALL_TASKS_LIST_BY_PROJECT("All Tasks List - By Project"), TASKS_WITH_NO_PROJECT(
                "Tasks with no project:");
        private String value;

        TaskListByProjectMenu(String value) {

            this.value = value;
        }

        public String getValue() {

            return value;
        }
    }
}
