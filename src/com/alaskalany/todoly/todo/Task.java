package com.alaskalany.todoly.todo;

public class Task {
    private String label;
    private String date;
    private Project project;
    private boolean done;

    private Task(String label, String date, Project project) {
        this.label = label;
        this.date = date;
        this.project = project;
    }

    @SuppressWarnings("WeakerAccess")
    public static Task createTask(String label, String date, Project project) {
        return new Task(label, date, project);
    }

    public String getLabel() {
        return label;
    }

    public String getDate() {
        return date;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @SuppressWarnings("WeakerAccess")
    public void setDone() {
        done = true;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean getDone() {
        return done;
    }
}
