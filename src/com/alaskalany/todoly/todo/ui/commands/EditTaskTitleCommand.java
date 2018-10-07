package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;

import java.util.Scanner;

public class EditTaskTitleCommand {

    private final UiImpl uiImpl;

    private EditTaskTitleCommand(UiImpl uiImpl) {

        this.uiImpl = uiImpl;
    }

    public static EditTaskTitleCommand create(UiImpl uiImpl) {

        return new EditTaskTitleCommand(uiImpl);
    }

    public void invoke(Integer taskIndex) {

        System.out.print("New title: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        uiImpl.getTaskManager().getTask(taskIndex).setTitle(input);
        System.out.println("Task title modified");
        uiImpl.editSelectedTask(taskIndex);
    }
}
