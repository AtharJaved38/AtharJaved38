package game;

import java.util.Random;

public class Words {
    private String[] randomwords = {"animals", "steady", "happiness", "indefinite", "extreme", "ceremony", "class",
            "java", "birthday", "rights", "beneath", "student" , "employee", "properties"};

    private String selectedword;
    private Random random = new Random();
    private char[] letters ;

    public Words()
    {
        selectedword = randomwords[random.nextInt(randomwords.length)];
        letters = new char[selectedword.length()];
    }

    public String toString() {

        StringBuilder word = new StringBuilder("");

        for (char letter: letters) {
            word.append((letter == '\0') ? '-' : letter);
            word.append(' ');
        }

        return word.toString();
    }

    public boolean guess( char letter){

        boolean guessRight = false;
        boolean flag = false;

        for (int i = 0; i < selectedword.length(); i++) {
            flag = false;
            if(letter == selectedword.charAt(i)){
                letters[i] = letter;
                flag = true;
                guessRight = true;
            }
        }

        if (!flag){
            System.out.println("Letter '"+ letter +"' is not present in the word.");
        }

        return guessRight;

    }

    public boolean guessSuccess() {

        for (char c : letters) {
            if (c == '\0'){
                return false;
            }
        }

        return true;
    }
}
