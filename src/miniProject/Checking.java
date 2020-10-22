package miniProject;
import java.io.FileNotFoundException;
import java.util.*;
import static miniProject.Question.*;

/**
 * @author Kazunobu Someya
 */
public class Checking {
    private String word;

    public Checking(String word) {
        setWord(word);
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

    public void identical(String word) throws FileNotFoundException {
        int ansLength = word.length() - 1;
        String alpha = "";
        String underBar = "";
        for(int i = 0; i <= word.length() - 1; i++) {
            underBar += "_";
        }
        String[] underBars = underBar.split(",");
        List<String> al = new ArrayList<String>();
        al = Arrays.asList(underBars);

        Scanner in = new Scanner(System.in);
        System.out.println("Here's the question.");
        int wrongCount = 0;
        while(wrongCount <= 10) {

            System.out.print("Guess a letter: ");
            char alphabet = in.next().charAt(0);

            int num = word.indexOf(alphabet);
            for(int i = 0; i <= word.length() - 1; i++) {
                if (num != -1) {
                    al.set(num, alphabet);
                } else {
                    alpha += alphabet;
                    System.out.println("You are guessing: ");
                    wrongCount += 1;
                    System.out.println("You have guessed (" + wrongCount + ") wrong letters: " + alpha);
                }
            }
        }
    }

}
