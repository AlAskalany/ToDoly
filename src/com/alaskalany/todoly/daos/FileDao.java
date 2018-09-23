package com.alaskalany.todoly.daos;

import com.alaskalany.todoly.daos.projects.ProjectDao;
import com.alaskalany.todoly.daos.tasks.TaskDao;
import com.alaskalany.todoly.todo.Project;
import com.alaskalany.todoly.todo.Task;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileDao implements ProjectDao, TaskDao {

    private final String inputFileName;
    private final String outputFileName;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public FileDao(String inputFileName, String outputFileName) throws FileNotFoundException {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        fileInputStream = new FileInputStream(this.inputFileName);
        fileOutputStream = new FileOutputStream(this.outputFileName);
    }

    // ToDo
    public Project entityToProject(JSONObject jsonObject) {
        return new Project.Builder().title((String) jsonObject.get(Project.TITLE)).id((Long) jsonObject.get(Project.ID))
                .build();
    }

    @Override
    public Long createProject(Project project) throws IOException {
        return null;
    }

    @Override
    public Project readProject(Long projectId) throws IOException {
        return null;
    }

    @Override
    public void updateProject(Project project) throws IOException {

    }

    @Override
    public void deleteProject(Long projectId) throws IOException {

    }

    @Override
    public ArrayList<Project> listProjects(String startCursor) throws IOException {
        return null;
    }

    // TODO
    public Task entityToTask(JSONObject jsonObject) {
        return new Task.Builder().title((String) jsonObject.get(Task.TITLE)).id((Long) jsonObject.get(Task.ID))
                .status((Boolean) jsonObject.get(Task.STATUS)).dueDate((String) jsonObject.get(Task.DUE_DATE))
                .projectId((Long) jsonObject.get(Task.PROJECT_ID)).build();
    }

    @Override
    public Long createTask(Task task) throws IOException {
        return null;
    }

    @Override
    public Task readTask(Long taskId) throws IOException {
        return null;
    }

    @Override
    public void updateTask(Task task) throws IOException {

    }

    @Override
    public void deleteTask(Long taskId) throws IOException {

    }
}
