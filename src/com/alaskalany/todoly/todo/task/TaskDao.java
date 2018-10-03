package com.alaskalany.todoly.todo.task;

import com.alaskalany.todoly.todo.task.Task;

import java.io.IOException;

public interface TaskDao {

    Long createTask(Task task) throws IOException;

    Task readTask(Long taskId) throws IOException;

    void updateTask(Task task) throws IOException;

    void deleteTask(Long taskId) throws IOException;
}
