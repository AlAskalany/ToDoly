package com.alaskalany.todoly.persistence;

public class FileManager {

    private static FileManager ourInstance = new FileManager();

    public static FileManager getInstance() {

        return ourInstance;
    }

    private FileManager() {

    }
}
