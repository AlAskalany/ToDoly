package com.alaskalany.todoly.todo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String TITLE = "title";
    public static final String ID = "id";
    private Long id;
    /**
     * Project title
     */
    private String title;
    /**
     * List of tasks in the project
     */
    private ArrayList<Task> tasks = new ArrayList<>();

    public Project() {

    }

    public Project(Builder builder) {

        this.title = builder.title;
        this.id = builder.id;
    }

    public Project(String input) {

        setTitle(input);
    }

    /**
     * @param label {@link String Label of the task}
     * @param date  {@link String Due date for the task}
     */
    void addTask(String label, Date date) {
        // TODO how and where to create task id?
        Long taskId = 1L;
        Task task = new Task.Builder().title(label).dueDate(date).id(taskId).status(false).projectId(this.id).build();
        tasks.add(task);
    }

    /**
     * @return {@link String} Name of the project
     */
    public String getTitle() {

        return title;
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
            if (task.getStatus()) {
                finishedTasksCount += 1;
            }
        }
        return finishedTasksCount;
    }

    /**
     * @param new_project_name {@link String} New project title
     */
    public void setTitle(@SuppressWarnings("SameParameterValue") String new_project_name) {

        title = new_project_name;
    }

    public ArrayList<Task> getAllTasks(){
        return tasks;
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
            if (getTask(i).getStatus()) {
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

    public Long getId() {

        return id;
    }

    public void addTask(Task task) {

        tasks.add(task);
        task.setProject(this);
    }

    /**
     * Builder class for the Project class
     */
    // [START builder]
    public static class Builder {

        private String title;
        private Long id;

        public Builder title(String title) {

            this.title = title;
            return this;
        }

        public Builder id(Long projectId) {

            this.id = projectId;
            return this;
        }

        public Project build() {

            return new Project(this);
        }
    }
    // [END builder]

    /*@Override
    public String toString() {
        return new StringBuffer(" id: ").append(this.id).append(" title: ").append(this.title).toString();
    }*/
}
