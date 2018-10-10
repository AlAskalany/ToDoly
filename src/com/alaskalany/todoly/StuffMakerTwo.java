package com.alaskalany.todoly;

public class StuffMakerTwo extends StuffMaker {

  @Override
  public void makeStuff() {
    System.out.println(message);
  }

  @Override
  public void setMessage() {
    this.message = "Maker two";
  }
}
