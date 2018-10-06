package com.alaskalany.todoly.cli.listtaskmenu;

import com.alaskalany.todoly.cli.mainmenu.MainMenu;
import com.alaskalany.todoly.cli.tasklistduedatemenu.TaskListDueDateMenu;

import javax.inject.Inject;
import java.util.ArrayList;

public class ListTasksMenuImpl extends ListTasksMenu {

    @Inject
    private TaskListDueDateMenu taskListDueDateMenu;
    @Inject
    private MainMenu mainMenu;

    @Inject
    public ListTasksMenuImpl(String title) {

        super(title);
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

        options.add("By date");
        options.add("By project");
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
                displayMenu(mainMenu);
                break;
            case "1":
                taskListDueDateMenu.display();
                break;
//noinspection StatementWithEmptyBody
            case "2":
                // TODO: 2018-10-05
                break;
        }
    }
}
