package com.alaskalany.todoly.todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TasksSorterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortTasks() {
        ArrayList<Task> expectedTasksList = new ArrayList<>();

        expectedTasksList
                .add(new Task.Builder().title("task2").id(1L).dueDate(new Date(0, 0, 0)).projectId(1L).status(false)
                        .build());
        expectedTasksList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 0, 2)).projectId(1L).status(false)
                        .build());
        expectedTasksList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 0, 6)).projectId(1L).status(false)
                        .build());
        expectedTasksList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 3, 0)).projectId(1L).status(false)
                        .build());
        expectedTasksList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 4, 5)).projectId(1L).status(false)
                        .build());

        ArrayList<Task> inputTaskList = new ArrayList<>();

        inputTaskList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 0, 0)).projectId(1L).status(false)
                        .build());
        inputTaskList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 0, 2)).projectId(1L).status(false)
                        .build());
        inputTaskList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 4, 5)).projectId(1L).status(false)
                        .build());
        inputTaskList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 0, 6)).projectId(1L).status(false)
                        .build());
        inputTaskList
                .add(new Task.Builder().title("task1").id(1L).dueDate(new Date(0, 3, 0)).projectId(1L).status(false)
                        .build());

        TasksSorter sorter = new TasksSorter();
        ArrayList<Task> resultTasksList = sorter.sortTasks(inputTaskList);

        resultTasksList.forEach(resultTask -> {
            int indexOfResultTask = resultTasksList.indexOf(resultTask);
            Task expectedTask = expectedTasksList.get(indexOfResultTask);
            assertEquals(0, resultTask.compareTo(expectedTask));
        });
    }
}