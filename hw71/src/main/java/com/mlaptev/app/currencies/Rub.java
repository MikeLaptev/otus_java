package com.mlaptev.app.currencies;

public class Rub implements BaseCurrency {

  private Rub5000WithdrawChain rub5000 = new Rub5000WithdrawChain();
  private Rub1000WithdrawChain rub1000 = new Rub1000WithdrawChain();
  private Rub500WithdrawChain rub500 = new Rub500WithdrawChain();
  private Rub100WithdrawChain rub100 = new Rub100WithdrawChain();
  private Rub50WithdrawChain rub50 = new Rub50WithdrawChain();
  private Rub10WithdrawChain rub10 = new Rub10WithdrawChain();

  public Rub() {
    // Build chain
    rub5000.setNextChain(rub1000);
    rub1000.setNextChain(rub500);
    rub500.setNextChain(rub100);
    rub100.setNextChain(rub50);
    rub50.setNextChain(rub10);
  }

  @Override
  public boolean withdraw(Amount amount) {
    return rub5000.withdraw(amount);
  }

  private class Rub5000WithdrawChain extends WithdrawChain {

    Rub5000WithdrawChain() {
      nomination = 5000;
    }
  }

  private class Rub1000WithdrawChain extends WithdrawChain {

    Rub1000WithdrawChain() {
      nomination = 1000;
    }
  }

  private class Rub500WithdrawChain extends WithdrawChain {

    Rub500WithdrawChain() {
      nomination = 500;
    }
  }

  private class Rub100WithdrawChain extends WithdrawChain {

    Rub100WithdrawChain() {
      nomination = 100;
    }
  }

  private class Rub50WithdrawChain extends WithdrawChain {

    Rub50WithdrawChain() {
      nomination = 50;
    }
  }

  private class Rub10WithdrawChain extends WithdrawChain {

    Rub10WithdrawChain() {
      nomination = 10;
    }
  }
}
