package com.mlaptev.app.currencies;

public class Eur implements BaseCurrency {

  private Eur500WithdrawChain eur500 = new Eur500WithdrawChain();
  private Eur200WithdrawChain eur200 = new Eur200WithdrawChain();
  private Eur100WithdrawChain eur100 = new Eur100WithdrawChain();
  private Eur50WithdrawChain eur50 = new Eur50WithdrawChain();
  private Eur20WithdrawChain eur20 = new Eur20WithdrawChain();
  private Eur10WithdrawChain eur10 = new Eur10WithdrawChain();
  private Eur5WithdrawChain eur5 = new Eur5WithdrawChain();

  public Eur() {
    // Build chain
    eur500.setNextChain(eur200);
    eur200.setNextChain(eur100);
    eur100.setNextChain(eur50);
    eur50.setNextChain(eur20);
    eur20.setNextChain(eur10);
    eur10.setNextChain(eur5);
  }

  @Override
  public boolean withdraw(Amount amount) {
    return eur500.withdraw(amount);
  }

  private class Eur500WithdrawChain extends WithdrawChain {

    Eur500WithdrawChain() {
      nomination = 500;
    }
  }

  private class Eur200WithdrawChain extends WithdrawChain {

    Eur200WithdrawChain() {
      nomination = 200;
    }
  }

  private class Eur100WithdrawChain extends WithdrawChain {

    Eur100WithdrawChain() {
      nomination = 100;
    }
  }

  private class Eur50WithdrawChain extends WithdrawChain {

    Eur50WithdrawChain() {
      nomination = 50;
    }
  }

  private class Eur20WithdrawChain extends WithdrawChain {

    Eur20WithdrawChain() {
      nomination = 20;
    }
  }

  private class Eur10WithdrawChain extends WithdrawChain {

    Eur10WithdrawChain() {
      nomination = 10;
    }
  }

  private class Eur5WithdrawChain extends WithdrawChain {

    Eur5WithdrawChain() {
      nomination = 5;
    }
  }
}
