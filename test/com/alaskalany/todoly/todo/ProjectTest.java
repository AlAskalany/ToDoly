package com.alaskalany.todoly.todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void setName(){
        project.setName("New Project Name");
        assertEquals("New Project Name", project.getName());
    }

    @Test
    @DisplayName("Get tasks")
    void getTasks() {
        project.addTask("Task label", "2018-09-15");
        assertNotNull(project.getTasks());
    }

    @ParameterizedTest
    @ValueSource(ints ={0,10,1000})
    void getTasksCountInProject(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            project.addTask(Integer.toString(i), "2018-09-15");
        }
        assertEquals(numTasks, project.getTasksCount());
    }

    @Test
    void getFinishedTasksCount() {
        for (int i = 0; i < 50; i++) {
            project.addTask(Integer.toString(i), "2018-09-05");
            if ((i % 2) == 0) {
                project.getTasks().get(i).setDone();
            }
        }
        assertEquals(25, project.getFinishedTasksCount());
    }

    @ParameterizedTest
    @ValueSource(ints ={0, 10, 100, 1000})
    void deleteAllTasks(int numTasks){
        for (int i = 0; i < numTasks; i++) {
            project.addTask(Integer.toString(i), "2018-09-15");
        }
        assertEquals(numTasks, project.getTasksCount());
        project.deleteAllTasks();
        assertEquals(0, project.getTasksCount());
    }

    @Test
    void removeFinishedTasks(){
        for (int i = 0; i < 50; i++) {
            project.addTask(Integer.toString(i), "2018-09-05");
            if ((i % 2) == 0) {
                project.getTasks().get(i).setDone();
            }
        }
        assertEquals(25, project.getFinishedTasksCount());
        project.deleteFinishedTasks();
        assertEquals(25, project.getUnfinishedTasksCount());
    }

    @Test
    void getUnfinishedTasksCount(){
        for (int i = 0; i < 50; i++) {
            project.addTask(Integer.toString(i), "2018-09-05");
            if ((i % 2) == 0) {
                project.getTasks().get(i).setDone();
            }
        }
        assertEquals(25, project.getUnfinishedTasksCount());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5})
    void testParametersHere(@SuppressWarnings("unused") int numTasks){

    }
}