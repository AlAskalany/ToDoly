package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;

import java.time.LocalDate;
import java.util.Scanner;

public class EditTaskDueDateCommand extends Command {

    public static final String TASK_DUE_DATE_MODIFIED = "Task Due date modified";
    public static final String ENTER_A_VALID_DATE_YYYY_MM_DD = "Enter a valid date yyyy-MM-dd";

    private EditTaskDueDateCommand(Ui ui) {

        super(ui);
    }

    public static EditTaskDueDateCommand create(Ui ui) {

        return new EditTaskDueDateCommand(ui);
    }

    public void invoke(Integer taskIndex) {

        System.out.print("New Due date: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (ui.getDateParser().isDateValid(input)) {
            LocalDate dueDate = ui.getDateParser().getDateFromString(input);
            ui.getTaskManager().getTask(taskIndex).setDueDate(dueDate);
            System.out.println(TASK_DUE_DATE_MODIFIED);
            ui.editSelectedTask(taskIndex);
        } else {
            System.out.println(ENTER_A_VALID_DATE_YYYY_MM_DD);
            invoke(taskIndex);
        }
    }

    @Override
    public void handleInput(Integer taskIndex) {

    }

    @Override
    public void handleInput(Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input) {

    }

    @Override
    public void handleInput(String input, Integer taskIndex, Ui ui) {

    }

    @Override
    public void handleInput(String input, Ui ui) {

    }
}
