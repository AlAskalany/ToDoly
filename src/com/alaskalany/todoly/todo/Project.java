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

    public String getName(){
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
