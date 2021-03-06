package com.mlaptev.app.currencies;

import com.mlaptev.app.exceptions.CannotWithdrawException;
import com.mlaptev.app.exceptions.InvalidBanknoteNominationException;
import com.mlaptev.app.exceptions.InvalidCassetteStateException;
import java.util.Map;

public class Rub implements BaseCurrency {

  private Rub5000Banknote rub5000 = new Rub5000Banknote();
  private Rub1000Banknote rub1000 = new Rub1000Banknote();
  private Rub500Banknote rub500 = new Rub500Banknote();
  private Rub100Banknote rub100 = new Rub100Banknote();
  private Rub50Banknote rub50 = new Rub50Banknote();
  private Rub10Banknote rub10 = new Rub10Banknote();

  public Rub() {
    // Build chain
    rub5000.setLowerNominationBanknote(rub1000);
    rub1000.setLowerNominationBanknote(rub500);
    rub500.setLowerNominationBanknote(rub100);
    rub100.setLowerNominationBanknote(rub50);
    rub50.setLowerNominationBanknote(rub10);
  }

  @Override
  public Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException {
    return rub5000.withdraw(amount);
  }

  @Override
  public void uploadBanknotes(Map<Integer, Integer> cassette)
      throws InvalidBanknoteNominationException, InvalidCassetteStateException {
    rub5000.refillBanknoteFromCassette(cassette);
  }

  @Override
  public Map<Integer, Integer> getCurrencyState() {
    return rub5000.getBanknoteState();
  }

  @Override
  public void setCurrencyState(Map<Integer, Integer> state)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    rub5000.updateBanknoteState(state);
  }

  private class Rub5000Banknote extends Banknote {

    Rub5000Banknote() {
      nomination = 5000;
    }
  }

  private class Rub1000Banknote extends Banknote {

    Rub1000Banknote() {
      nomination = 1000;
    }
  }

  private class Rub500Banknote extends Banknote {

    Rub500Banknote() {
      nomination = 500;
    }
  }

  private class Rub100Banknote extends Banknote {

    Rub100Banknote() {
      nomination = 100;
    }
  }

  private class Rub50Banknote extends Banknote {

    Rub50Banknote() {
      nomination = 50;
    }
  }

  private class Rub10Banknote extends Banknote {

    Rub10Banknote() {
      nomination = 10;
    }
  }
}
