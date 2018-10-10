package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.time.LocalDate;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EditTaskDueDateCommand implements Command {

  private static final String TASK_DUE_DATE_MODIFIED = "Task Due date modified";
  private static final String ENTER_A_VALID_DATE_YYYY_MM_DD = "Enter a valid date yyyy-MM-dd";
  private final Ui ui;

  private EditTaskDueDateCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static EditTaskDueDateCommand create(Ui ui) {

    return new EditTaskDueDateCommand(ui);
  }

  public void invoke() {

    System.out.print("New Due date: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (ui.getDateParser().isDateValid(input)) {
      LocalDate dueDate = ui.getDateParser().getDateFromString(input);
      ui.getTaskManager().getTask(ui.getTaskIndex()).setDueDate(dueDate);
      System.out.println(TASK_DUE_DATE_MODIFIED);
      ui.editSelectedTask();
    } else {
      System.out.println(ENTER_A_VALID_DATE_YYYY_MM_DD);
      invoke();
    }
  }
}
