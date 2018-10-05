package com.alaskalany.todoly.date;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @NotNull
    public static String getFormattedDate(Date date) {

        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    @NotNull
    public static Date getDate(int year, int month, int date) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }

    public @NotNull
    static String getFormattedDate(int year, int month, int date) {

        return getFormattedDate(getDate(year, month, date));
    }
}
