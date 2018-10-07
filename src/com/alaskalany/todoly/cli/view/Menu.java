package com.alaskalany.todoly.cli.view;

import com.alaskalany.todoly.cli.View;

public class Menu extends View {

  private Title title;
  private ListView<MenuOption> menuOptionListView;
  private Prompt prompt;

  public Menu(String title) {

    this.title = new Title(title);
    menuOptionListView = new ListView<>();
  }

  public Menu(String title, String promptMessage) {

    this.title = new Title(title);
    menuOptionListView = new ListView<>();
    setPrompt(new Prompt(promptMessage));
  }

  private void setPrompt(Prompt prompt) {

    this.prompt = prompt;
  }

  public boolean add(MenuOption menuOption) {

    return menuOptionListView.add(menuOption);
  }

  public boolean add(String optionText) {

    return menuOptionListView.add(new MenuOption(menuOptionListView.size() + 1, optionText));
  }

  @Override
  public void print() {

    title.print();
    menuOptionListView.print();
    if (prompt != null) {
      System.out.println();
      prompt.start();
    }
  }
}
