package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AddTaskCommand implements Command {

  private static final String ENTER_TASK_NAME = "Enter task name:";
  private final Ui ui;

  private AddTaskCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static AddTaskCommand create(Ui ui) {

    return new AddTaskCommand(ui);
  }

  public void invoke() {

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("\n");
    String input;
    System.out.print(ENTER_TASK_NAME);
    input = scanner.next();
    String taskTitle = ui.getTaskTitle(input);
    ui.getTaskManager().addTask(taskTitle);
    ui.mainMenu();
  }
}
