package com.alaskalany.todoly.daos.projects;

import com.alaskalany.todoly.todo.Project;

import java.io.IOException;
import java.util.ArrayList;

public interface ProjectDao {

    Long createProject(Project project) throws IOException;

    Project readProject(Long projectId) throws IOException;

    void updateProject(Project project) throws IOException;

    void deleteProject(Long projectId) throws IOException;

    ArrayList<Project> listProjects(String startCursor) throws IOException;
}
