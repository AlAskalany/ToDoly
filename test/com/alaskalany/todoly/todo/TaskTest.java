package com.alaskalany.todoly.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.alaskalany.todoly.date.DateHelper;
import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Task Test")
class TaskTest {

  private Task task;
  private Project project;
  private LocalDate date = DateHelper.getDate(0, Month.JANUARY, 1);

  /**
   *
   */
  @BeforeAll
  static void initAll() {

  }

  /**
   *
   */
  @BeforeEach
  void setUp() {

    project = new Project.Builder().title("Test project").build();
    task = new Task.Builder().title("Test task").status(false).dueDate(date).project(project)
        .build();
  }

  /**
   *
   */
  @AfterEach
  void tearDown() {

  }

  /**
   *
   */
  @AfterAll
  static void tearDownAll() {

  }

  /**
   *
   */
  @Test
  @DisplayName("Create a task")
  void createTask() {

    assertNotNull(task);
  }

  /**
   *
   */
  @Test
  @DisplayName("Display task label")
  void getLabel() {

    String taskLabel = task.getTitle();
    assertEquals("Test task", taskLabel);
  }

  /**
   *
   */
  @Test
  @DisplayName("Get task date")
  void getDate() {

    assertEquals(date, task.getDueDate());
  }

  /**
   *
   */
  @Test
  @DisplayName("Set task label")
  void setLabel() {

    task.setTitle("Test task 2");
    String taskLabel = task.getTitle();
    assertEquals("Test task 2", taskLabel);
  }

  /**
   *
   */
  @Test
  @DisplayName("Set task date")
  void setDate() {

    task.setDueDate(date);
    assertEquals(date, task.getDueDate());
  }

  /**
   *
   */
  @Test
  @DisplayName("Finish task")
  void finish() {

    task.setStatus(true);
    assertTrue(task.getStatus());
  }

  @Test
  void setDone() {

    task.setStatus(true);
    assertTrue(task.getStatus());
  }

  @Test
  void getDoneUnfinishedTask() {

    task.setStatus(true);
    assertTrue(task.getStatus());
  }

  @Test
  void getDoneFinishedTask() {

    task.setStatus(true);
    assertTrue(task.getStatus());

    task.setStatus(false);
    assertFalse(task.getStatus());
  }

  @Test
  void getProjectNotNull() {

    Project project = new Project.Builder().title("Some Project").build();
    task.setProject(project);
    assertNotNull(task.getProject());
  }

  @Test
  void getProjectId() {

    assertSame(project.getId(), task.getProject().getId());
  }

  @Test
  void setProject() {

    Project newProject = new Project.Builder().title("New project").build();
    task.setProject(newProject);
    assertSame(newProject, task.getProject());
  }
}