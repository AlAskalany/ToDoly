package com.alaskalany.todoly;

/**
 *
 */
public class ToDoly {

    private static TaskManager taskManager = new TaskManager();

    /**
     * @param args Arguments
     */
    public static void main(String[] args) {
        //Ui ui = new Ui(taskManager);
        //ui.mainMenu();
        TaskManager taskManager = new TaskManager();
        MainMenu mainMenu = new MainMenu(taskManager);
        mainMenu.display();
    }
}
