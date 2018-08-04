package com.mlaptev.app;

import static com.google.common.truth.Truth.assertThat;

import com.mlaptev.app.helpers.OnePrimitiveDouble;
import com.mlaptev.app.helpers.TwoEmptyStrings;
import com.mlaptev.app.helpers.TwoIntegersOfByteMaxAndMin;
import com.mlaptev.app.helpers.TwoIntegersOfGreaterByteMaxAndLessByteMin;
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

  @DisplayName("Get Size of an empty object:")
  @ParameterizedTest(name = "[{index}] Type of the object {0}")
  @MethodSource(value = "argumentsOfGetSizeOfEmptyObject")
  <T> void getSizeOfEmptyObjectUsingLoop(T notUsedType, Supplier<T> initializer, long expectedSizeOfMemory)
      throws InterruptedException {
    assertThat(GetSizeOfTheObject.getSizeOfTheObjectUsingLoop(initializer))
        .isEqualTo(expectedSizeOfMemory);
  }

  private static Stream<Arguments> argumentsOfGetSizeOfEmptyObject() {
    return Stream.of(
        Arguments.of(OnePrimitiveDouble.class,
            (Supplier<OnePrimitiveDouble>) OnePrimitiveDouble::new, 24),
        Arguments.of(TwoEmptyStrings.class,
            (Supplier<TwoEmptyStrings>) TwoEmptyStrings::new, 24),
        Arguments.of(TwoIntegersOfByteMaxAndMin.class,
            (Supplier<TwoIntegersOfByteMaxAndMin>) TwoIntegersOfByteMaxAndMin::new, 24),
        Arguments.of(TwoIntegersOfGreaterByteMaxAndLessByteMin.class,
            (Supplier<TwoIntegersOfGreaterByteMaxAndLessByteMin>) TwoIntegersOfGreaterByteMaxAndLessByteMin::new, 56),
        Arguments.of(TwoPrimitiveIntegers.class,
            (Supplier<TwoPrimitiveIntegers>) TwoPrimitiveIntegers::new, 24),
        Arguments.of(String.class,
            (Supplier<String>) () -> "", 0),
        Arguments.of(String.class, // Generating of 128 bit UUID
            (Supplier<String>) () -> UUID.randomUUID().toString(), 80),
        Arguments.of(List.class,
            (Supplier<List<Integer>>) ArrayList::new, 24),
        Arguments.of(Integer.class,
            (Supplier<Integer>) () -> new Random().nextInt(), 16)
    );
  }
}