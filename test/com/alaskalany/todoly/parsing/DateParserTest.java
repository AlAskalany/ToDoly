package com.alaskalany.todoly.parsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateParserTest {

  private DateParser dateParser = new DateParserImpl();

  @BeforeEach
  void setUp() {

  }

  @AfterEach
  void tearDown() {

  }

  @Test
  void getDateFromString() {

    LocalDate expectedDate = LocalDate.of(1898, Month.DECEMBER, 31);
    LocalDate resultDate = dateParser.getDateFromString("1898-12-31");
    assertEquals(0, expectedDate.compareTo(resultDate));
  }
}