package com.alaskalany.todoly.todo;

import com.alaskalany.todoly.todo.project.Project;
import com.alaskalany.todoly.todo.task.Task;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task Test")
class TaskTest {

    private Task task;
    private Project project;
    Date date = new Date(0,0,0);


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
        project = new Project.Builder().title("Test project").id(1L).build();
        task = new Task.Builder().title("Test task").id(2L).status(false).dueDate(date)
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
        task.setStatusTrue();
        assertTrue(task.getStatus());
    }

    @Test
    void setDone() {
        task.setStatusTrue();
        assertTrue(task.getStatus());
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
        assertNotNull(task.getProjectId());
    }

    @Test
    void getProjectId() {
        assertSame(project.getId(), task.getProjectId());
    }

    @Test
    void setProject() {
        Project newProject = new Project.Builder().title("New project").id(1L).build();
        ;
        task.setProjectId(newProject.getId());
        assertSame(newProject.getId(), task.getProjectId());
    }
}