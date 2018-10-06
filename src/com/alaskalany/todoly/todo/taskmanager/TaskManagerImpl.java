package com.alaskalany.todoly.todo.taskmanager;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.projectlist.ProjectList;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.tasklist.TaskList;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskManagerImpl extends TaskManager implements Manager {

    @Inject
    private TaskList taskList;
    @Inject
    private ProjectList projectList;

    public void addTask(String taskTitle) {

        taskList.add(new Task.Builder().title(taskTitle).build());
    }

    public ArrayList<String> getAllTasksByDueDate() {

        ArrayList<Task> orderedTasks = new ArrayList<>(taskList);
        orderedTasks.sort(Task::compareTo);
        ArrayList<String> taskTitles = new ArrayList<>();
        orderedTasks.forEach(task -> taskTitles.add(task.toString()));
        return taskTitles;
    }

    public String getTaskTitle(Integer valueOf) {

        return taskList.get(valueOf - 1).getTitle();
    }

    public Task getTask(Integer taskIndex) {

        return taskList.get(taskIndex - 1);
    }

    public boolean doesProjectExist(String input) {

        return projectList.containsKey(input);
    }

    public void createProject(String input) {

        projectList.put(input, new Project(input));
    }

    public void addTaskToProject(Integer taskIndex, String input) {

        projectList.get(input).addTask(taskList.get(taskIndex - 1));
    }

    public ArrayList<String> getAllWithNoProject() {

        ArrayList<String> taskTitles = new ArrayList<>();
        taskList.forEach(task -> {
            if (!task.hasProject()) {
                taskTitles.add(task.toString());
            }
        });
        return taskTitles;
    }

    public ArrayList<Project> getAllProjects() {

        ArrayList<Project> projectsList = new ArrayList<>();
        projectList.forEach((s, project) -> projectsList.add(project));
        projectsList.sort(Comparator.comparing(Project::getTitle));
        return projectsList;
    }
}
