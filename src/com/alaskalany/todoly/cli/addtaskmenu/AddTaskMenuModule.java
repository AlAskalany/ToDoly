package com.alaskalany.todoly.cli.addtaskmenu;

import com.google.inject.AbstractModule;

public class AddTaskMenuModule extends AbstractModule {

    @Override
    public void configure() {

        bind(AddTaskMenu.class).to(AddTaskMenuImpl.class);
    }
}
