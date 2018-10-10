package com.alaskalany.todoly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NamePrinterTest {

  private String name;

  @BeforeEach
  void setUp() {
    name = "Ahmed";
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void printName() {
    // Arrange
    String actual;
    String expected = "My Name is " + name;

    // Act
    NamePrinter printer = new NamePrinter();
    actual = printer.printName(name);

    // Assert
    assertEquals(0, actual.compareTo(expected));
  }

  @Test
  void capitalize() {
    // Arrange
    String actual;
    String expected = "AHMED";

    // Act
    NamePrinter printer = new NamePrinter();
    actual = printer.capitalize(name);

    // Assert
    assertEquals(0, actual.compareTo(expected));
  }
}