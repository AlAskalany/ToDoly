package com.alaskalany.todoly.todo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class TaskManager {

  private ArrayList<Task> allTasksList;
  private HashMap<String, Project> projectsMap;

  public TaskManager() {
    allTasksList = new ArrayList<>();
    projectsMap = new HashMap<>();
  }

  public void addTaskWithTitle(String taskTitle) {

    allTasksList.add(new Task.Builder().title(taskTitle).build());
  }

  public ArrayList<String> getAllTasksByDueDate() {

    ArrayList<Task> orderedTasks = new ArrayList<>(allTasksList);
    orderedTasks.sort(Task::compareTo);
    ArrayList<String> taskTitles = new ArrayList<>();
    orderedTasks.forEach(task -> taskTitles.add(task.toString()));
    return taskTitles;
  }

  public boolean isTaskIndexValid(Integer taskIndex) {

    return allTasksList.size() > taskIndex;
  }

  public String getTaskTitle(Integer taskIndex) {

    return allTasksList.get(taskIndex - 1).getTitle();
  }

  public Task getTask(Integer taskIndex) {

    return allTasksList.get(taskIndex - 1);
  }

  public boolean doesProjectExist(String input) {

    return projectsMap.containsKey(input);
  }

  public void createProject(String input) {

    projectsMap.put(input, new Project(input));
  }

  public void addTaskToProject(Integer taskIndex, String input) {

    projectsMap.get(input).addTask(allTasksList.get(taskIndex - 1));
  }

  public ArrayList<String> getAllWithNoProject() {

    ArrayList<String> taskTitles = new ArrayList<>();
    allTasksList.forEach(task -> {
      if (!task.hasProject()) {
        taskTitles.add(task.toString());
      }
    });
    return taskTitles;
  }

  public ArrayList<Project> getAllProjects() {

    ArrayList<Project> projectsList = new ArrayList<>();
    projectsMap.forEach((s, project) -> projectsList.add(project));
    projectsList.sort(Comparator.comparing(Project::getTitle));
    return projectsList;
  }

}
