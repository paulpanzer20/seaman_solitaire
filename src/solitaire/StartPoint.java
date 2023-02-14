package solitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartPoint {

  static private int[] startingBoard = {1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2};
  static private int[] endingBoard = {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1,};

  static boolean foundIt = false;

  static solitaire.Blatt winningBlatt;
  static ArrayList<int[]> memory = new ArrayList<>();
  static Baumstruktur tree = new Baumstruktur();

  static void isEndingBoard(int[] board) {
    if (endingBoard.equals(board)) {
      foundIt = true;
    }
  }

  static ArrayList<Blatt> currentStage = new ArrayList<>();

  static void nextStage() {
    ArrayList<Blatt> oldStage = currentStage;
    currentStage = new ArrayList<>();
    System.out.println("länge: "+ oldStage.size());
    for (int x = 0; x < oldStage.size(); x++) {
      makeMovesOfBlatt(oldStage.get(x));
    }
  }

  static void newPlay(Blatt blatt, int[] feld) {
    if (!memoryHolds(feld)) {
      Blatt b = blatt.createChild(feld);
      isEndingBoard(feld);
      currentStage.add(b);
      memory.add(feld);
      if (foundIt) {
        winningBlatt = b;
      }
    }
  }



  static void makeMovesOfBlatt(Blatt blatt) {
    int index = getEmptyIndex(blatt.feld);
      int[][] fieldArray = new int[4][];
      fieldArray[0] = PlayingBoard.getNeighbouringIndexesEast(index);
      fieldArray[1] = PlayingBoard.getNeighbouringIndexesNord(index);
      fieldArray[2] = PlayingBoard.getNeighbouringIndexesWest(index);
      fieldArray[3] = PlayingBoard.getNeighbouringIndexesSouth(index);
      for (int i = 0; i < 4; i++) {
        for (int x = 0; x < fieldArray[i].length && !foundIt; x++) {
            int[] cloneFeld = blatt.feld.clone();
            System.out.println(i+"<> "+fieldArray[i][x]);
            cloneFeld[index] = cloneFeld[fieldArray[i][x]];
            cloneFeld[fieldArray[i][x]] = 0;
            newPlay(blatt, cloneFeld);
          }

      }


  }

  public static void main(String[] args) {
    int steps = 0;
    currentStage.add(tree.startingBlatt);
    while (!foundIt && steps < 60) {
      System.out.println(steps);
      steps++;
      nextStage();
    }
    if (foundIt) {
      Blatt blatt = winningBlatt;
      while (blatt.hasFather()) {
        System.out.println(blatt.feld);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }


  static boolean memoryHolds(int[] array) {
    for (int x = 0; x < memory.size(); x++) {
      if (Arrays.equals(array, memory.get(x))) {
        System.out.println("found it");

        return true;
      }
    }
    return false;
  }

  static public int getEmptyIndex(int[] board){
    for(int i = 0;i<board.length;i++){
      if(board[i]==0){
        return i;
      }
    }
    return -1;
  }
}






