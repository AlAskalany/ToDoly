package com.alaskalany.todoly.parsing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    DateParser dateParser = new DateParser();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDateFromString() throws ParseException {
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse("1898-12-31");
        Date resultDate = dateParser.getDateFromString("1898-12-31");
        assertEquals(0, expectedDate.compareTo(resultDate));
    }
}