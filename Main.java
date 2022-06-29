import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    boolean play = true;
    Scanner sc = new Scanner(System.in);
    while (play){
      System.out.println("Welcome to Alyssa's Hangman! To begin, choose a number to select your difficulty.");
      //selecting difficulty level
      System.out.println("1: Beginner, 2: Intermediate, 3: Expert");
      int numDifficulty = sc.nextInt();
      while (!validDifficulty(numDifficulty)){
        System.out.println("Please re-enter a valid difficulty level. 1: Beginner, 2: Intermediate, 3: Expert");
        numDifficulty = sc.nextInt();
      }
      String goal = wordSelector(numDifficulty);
      String current = startWord(goal); 
      int wrongGuesses = 0; 
      //guessing the word 
      while (!won(goal, current) && wrongGuesses < 6){
        System.out.println("Word: " + current);
        System.out.println("Enter a letter: ");
        String guess = sc.next().toLowerCase();
        if (!containsLetter(goal, guess)){
          wrongGuesses++;
          System.out.println("The word does not contain the letter " + guess);
          System.out.println("Incorrect tries: " + wrongGuesses);
        }
        else{
          System.out.println("Good guess!");
          //filling in the word with correct guess
          for (int i = 0; i < goal.length(); i++){
            if (goal.substring(i, i+1).equals(guess)) current = current.substring(0,i) + guess + current.substring(i+1);
          }
        }
      }
      //congratulating and checking for replay
      if (won(goal, current) && wrongGuesses < 6){
        System.out.println("Great job you guessed the word correctly!! Would you like to play again?");
      }
      //revealing word and checking for replay if no more tries
      if (wrongGuesses == 6){
        System.out.println("Uh oh it seems that you have run out of tries. The word was " + goal.toUpperCase() + ". Good try though!! Would you like to play again?");
      }
      String tryAgain = sc.next().toLowerCase();
      if (tryAgain.equals("no")){
        System.out.println("See you next time :)");
        play = false;
        sc.close();
      }
    }
  }
  //ensuring that entered difficulty level is valid (between 1-3)
  public static boolean validDifficulty(int num){
    if (num == 1 || num == 2 || num == 3) return true;
    return false;
  }
  //selecting a word based on selected difficulty 
  public static String wordSelector(int num){
    String word = "";
    int x = (int)(Math.random()*10);
    //3 sets of 10 words in increasing difficulty 
    String[][] wordBank = {{"right", "roy", "toast", "craft", "fault", "cycle", "fossil", "float", "prince", "shout", "shelf" }, {"application", "continuous", "explicit", "aquarium", "entitlement", "momentum", "generation", "stimulation", "cylinder",   "explosion", "directory"}, {"apparatus", "ostracize", "ambiguous", "revolutionary", "negligence", "spontaneous", "reservoir", "rehabilitation", "consensus", "conglomerate", "troglodyte"}};
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
  //filling word with dashes to guess 
  public static String startWord(String str){
    String x = "";
    for (int i = 0; i < str.length(); i++){
      x += "-";
    }
    return x;
  }
  public static boolean won(String one, String two){
    if (two.equals(one)) return true;
    return false;
  }
  public static boolean containsLetter(String str, String letter){
    if (str.contains(letter)) return true;
    return false;
  }
}

  // when completed, add completed words method that stores all the previously
  // done words => if same word is randomly selected, redo wordselector