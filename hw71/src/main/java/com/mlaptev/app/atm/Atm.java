package com.mlaptev.app.atm;

import com.mlaptev.app.currencies.BaseCurrency;
import com.mlaptev.app.currencies.CurrencyType;
import com.mlaptev.app.exceptions.CannotWithdrawException;
import com.mlaptev.app.exceptions.CurrencyNotSupportedException;
import com.mlaptev.app.exceptions.InvalidBanknoteNominationException;
import com.mlaptev.app.exceptions.InvalidCassetteStateException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Atm {

  private static final Logger logger = LogManager.getLogger(Atm.class);

  private Map<CurrencyType, BaseCurrency> acceptedCurrencies = new HashMap<>();

  public void addSupportOfCurrencyType(CurrencyType type)
      throws Exception {
    logger.info("Adding support of currency {}", type.name());
    acceptedCurrencies.put(type, (BaseCurrency) type.getCurrency().getConstructor().newInstance());
  }

  public boolean isCurrencySupported(CurrencyType type) {
    return acceptedCurrencies.containsKey(type);
  }

  public Map<Integer, Integer> withdraw(CurrencyType type, int amount)
      throws CurrencyNotSupportedException, CannotWithdrawException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      return acceptedCurrencies.get(type).withdraw(amount);
    } catch (CannotWithdrawException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  public void loadCassette(CurrencyType type, Map<Integer, Integer> cassette)
      throws CurrencyNotSupportedException, InvalidBanknoteNominationException, InvalidCassetteStateException {
    if (!isCurrencySupported(type)) {
      throw new CurrencyNotSupportedException(
          String.format("Currency %s is not supported by ATM", type.name()));
    }

    AtmCaretaker caretaker = new AtmCaretaker();
    try {
      caretaker.save(this);
      acceptedCurrencies.get(type).uploadBanknotes(cassette);
    }
    catch (InvalidBanknoteNominationException | InvalidCassetteStateException e) {
      caretaker.undo(this);
      throw e;
    }
  }

  public AtmMomento save() {
    // TODO(mlaptev): Implementation is required
    return null;
  }

  public void undo(Object obj) {
    AtmMomento momento = (AtmMomento) obj;
    // TODO(mlaptev): Implementation is required
  }

  private class AtmMomento {
    // TODO(mlaptev): Implementation is required
  }
}
