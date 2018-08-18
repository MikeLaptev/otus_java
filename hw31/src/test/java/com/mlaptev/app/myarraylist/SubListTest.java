package com.mlaptev.app.myarraylist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mlaptev.app.MyArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubListTest {

  private MyArrayList<Integer> myArrayList;

  @BeforeEach
  void setup() {
    myArrayList = new MyArrayList<>();
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfFromIndexIsNegative() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(-1, 1));
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfToIndexIsGreaterThanSize() {
    // Arrange & Act
    myArrayList.add(0);
    myArrayList.add(1);

    // Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(1, 3));
  }

  @Test
  void subListThrowsIndexOutOfBoundsIfToIndexIsGreaterThanFromIndex() {
    // Arrange & Act & Assert
    assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.subList(2, 1));
  }
}
