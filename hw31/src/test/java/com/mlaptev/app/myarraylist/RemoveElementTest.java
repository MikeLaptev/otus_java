package com.mlaptev.app.myarraylist;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mlaptev.app.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveElementTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void removeAtNegativeIndexShouldThrowAnException() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(-1));
  }

  @Test
  void removeAtPositiveIndexTheGreaterOrEqualSizeOfArrayShouldThrowAnException() {
    // Arrange
    myArrayList.add(0);
    myArrayList.add(1);

    // Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(2));
  }
}
