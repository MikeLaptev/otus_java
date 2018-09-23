package com.mlaptev.app.currencies;

abstract class WithdrawChain {

  private WithdrawChain chain;
  int nomination;

  void setNextChain(WithdrawChain nextChain) {
    chain = nextChain;
  }

  boolean withdraw(Amount amount) {
    if (amount.getAmount() >= nomination) {
      int reminder = amount.getAmount() % nomination;
      if (reminder != 0) {
        if (chain != null) {
          return chain.withdraw(new Amount(reminder));
        }
      } else {
        return true;
      }
    } else {
      if (chain != null) {
        return chain.withdraw(amount);
      }
    }

    return false;
  }
}
