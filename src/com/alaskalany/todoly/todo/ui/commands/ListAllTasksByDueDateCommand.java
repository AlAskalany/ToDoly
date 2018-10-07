package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.ArrayList;

public class ListAllTasksByDueDateCommand {

  private final UiImpl uiImpl;

  private ListAllTasksByDueDateCommand(UiImpl uiImpl) {

    this.uiImpl = uiImpl;
  }

  public static ListAllTasksByDueDateCommand create(UiImpl uiImpl) {

    return new ListAllTasksByDueDateCommand(uiImpl);
  }

  public void invoke() {

    UiImpl.FROM_LIST_BY_DUE_DATE = true;
    System.out.println(TaskListByDueDateMenu.ALL_TASKS_LIST_BY_DUE_DATE.getValue());
    System.out.println();
    ArrayList<String> tasks = uiImpl.getTaskManager().getAllTasksByDueDate();
    tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + "- " + task));
    System.out.println();
    uiImpl.selectTaskOrMainMenu();
  }

  public enum TaskListByDueDateMenu {
    ALL_TASKS_LIST_BY_DUE_DATE("All Tasks List - By Due Date"), EDIT_OR_0_FOR_MAIN_MENU(
        "Enter task number to edit or 0 for main menu: ");
    private String value;

    TaskListByDueDateMenu(String value) {

      this.value = value;
    }

    public String getValue() {

      return value;
    }
  }
}
