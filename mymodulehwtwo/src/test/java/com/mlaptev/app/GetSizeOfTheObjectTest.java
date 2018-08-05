package com.mlaptev.app;

import static com.google.common.truth.Truth.assertThat;

import com.mlaptev.app.helpers.Empty;
import com.mlaptev.app.helpers.OnePrimitiveByte;
import com.mlaptev.app.helpers.OnePrimitiveDouble;
import com.mlaptev.app.helpers.OnePrimitiveInteger;
import com.mlaptev.app.helpers.TwoDoubles;
import com.mlaptev.app.helpers.TwoEmptyStrings;
import com.mlaptev.app.helpers.TwoIntegersInsideOfIntegerCashing;
import com.mlaptev.app.helpers.TwoIntegersOutsideOfIntegerCashing;
import com.mlaptev.app.helpers.TwoPrimitiveIntegers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GetSizeOfTheObjectTest {

  private static final int SIZE_OF_OBJECT_HEADER = 12;
  private static final int SIZE_OF_REFERENCE = 4;
  private static final int SIZE_OF_ARRAY_REFERENCE = 16;

  @DisplayName("Get Size of an empty object:")
  @ParameterizedTest(name = "[{index}] Type of the object {0}")
  @MethodSource(value = "argumentsOfGetSizeOfEmptyObject")
  <T> void getSizeOfEmptyObjectUsingLoop(T notUsedType, Supplier<T> initializer,
      long expectedSizeOfMemory)
      throws InterruptedException {
    assertThat(GetSizeOfTheObject.getSizeOfTheObjectUsingLoop(initializer))
        .isEqualTo(expectedSizeOfMemory);
  }

  private static Stream<Arguments> argumentsOfGetSizeOfEmptyObject() {
    return Stream.of(
        Arguments.of(Empty.class,
            (Supplier<Empty>) Empty::new,
            applyPadding(SIZE_OF_OBJECT_HEADER)
        ),
        Arguments.of(OnePrimitiveByte.class,
            (Supplier<OnePrimitiveByte>) OnePrimitiveByte::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + Byte.BYTES
            )
        ),
        Arguments.of(OnePrimitiveInteger.class,
            (Supplier<OnePrimitiveInteger>) OnePrimitiveInteger::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + Integer.BYTES
            )
        ),
        Arguments.of(TwoPrimitiveIntegers.class,
            (Supplier<TwoPrimitiveIntegers>) TwoPrimitiveIntegers::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + 2 * Integer.BYTES
            )
        ),
        Arguments.of(OnePrimitiveDouble.class,
            (Supplier<OnePrimitiveDouble>) OnePrimitiveDouble::new,
            applyPadding(SIZE_OF_OBJECT_HEADER +
                Double.BYTES
            )
        ),
        Arguments.of(TwoEmptyStrings.class,
            (Supplier<TwoEmptyStrings>) TwoEmptyStrings::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + 2 * SIZE_OF_REFERENCE
            )
        ),
        Arguments.of(TwoIntegersInsideOfIntegerCashing.class,
            (Supplier<TwoIntegersInsideOfIntegerCashing>) TwoIntegersInsideOfIntegerCashing::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + 2 * SIZE_OF_REFERENCE
            )
        ),
        Arguments.of(TwoIntegersOutsideOfIntegerCashing.class,
            (Supplier<TwoIntegersOutsideOfIntegerCashing>) TwoIntegersOutsideOfIntegerCashing::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + 2 * (SIZE_OF_OBJECT_HEADER
                    + applyPadding(SIZE_OF_REFERENCE
                    + Integer.BYTES)
                )
            )
        ),
        Arguments.of(TwoDoubles.class,
            (Supplier<TwoDoubles>) TwoDoubles::new,
            applyPadding(SIZE_OF_OBJECT_HEADER
                + 2 * (SIZE_OF_OBJECT_HEADER
                    + applyPadding(SIZE_OF_REFERENCE
                    + Double.BYTES)
                )
            )
        ),
        Arguments.of(String.class,
            (Supplier<String>) () -> "",
            0 // Just rewriting references for cached value, no additional memory needed
        ),
        // Generating of 128 bit UUID
        Arguments.of(String.class,
            (Supplier<String>) () -> UUID.randomUUID().toString(),
            applyPadding(2 * Long.BYTES // internal fields (2 fields of type long) of UUID
                + SIZE_OF_ARRAY_REFERENCE // there is array of bytes inside the string
                + 36 // size of array with symbols of UUID
                + Byte.BYTES // for variable 'coder' from String.class
                + Integer.BYTES // for variable 'hash' from String.class
            )
        ),
        // Empty array list (just an empty array inside)
        Arguments.of(List.class,
            (Supplier<List<Integer>>) ArrayList::new,
            applyPadding(SIZE_OF_ARRAY_REFERENCE
                + Integer.BYTES // internal variable responsible for size of the collection
            )
        ),
        Arguments.of(int[].class,
            (Supplier<int[]>) () -> new int[10],
            applyPadding(SIZE_OF_ARRAY_REFERENCE
                + 10 * Integer.BYTES
            )
        ),
        Arguments.of(Integer.class,
            (Supplier<Integer>) () -> new Random().nextInt(),
            applyPadding(SIZE_OF_OBJECT_HEADER
                + Integer.BYTES
            )
        )
    );
  }

  private static int applyPadding(int value) {
    return (value & 7) != 0 ? (((value >> 3) + 1) << 3) : value;
  }
}