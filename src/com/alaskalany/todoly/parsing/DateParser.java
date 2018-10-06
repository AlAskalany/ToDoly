package com.alaskalany.todoly.parsing;

import java.time.LocalDate;

public abstract class DateParser {

    public abstract LocalDate getDateFromString(String inputDate);
}
