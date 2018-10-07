package com.alaskalany.todoly.cli.view;

import com.alaskalany.todoly.cli.View;
import java.util.ArrayList;

public class ListView<V extends View> extends View {

  private ArrayList<V> viewsList;

  public ListView() {

    viewsList = new ArrayList<>();
  }

  public boolean add(V v) {

    return viewsList.add(v);
  }

  public int size() {

    return viewsList.size();
  }

  @Override
  public void print() {

    viewsList.forEach(v -> {
      v.print();
      System.out.print("\n");
    });
  }
}
