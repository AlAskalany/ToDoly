package com.alaskalany.todoly.todo.projectlist;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ProjectListImpl extends ProjectList {

    public ProjectListImpl() {

    }

    @NotNull
    @Contract(" -> new")
    public static ProjectList createProjectList() {

        return new ProjectListImpl();
    }
}
