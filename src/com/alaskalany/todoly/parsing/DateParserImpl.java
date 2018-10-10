package com.alaskalany.todoly.parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParserImpl extends DateParser {

  public DateParserImpl() {

  }

  @Override
  public LocalDate getDateFromString(String inputDate) {

    return LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public boolean isDateValid(String inputDate) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      simpleDateFormat.parse(inputDate);
    } catch (ParseException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
