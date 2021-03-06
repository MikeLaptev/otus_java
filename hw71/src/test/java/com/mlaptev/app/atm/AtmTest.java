package com.mlaptev.app.atm;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mlaptev.app.currencies.CurrencyType;
import com.mlaptev.app.exceptions.CannotWithdrawException;
import com.mlaptev.app.exceptions.CurrencyNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtmTest {

  private Atm atm;

  @BeforeEach
  void setup() {
    atm = new Atm();
  }

  @Test
  void itShouldBePossibleToWithdrawUsdFromAtmSupportedUsd() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.USD);
    atm.loadCassette(CurrencyType.USD, new HashMap<>(){{
      put(1, 1);
      put(2, 1);
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    // Act
    Map<Integer, Integer> money = atm.withdraw(CurrencyType.USD, 188);

    // Assert
    assertAll(
        () -> assertTrue(money.containsKey(1), "Withdraw money should contains 1 USD banknote."),
        () -> assertTrue(money.containsKey(2), "Withdraw money should contains 2 USD banknote."),
        () -> assertTrue(money.containsKey(5), "Withdraw money should contains 5 USD banknote."),
        () -> assertTrue(money.containsKey(10), "Withdraw money should contains 10 USD banknote."),
        () -> assertTrue(money.containsKey(20), "Withdraw money should contains 20 USD banknote."),
        () -> assertTrue(money.containsKey(50), "Withdraw money should contains 50 USD banknote."),
        () -> assertTrue(money.containsKey(100), "Withdraw money should contains 100 USD banknote.")
    );

    assertAll(
        () -> assertEquals(money.get(1).intValue(), 1, "Invalid amount of 1 USD banknotes"),
        () -> assertEquals(money.get(2).intValue(), 1, "Invalid amount of 2 USD banknotes"),
        () -> assertEquals(money.get(5).intValue(), 1, "Invalid amount of 5 USD banknotes"),
        () -> assertEquals(money.get(10).intValue(), 1, "Invalid amount of 10 USD banknotes"),
        () -> assertEquals(money.get(20).intValue(), 1, "Invalid amount of 20 USD banknotes"),
        () -> assertEquals(money.get(50).intValue(), 1, "Invalid amount of 50 USD banknotes"),
        () -> assertEquals(money.get(100).intValue(), 1, "Invalid amount of 100 USD banknotes")
    );
  }

  @Test
  void isShouldNotBePossibleToWithdrawUsdFromAtmThatNotSupportedUsd() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.GBP);
    atm.addSupportOfCurrencyType(CurrencyType.EURO);
    atm.addSupportOfCurrencyType(CurrencyType.RUBLE);

    // Act & Assert
    assertThrows(CurrencyNotSupportedException.class,
        () -> atm.withdraw(CurrencyType.USD, 188),
        "It should not be possible to withdraw USD.");
  }

  @Test
  void atmStateShouldNotBeChangedAfterUnsuccessfulWithdrawal() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.GBP);
    atm.loadCassette(CurrencyType.GBP, new HashMap<>(){{
      put(5, 1);
      put(10, 1);
      put(20, 1);
      put(50, 1);
      put(100, 1);
    }});

    // Act & Assert
    assertThrows(CannotWithdrawException.class,
        () -> atm.withdraw(CurrencyType.GBP, 13),
        "It should not be possible to withdraw.");

    Map<Integer, Integer> money = new HashMap<>();

    assertDoesNotThrow(() -> money.putAll(atm.withdraw(CurrencyType.GBP, 185)),
        "It should be possible to withdraw.");

    assertAll(
        () -> assertEquals(money.get(5).intValue(), 1, "Invalid amount of 5 GBP banknotes"),
        () -> assertEquals(money.get(10).intValue(), 1, "Invalid amount of 10 GBP banknotes"),
        () -> assertEquals(money.get(20).intValue(), 1, "Invalid amount of 20 GBP banknotes"),
        () -> assertEquals(money.get(50).intValue(), 1, "Invalid amount of 50 GBP banknotes"),
        () -> assertEquals(money.get(100).intValue(), 1, "Invalid amount of 100 GBP banknotes")
    );
  }

  @Test
  void atmStateShouldBeChangedAfterSuccessfulWithdrawal() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.GBP);
    atm.loadCassette(CurrencyType.GBP, new HashMap<>(){{
      put(5, 2);
      put(10, 2);
      put(20, 2);
      put(50, 2);
      put(100, 2);
    }});

    // Act & Assert
    Map<Integer, Integer> money = atm.withdraw(CurrencyType.GBP, 370);

    assertAll(
        () -> assertEquals(money.get(5).intValue(), 2, "Invalid amount of 5 GBP banknotes"),
        () -> assertEquals(money.get(10).intValue(), 2, "Invalid amount of 10 GBP banknotes"),
        () -> assertEquals(money.get(20).intValue(), 2, "Invalid amount of 20 GBP banknotes"),
        () -> assertEquals(money.get(50).intValue(), 2, "Invalid amount of 50 GBP banknotes"),
        () -> assertEquals(money.get(100).intValue(), 2, "Invalid amount of 100 GBP banknotes")
    );

    assertAll(
        () -> assertThrows(CannotWithdrawException.class,
            () -> atm.withdraw(CurrencyType.GBP, 5), "Invalid amount of 5 GBP."),
        () -> assertThrows(CannotWithdrawException.class,
            () -> atm.withdraw(CurrencyType.GBP, 10), "Invalid amount of 10 GBP."),
        () -> assertThrows(CannotWithdrawException.class,
            () -> atm.withdraw(CurrencyType.GBP, 20), "Invalid amount of 20 GBP."),
        () -> assertThrows(CannotWithdrawException.class,
            () -> atm.withdraw(CurrencyType.GBP, 50), "Invalid amount of 50 GBP."),
        () -> assertThrows(CannotWithdrawException.class,
            () -> atm.withdraw(CurrencyType.GBP, 100), "Invalid amount of 100 GBP.")
    );
  }
}