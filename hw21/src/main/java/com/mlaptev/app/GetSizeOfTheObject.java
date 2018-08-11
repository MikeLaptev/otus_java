package com.mlaptev.app;

import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetSizeOfTheObject {

  private static final Logger logger = LogManager.getLogger(GetSizeOfTheObject.class);

  public static <T> long getSizeOfTheObjectUsingLoop(Supplier<T> initializer)
      throws InterruptedException {

    int size = 5_000_000;

    long memBefore = getCurrentMemory();

    Object[] array = new Object[size];

    long memAfterArrayCreation = getCurrentMemory();

    for (int i = 0; i < array.length; i++) {
      array[i] = initializer.get();
    }

    long memAfterInitialization = getCurrentMemory();

    long memoryForReference = Math.round((memAfterArrayCreation - memBefore)/(1.0*array.length));
    logger.info("Memory for reference: {}", memoryForReference);

    long memoryForObject = Math.round((memAfterInitialization - memAfterArrayCreation)/(1.0*array.length));
    logger.info("Memory for object: {}", memoryForObject);

    array = null;
    launchGc();

    return memoryForObject;
  }

  private static long getCurrentMemory() throws InterruptedException {
    launchGc();
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static void launchGc() throws InterruptedException {
    System.gc();
    Thread.sleep(1000);
  }

  // TODO(mikhail.laptev): Implementation is required.
  public static long getSizeOfTheObjectUsingInstrumentation() {
    return 0L;
  }
}
