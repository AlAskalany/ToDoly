package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EditTaskProjectCommand implements Command {

  private static final String TASK_PROJECT_MODIFIED = "Task Project modified";
  private final Ui ui;

  private EditTaskProjectCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static EditTaskProjectCommand create(Ui ui) {

    return new EditTaskProjectCommand(ui);
  }

  @Override
  public void invoke() {

  }

  public void invoke(Integer taskIndex) {

    System.out.print("New Project: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (!ui.getTaskManager().doesProjectExist(input)) {
      ui.getTaskManager().createProject(input);
    }
    ui.getTaskManager().addTaskToProject(taskIndex, input);
    System.out.println(TASK_PROJECT_MODIFIED);
    ui.editSelectedTask();
  }
}
