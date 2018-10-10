package com.alaskalany.todoly.cli.view;

import com.alaskalany.todoly.cli.View;

public class Text extends View {

  private String text;

  public Text(String text) {

    this.text = text;
  }

  @Override
  public void print() {

    System.out.print(text);
  }
}
