package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AddTaskCommand extends Command{

  public static final String ENTER_TASK_NAME = "Enter task name:";

  public AddTaskCommand(UiImpl uiImpl) {
    super(uiImpl);
  }

  @NotNull
  @Contract("_ -> new")
  public static AddTaskCommand create(UiImpl uiImpl) {

    return new AddTaskCommand(uiImpl);
  }

  public void invoke() {

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("\n");
    String input;
    System.out.print(ENTER_TASK_NAME);
    input = scanner.next();
    String taskTitle = uiImpl.getTaskTitle(input);
    uiImpl.getTaskManager().addTask(taskTitle);
    uiImpl.mainMenu();
  }

  @Override
  public void handleInput(String input) {

  }
}
