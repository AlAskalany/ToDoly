package com.alaskalany.todoly.parsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

    public DateParser() {

    }

    public LocalDate getDateFromString(String inputDate) {

        return LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
