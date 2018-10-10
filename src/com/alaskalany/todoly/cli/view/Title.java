package com.alaskalany.todoly.cli.view;

import com.alaskalany.todoly.cli.View;

public class Title extends View {

  private Text text;

  public Title(String text) {

    this.text = new Text(text);
  }

  @Override
  public void print() {

    text.print();
    System.out.println("\n_________________\n");
  }
}
