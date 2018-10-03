package com.alaskalany.todoly.cli;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    protected String title;
    protected ArrayList<String> options;
    private String prompt;

    public Menu(String title) {

        options = new ArrayList<>();
        this.title = title;
        prompt = setPrompt();
        setOptions(options);
        setActions();
    }

    protected Menu() {

    }

    protected abstract void setOptions(ArrayList<String> options);

    public void display() {

        System.out.println();
        displayTitle();
        System.out.println();
        displayOptions();
        System.out.println();
        displayBody();
        System.out.println();
        displayPrompt();
        getInput();
    }

    protected abstract void displayBody();

    protected void displayPrompt() {

        System.out.print(prompt);
        System.out.print(":> ");
    }

    private void displayOptions() {

        options.forEach(option -> {
            System.out.print(1 + options.indexOf(option));
            System.out.print("- ");
            System.out.print(option);
            System.out.println();
        });
    }

    private void displayTitle() {

        System.out.println(title);
    }

    protected abstract String setPrompt();

    public abstract void setActions();

    public void getInput() {

        Scanner scanner = new Scanner(System.in);
        onInput(scanner.nextLine());
    }

    public abstract void onInput(String string);

    protected void displayMenu(Menu menu) {

        menu.display();
    }
}
