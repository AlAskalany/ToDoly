package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class AddTaskCommand implements Command {

  private static final String ENTER_TASK_NAME = "Enter task name:";
  private final Ui ui;

  private AddTaskCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static AddTaskCommand create(Ui ui) {

    return new AddTaskCommand(ui);
  }

  public void invoke(Integer taskIndex) {

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("\n");
    System.out.print(ENTER_TASK_NAME);
    String taskTitle = scanner.next();
    ui.getTaskManager().addTaskWithTitle(taskTitle);
    ui.Command(CommandType.MAIN_MENU).invoke(taskIndex);
  }
}
