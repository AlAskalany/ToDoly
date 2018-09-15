package com.alaskalany.todoly.todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Project test")
class ProjectTest {

    @SuppressWarnings("WeakerAccess")
    Project project;

    @BeforeEach
    void setUp() {
        project = Project.createProject("My Project");
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
        project.addTask("Task label", "2018-09-15");
        assertEquals(1, project.getTasks().size());
    }

    @Test
    @DisplayName("Get project name")
    void getName() {
        assertEquals("My Project", project.getName());
    }

    @Test
    @DisplayName("Get tasks")
    void getTasks() {
        project.addTask("Task label", "2018-09-15");
        assertNotNull(project.getTasks());
    }
}