package com.alaskalany.todoly.todo.project;

import com.alaskalany.todoly.todo.task.Task;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class Project implements Serializable {

  private static final long serialVersionUID = 1L;
  private final Predicate<Task> finishedTask = Task::getStatus;
  private final Predicate<Task> unfinishedTask = task -> !task.getStatus();
  /**
   * List of tasks in the project
   */
  private ArrayList<Task> tasks = new ArrayList<>();
  private UUID id;
  /**
   * Project title
   */
  private String title;

  private Project(@NotNull Builder builder) {

    this.title = builder.title;
    this.id = UUID.randomUUID();
  }

  /**
   * @param label {@link String Label of the task}
   * @param date  {@link String Due date for the task}
   */
  public void addTask(String label, LocalDate date) {
    // TODO how and where to create task id?
    new Task.Builder().title(label).dueDate(date).status(false).project(this).build();
  }

  /**
   * @return {@link String} Name of the project
   */
  public String getTitle() {

    return title;
  }

  /**
   * @param title {@link String} New project title
   */
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return {@link ArrayList<Task>} Tasks in the project
   */
  public ArrayList<Task> getTasks() {

    return tasks;
  }

  /**
   * @return {int} Number of finished tasks in the project
   */
  public int finishedTasksCount() {
    return Math.toIntExact(tasks.stream().filter(finishedTask).count());
  }

  /**
   * Deletes all tasks in the project
   */
  public void deleteAllTasks() {
    tasks.clear();
  }

  /**
   * @return int Number of unfinished tasks in the project
   */
  public int getUnfinishedTasksCount() {
    //noinspection UnnecessaryLocalVariable

    return Math.toIntExact(tasks.stream().filter(unfinishedTask).count());
  }

  /**
   * Deletes all finished tasks in the project
   */
  public void deleteFinishedTasks() {

    tasks = tasks.stream().filter(finishedTask).collect(Collectors.toCollection(ArrayList::new));
  }

  public void removeTask(int i) {

    tasks.remove(i);
  }

  public Task getTask(int i) {

    return tasks.get(i);
  }

  public UUID getId() {

    return id;
  }

  public void addTask(Task task) {

    tasks.add(task);
    task.setProject(this);
  }

  /**
   * Builder class for the Project class
   */
  // [START builder]
  public static class Builder {

    private String title;

    public Builder title(String title) {

      this.title = title;
      return this;
    }

    public Project build() {

      return new Project(this);
    }
  }
  // [END builder]
}
