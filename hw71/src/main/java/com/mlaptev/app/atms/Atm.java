package com.mlaptev.app.atms;

import com.mlaptev.app.currencies.Amount;
import com.mlaptev.app.currencies.BaseCurrency;
import com.mlaptev.app.currencies.CurrencyType;
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

  public boolean isCurrencySupported(CurrencyType currencyType) {
    return acceptedCurrencies.containsKey(currencyType);
  }

  public boolean isItPossibleToWithdraw(CurrencyType currencyType, int amount) {
    if (!isCurrencySupported(currencyType)) {
      return false;
    }

    return acceptedCurrencies.get(currencyType).withdraw(new Amount(amount));
  }
}
