package com.alaskalany.todoly;

import com.google.inject.Guice;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * Utilities
 *
 * @author Ahmed AlAskalany
 * @version %I%, %G%
 * @since 1.0
 */
class Utils {

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
}
