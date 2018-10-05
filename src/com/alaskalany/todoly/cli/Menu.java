package com.alaskalany.todoly.cli;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Menu {

    private final String title;
    private final ArrayList<String> options;
    private final String prompt;

    Menu(String title) {

        options = new ArrayList<>();
        this.title = title;
        prompt = setPrompt();
        setOptions(options);
    }

    protected abstract void setOptions(ArrayList<String> options);

    void display() {

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

    private void displayPrompt() {

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

    private void getInput() {

        Scanner scanner = new Scanner(System.in);
        onInput(scanner.nextLine());
    }

    protected abstract void onInput(String string);

    void displayMenu(Menu menu) {

        menu.display();
    }
}
