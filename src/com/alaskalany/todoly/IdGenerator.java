package com.alaskalany.todoly;

import java.util.UUID;

public class IdGenerator {

    public static UUID getRandomId() {

        return UUID.randomUUID();
    }

    public static String getTypeRandomIdString(Class c) {

        String className = c.getSimpleName();
        return className + "-" + getRandomId().toString();
    }
}
