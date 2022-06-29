import java.util.Scanner;
import java.lang.Math;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Alyssa's Hangman! To begin, choose a number to select your difficulty.");
    //selecting difficulty level
    System.out.println("1: Beginner, 2: Intermediate, 3: Expert - ");
    int numDifficulty = sc.nextInt();
    while (!validDifficulty(numDifficulty)){
      System.out.println("Please re-enter a valid difficulty level. 1: Beginner, 2: Intermediate, 3: Expert- ");
      numDifficulty = sc.nextInt();
    }
    wordSelector(numDifficulty);
  }
  //ensuring that entered difficulty level is valid (between 1-3)
  public static boolean validDifficulty(int num){
    if (num == 1 || num == 2 || num == 3) return true;
    return false;
  }
  //selecting a word based on selected difficulty 
  public static String wordSelector(int num){
    String word = "";
    int x = (int)Math.random()*9;
    //3 sets of 10 words in increasing difficulty 
    String[][] wordBank = {{"right", "toast", "craft", "fault", "cycle", "fossil", "float", "prince", "shout", "shelf" }, {"application", "continuous", "explicit", "aquarium", "entitlement", "momentum", "generation", "stimulation", "cylinder", "explosion"}, {"apparatus", "ostracize", "ambiguous", "revolutionary", "negligence", "spontaneous", "reservoir", "rehabilitation", "consensus", "conglomerate"}};
    if (num == 1){
      word = wordBank[0][x];
    }
    else if (num == 2){
      word = wordBank[1][x];
    }
    else{
      word = wordBank[2][x];
    }
    return word;
  }











  //when completed, add completed words method that stores all the previously done words => if same word is randomly selected, redo wordselector
}