package com.mlaptev.app.currencies;

import com.mlaptev.app.exceptions.CannotWithdrawException;
import com.mlaptev.app.exceptions.InvalidBanknoteNominationException;
import com.mlaptev.app.exceptions.InvalidCassetteStateException;
import java.util.Map;

public interface BaseCurrency {

  Map<Integer, Integer> withdraw(int amount) throws CannotWithdrawException;

  void uploadBanknotes(Map<Integer, Integer> cassette)
      throws InvalidBanknoteNominationException, InvalidCassetteStateException;
}
