package com.alaskalany.todoly.date;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getFormattedDate(LocalDate date) {

        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static LocalDate getDate(int year, int month, int date) {

        return LocalDate.of(year, month, date);
    }

    @SuppressWarnings("SameParameterValue")
    @NotNull
    static String getFormattedDate(int year, int month, int date) {

        return getFormattedDate(getDate(year, month, date));
    }
}
