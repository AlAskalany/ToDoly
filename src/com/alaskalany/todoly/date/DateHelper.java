package com.alaskalany.todoly.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import org.jetbrains.annotations.NotNull;

public class DateHelper {

  @NotNull
  public static String getFormattedDateFromLocalDate(@NotNull LocalDate date) {

    return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
  }

  @NotNull
  public static LocalDate getDate(int year, Month month, int date) {

    return LocalDate.of(year, month, date);
  }

  @NotNull
  public static String getLocalDateString(int year, Month month, int date) {

    return getFormattedDateFromLocalDate(getDate(year, month, date));
  }
}
