package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.time.LocalDate;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class EditTaskDueDateCommand implements Command {

  private static final String TASK_DUE_DATE_MODIFIED = "Task Due date modified";
  private static final String ENTER_A_VALID_DATE_YYYY_MM_DD = "Enter a valid date yyyy-MM-dd";
  private final Ui ui;

  private EditTaskDueDateCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static EditTaskDueDateCommand create(Ui ui) {

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
      ui.Command(CommandType.EDIT_SELECTED_TASK).invoke(taskIndex);
    } else {
      System.out.println(ENTER_A_VALID_DATE_YYYY_MM_DD);
      invoke(taskIndex);
    }
  }
}
