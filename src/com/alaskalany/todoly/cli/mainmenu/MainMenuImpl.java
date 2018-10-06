package com.alaskalany.todoly.cli.mainmenu;

import com.alaskalany.todoly.cli.addtaskmenu.AddTaskMenu;
import com.alaskalany.todoly.cli.listtaskmenu.ListTasksMenu;

import javax.inject.Inject;
import java.util.ArrayList;

public class MainMenuImpl extends MainMenu {

    @Inject
    private AddTaskMenu addTaskMenu;
    @Inject
    private ListTasksMenu listTasksMenu;

    @Inject
    public MainMenuImpl(String title) {

        super(title);
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

        options.add("Add a task");
        options.add("List all tasks");
        options.add("Save and quit");
    }

    @Override
    protected void displayBody() {

    }

    @Override
    protected String setPrompt() {

        return "Enter choice";
    }

    @Override
    public void onInput(String input) {

        switch (input) {
            case "0":
                displayMenu(this);
                break;
            case "1":
                displayMenu(addTaskMenu);
                break;
            case "2":
                displayMenu(listTasksMenu);
                break;
        }
    }
}
