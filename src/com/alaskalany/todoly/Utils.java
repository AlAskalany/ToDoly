package com.alaskalany.todoly;

import com.google.inject.Guice;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

/**
 * Utilities
 *
 * @author Ahmed AlAskalany
 * @version %I%, %G%
 * @since 1.0
 */
public class Utils {

  /**
   * Disabling the following warning, caused by using {@link Guice}:
   * <p>
   * WARNING: An illegal reflective access operation has occurred
   * <p>
   * See <a href="https://github.com/google/guice/issues/1133">Guice issue #1133</a>,
   * <a href="https://stackoverflow.com/a/46458447/6798074">Stack Overflow answer</a>
   */
  static void disableWarning() {
    try {
      Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafe.setAccessible(true);
      Unsafe u = (Unsafe) theUnsafe.get(null);

      Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
      Field logger = cls.getDeclaredField("logger");
      u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
    } catch (Exception e) {
      // ignore
    }
  }

  public static class IdGenerator {

    @NotNull
    static UUID getRandomId() {

      return UUID.randomUUID();
    }

    @NotNull
    static String getTypeRandomIdString(@NotNull Class c) {

      String className = c.getSimpleName();
      return className + "-" + getRandomId().toString();
    }
  }

  public static class DateHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @NotNull
    public static String getFormattedDateFromLocalDate(@NotNull LocalDate date) {

      return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @NotNull
    public static LocalDate getDate(int year, Month month, int date) {

      return LocalDate.of(year, month, date);
    }

    @NotNull
    public static String getLocalDateString(int year, Month month, int date) {

      return getFormattedDateFromLocalDate(getDate(year, month, date));
    }
  }

  public static class DateParser {

    public DateParser() {

    }

    public LocalDate getDateFromString(String inputDate) {

      return LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public boolean isDateValid(String inputDate) {

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
        simpleDateFormat.parse(inputDate);
      } catch (ParseException e) {
        e.printStackTrace();
        return false;
      }
      return true;
    }
  }
}
