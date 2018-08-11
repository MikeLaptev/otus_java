package com.mlaptev.app;

import com.mlaptev.app.helpers.Empty;
import com.mlaptev.app.helpers.OneDouble;
import com.mlaptev.app.helpers.OnePrimitiveByte;
import com.mlaptev.app.helpers.OnePrimitiveDouble;
import com.mlaptev.app.helpers.OnePrimitiveInteger;
import com.mlaptev.app.helpers.ThreeDoubles;
import com.mlaptev.app.helpers.TwoDoubles;
import com.mlaptev.app.helpers.TwoIntegersInsideOfIntegerCashing;
import com.mlaptev.app.helpers.TwoIntegersOutsideOfIntegerCashing;
import com.mlaptev.app.helpers.TwoPrimitiveIntegers;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetSizeOfTheObject {

  private static final Logger logger = LogManager.getLogger(GetSizeOfTheObject.class);

  private static final int SIZE_OF_OBJECT_HEADER = 12;
  private static final int SIZE_OF_REFERENCE = 4;
  private static final int SIZE_OF_ARRAY_REFERENCE = 16;

  private static <T> long getSizeOfTheObjectUsingLoop(Supplier<T> initializer)
      throws InterruptedException {

    int size = 5_000_000;

    long memBefore = getCurrentMemory();

    Object[] array = new Object[size];

    long memAfterArrayCreation = getCurrentMemory();

    for (int i = 0; i < array.length; i++) {
      array[i] = initializer.get();
    }

    long memAfterInitialization = getCurrentMemory();

    long memoryForReference = Math
        .round((memAfterArrayCreation - memBefore) / (1.0 * array.length));
    logger.info("Memory for reference: {}", memoryForReference);

    long memoryForObject = Math
        .round((memAfterInitialization - memAfterArrayCreation) / (1.0 * array.length));
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
  private static long getSizeOfTheObjectUsingInstrumentation() {
    return 0L;
  }

  private static int applyPadding(int value) {
    return (value & 7) != 0 ? (((value >> 3) + 1) << 3) : value;
  }

  public static void main(String[] args) throws InterruptedException {
    logger.info("Size of an empty object: {} (expected {})",
        getSizeOfTheObjectUsingLoop(Empty::new),
        applyPadding(SIZE_OF_OBJECT_HEADER));

    logger.info("Size of an object with only one variable of type primitive byte: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OnePrimitiveByte::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + Byte.BYTES
        ));

    logger.info("Size of an object with only one variable of type primitive integer: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OnePrimitiveInteger::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + Integer.BYTES
        ));

    logger.info("Size of an object with two variables of type primitive integer: {} (expected {})",
        getSizeOfTheObjectUsingLoop(TwoPrimitiveIntegers::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * Integer.BYTES
        ));

    logger.info("Size of an object with only one variable of type primitive double: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OnePrimitiveDouble::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + Double.BYTES
        ));

    logger.info("Size of an object with two variables - empty String: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OnePrimitiveDouble::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * SIZE_OF_REFERENCE
        ));

    logger.info("Size of an object with two variables - empty String: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OnePrimitiveDouble::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * SIZE_OF_REFERENCE
        ));

    logger.info("Size of an object with two variables of type Integer and initial values inside of Integer Caching: {} (expected {})",
        getSizeOfTheObjectUsingLoop(TwoIntegersInsideOfIntegerCashing::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * SIZE_OF_REFERENCE
        ));

    logger.info("Size of an object with two variables of type Integer and initial values outside of Integer Caching: {} (expected {})",
        getSizeOfTheObjectUsingLoop(TwoIntegersOutsideOfIntegerCashing::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * SIZE_OF_REFERENCE
            + 2 * applyPadding(SIZE_OF_OBJECT_HEADER
            + Integer.BYTES)
        ));

    logger.info("Size of an object with one variable of type Double: {} (expected {})",
        getSizeOfTheObjectUsingLoop(OneDouble::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 1 * SIZE_OF_REFERENCE
            + 1 * applyPadding(SIZE_OF_OBJECT_HEADER
            + Double.BYTES)
        ));

    logger.info("Size of an object with two variables of type Double: {} (expected {})",
        getSizeOfTheObjectUsingLoop(TwoDoubles::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 2 * SIZE_OF_REFERENCE
            + 2 * applyPadding(SIZE_OF_OBJECT_HEADER
            + Double.BYTES)
        ));

    logger.info("Size of an object with three variables of type Double: {} (expected {})",
        getSizeOfTheObjectUsingLoop(ThreeDoubles::new),
        applyPadding(SIZE_OF_OBJECT_HEADER
            + 3 * SIZE_OF_REFERENCE
            + 3 * applyPadding(SIZE_OF_OBJECT_HEADER
            + Double.BYTES)
        ));

    // Just rewriting references for cached value, no additional memory needed
    logger.info("Size of an empty String: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> ""),
        0);

    logger.info("Size of a String initialised by an empty String: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new String("")),
        applyPadding(SIZE_OF_OBJECT_HEADER // header of String object
            + SIZE_OF_OBJECT_HEADER // header of Array object
        ));

    logger.info("Size of a String initialised by an array with size of 0 and type of byte: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new String(new byte[0])),
        applyPadding(SIZE_OF_OBJECT_HEADER // header of String object
            + SIZE_OF_OBJECT_HEADER // header of Array object
            + SIZE_OF_ARRAY_REFERENCE // reference for array
        ));

    logger.info("Size of a String initialised by an array with size of 10 and type of byte: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new String(new byte[10])),
        applyPadding(SIZE_OF_OBJECT_HEADER // header of String object
            + SIZE_OF_OBJECT_HEADER // header of Array object
            + SIZE_OF_ARRAY_REFERENCE // reference for array
            + 10*Byte.BYTES
        ));

    logger.info("Size of a String initialised by an array with size of 16 and type of byte: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new String(new byte[10])),
        applyPadding(SIZE_OF_OBJECT_HEADER // header of String object
            + SIZE_OF_OBJECT_HEADER // header of Array object
            + SIZE_OF_ARRAY_REFERENCE // reference for array
            + 16*Byte.BYTES
        ));

    logger.info("Size of a String initialised by an array with size of 17 and type of byte: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new String(new byte[10])),
        applyPadding(SIZE_OF_OBJECT_HEADER // header of String object
            + SIZE_OF_OBJECT_HEADER // header of Array object
            + SIZE_OF_ARRAY_REFERENCE // reference for array
            + 17*Byte.BYTES
        ));

    // Generating of 128 bit UUID
    logger.info("Size of a 128-bit UUID: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> UUID.randomUUID().toString()),
        applyPadding(2 * Long.BYTES // internal fields (2 fields of type long) of UUID
            + SIZE_OF_ARRAY_REFERENCE // there is array of bytes inside the string
            + 36 // size of array with symbols of UUID
            + Byte.BYTES // for variable 'coder' from String.class
            + Integer.BYTES // for variable 'hash' from String.class
        ));

    // Empty ArrayList (just an empty array inside)
    logger.info("Size of an empty ArrayList: {} (expected {})",
        getSizeOfTheObjectUsingLoop(ArrayList::new),
        applyPadding(SIZE_OF_ARRAY_REFERENCE
            + Integer.BYTES // internal variable responsible for size of the collection
        ));

    logger.info("Size of an array of ints of size 10: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new int[10]),
        applyPadding(SIZE_OF_ARRAY_REFERENCE
            + 10 * Integer.BYTES
        ));

    logger.info("Size of a randomly generated integer: {} (expected {})",
        getSizeOfTheObjectUsingLoop(() -> new Random().nextInt()),
        applyPadding(SIZE_OF_ARRAY_REFERENCE
            + Integer.BYTES
        ));
  }
}
