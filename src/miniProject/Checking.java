package miniProject;
import java.io.FileNotFoundException;

import static miniProject.Question.*;

/**
 * @author Kazunobu Someya
 */
public class Checking {
    private char alphabet;
    private String word;


    public Checking(char alphabet, String word) {
        if (isValidAlphabet(alphabet)){
            setLetter(alphabet);
        }
        setWord(word);
    }

    public char getLetter(char alphabet) {
        return this.alphabet;
    }

    public void setLetter(char alphabet) {
        this.alphabet = alphabet;
    }

    private static boolean isValidAlphabet (char alphabet) {
        if ((alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z')) {
            return true;
        } else {
            throw new IllegalArgumentException("Must be one alphabet");
        }
    }

    public String getWord(String answer) {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void identical(char alphabet, String word) throws FileNotFoundException {
        boolean finished = true;
        int wrongCount = 0;
        String underBar = "";
        String alpha = "";
        for (int i = 0; i <= word.length() - 1; i++) {
            underBar += "_";
        }

//        while(!finished) {
            if (word.indexOf(alphabet) != -1) {


            } else {
                alpha += alphabet;
                System.out.println("You are guessing: ");
                wrongCount += 1;
                System.out.println("You have guessed (" + wrongCount + ") wrong letters: " + alpha);
                inputChar();
            }

//        }
    }

}
