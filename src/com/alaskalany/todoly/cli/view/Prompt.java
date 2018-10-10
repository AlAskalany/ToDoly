package com.alaskalany.todoly.cli.view;

import java.util.Scanner;

public class Prompt {

  private Text text;

  public Prompt(String message) {

    this.text = new Text(message);
  }

  public String start() {

    text.print();
    System.out.print(":>");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
