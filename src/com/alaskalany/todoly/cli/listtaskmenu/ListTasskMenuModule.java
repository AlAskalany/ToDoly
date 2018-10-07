package com.alaskalany.todoly.cli.listtaskmenu;

import com.google.inject.AbstractModule;

public class ListTasskMenuModule extends AbstractModule {

  @Override
  public void configure() {

    bind(ListTasksMenu.class).to(ListTasksMenuImpl.class);
  }
}
