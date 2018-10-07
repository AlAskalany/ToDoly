package com.alaskalany.todoly.parsing;

import com.google.inject.AbstractModule;

public class DateParserModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(DateParser.class).to(DateParserImpl.class);
  }
}
