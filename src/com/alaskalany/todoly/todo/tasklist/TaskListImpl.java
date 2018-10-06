package com.alaskalany.todoly.todo.tasklist;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class TaskListImpl extends TaskList {

    public TaskListImpl() {

    }

    @NotNull
    @Contract(" -> new")
    public static TaskListImpl createTaskList() {

        return new TaskListImpl();
    }
}
