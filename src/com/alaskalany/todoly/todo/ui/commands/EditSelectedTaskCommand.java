package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.UiImpl;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EditSelectedTaskCommand {

  private final UiImpl uiImpl;

  private EditSelectedTaskCommand(UiImpl uiImpl) {

    this.uiImpl = uiImpl;
  }

  @NotNull
  @Contract("_ -> new")
  public static EditSelectedTaskCommand create(UiImpl uiImpl) {

    return new EditSelectedTaskCommand(uiImpl);
  }

  public void invoke(Integer valueOf) {

    if (uiImpl.getTaskManager().isTaskIndexValid(valueOf)) {
      System.out
          .println(SelectEditTaskOption.EDITING_TASK.getValue() + uiImpl.getTaskManager()
              .getTaskTitle(valueOf));
      System.out.println(SelectEditTaskOption.EDIT_TASK_TITLE.getValue());
      System.out.println(SelectEditTaskOption.EDIT_TASK_STATUS.getValue());
      System.out.println(SelectEditTaskOption.EDIT_TASK_PROJECT.getValue());
      System.out.println(SelectEditTaskOption.EDIT_TASK_DUE_DATE.getValue());
      System.out.print(
          ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU.getValue());
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      handleEditSelectedTask(input, valueOf, uiImpl);
    } else {
      System.out.println(SelectEditTaskOption.ENTER_A_VALID_TASK_NUMBER.getValue());
      if (UiImpl.FROM_LIST_BY_DUE_DATE) {
        UiImpl.FROM_LIST_BY_DUE_DATE = false;
        uiImpl.listAllTasksByDueDate();
      } else if (UiImpl.FROM_LIST_BY_PROJECT) {
        UiImpl.FROM_LIST_BY_PROJECT = false;
        uiImpl.listAllTasksByProject();
      }
    }
  }

  private void handleEditSelectedTask(String input, Integer taskIndex, UiImpl ui) {

    if (ui.isTaskIndexValid(taskIndex)) {
      switch (Integer.valueOf(input)) {
        case 0:
          ui.mainMenu();
          break;
        case 1:
          ui.editTaskTitle(taskIndex);
          break;
        case 2:
          ui.editTaskStatus(taskIndex);
          break;
        case 3:
          ui.editTaskProject(taskIndex);
          break;
        case 4:
          ui.editTaskDueDate(taskIndex);
          break;
        default:
          break;
      }
    } else {
      System.out.println(SelectEditTaskOption.ENTER_A_VALID_TASK_NUMBER.getValue());
    }
  }

  public enum SelectEditTaskOption {
    EDITING_TASK("Editing Task:"), EDIT_TASK_TITLE("1- Title"), EDIT_TASK_STATUS(
        "2- Status"), EDIT_TASK_PROJECT("3- Project"), EDIT_TASK_DUE_DATE(
        "4- Due date"), ENTER_A_VALID_TASK_NUMBER("Enter a valid task number");
    private String value;

    SelectEditTaskOption(String value) {

      this.value = value;
    }

    public String getValue() {

      return value;
    }
  }
}
