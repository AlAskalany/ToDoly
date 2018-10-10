package com.alaskalany.todoly.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.time.LocalDate;
import java.util.Calendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Project test")
class ProjectTest {

  @SuppressWarnings("WeakerAccess")
  Project project;
  private LocalDate date = LocalDate.of(2014, Calendar.FEBRUARY, 2);

  @BeforeEach
  void setUp() {

    project = new Project.Builder().title("My Project").build();
  }

  @AfterEach
  void tearDown() {

  }

  @Test
  @DisplayName("Create a project")
  void createProject() {

    assertNotNull(project);
  }

  @Test
  @DisplayName("Project is created with no tasks")
  void projectStartsWithNoTasks() {

    assertEquals(0, project.getTasks().size());
  }

  @Test
  @DisplayName("Add a task to the project")
  void addTask() {

    project.addTask("Task label", date);
    assertEquals(1, project.getTasks().size());
  }

  @Test
  @DisplayName("Get project name")
  void getName() {

    assertEquals("My Project", project.getTitle());
  }

  @Test
  void setName() {

    project.setTitle("New Project Name");
    assertEquals("New Project Name", project.getTitle());
  }

  @Test
  @DisplayName("Get tasks")
  void getTasks() {

    project.addTask("Task label", date);
    assertNotNull(project.getTasks());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 10, 1000})
  void getTasksCountInProject(int numTasks) {

    for (int i = 0; i < numTasks; i++) {
      project.addTask(Integer.toString(i), date);
    }
    assertEquals(numTasks, project.numTasks());
  }

  @Test
  void getFinishedTasksCount() {

    for (int i = 0; i < 50; i++) {
      project.addTask(Integer.toString(i), date);
      if ((i % 2) == 0) {
        project.getTasks().get(i).setStatusTrue();
      }
    }
    assertEquals(25, project.numFinishedTasks());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 10, 100, 1000})
  void deleteAllTasks(int numTasks) {

    // Arrange
    for (int i = 0; i < numTasks; i++) {
      project.addTask(Integer.toString(i), date);
    }
    assertEquals(numTasks, project.numTasks());
    project.deleteAllTasks();
    assertEquals(0, project.numTasks());
  }

  @Test
  void removeFinishedTasks() {

    for (int i = 0; i < 50; i++) {
      project.addTask(Integer.toString(i), date);
      if ((i % 2) == 0) {
        project.getTasks().get(i).setStatusTrue();
      }
    }
    assertEquals(25, project.numFinishedTasks());
    project.deleteFinishedTasks();
    assertEquals(25, project.getUnfinishedTasksCount());
  }

  @Test
  void getUnfinishedTasksCount() {

    for (int i = 0; i < 50; i++) {
      project.addTask(Integer.toString(i), date);
      if ((i % 2) == 0) {
        project.getTasks().get(i).setStatusTrue();
      }
    }
    assertEquals(25, project.getUnfinishedTasksCount());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 5})
  void testParametersHere(@SuppressWarnings("unused") int numTasks) {

  }

  @Test
  void removeTask() {

    int numTasks = 3;
    for (int i = 0; i < numTasks; i++) {
      project.addTask(Integer.toString(i), date);
    }
    project.removeTask(2);
    assertEquals(2, project.numTasks());
  }

  @Test
  void getTask() {

    project.addTask("I am a task", date);
    Task task = project.getTask(0);
    assertEquals("I am a task", task.getTitle());
    assertEquals(date, task.getDueDate());
  }
}