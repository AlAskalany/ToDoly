package com.alaskalany.todoly.date;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ranges.RangeException;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getFormattedDateFromLocalDate(LocalDate date) {

        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate getDate(int year, Month month, int date) {

        return LocalDate.of(year, month, date);
    }

    @NotNull
    public static String getLocalDateString(int year, Month month, int date) {

        return getFormattedDateFromLocalDate(getDate(year, month, date));
    }
}
