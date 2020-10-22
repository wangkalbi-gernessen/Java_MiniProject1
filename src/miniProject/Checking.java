package miniProject;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Kazunobu Someya
 */
public class Checking {
    private String city;

    /**
     * Constructor
     * @param city
     */
    public Checking(String city) {
        setCity(city);
    }

    /**
     * Check if input character is an alphabet
     * @param alphabet
     * @return
     */
    private static boolean isValidAlphabet (char alphabet) {
        if ((alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z')) {
            return true;
        } else {
            System.out.println("Must be one alphabet");
            return false;
        }
    }
    /**
     * Get city variable of this class
     * @return
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Set city variable of this class
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Check if input char is included in a sequence of city
     * Finish game when player made mistakes ten times
     * @param city
     * @throws FileNotFoundException
     */
    public void identical(String city) throws FileNotFoundException {
        String alpha = "";
        String underBar = "";
        for (int i = 0; i <= city.length() - 1; i++) {
            underBar += "_";
        }
        String[] underBars = underBar.split("");
        List<String> al = new ArrayList<String>();
        al = Arrays.asList(underBars);
        Scanner in = new Scanner(System.in);
        System.out.println("Here's the question.");
        System.out.println(underBar);
        int wrongCount = 0;
        while (wrongCount <= 10) {
            System.out.print("Guess a letter: ");
            char alphabet = in.next().charAt(0);
            if (isValidAlphabet(alphabet)) {
                int num = city.indexOf(alphabet);
                if (num != -1) {
                    /**
                     * I referred to following URL regarding repeated character
                     * https://stackoverflow.com/questions/22589911/how-to-deal-with-repeated-letters-in-a-java-hangman-game/22590179#22590179
                     */
                    while (num >= 0) {
                        /**
                         * Thanks to Takayuki I could come up with following casting
                         */
                        al.set(num, String.valueOf(alphabet));
                        num = city.indexOf(alphabet, num + 1);
                    }
                    String str = "";
                    for (String s : al) {
                        str += s;
                    }
                    System.out.println("You are guessing: " + str);
                } else {
                    alpha += alphabet + " ";
                    String str = "";
                    for (String s : al) {
                        str += s;
                    }
                    System.out.println("You are guessing: " + str);
                    wrongCount += 1;
                    System.out.println("You have guessed (" + wrongCount + ") wrong letters: " + alpha);
                }
            }
            if (!al.contains("_")) {
                System.out.println("You win!");
                System.out.println("You have guessed '" + city + "' correctly");
                break;
            }
            if (wrongCount == 10) {
                String mistake = "";
                for (int i = 1; i <= 10; i++) {
                    mistake += "X ";
                }
                System.out.println("You have guessed (" + wrongCount + ") wrong letters: " + mistake);
                System.out.println("You lose!");
                System.out.println("The correct word was '" + city + "'!");
                break;
            }
        }
    }
}
