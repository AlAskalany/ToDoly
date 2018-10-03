package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.todo.project.Project;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class TaskSerializer {

    private final JsonSerializer<ArrayList<Task>> value;

    public TaskSerializer() {

        value = (ArrayList<Task> src, Type typeOfSrc, JsonSerializationContext context) -> {

            JsonArray jsonTask = new JsonArray();
            for (Task task : src) {
                jsonTask.add("" + task.getId());
            }
            return jsonTask;
        };
    }

    public static Type getTaskArrayListType() {

        return new TypeToken<ArrayList<Task>>() {

        }.getType();
    }

    public String makeJson(Task task) {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(getTaskArrayListType(), new TaskSerializer().getValue());

        Gson gson = gsonBuilder.create();
        String taskJson = gson.toJson(task);
        System.out.println(taskJson);
        return taskJson;
    }

    public @NotNull JsonSerializer<ArrayList<Task>> getValue() {

        return value;
    }
}
