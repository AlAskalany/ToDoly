package com.alaskalany.todoly.cli.view;

import com.alaskalany.todoly.cli.View;

public class MenuOption extends View {

  private int index;
  private Text optionText;

  public MenuOption(int index, String optionText) {

    this.index = index;
    this.optionText = new Text(optionText);
  }

  public MenuOption(int index, String optionText, Menu menu) {

    MenuOption menuOption = new MenuOption(index, optionText);
  }

  @Override
  public void print() {

    System.out.print(Integer.toString(index) + "- ");
    optionText.print();
  }
}
