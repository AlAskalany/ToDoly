package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.task.TaskSerializer;
import com.alaskalany.todoly.todo.TaskManager;

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

    }

    public static void taskJsonization() {

        String taskTitle = "first Task";
        Date dueDate = new Date();
        Project project = new Project.Builder().id(1L).title("first project").build();
        new TaskSerializer()
                .makeJson(new Task.Builder().title(taskTitle).dueDate(dueDate).project(project).id(3L).build());
    }
}
