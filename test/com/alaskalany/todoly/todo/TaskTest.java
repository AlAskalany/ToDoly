package com.alaskalany.todoly.todo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Task Test")
class TaskTest {

    private Task task;


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
        Project project = Project.createProject("Test project");
        task = Task.createTask("Test task", "2018-09-15", project);
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
        String taskLabel = task.getLabel();
        assertEquals("Test task", taskLabel);
    }

    /**
     *
     */
    @Test
    @DisplayName("Get task date")
    void getDate() {
        String taskDate = task.getDate();
        assertEquals("2018-09-15", taskDate);
    }

    /**
     *
     */
    @Test
    @DisplayName("Set task label")
    void setLabel() {
        task.setLabel("Test task 2");
        String taskLabel = task.getLabel();
        assertEquals("Test task 2", taskLabel);
    }

    /**
     *
     */
    @Test
    @DisplayName("Set task date")
    void setDate() {
        task.setDate("2018-09-20");
        String taskDate = task.getDate();
        assertEquals("2018-09-20", taskDate);
    }

    /**
     *
     */
    @Test
    @DisplayName("Finish task")
    void finish(){
        task.setDone();
        assertTrue(task.getDone());
    }
}