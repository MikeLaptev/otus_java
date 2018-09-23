package com.mlaptev.app.currencies;

public class Gbp implements BaseCurrency {

  private Gbp100WithdrawChain gbp100 = new Gbp100WithdrawChain();
  private Gbp50WithdrawChain gbp50 = new Gbp50WithdrawChain();
  private Gbp20WithdrawChain gbp20 = new Gbp20WithdrawChain();
  private Gbp10WithdrawChain gbp10 = new Gbp10WithdrawChain();
  private Gbp5WithdrawChain gbp5 = new Gbp5WithdrawChain();

  public Gbp() {
    // Build chain
    gbp100.setNextChain(gbp50);
    gbp50.setNextChain(gbp20);
    gbp20.setNextChain(gbp10);
    gbp10.setNextChain(gbp5);
  }

  @Override
  public boolean withdraw(Amount amount) {
    return gbp100.withdraw(amount);
  }

  private class Gbp100WithdrawChain extends WithdrawChain {

    Gbp100WithdrawChain() {
      nomination = 100;
    }
  }

  private class Gbp50WithdrawChain extends WithdrawChain {

    Gbp50WithdrawChain() {
      nomination = 50;
    }
  }

  private class Gbp20WithdrawChain extends WithdrawChain {

    Gbp20WithdrawChain() {
      nomination = 20;
    }
  }

  private class Gbp10WithdrawChain extends WithdrawChain {

    Gbp10WithdrawChain() {
      nomination = 10;
    }
  }

  private class Gbp5WithdrawChain extends WithdrawChain {

    Gbp5WithdrawChain() {
      nomination = 5;
    }
  }
}
