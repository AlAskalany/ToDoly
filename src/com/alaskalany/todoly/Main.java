package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.Project;
import com.alaskalany.todoly.todo.Task;

public class Main {

//    private static final String MAIN_MENU = "MainMenu";
//    private static final String SHOW_TASK_LIST_MENU = "ShowTaskListMenu";
//    private static final String EDIT_TASK_MENU = "EditTaskMenu";
//    private static final String ADD_NEW_TASK_MENU = "AddNewTaskMenu";
//    private static Printer printer = new Printer();
//    private static Ui ui;

    public static void main(String[] args) {
//        ui = Ui.getInstance();
//        ui.getMenu(MAIN_MENU).show(printer);
//        ui.handleMainMenuInput(printer);

        // Create a new project, give it a name, and add some tasks
        Project project = createSomeProject();
        // Print the project's name and tasks
        printProject(project);
        // Change the label of a task in the project
        changeChangeLabelOfProjectTask(project, 1, "Cool");
        // Print the project's name and tasks
        printProject(project);
    }

    private static Project createSomeProject() {
        Project project = Project.createProject("My Project");

        // Add new tasks to the project
        project.addTask("Do the dishes", "2018-09-20");
        project.addTask("Get the groceries", "2018-09-25");
        return project;
    }

    private static void changeChangeLabelOfProjectTask(Project project, int taskIndex, String label) {
        project.getTasks().get(taskIndex).setLabel(label);
    }

    private static void changeChangeDateOfProjectTask(Project project, int taskIndex, String date) {
        project.getTasks().get(taskIndex).setDate(date);
    }

    private static void printProject(Project project){
        printProjectName(project);
        printProjectTasks(project);
    }

    private static void printProjectName(Project project) {
        System.out.printf("%nProject: %s%n%n", project.getName());
    }

    private static void printProjectTasks(Project project) {
        for (Task task : project.getTasks()) {
            int taskIndex = project.getTasks().indexOf(task) + 1;
            String taskLabel = task.getLabel();
            String taskDate = task.getDate();
            System.out.printf("(%d) %s\t%s%n", taskIndex, taskLabel, taskDate);
        }
    }

}
