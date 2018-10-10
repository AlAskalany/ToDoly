package com.alaskalany.todoly.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alaskalany.todoly.date.DateHelper;
import com.alaskalany.todoly.todo.task.Task;
import com.alaskalany.todoly.todo.task.TasksComparator;
import java.time.Month;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TasksComparatorTest {

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
        .add(new Task.Builder().title("task2").dueDate(DateHelper.getDate(0, Month.JANUARY, 1))
            .status(false)
            .build());
    expectedTasksList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.JANUARY, 2))
            .status(false)
            .build());
    expectedTasksList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.JANUARY, 6))
            .status(false)
            .build());
    expectedTasksList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.MARCH, 1))
            .status(false)
            .build());
    expectedTasksList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.APRIL, 5))
            .status(false)
            .build());

    ArrayList<Task> inputTaskList = new ArrayList<>();

    inputTaskList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.JANUARY, 1))
            .status(false)
            .build());
    inputTaskList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.JANUARY, 2))
            .status(false)
            .build());
    inputTaskList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.APRIL, 5))
            .status(false)
            .build());
    inputTaskList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.JANUARY, 6))
            .status(false)
            .build());
    inputTaskList
        .add(new Task.Builder().title("task1").dueDate(DateHelper.getDate(0, Month.MARCH, 1))
            .status(false)
            .build());

    TasksComparator sorter = new TasksComparator();
    ArrayList<Task> resultTasksList = sorter.sortTasks(inputTaskList);

    resultTasksList.forEach(resultTask -> {
      int indexOfResultTask = resultTasksList.indexOf(resultTask);
      Task expectedTask = expectedTasksList.get(indexOfResultTask);
      assertEquals(0, resultTask.compareTo(expectedTask));
    });
  }
}