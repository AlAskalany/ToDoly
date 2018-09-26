package com.alaskalany.todoly.todo;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
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

    public Task(Builder builder) {
        this.title = builder.title;
        this.id = builder.id;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.projectId = builder.projectId;
    }

    String getTitle() {
        return title;
    }

    Date getDueDate() {
        return dueDate;
    }

    void setTitle(@SuppressWarnings("SameParameterValue") String label) {
        this.title = label;
    }

    @SuppressWarnings("SameParameterValue")
    void setDueDate(Date date) {
        this.dueDate = date;
    }

    @SuppressWarnings("WeakerAccess")
    public void setStatusTrue() {
        status = true;
    }

    @SuppressWarnings("WeakerAccess")
    public boolean getStatus() {
        return status;
    }

    void setStatusFalse() {
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

    public static class Builder {
        private String title;
        private Long id;
        private Boolean status;
        private Long projectId;
        private Date dueDate;

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
            return new Task(this);
        }

        public Builder dueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }
    }
}
