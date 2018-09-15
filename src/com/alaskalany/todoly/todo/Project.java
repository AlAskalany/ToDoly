package com.alaskalany.todoly.todo;

import java.util.ArrayList;

public class Project {
    private String name;
    private ArrayList<Task> tasks = new ArrayList<>();

    private Project(String name) {
        this.name = name;
    }

    public static Project createProject(String name) {
        return new Project(name);
    }

    public void addTask(String label, String date) {
        Task task = Task.createTask(label, date, this);
        tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getTasksCount() {
        return tasks.size();
    }

    public int getFinishedTasksCount() {
        int finishedTasksCount = 0;
        for (Task task : tasks) {
            if (task.getDone()) {
                finishedTasksCount += 1;
            }
        }
        return finishedTasksCount;
    }

    public void setName(String new_project_name) {
        name = new_project_name;
    }

    public void deleteAllTasks() {
        int i = tasks.size()-1;
        while (tasks.size() > 0){
            tasks.remove(i--);
        }
    }

    public int getUnfinishedTasksCount() {
        return tasks.size() - getFinishedTasksCount();
    }

    public void deleteFinishedTasks() {
        int i = tasks.size()-1;
        while (i > 0){
            if(tasks.get(i).getDone()){
                tasks.remove(i);
            }
            i--;
        }
    }
}
