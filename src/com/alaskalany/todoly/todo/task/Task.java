package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.todo.project.Project;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable, Comparable<Task> {

    public static final String TITLE = "title";
    public static final String ID = "id";
    public static final String STATUS = "status";
    public static final String PROJECT_ID = "project-id";
    public static final String DUE_DATE = "due-date";
    private Date dueDate;
    private Long projectId;
    private Boolean status;
    private Long id;
    private String title;
    private transient Project project;

    public Task(Builder builder) {

        this.title = builder.title;
        this.id = builder.id;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.projectId = builder.projectId;
        this.project = builder.project;
    }

    public void setProject(Project project) {

        this.project = project;
    }

    public Project getProject() {

        return project;
    }

    public String getTitle() {

        return title;
    }

    public Date getDueDate() {

        return dueDate;
    }

    public void setTitle(@SuppressWarnings("SameParameterValue") String label) {

        this.title = label;
    }

    @SuppressWarnings("SameParameterValue")
    public void setDueDate(Date date) {

        this.dueDate = date;
    }

    @SuppressWarnings("WeakerAccess")
    public void setStatusTrue() {

        status = true;
    }

    @SuppressWarnings("WeakerAccess")
    public Boolean getStatus() {

        return status;
    }

    public void setStatusFalse() {

        status = false;
    }

    public Long getProjectId() {

        return projectId;
    }

    public void setProjectId(Long projectId) {

        this.projectId = projectId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public int compareTo(@NotNull Task otherTask) {

        if (getDueDate() == null || otherTask.getDueDate() == null) {
            return 0;
        }
        return getDueDate().compareTo(otherTask.getDueDate());
    }

    @Override
    public String toString() {

        return getTaskString();
    }

    @NotNull
    private String getTaskString() {

        return title + " | " + getDueDateOrNoDueDateString() + " | " + getProjectOrNoProjectString() + " | " + getStatusString();
    }

    private String getStatusString() {

        return (getStatus() != null && getStatus()) ? "Done" : "To do";
    }

    private String getProjectOrNoProjectString() {

        return hasProject() ? getTitleString() : "No project";
    }

    private String getDueDateOrNoDueDateString() {

        return hasDueDate() ? getDueDateString() : "No due date";
    }

    private String getTitleString() {

        return getProject().getTitle();
    }

    private String getDueDateString() {

        return getDueDate()
                .toString();
    }

    public boolean hasProject() {

        return getProject() != null;
    }

    private boolean hasDueDate() {

        return getDueDate() != null;
    }

    public static class Builder {

        public Project project;
        private String title;
        private Long id;
        private Boolean status;
        private Long projectId;
        private Date dueDate;

        public Builder project(Project project) {

            this.project = project;
            return this;
        }

        public Builder title(String title) {

            this.title = title;
            return this;
        }

        public Builder id(Long id) {

            this.id = id;
            return this;
        }

        public Builder status(Boolean status) {

            this.status = status;
            return this;
        }

        public Builder projectId(Long projectId) {

            this.projectId = projectId;
            return this;
        }

        public Task build() {

            Task task = new Task(this);
            if (project != null) {
                project.addTask(task);
            }
            return task;
        }

        public Builder dueDate(Date dueDate) {

            this.dueDate = dueDate;
            return this;
        }

        @Override
        public String toString() {

            return title + " | ";
        }
    }
}
