package com.alaskalany.todoly;

import com.alaskalany.todoly.todo.ui.Ui;
import com.alaskalany.todoly.todo.ui.Ui.CommandType;

/**
 *
 */
public class ToDoly {

  /**
   * @param args Arguments
   */
  public static void main(String[] args) {
    Ui ui = new Ui();
    ui.Command(CommandType.MAIN_MENU).invoke(taskIndex);
  }

}
