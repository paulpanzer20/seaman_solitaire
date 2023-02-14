package solitaire;

import solitaire.Blatt;

public class Baumstruktur {
  private int[] board = {1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,2,2};
  Blatt startingBlatt = new Blatt();

  public Baumstruktur(){
    startingBlatt.feld = board;
  }

  public Blatt getRoot(){
    return this.startingBlatt;
  }
}


