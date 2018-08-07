package com.mlaptev.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MyArrayListTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void newListShouldHaveSizeZeroAndShouldBeEmpty() {
    // Arrange & Act & Assert
    assertAll(
        () -> assertEquals(0, myArrayList.size()),
        () -> assertTrue(myArrayList.isEmpty())
    );
  }

  @Test
  void accessToItemOfEmptyListShouldThrowsAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(0));
  }

  @Test
  void accessToANegativeIndexShouldThrowsAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
  }

  @Test
  void conversionToArrayShouldReturnsEmptyArray() {
    // Arrange & Act
    Object[] actualArray = myArrayList.toArray();

    // Assert
    assertAll(
        () -> assertNotNull(actualArray),
        () -> assertEquals(0, actualArray.length)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionShouldAddElementProperly(Integer... elementsToAdd) {
    // Arrange & Act
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
    }

    // Assert
    for (int i = 0; i < elementsToAdd.length; i++) {
      assertEquals(elementsToAdd[i], myArrayList.get(i));
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionReturnReturnsTrueWhenItIsEnoughMemory(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    for (Integer element: elementsToAdd) {
      assertTrue(myArrayList.add(element));
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void addElementFunctionShouldUpdateSizeOfTheArray(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    int currentSize = myArrayList.size();
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
      assertEquals(++currentSize, myArrayList.size());
    }
  }

  @ParameterizedTest
  @MethodSource(value = "listOfIntegers")
  void arrayShouldNotBeEmptyIfItContainsOneOrMoreElements(Integer... elementsToAdd) {
    // Arrange & Act & Assert
    for (Integer element: elementsToAdd) {
      myArrayList.add(element);
      assertFalse(myArrayList.isEmpty());
    }
  }

  private static Stream<Arguments> listOfIntegers() {
    return Stream.of(
        Arguments.of((Object[]) new Integer[][]{new Integer[]{20, 3, 6}}),
        Arguments.of((Object[]) new Integer[][]{new Integer[]{13, 33, 17, 85, 7, 18, 19, 31}})
    );
  }
}
