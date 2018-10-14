package com.alaskalany.todoly.todo;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.project.Project.Builder;
import com.alaskalany.todoly.todo.task.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class TaskManager {

  private final ArrayList<Task> taskArrayList = new ArrayList<>();
  private final HashMap<String, Project> stringProjectHashMap = new HashMap<>();
  private final Predicate<Task> taskWithProjectPredicate = task -> task.getProject() != null;
  private final Function<Task, String> taskStringFunction = Task::toString;
  private final Comparator<Project> projectTitleComparator = Comparator
      .comparing(Project::getTitle);
  private final BiFunction<ArrayList<Project>, Project, Boolean> addProjectToList = ArrayList::add;
  private final Function<String, Project> projectFromTitle = title -> new Builder().title(title)
      .build();
  private final BiConsumer<ArrayList<Project>, Comparator<Project>> projectSorter = ArrayList::sort;
  private final Comparator<Task> taskComparator = Task::compareTo;
  private final Function<ArrayList<Task>, ArrayList<Task>> copyTasks = ArrayList::new;
  private final BiConsumer<ArrayList<Task>, Comparator<Task>> tasksSorter = ArrayList::sort;
  private final BiFunction<ArrayList<Task>, Function<Task, String>, ArrayList<String>> tasksToTitles = (tasks, taskToStringFunction) -> tasks
      .stream().map(taskToStringFunction).collect(Collectors.toCollection(ArrayList::new));
  private final Supplier<ArrayList<Project>> projectListSupplier = ArrayList::new;
  private final ToIntFunction<Integer> minusOne = i -> i - 1;

  public void addTask(String taskTitle) {

    taskArrayList.add(new Task.Builder().title(taskTitle).build());
  }

  public ArrayList<String> getAllTasksByDueDate() {

    ArrayList<Task> orderedTasks = copyTasks.apply(taskArrayList);
    tasksSorter.accept(orderedTasks, taskComparator);
    return tasksToTitles.apply(orderedTasks, taskStringFunction);
  }

  public String getTaskTitle(Integer valueOf) {

    return taskArrayList.get(valueOf - 1).getTitle();
  }

  public Task getTask(Integer taskIndex) {

    return taskArrayList.get(taskIndex - 1);
  }

  public boolean doesProjectExist(String input) {

    return stringProjectHashMap.containsKey(input);
  }

  public void createProject(String title) {

    stringProjectHashMap.put(title, projectFromTitle.apply(title));
  }

  public void addTaskToProject(Integer taskIndex, String input) {

    int index = minusOne.applyAsInt(taskIndex);
    stringProjectHashMap.get(input).addTask(taskArrayList.get(index));
  }

  public ArrayList<String> getAllWithNoProject() {

    return taskArrayList.stream().filter(taskWithProjectPredicate)
        .map(taskStringFunction).collect(Collectors.toCollection(ArrayList::new));
  }

  public ArrayList<Project> getProjectsList() {

    ArrayList<Project> projectsList = projectListSupplier.get();
    stringProjectHashMap
        .forEach((projectTitle, project) -> addProjectToList.apply(projectsList, project));
    projectSorter.accept(projectsList, projectTitleComparator);
    return projectsList;
  }
}
