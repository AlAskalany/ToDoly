package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.Project;
import com.alaskalany.todoly.todo.Task;
import com.alaskalany.todoly.todo.TasksComparator;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private ArrayList<Task> tasks = new ArrayList<>();
    private HashMap<String, Project> projects = new HashMap<>();

    public void addTask(String taskTitle) {

        tasks.add(new Task.Builder().title(taskTitle).build());
    }

    public ArrayList<String> getAllTasksByDueDate() {

        ArrayList<Task> orderedTasks = new ArrayList<>(tasks);
        orderedTasks.sort(Task::compareTo);
        ArrayList<String> taskTitles = new ArrayList<>();
        orderedTasks.forEach(task -> taskTitles.add(task.toString()));
        return taskTitles;
    }

    public ArrayList<String> getAllTasksWithAProject() {

        ArrayList<String> taskTitles = new ArrayList<>();
        projects.forEach((s, project) -> project.getAllTasks().forEach(task -> taskTitles.add(task.toString())));
        return taskTitles;
    }

    public String getTaskTitle(Integer valueOf) {

        return tasks.get(valueOf-1).getTitle();
    }

    public Task getTask(Integer taskIndex) {

        return tasks.get(taskIndex-1);
    }

    public boolean doesProjectExist(String input) {

        return projects.containsKey(input);
    }

    public void createProject(String input) {

        projects.put(input, new Project(input));
    }

    public void addTaskToProject(Integer taskIndex, String input) {

        projects.get(input).addTask(tasks.get(taskIndex-1));
    }

    public ArrayList<String> getAllWithNoProject() {

        ArrayList<String> taskTitles = new ArrayList<>();
        tasks.forEach(task -> {
            if (!task.hasProject()) {
                taskTitles.add(task.toString());
            }
        });
        return taskTitles;
    }
}
