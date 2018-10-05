package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.date.DateHelper;
import com.alaskalany.todoly.todo.project.Project;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable, Comparable<Task> {

    private LocalDate dueDate;
    private Long projectId;
    private Boolean status;
    private String title;
    private transient Project project;

    private Task(Builder builder) {

        this.title = builder.title;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.projectId = builder.projectId;
        this.project = builder.project;
    }

    public void setProject(Project project) {

        this.project = project;
    }

    public String getTitle() {

        return title;
    }

    public LocalDate getDueDate() {

        return dueDate;
    }

    public void setTitle(@SuppressWarnings("SameParameterValue") String label) {

        this.title = label;
    }

    @SuppressWarnings("SameParameterValue")
    public void setDueDate(LocalDate date) {

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

    @Override
    public int compareTo(@NotNull Task otherTask) {

        if (dueDate == null || otherTask.getDueDate() == null) {
            return 0;
        }
        return dueDate.compareTo(otherTask.getDueDate());
    }

    @Override
    public String toString() {

        return String
                .format("%s | %s | %s | %s", title, getDueDateOrNoDueDateString(), getProjectOrNoProjectString(), getStatusString());
    }

    private String getStatusString() {

        return (status != null && status) ? "Done" : "To do";
    }

    private String getProjectOrNoProjectString() {

        return (project != null) ? getTitleString() : "No project";
    }

    private String getDueDateOrNoDueDateString() {

        return (dueDate != null) ? DateHelper.getFormattedDate(dueDate) : "No due date";
    }

    private String getTitleString() {

        return project.getTitle();
    }

    public boolean hasProject() {

        return project != null;
    }

    public static class Builder {

        Project project;
        private String title;
        private Boolean status;
        private Long projectId;
        private LocalDate dueDate;

        public Builder title(String title) {

            this.title = title;
            return this;
        }

        public Builder id() {

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

        public Builder dueDate(LocalDate dueDate) {

            this.dueDate = dueDate;
            return this;
        }

        @Override
        public String toString() {

            return String.format("%s | ", title);
        }
    }
}
