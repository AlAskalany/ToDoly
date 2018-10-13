package com.alaskalany.todoly.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.alaskalany.todoly.Utils.DateHelper;
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
  @AfterAll
  static void tearDownAll() {

  }

  /**
   *
   */
  @BeforeEach
  void setUp() {

    project = new Project.Builder().title("Test project").build();
    task = new Task.Builder().title("Test task").status(false).dueDate(date)
        .projectId(project.getId()).build();
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
  void getTitle() {

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
  void setTitle() {

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

    task.setStatusTrue();
    assertTrue(task.getStatus());
  }

  @Test
  void setDone() {

    task.setStatusTrue();
    assertTrue(task.getStatus().booleanValue());
  }

  @Test
  void getDoneUnfinishedTask() {

    task.setStatusTrue();
    assertTrue(task.getStatus());
  }

  @Test
  void getDoneFinishedTask() {

    task.setStatusTrue();
    assertTrue(task.getStatus());
    task.setStatusFalse();
    assertFalse(task.getStatus());
  }

  @Test
  void getProjectNotNull() {

    Project project = new Project.Builder().title("Some Project").build();
    task.setProject(project);
    assertNotNull(task.getProjectId());
  }

  @Test
  void getProjectId() {

    assertSame(project.getId(), task.getProjectId());
  }

  @Test
  void setProject() {

    Project newProject = new Project.Builder().title("New project").build();
    task.setProjectId(newProject.getId());
    assertSame(newProject.getId(), task.getProjectId());
  }

  @Test
  void getDueDate() {
    fail();
  }

  @Test
  void setDueDate() {
    fail();
  }


  @Test
  void getStatus() {
    fail();
  }

  @Test
  void setStatusFalse() {
    fail();
  }

  @Test
  void setProjectId() {
    fail();
  }

  @Test
  void compareTo() {
    fail();
  }

  @Test
  void taskToString() {
    fail();
  }

  @Test
  void hasProject() {
    fail();
  }
}