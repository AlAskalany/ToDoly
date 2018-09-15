package com.alaskalany.todoly.todo;

import java.util.ArrayList;

class Project {
    private String name;
    private ArrayList<Task> tasks = new ArrayList<>();

    private Project(String name) {
        this.name = name;
    }

    static Project createProject(String name) {
        return new Project(name);
    }

    void addTask(String label, String date) {
        Task task = Task.createTask(label, date, this);
        tasks.add(task);
    }

    String getName() {
        return name;
    }

    ArrayList<Task> getTasks() {
        return tasks;
    }

    int getTasksCount() {
        return tasks.size();
    }

    int getFinishedTasksCount() {
        int finishedTasksCount = 0;
        for (Task task : tasks) {
            if (task.getDone()) {
                finishedTasksCount += 1;
            }
        }
        return finishedTasksCount;
    }

    void setName(@SuppressWarnings("SameParameterValue") String new_project_name) {
        name = new_project_name;
    }

    void deleteAllTasks() {
        int i = tasks.size()-1;
        while (tasks.size() > 0){
            tasks.remove(i--);
        }
    }

    int getUnfinishedTasksCount() {
        return tasks.size() - getFinishedTasksCount();
    }

    void deleteFinishedTasks() {
        int i = tasks.size()-1;
        while (i > 0){
            if(tasks.get(i).getDone()){
                tasks.remove(i);
            }
            i--;
        }
    }
}
