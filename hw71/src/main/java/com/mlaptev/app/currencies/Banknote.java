package com.mlaptev.app.currencies;

import com.mlaptev.app.exceptions.CannotWithdrawException;
import com.mlaptev.app.exceptions.InvalidBanknoteNominationException;
import com.mlaptev.app.exceptions.InvalidCassetteStateException;
import java.util.HashMap;
import java.util.Map;

abstract class Banknote {

  // Reference on a banknote with lower nomination
  private Banknote lowerNominationBanknote = null;

  int nomination;
  private int numberOfBanknotes;

  void setLowerNominationBanknote(Banknote banknote) {
    this.lowerNominationBanknote = banknote;
  }

  void refillBanknoteFromCassette(Map<Integer, Integer> cassette)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    if (cassette.containsKey(nomination)) {
      if (cassette.get(nomination) <= 0) {
        throw new InvalidCassetteStateException("Number of banknotes to add should be positive");
      }

      numberOfBanknotes += cassette.remove(nomination);

      if (lowerNominationBanknote != null) {
        lowerNominationBanknote.refillBanknoteFromCassette(cassette);
      } else if (!cassette.isEmpty()) {
        throw new InvalidBanknoteNominationException(
            "Not supported banknote nomination in cassette");
      }
    }
  }

  Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException {
    Map<Integer, Integer> current = new HashMap<>();

    if (numberOfBanknotes != 0 && amount >= nomination) {
      int numberOfBanknotesToUse = amount / nomination;

      if (numberOfBanknotesToUse > numberOfBanknotes) {
        numberOfBanknotesToUse = numberOfBanknotes;
      }

      int reminder = amount - numberOfBanknotesToUse * nomination;

      current.put(nomination, numberOfBanknotesToUse);
      numberOfBanknotes -= numberOfBanknotesToUse;

      if (reminder != 0) {
        if (lowerNominationBanknote != null) {
          current.putAll(lowerNominationBanknote.withdraw(reminder));
          return current;
        } else {
          throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
        }
      } else {
        return current;
      }
    } else {
      if (lowerNominationBanknote != null) {
        return lowerNominationBanknote.withdraw(amount);
      } else {
        throw new CannotWithdrawException("Cannot withdraw required amount of money from ATM.");
      }
    }
  }
}
