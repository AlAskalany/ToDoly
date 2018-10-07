package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.Scanner;

public class EditTaskStatusCommand {

  public static final String TASK_STATUS_MODIFIED = "Task status modified";
  private final UiImpl uiImpl;

  private EditTaskStatusCommand(UiImpl uiImpl) {

    this.uiImpl = uiImpl;
  }

  public static EditTaskStatusCommand create(UiImpl uiImpl) {

    return new EditTaskStatusCommand(uiImpl);
  }

  public void invoke(Integer taskIndex) {

    System.out.print("New Status: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    uiImpl.getTaskManager().getTask(taskIndex).setTitle(input);
    System.out.println(TASK_STATUS_MODIFIED);
    uiImpl.editSelectedTask(taskIndex);
  }
}
