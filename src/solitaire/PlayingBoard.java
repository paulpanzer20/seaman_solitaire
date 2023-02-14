package solitaire;

import java.util.ArrayList;

public class PlayingBoard {

  public static int[] getNeighbouringIndexesNord(int index){
    int x = index;
    int[] indexes = new int[0];

    while(x> 0 && x < 18 && x != 1 &&x != 2 &&x != 3 &&x != 10 &&x != 11 && indexes.length < 2){
      indexes = addToLIst(indexes, x);
      x -= 3;
    }
    return indexes;
  }

  public static int[] getNeighbouringIndexesEast(int index){
    int x = index;
    int[] indexes = new int[0];
    while(x> 0 && x < 18 && x != 3 &&x != 6 &&x != 11 &&x != 14 &&x != 17&& indexes.length < 2){
      indexes = addToLIst(indexes, x);
      x++;
    }
    return indexes;
  }

  public static int[] getNeighbouringIndexesSouth(int index){
    int x = index;
    int[] indexes = new int[0];
    while(x> 0 && x < 18 && x != 7 &&x != 8 &&x != 15 &&x != 16 &&x != 17 && indexes.length < 2){
      indexes = addToLIst(indexes, x);
      x += 3;
    }
    return indexes;
  }

  public static int[] getNeighbouringIndexesWest(int index){
    int x = index;
    int[] indexes = new int[0];
    while(x> 0 && x < 18 && x != 1 &&x != 4 &&x != 7 &&x != 12 &&x != 15 && indexes.length < 2){
      indexes = addToLIst(indexes, x);
      x--;
    }
    return indexes;
  }

  private static int[] addToLIst(int[] list, int index){
    int[] newList = new int[list.length+1];
    for(int a = 0; a < list.length; a++){
      newList[a] = list[a];
    }
    newList[list.length] =index;
    return newList;
  }

}
