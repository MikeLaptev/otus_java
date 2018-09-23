package com.mlaptev.app.currencies;

public class Usd implements BaseCurrency {

  private Usd100WithdrawChain usd100 = new Usd100WithdrawChain();
  private Usd50WithdrawChain usd50 = new Usd50WithdrawChain();
  private Usd20WithdrawChain usd20 = new Usd20WithdrawChain();
  private Usd10WithdrawChain usd10 = new Usd10WithdrawChain();
  private Usd5WithdrawChain usd5 = new Usd5WithdrawChain();
  private Usd2WithdrawChain usd2 = new Usd2WithdrawChain();
  private Usd1WithdrawChain usd1 = new Usd1WithdrawChain();

  public Usd() {
    // Building chain
    usd100.setNextChain(usd50);
    usd50.setNextChain(usd20);
    usd20.setNextChain(usd10);
    usd10.setNextChain(usd5);
    usd5.setNextChain(usd2);
    usd2.setNextChain(usd1);
  }

  @Override
  public boolean withdraw(Amount amount) {
    return usd100.withdraw(amount);
  }

  private class Usd100WithdrawChain extends WithdrawChain {

    Usd100WithdrawChain() {
      nomination = 100;
    }
  }

  private class Usd50WithdrawChain extends WithdrawChain {

    Usd50WithdrawChain() {
      nomination = 50;
    }
  }

  private class Usd20WithdrawChain extends WithdrawChain {

    Usd20WithdrawChain() {
      nomination = 20;
    }
  }

  private class Usd10WithdrawChain extends WithdrawChain {

    Usd10WithdrawChain() {
      nomination = 10;
    }
  }

  private class Usd5WithdrawChain extends WithdrawChain {

    Usd5WithdrawChain() {
      nomination = 5;
    }
  }

  private class Usd2WithdrawChain extends WithdrawChain {

    Usd2WithdrawChain() {
      nomination = 2;
    }
  }

  private class Usd1WithdrawChain extends WithdrawChain {

    Usd1WithdrawChain() {
      nomination = 1;
    }
  }
}
