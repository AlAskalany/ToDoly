package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EditTaskTitleCommand implements Command {

  private final Ui ui;

  private EditTaskTitleCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static EditTaskTitleCommand create(Ui ui) {

    return new EditTaskTitleCommand(ui);
  }

  @Override
  public void invoke() {

  }

  public void invoke(Integer taskIndex) {

    System.out.print("New title: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    ui.getTaskManager().getTask(taskIndex).setTitle(input);
    System.out.println("Task title modified");
    ui.editSelectedTask();
  }
}
