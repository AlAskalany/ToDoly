package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.todo.task.Task;
import com.google.gson.JsonArray;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;

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

    public @NotNull JsonSerializer<ArrayList<Task>> getValue() {

        return value;
    }
}
