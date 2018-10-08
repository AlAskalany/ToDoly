package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.commands.uicommands.*;

/**
 * Command Factory
 */
public interface CommandFactory {

    /**
     * Command: Add task
     *
     * @return {@link AddTaskCommand}
     */
    AddTaskCommand addTask(Ui ui);

    /**
     * Command: Edit selected task
     *
     * @return {@link EditSelectedTaskCommand}
     */
    EditSelectedTaskCommand editSelectedTask(Ui ui);

    /**
     * Command: Edit task due date
     *
     * @return {@link EditTaskDueDateCommand}
     */
    EditTaskDueDateCommand edtTaskDueDate(Ui ui);

    /**
     * Command: Edit task project
     *
     * @return {@link EditTaskProjectCommand}
     */
    EditTaskProjectCommand editTaskProject(Ui ui);

    /**
     * Command: Edit task status
     *
     * @return {@link EditTaskStatusCommand}
     */
    EditTaskStatusCommand editTaskStatus(Ui ui);

    /**
     * Command: Edit task title
     *
     * @return {@link EditTaskTitleCommand}
     */
    EditTaskTitleCommand editTaskTitle(Ui ui);

    /**
     * Command: List all tasks by due date
     *
     * @return {@link ListAllTasksByDueDateCommand}
     */
    ListAllTasksByDueDateCommand listAllTasksByDueDate(Ui ui);

    /**
     * Command: List all tasks by project
     *
     * @return {@link ListAllTasksByProjectCommand}
     */
    ListAllTasksByProjectCommand listAllTasksByProject(Ui ui);

    /**
     * Command: List all tasks
     *
     * @return {@link ListAllTasksCommand}
     */
    ListAllTasksCommand listAllTasks(Ui ui);

    /**
     * Command: Main menu
     *
     * @return {@link MainMenuCommand}
     */
    MainMenuCommand mainMenu(Ui ui);

    /**
     * Command: Save and quit application
     *
     * @return {@link SaveAndQuitCommand}
     */
    SaveAndQuitCommand saveAndQuit(Ui ui);

    /**
     * Command: Select task or return to main menu
     *
     * @return {@link SelectTaskOrMainMenuCommand}
     */
    SelectTaskOrMainMenuCommand selectTaskOrMainMenu(Ui ui);
}
