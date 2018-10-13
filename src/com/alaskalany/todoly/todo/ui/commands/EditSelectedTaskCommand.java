package com.alaskalany.todoly.todo.ui.commands;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;
import java.util.Scanner;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class EditSelectedTaskCommand implements InputCommand {

  private final Ui ui;

  private EditSelectedTaskCommand(Ui ui) {

    this.ui = ui;
  }

  @NotNull
  @Contract("_ -> new")
  static EditSelectedTaskCommand create(Ui ui) {

    return new EditSelectedTaskCommand(ui);
  }

  public void invoke(Integer taskIndex) {

    boolean taskIndexValid = ui.getTaskManager().isTaskIndexValid(taskIndex);
    if (taskIndexValid) {
      String taskTitle = ui.getTaskManager()
          .getTaskTitle(taskIndex);
      String value = SelectEditTaskOption.EDITING_TASK.getValue();
      System.out
          .println(value + taskTitle);
      String value1 = SelectEditTaskOption.EDIT_TASK_TITLE.getValue();
      System.out.println(value1);
      String value2 = SelectEditTaskOption.EDIT_TASK_STATUS.getValue();
      System.out.println(value2);
      String value3 = SelectEditTaskOption.EDIT_TASK_PROJECT.getValue();
      System.out.println(value3);
      String value4 = SelectEditTaskOption.EDIT_TASK_DUE_DATE.getValue();
      System.out.println(value4);
      String allTasksString = ListAllTasksByDueDateCommand.TaskListByDueDateMenu.EDIT_OR_0_FOR_MAIN_MENU
          .getValue();
      System.out.print(allTasksString);
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      ui.setInput(input);
      handleInput(taskIndex);
    } else {
      String value = SelectEditTaskOption.ENTER_A_VALID_TASK_NUMBER.getValue();
      System.out.println(value);
      boolean fromListByDueDate = Ui.FROM_LIST_BY_DUE_DATE;
      if (fromListByDueDate) {
        Ui.FROM_LIST_BY_DUE_DATE = false;
        ui.Command(CommandType.LIST_ALL_TASKS_BY_PROJECT).invoke(taskIndex);
      } else if (Ui.FROM_LIST_BY_PROJECT) {
        Ui.FROM_LIST_BY_PROJECT = false;
        ui.Command(CommandType.LIST_ALL_TASKS_BY_PROJECT).invoke(taskIndex);
      }
    }
  }

  @Override
  public void handleInput(Integer taskIndex) {

    if (ui.getTaskManager().isTaskIndexValid(taskIndex)) {
      switch (Integer.valueOf(ui.getInput())) {
        case 0:
          ui.Command(CommandType.MAIN_MENU).invoke(taskIndex);
          break;
        case 1:
          ui.Command(CommandType.EDIT_TASK_TITLE).invoke(taskIndex);
          break;
        case 2:
          ui.Command(CommandType.EDIT_TASK_STATUS).invoke(taskIndex);
          break;
        case 3:
          ui.Command(CommandType.EDIT_TASK_PROJECT).invoke(taskIndex);
          break;
        case 4:
          ui.Command(CommandType.EDIT_TASK_DUE_DATE).invoke(taskIndex);
          break;
        default:
          break;
      }
    } else {
      String value = SelectEditTaskOption.ENTER_A_VALID_TASK_NUMBER.getValue();
      System.out.println(value);
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

    @Contract(pure = true)
    public String getValue() {

      return value;
    }
  }
}
