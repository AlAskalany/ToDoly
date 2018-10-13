package com.alaskalany.todoly;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public class IdGenerator {

  @NotNull
  public static UUID getRandomId() {

    return UUID.randomUUID();
  }

  @NotNull
  public static String getTypeRandomIdString(@NotNull Class c) {

    String className = c.getSimpleName();
    return className + "-" + getRandomId().toString();
  }
}
