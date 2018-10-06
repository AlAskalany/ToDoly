package com.alaskalany.todoly.parsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParserImpl extends DateParser {

    public DateParserImpl() {

    }

    @Override
    public LocalDate getDateFromString(String inputDate) {

        return LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
