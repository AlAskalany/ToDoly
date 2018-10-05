package com.alaskalany.todoly.date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateHelperTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getFormattedDate() {
        // Arrange
        String expectedDateString = "2014-02-19";
        // Act
        String actualDateString = DateHelper.getFormattedDate(2014, 2, 19);
        // Assert
        assertEquals(expectedDateString, actualDateString);
    }

    @Test
    void getDate() {
        // Arrange
        LocalDate expectedDate = LocalDate.of(2014, Calendar.FEBRUARY, 19);
        // Act
        LocalDate actualDate = DateHelper.getDate(2014, Calendar.FEBRUARY, 19);
        // Assert
        assertEquals(0, expectedDate.compareTo(actualDate));
    }

    @Test
    void getFormattedDate1() {

    }
}