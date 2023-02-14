package solitaire;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SeemannsSolitaer {

  private byte[] board = {1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,2,2};
  /*Stell dir einen Vektor vor, der in der oberen linken Ecke(Nordwesten) des Spiels beginnt zu zaehlen.
  Beispiel: (1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,2,2) --> Das ist die Ausgangssituation. Hierbei steht
  eine 1 für einen weissen Stein, 0 für die leere Stelle und 2 für shcwarze Steine.
   */
  private LinkedHashSet<byte[]> memory = new LinkedHashSet<>();
  /*
  Diese Liste soll bereits besuchte Zustände speichern und ist unverzichtbar für die Duplikateliminierung.
   */

  public LinkedHashSet<byte[]> getAvailableMoves(){
    LinkedHashSet<byte[]> result = new LinkedHashSet<>();
    //Finde Index der leeren Stelle
    int indexEmptySpace = this.getEmptyIndex();
    //Probiere eine Position in Osten und Westen
    result.add(tryMove(indexEmptySpace,indexEmptySpace+1));
    result.add(tryMove(indexEmptySpace,indexEmptySpace-1));
    //Probiere zwei Positionen in Osten und Westen
    result.add(tryMove(indexEmptySpace,indexEmptySpace+2));
    result.add(tryMove(indexEmptySpace,indexEmptySpace-2));
    //Probiere eine Position in Norden und Süden
    result.add(tryMove(indexEmptySpace,indexEmptySpace+3));
    result.add(tryMove(indexEmptySpace,indexEmptySpace-3));
    //Probiere zwei Positionen in Norden oder Süden
    result.add(tryMove(indexEmptySpace,indexEmptySpace+6));
    result.add(tryMove(indexEmptySpace,indexEmptySpace-6));
    return result;
  }

  public byte[] tryMove(int empty,int toMove){
    //empty gibt Index der leeren Stelle an die der andere bewegt werden soll
    byte[] result = this.board;
    if(toMove>-1 && toMove<17) {
      byte stein = result[toMove];
      result[toMove] = 0;
      result[empty] = stein;
    }
    return result;
  }

  public int getEmptyIndex(){
    for(int i = 0;i<board.length;i++){
      if(board[i]==0){
        return i;
      }
    }
    return -1;
  }
}
