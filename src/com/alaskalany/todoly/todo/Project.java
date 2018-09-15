package com.alaskalany.todoly.todo;

import java.util.ArrayList;

/**
 *
 */
class Project {
    /**
     * Project name
     */
    private String name;
    /**
     * List of tasks in the project
     */
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * @param name {@link String} Project name
     */
    private Project(String name) {
        this.name = name;
    }

    /**
     * @param name {@link String} Project name
     * @return {@link Project} Project instance
     */
    static Project createProject(String name) {
        return new Project(name);
    }

    /**
     * @param label {@link String Label of the task}
     * @param date  {@link String Due date for the task}
     */
    void addTask(String label, String date) {
        Task task = Task.createTask(label, date, this);
        tasks.add(task);
    }

    /**
     * @return {@link String} Name of the project
     */
    String getName() {
        return name;
    }

    /**
     * @return {@link ArrayList<Task>} Tasks in the project
     */
    ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * @return {int} Number of tasks in the project
     */
    int numTasks() {
        return tasks.size();
    }

    /**
     * @return {int} Number of finished tasks in the project
     */
    int numFinishedTasks() {
        int finishedTasksCount = 0;
        for (Task task : tasks) {
            if (task.isFinished()) {
                finishedTasksCount += 1;
            }
        }
        return finishedTasksCount;
    }

    /**
     * @param new_project_name {@link String} New project name
     */
    void setName(@SuppressWarnings("SameParameterValue") String new_project_name) {
        name = new_project_name;
    }

    /**
     * Deletes all tasks in the project
     */
    void deleteAllTasks() {
        // Start from the last task in the tasks list
        int i = getLastTask(tasks);
        // Remove every task
        while (numTasks() > 0) {
            removeTask(i--);
        }
    }

    /**
     * @return int Number of unfinished tasks in the project
     */
    int getUnfinishedTasksCount() {
        //noinspection UnnecessaryLocalVariable
        int numUnfinishedTasks = numTasks() - numFinishedTasks();
        return numUnfinishedTasks;
    }

    /**
     * Deletes all finished tasks in the project
     */
    void deleteFinishedTasks() {
        // Start from the last task in the tasks list
        int i = getLastTask(tasks);
        while (i > 0) {
            if (getTask(i).isFinished()) {
                removeTask(i);
            }
            i--;
        }
    }

    public void removeTask(int i) {
        tasks.remove(i);
    }

    public Task getTask(int i) {
        return tasks.get(i);
    }

    private static int getLastTask(ArrayList<Task> tasks) {
        return tasks.size() - 1;
    }
}
