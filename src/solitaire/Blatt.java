package solitaire;

import java.util.ArrayList;

public class Blatt{
  int[] feld = new int[17];
  Blatt father;
  int childCount = 0;
  ArrayList<Blatt> children = new ArrayList<>();

  Blatt createChild(int[] feld){
    printFeld();
    childCount++;
    Blatt neuesBlatt = new Blatt();
    neuesBlatt.father = this;
    neuesBlatt.feld = feld;
    children.add(neuesBlatt);
    return neuesBlatt;
  }

  boolean hasFather(){
    if(father == null){
      return false;
    }
    return true;
  }


  void printFeld(){
    for(int x = 0; x < 17; x++){
      System.out.print(this.feld[x]+"\t");
      if(x == 5 ||x == 10 ||x == 13 ||x == 16||x == 2){
        System.out.print("\n");
      }
      if(x == 10 ||x == 13 ){
        System.out.print("\t\t");
      }

    }
  }
}
