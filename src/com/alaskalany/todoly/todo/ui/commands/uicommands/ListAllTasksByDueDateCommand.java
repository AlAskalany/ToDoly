package com.alaskalany.todoly.todo.ui.commands.uicommands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.ArrayList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ListAllTasksByDueDateCommand implements Command {

  private final Ui ui;

  private ListAllTasksByDueDateCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  public static ListAllTasksByDueDateCommand create(Ui ui) {

    return new ListAllTasksByDueDateCommand(ui);
  }

  public void invoke() {

    UiImpl.FROM_LIST_BY_DUE_DATE = true;
    System.out.println(TaskListByDueDateMenu.ALL_TASKS_LIST_BY_DUE_DATE.getValue());
    System.out.println();
    ArrayList<String> tasks = ui.getTaskManager().getAllTasksByDueDate();
    tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
    System.out.println();
    ui.selectTaskOrMainMenu();
  }

  public enum TaskListByDueDateMenu {
    ALL_TASKS_LIST_BY_DUE_DATE("All Tasks List - By Due Date"), EDIT_OR_0_FOR_MAIN_MENU(
        "Enter task number to edit or 0 for main menu: ");
    private String value;

    TaskListByDueDateMenu(String value) {

      this.value = value;
    }

    @Contract(pure = true)
    public String getValue() {

      return value;
    }
  }
}
