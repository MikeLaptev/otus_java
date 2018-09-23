package com.mlaptev.app.atms;

import com.mlaptev.app.currencies.CurrencyType;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Act & Assert
    assertTrue(atm.isItPossibleToWithdraw(CurrencyType.USD, 188),
        "It should be possible to withdraw USD.");
  }

  @Test
  void isShouldNotBePossibleToWithdrawUsdFromAtmThatNotSupportedUsd() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.GBP);
    atm.addSupportOfCurrencyType(CurrencyType.EURO);
    atm.addSupportOfCurrencyType(CurrencyType.RUBLE);

    // Act & Assert
    assertFalse(atm.isItPossibleToWithdraw(CurrencyType.USD, 188),
        "It should not be possible to withdraw USD.");
  }
}