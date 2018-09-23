package com.mlaptev.app.atm;

public class AtmCaretaker {

  private Object obj;

  public void save(Atm atm) {
    this.obj = atm.save();
  }

  public void undo(Atm atm) {
    atm.undo(this.obj);
  }
}
