package com.alaskalany.todoly.todo;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

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
