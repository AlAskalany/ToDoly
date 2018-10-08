package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.time.LocalDate;
import java.util.Scanner;

public class EditTaskDueDateCommand {

  public static final String TASK_DUE_DATE_MODIFIED = "Task Due date modified";
  public static final String ENTER_A_VALID_DATE_YYYY_MM_DD = "Enter a valid date yyyy-MM-dd";
  private final UiImpl uiImpl;

  private EditTaskDueDateCommand(UiImpl uiImpl) {

    this.uiImpl = uiImpl;
  }

  public static EditTaskDueDateCommand create(UiImpl uiImpl) {

    return new EditTaskDueDateCommand(uiImpl);
  }

  public void invoke(Integer taskIndex) {

    System.out.print("New Due date: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (uiImpl.getDateParser().isDateValid(input)) {
      LocalDate dueDate = uiImpl.getDateParser().getDateFromString(input);
      uiImpl.getTaskManager().getTask(taskIndex).setDueDate(dueDate);
      System.out.println(TASK_DUE_DATE_MODIFIED);
      uiImpl.editSelectedTask(taskIndex);
    } else {
      System.out.println(ENTER_A_VALID_DATE_YYYY_MM_DD);
      invoke(taskIndex);
    }
  }
}
