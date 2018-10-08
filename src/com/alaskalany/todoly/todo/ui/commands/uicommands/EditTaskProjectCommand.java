package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.Scanner;

public class EditTaskProjectCommand {

  public static final String TASK_PROJECT_MODIFIED = "Task Project modified";
  private final UiImpl uiImpl;

  private EditTaskProjectCommand(UiImpl uiImpl) {

    this.uiImpl = uiImpl;
  }

  public static EditTaskProjectCommand create(UiImpl uiImpl) {

    return new EditTaskProjectCommand(uiImpl);
  }

  public void invoke(Integer taskIndex) {

    System.out.print("New Project: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (!uiImpl.getTaskManager().doesProjectExist(input)) {
      uiImpl.getTaskManager().createProject(input);
    }
    uiImpl.getTaskManager().addTaskToProject(taskIndex, input);
    System.out.println(TASK_PROJECT_MODIFIED);
    uiImpl.editSelectedTask(taskIndex);
  }
}
