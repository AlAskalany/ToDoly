package com.alaskalany.todoly.todo.ui;

import com.alaskalany.todoly.parsing.DateParser;
import com.alaskalany.todoly.todo.taskmanager.TaskManager;
import org.jetbrains.annotations.Contract;

public abstract class Ui {

    public abstract void mainMenu();

    public abstract TaskManager getTaskManager();

    public abstract DateParser getDateParser();

    public abstract void addTask();

    @Contract(value = "_ -> param1", pure = true)
    public abstract String getTaskTitle(String input);

    public abstract void listAllTasks();

    public abstract void listAllTasksByProject();

    public abstract void selectTaskOrMainMenu();

    public abstract void editSelectedTask(Integer valueOf);

    public abstract boolean isTaskIndexValid(Integer taskIndex);

    public abstract void editTaskDueDate(Integer taskIndex);

    public abstract void editTaskProject(Integer taskIndex);

    public abstract void editTaskStatus(Integer taskIndex);

    public abstract void editTaskTitle(Integer taskIndex);

    public abstract void listAllTasksByDueDate();

    public abstract void saveAndQuit();
}
