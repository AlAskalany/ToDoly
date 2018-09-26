package com.alaskalany.todoly.todo;

import java.util.ArrayList;
import java.util.Comparator;

public class TasksSorter implements Comparator<Task> {
    public ArrayList<Task> sortTasks(ArrayList<Task> inputTasks) {
        inputTasks.sort(new TasksSorter());
        return inputTasks;
    }

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDueDate().compareTo(o2.getDueDate());
    }
}
