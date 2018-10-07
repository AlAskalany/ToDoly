package com.alaskalany.todoly.todo.ui;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import com.alaskalany.todoly.todo.ui.commands.*;
import org.jetbrains.annotations.Contract;

import javax.inject.Inject;

public class UiImpl extends Ui {

    public static boolean FROM_LIST_BY_DUE_DATE = false;
    public static boolean FROM_LIST_BY_PROJECT = true;
    private final EditTaskTitleCommand editTaskTitleCommand = EditTaskTitleCommand.create(this);
    private final ListAllTasksByProjectCommand listAllTasksByProjectCommand = ListAllTasksByProjectCommand.create(this);
    private final EditSelectedTaskCommand editSelectedTaskCommand = EditSelectedTaskCommand.create(this);
    private final ListAllTasksByDueDateCommand listAllTasksByDueDateCommand = ListAllTasksByDueDateCommand.create(this);
    private final MainMenuCommand mainMenuCommand = MainMenuCommand.create(this);
    private final ListAllTasksCommand listAllTasksCommand = ListAllTasksCommand.create(this);
    private final AddTaskCommand addTaskCommand = AddTaskCommand.create(this);
    private final EditTaskProjectCommand editTaskProjectCommand = EditTaskProjectCommand.create(this);
    private final EditTaskDueDateCommand editTaskDueDateCommand = EditTaskDueDateCommand.create(this);
    private final EditTaskStatusCommand editTaskStatusCommand = EditTaskStatusCommand.create(this);
    private final SaveAndQuitCommand saveAndQuitCommand = SaveAndQuitCommand.create();
    private final SelectTaskOrMainMenuCommand selectTaskOrMainMenuCommand = SelectTaskOrMainMenuCommand.create(this);
    @Inject
    private TaskManager taskManager;
    @Inject
    private DateParser dateParser;

    @Override
    public void mainMenu() {

        mainMenuCommand.invoke();
    }

    @Override
    public TaskManager getTaskManager() {

        return taskManager;
    }

    @Override
    public DateParser getDateParser() {

        return dateParser;
    }

    public void addTask() {

        addTaskCommand.invoke();
    }

    @Contract(value = "_ -> param1", pure = true)
    public String getTaskTitle(String input) {

        return input;
    }

    public void listAllTasks() {

        listAllTasksCommand.invoke();
    }

    public void listAllTasksByProject() {

        listAllTasksByProjectCommand.invoke();
    }

    public void selectTaskOrMainMenu() {

        selectTaskOrMainMenuCommand.invoke();
    }

    public void editSelectedTask(Integer valueOf) {

        editSelectedTaskCommand.invoke(valueOf);
    }

    public boolean isTaskIndexValid(Integer taskIndex) {

        return taskManager.isTaskIndexValid(taskIndex);
    }

    public void editTaskDueDate(Integer taskIndex) {

        editTaskDueDateCommand.invoke(taskIndex);
    }

    public void editTaskProject(Integer taskIndex) {

        editTaskProjectCommand.invoke(taskIndex);
    }

    public void editTaskStatus(Integer taskIndex) {

        editTaskStatusCommand.invoke(taskIndex);
    }

    public void editTaskTitle(Integer taskIndex) {

        editTaskTitleCommand.invoke(taskIndex);
    }

    public void listAllTasksByDueDate() {

        listAllTasksByDueDateCommand.invoke();
    }

    public void saveAndQuit() {

        saveAndQuitCommand.invoke();
    }
}