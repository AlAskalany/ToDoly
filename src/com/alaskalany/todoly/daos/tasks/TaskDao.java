package com.alaskalany.todoly.daos.tasks;

import com.alaskalany.todoly.todo.Task;

import java.io.IOException;

public interface TaskDao {

    Long createTask(Task task) throws IOException;

    Task readTask(Long taskId) throws IOException;

    void updateTask(Task task) throws IOException;

    void deleteTask(Long taskId) throws IOException;
}
