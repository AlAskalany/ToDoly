package com.alaskalany.todoly.cli;

import com.alaskalany.todoly.todo.TaskManager;

import java.util.ArrayList;

public class AddTaskMenu extends Menu {

    private MainMenu mainMenu;
    private TaskManager taskManager;

    public AddTaskMenu(MainMenu mainMenu, TaskManager taskManager) {

        super("Add new Task:");
        this.mainMenu = mainMenu;
        this.taskManager = taskManager;
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

    }

    @Override
    protected void displayBody() {

    }

    @Override
    protected String setPrompt() {

        return "Enter task name";
    }

    @Override
    public void setActions() {

    }

    @Override
    public void onInput(String taskTitle) {

        taskManager.addTask(taskTitle);
        mainMenu.display();
    }
}
