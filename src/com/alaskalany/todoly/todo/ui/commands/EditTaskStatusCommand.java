package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class EditTaskStatusCommand implements Command {

  private static final String TASK_STATUS_MODIFIED = "Task status modified";
  private final Ui ui;

  private EditTaskStatusCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static EditTaskStatusCommand create(Ui ui) {

    return new EditTaskStatusCommand(ui);
  }

  @Override
  public void invoke(Integer taskIndex) {

    System.out.print("New Status: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    ui.getTaskManager().getTask(taskIndex).setTitle(input);
    System.out.println(TASK_STATUS_MODIFIED);
    ui.Command(CommandType.EDIT_SELECTED_TASK).invoke(taskIndex);
  }
}
