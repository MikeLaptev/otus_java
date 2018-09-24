package com.mlaptev.app.atm;

import com.mlaptev.app.exceptions.InvalidBanknoteNominationException;
import com.mlaptev.app.exceptions.InvalidCassetteStateException;

public class AtmCaretaker {

  private Object obj;

  public void save(Atm atm) {
    this.obj = atm.save();
  }

  public void undo(Atm atm)
      throws InvalidCassetteStateException, InvalidBanknoteNominationException {
    atm.undo(this.obj);
  }
}
