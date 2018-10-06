package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.date.DateHelper;
import com.alaskalany.todoly.todo.project.Project;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Task implements Serializable, Comparable<Task> {

    private LocalDate dueDate;
    private UUID projectId;
    private Boolean status;
    private String title;
    private transient Project project;

    private Task(@NotNull Builder builder) {

        this.title = builder.title;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.projectId = builder.projectId;
        this.project = builder.project;
    }

    public void setProject(Project project) {

        this.project = project;
        this.projectId = project.getId();
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(@SuppressWarnings("SameParameterValue") String label) {

        this.title = label;
    }

    public LocalDate getDueDate() {

        return dueDate;
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

    public UUID getProjectId() {

        return projectId;
    }

    public void setProjectId(UUID projectId) {

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

    @NotNull
    @Contract(pure = true)
    private String getStatusString() {

        return (status != null && status) ? "Done" : "To do";
    }

    private String getProjectOrNoProjectString() {

        return (project != null) ? getTitleString() : "No project";
    }

    @NotNull
    private String getDueDateOrNoDueDateString() {

        return (dueDate != null) ? DateHelper.getFormattedDateFromLocalDate(dueDate) : "No due date";
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
        private UUID projectId;
        private LocalDate dueDate;

        public Builder title(String title) {

            this.title = title;
            return this;
        }

        public Builder status(Boolean status) {

            this.status = status;
            return this;
        }

        public Builder projectId(UUID projectId) {

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
