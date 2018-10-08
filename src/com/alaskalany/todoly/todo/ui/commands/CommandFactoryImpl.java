package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.commands.uicommands.*;

public class CommandFactoryImpl implements CommandFactory {

    /**
     * Command: Add task
     *
     * @return {@link AddTaskCommand}
     */
    @Override
    public AddTaskCommand addTask(Ui ui) {

        return AddTaskCommand.create(ui);
    }

    /**
     * Command: Edit selected task
     *
     * @return {@link EditSelectedTaskCommand}
     */
    @Override
    public EditSelectedTaskCommand editSelectedTask(Ui ui) {

        return EditSelectedTaskCommand.create(ui);
    }

    /**
     * Command: Edit task due date
     *
     * @return {@link EditTaskDueDateCommand}
     */
    @Override
    public EditTaskDueDateCommand edtTaskDueDate(Ui ui) {

        return EditTaskDueDateCommand.create(ui);
    }

    /**
     * Command: Edit task project
     *
     * @return {@link EditTaskProjectCommand}
     */
    @Override
    public EditTaskProjectCommand editTaskProject(Ui ui) {

        return EditTaskProjectCommand.create(ui);
    }

    /**
     * Command: Edit task status
     *
     * @return {@link EditTaskStatusCommand}
     */
    @Override
    public EditTaskStatusCommand editTaskStatus(Ui ui) {

        return EditTaskStatusCommand.create(ui);
    }

    /**
     * Command: Edit task title
     *
     * @return {@link EditTaskTitleCommand}
     */
    @Override
    public EditTaskTitleCommand editTaskTitle(Ui ui) {

        return EditTaskTitleCommand.create(ui);
    }

    /**
     * Command: List all tasks by due date
     *
     * @return {@link ListAllTasksByDueDateCommand}
     */
    @Override
    public ListAllTasksByDueDateCommand listAllTasksByDueDate(Ui ui) {

        return ListAllTasksByDueDateCommand.create(ui);
    }

    /**
     * Command: List all tasks by project
     *
     * @return {@link ListAllTasksByProjectCommand}
     */
    @Override
    public ListAllTasksByProjectCommand listAllTasksByProject(Ui ui) {

        return ListAllTasksByProjectCommand.create(ui);
    }

    /**
     * Command: List all tasks
     *
     * @return {@link ListAllTasksCommand}
     */
    @Override
    public ListAllTasksCommand listAllTasks(Ui ui) {

        return ListAllTasksCommand.create(ui);
    }

    /**
     * Command: Main menu
     *
     * @return {@link MainMenuCommand}
     */
    @Override
    public MainMenuCommand mainMenu(Ui ui) {

        return MainMenuCommand.create(ui);
    }

    /**
     * Command: Save and quit application
     *
     * @return {@link SaveAndQuitCommand}
     */
    @Override
    public SaveAndQuitCommand saveAndQuit(Ui ui) {

        return SaveAndQuitCommand.create(ui);
    }

    /**
     * Command: Select task or return to main menu
     *
     * @return {@link SelectTaskOrMainMenuCommand}
     */
    @Override
    public SelectTaskOrMainMenuCommand selectTaskOrMainMenu(Ui ui) {

        return SelectTaskOrMainMenuCommand.create(ui);
    }
}
