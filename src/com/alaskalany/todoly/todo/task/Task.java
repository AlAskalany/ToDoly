package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.date.DateHelper;
import com.alaskalany.todoly.todo.project.Project;
import java.io.Serializable;
import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;

public class Task implements Serializable, Comparable<Task> {

  private LocalDate dueDate;
  private Boolean status;
  private String title;
  private transient Project project;

  private Task(@NotNull Builder builder) {

    this.title = builder.title;
    this.status = builder.status;
    this.dueDate = builder.dueDate;
    this.project = builder.project;
  }

  public void setProject(Project project) {

    this.project = project;
  }

  public String getTitle() {

    return title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public LocalDate getDueDate() {

    return dueDate;
  }

  @SuppressWarnings("SameParameterValue")
  public void setDueDate(LocalDate date) {

    this.dueDate = date;
  }

  @SuppressWarnings("WeakerAccess")
  public Boolean getStatus() {

    return status;
  }

  @SuppressWarnings("WeakerAccess")
  public void setStatus(boolean status) {

    this.status = status;
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
        .format("%s | %s | %s | %s", title,
            (dueDate != null) ? DateHelper.getFormattedDateFromLocalDate(dueDate) : "No due date",
            (project != null) ? project.getTitle() : "No project",
            (status != null && status) ? "Done" : "To do");
  }

  public Project getProject() {
    return project;
  }

  // [START builder]
  public static class Builder {

    private Project project;
    private String title;
    private Boolean status;
    private LocalDate dueDate;

    public Builder title(String title) {

      this.title = title;
      return this;
    }

    public Builder status(Boolean status) {

      this.status = status;
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

    public Builder project(Project project) {
      this.project = project;
      return this;
    }
  }
  // [END builder]
}
