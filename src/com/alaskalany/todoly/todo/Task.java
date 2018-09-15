package com.alaskalany.todoly.todo;

class Task {
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

    String getLabel() {
        return label;
    }

    String getDate() {
        return date;
    }

    void setLabel(@SuppressWarnings("SameParameterValue") String label) {
        this.label = label;
    }

    @SuppressWarnings("SameParameterValue")
    void setDate(String date) {
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

    Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }

    void setUnfinished() {
        done = false;
    }
}
