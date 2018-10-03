package com.alaskalany.todoly.persistence;

import java.io.File;

public class FileManager {

    private static FileManager ourInstance = new FileManager();
    private File file;

    public static FileManager getInstance() {

        return ourInstance;
    }

    private FileManager() {

    }

    public Object getObjectFromJsonFile(String fileName) {

        return new Object();
    }
}
