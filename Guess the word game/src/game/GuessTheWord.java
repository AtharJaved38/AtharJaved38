package game;

import java.util.Scanner;

public class GuessTheWord {

    private boolean play = true;
    private Words randomword = new Words();
    private static Scanner sc = new Scanner(System.in);
    private int rounds = 3;
    private char lastround;

    public void start(){
       do {
            showWord();
            getInput();
            checkInput();
       }while (play);
   }

    private void showWord() {
        System.out.println("You have "+ rounds +" tries left.");
        System.out.println(randomword);
    }

     private void getInput() {
        System.out.println("Enter a letter to guess the word: ");
        String letter = sc.nextLine();
          lastround = letter.charAt(0);
    }

    private void checkInput() {

       boolean isGuessedRight = randomword.guess(lastround);

       if (isGuessedRight) {
           if (randomword.guessSuccess()) {
               System.out.println("Congrats! You won.");
               System.out.println("The word is " + randomword);
               play = false;
           }
       }
       else{
           rounds--;
           if (rounds == 0){
               System.out.println("You lose, Better luck next time. \nGame Over!");
               play = false;
           }
       }
    }
    public void end() {
        sc.close();
    }
}
