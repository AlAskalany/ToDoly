package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.task.TaskSerializer;
import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.TaskManager;
import com.google.gson.*;

import java.util.Date;

/**
 *
 */
public class ToDoly {

    private static TaskManager taskManager = new TaskManager();

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(TaskSerializer.getTaskArrayListType(), new TaskSerializer().getValue());

        Gson gson = gsonBuilder.create();
        long projectId = 2L;
        String projectTitle = "first project";
        Project project = new Project.Builder().title(projectTitle).id(projectId).build();
        Date dueDate = new Date();
        long taskId = 1L;
        String taskTitle = "first task";
        Task task = new Task.Builder().title(taskTitle).dueDate(dueDate).project(project).id(taskId).build();
        String taskJson = gson.toJson(project);
        System.out.println(taskJson);
    }
}
