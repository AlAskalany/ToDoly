package com.alaskalany.todoly.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    String actualDateString = DateHelper.getLocalDateString(2014, Month.FEBRUARY, 19);
    // Assert
    System.out.println(expectedDateString + " " + actualDateString);
    assertEquals(expectedDateString, actualDateString);
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