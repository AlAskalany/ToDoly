package com.alaskalany.todoly.todo.taskmanager;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;

import java.util.ArrayList;

public abstract class TaskManager {

    public void addTask(String taskTitle) {

    }

    public ArrayList<Project> getAllProjects() {

        return null;
    }

    public ArrayList<String> getAllWithNoProject() {

        return null;
    }

    public String getTaskTitle(Integer valueOf) {

        return null;
    }

    public Task getTask(Integer taskIndex) {

        return null;
    }

    public boolean doesProjectExist(String input) {

        return false;
    }

    public void createProject(String input) {

    }

    public void addTaskToProject(Integer taskIndex, String input) {

    }

    public ArrayList<String> getAllTasksByDueDate() {

        return null;
    }
}
