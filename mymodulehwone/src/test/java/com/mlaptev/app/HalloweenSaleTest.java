package com.mlaptev.app;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HalloweenSaleTest {

  @ParameterizedTest
  @MethodSource(value = "hackerrankScenarios")
  void hackerrankBasicTests(int p, int d, int m, int s, int expectedResult) {
    assertThat(HalloweenSale.getMaximumNumberOfGamesToBuy(p, d, m, s)).isEqualTo(expectedResult);
  }

  private static Stream<Arguments> hackerrankScenarios() {
    return Stream.of(
        Arguments.of((Object[]) new Integer[]{20, 3, 6, 80, 6}),
        Arguments.of((Object[]) new Integer[]{20, 3, 6, 85, 7})
    );
  }
}
