package com.alaskalany.todoly.date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateHelperTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getDate() {
        // Arrange
        LocalDate expectedDate = LocalDate.of(2014, Month.FEBRUARY, 19);
        // Act
        LocalDate actualDate = DateHelper.getDate(2014, Month.FEBRUARY, 19);
        // Assert
        assertEquals(0, expectedDate.compareTo(actualDate));
    }

    @Test
    void getFormattedDate1() {

    }
}