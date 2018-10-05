package com.alaskalany.todoly.persistence;

class FileManager {

    private static final FileManager ourInstance = new FileManager();

    static FileManager getInstance() {

        return ourInstance;
    }

    private FileManager() {

    }
}
