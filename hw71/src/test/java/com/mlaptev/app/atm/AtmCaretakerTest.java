package com.mlaptev.app.atm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mlaptev.app.currencies.CurrencyType;
import com.mlaptev.app.exceptions.CannotWithdrawException;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtmCaretakerTest {

  private Atm atm;
  private AtmCaretaker caretaker;

  @BeforeEach
  void setup() {
    atm = new Atm();
    caretaker = new AtmCaretaker();
  }

  @Test
  void itShouldBePossibleToRestoreAtmState() throws Exception {
    // Arrange
    atm.addSupportOfCurrencyType(CurrencyType.RUBLE);
    atm.loadCassette(CurrencyType.RUBLE, new HashMap<>() {{
      put(10, 1);
      put(50, 1);
      put(100, 1);
      put(500, 1);
      put(1000, 1);
      put(5000, 1);
    }});

    caretaker.save(atm);

    // Act & Assert
    atm.withdraw(CurrencyType.RUBLE, 6660);
    assertThrows(CannotWithdrawException.class,
        () -> atm.withdraw(CurrencyType.RUBLE, 6660),
        "It should not be possible to withdraw Russian Rubles.");

    caretaker.undo(atm);
    assertDoesNotThrow(
        () -> atm.withdraw(CurrencyType.RUBLE, 6660),
        "It should not be possible to withdraw Russian Rubles.");
  }
}