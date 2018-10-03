package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.task.TaskSerializer;
import com.alaskalany.todoly.todo.TaskManager;
import org.junit.platform.commons.util.FunctionUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 */
public class ToDoly {

    private static TaskManager taskManager = new TaskManager();

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {

        Consumer<Task> taskNamePrinter = task -> System.out.println(task.getTitle());

        Consumer<Task> taskStatusPrinter = task -> System.out.println(task.getStatus());

        Supplier<Task> taskSupplier = () -> {
            return new Task.Builder().title("Task1").build();
        };


    }

    public static void uniqueId() {

        UUID uuid = IdGenerator.getRandomId();
        String randomUuidString = uuid.toString();
        System.out.println("Random UUID String = " + randomUuidString);
        System.out.println("UUID version       = " + uuid.version());
        System.out.println("UUID variant       = " + uuid.variant());
        String classUUID = IdGenerator.getTypeRandomIdString(ToDoly.class);
        System.out.println(classUUID);

        Task task = new Task.Builder().build();
        String taskUUID = IdGenerator.getTypeRandomIdString(task.getClass());
        System.out.println(taskUUID);
        System.out.println(task.getClass().hashCode());
    }

    public static void taskJsonization() {

        String taskTitle = "first Task";
        Date dueDate = new Date();
        Project project = new Project.Builder().id(1L).title("first project").build();
        new TaskSerializer()
                .makeJson(new Task.Builder().title(taskTitle).dueDate(dueDate).project(project).id(3L).build());
    }
}
