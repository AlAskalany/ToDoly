package com.alaskalany.todoly.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Project test")
class ProjectTest {

  public static final String MY_PROJECT = "My Project";
  @SuppressWarnings("WeakerAccess")
  Project project;
  private LocalDate date = LocalDate.of(2014, Calendar.FEBRUARY, 2);

  @BeforeEach
  void setUp() {

    project = new Project.Builder().title(MY_PROJECT).build();
  }

  @AfterEach
  void tearDown() {
    project.getTasks().clear();
    project = null;
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

    assertEquals(MY_PROJECT, project.getTitle());
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

    IntStream.range(0, numTasks).forEachOrdered(i -> {
      project.addTask(Integer.toString(i), date);
      System.out.println(i);
    });

    assertEquals(numTasks, project.getTasks().size());
  }

  @Test
  void getFinishedTasksCount() {

    getRandomTasks();
    assertEquals(25, project.finishedTasksCount());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 10, 100, 1000})
  void deleteAllTasks(int numTasks) {

    for (int i = 0; i < numTasks; i++) {
      project.addTask(Integer.toString(i), date);
    }

    assertEquals(numTasks, project.getTasks().size());
    project.deleteAllTasks();

    assertEquals(0, project.getTasks().size());
  }

  @Test
  void removeFinishedTasks() {

    getRandomTasks();
    assertEquals(25, project.getUnfinishedTasksCount());
    project.deleteFinishedTasks();
    assertEquals(0, project.getUnfinishedTasksCount());
  }

  private void getRandomTasks() {
    for (int i = 0; i < 50; i++) {
      project.addTask(Integer.toString(i), date);
      if ((i % 2) == 0) {
        project.getTasks().get(i).setStatus(true);
      } else {
        project.getTasks().get(i).setStatus(false);
      }
      System.out.println("index" + i + "" + project.getTasks().get(i).getStatus());
    }
  }

  @Test
  void getUnfinishedTasksCount() {

    getRandomTasks();
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

    assertEquals(2, project.getTasks().size());
  }

  @Test
  void getTask() {

    project.addTask("I am a task", date);
    Task task = project.getTask(0);
    assertEquals("I am a task", task.getTitle());
    assertEquals(date, task.getDueDate());
  }

  @Test
  void getTitle() {
    assertEquals(0, project.getTitle().compareTo(MY_PROJECT));
  }

  @Test
  void setTitle() {
    String newTitle = "Huge project";
    project.setTitle(newTitle);
    final String newProjectTitle = project.getTitle();
    final int expected = 0;
    final int actual = newProjectTitle.compareTo(newTitle);
    assertEquals(expected, actual);
  }

  @Test
  void finishedTasksCount() {
    getRandomTasks();
    int expected = 25;
    int actual = project.finishedTasksCount();
    assertEquals(expected, actual);
  }

  @Test
  void deleteFinishedTasks() {
    getRandomTasks();
    int expected = 25;
    project.deleteFinishedTasks();
    int actual = project.getTasks().size();
    assertEquals(expected, actual);
  }

  @Test
  void getId() {
  }
}