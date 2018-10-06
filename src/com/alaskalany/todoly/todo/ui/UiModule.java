package com.alaskalany.todoly.todo.ui;

import com.google.inject.AbstractModule;

public class UiModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Ui.class).to(UiImpl.class);
    }
}
