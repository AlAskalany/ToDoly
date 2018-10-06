package com.alaskalany.todoly.cli.mainmenu;

import com.google.inject.AbstractModule;

public class MainMenuModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(MainMenu.class).to(MainMenuImpl.class);
    }
}
