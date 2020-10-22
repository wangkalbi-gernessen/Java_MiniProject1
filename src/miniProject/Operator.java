package miniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Kazunobu Someya
 */
public class Operator {

    /**
     * Constructor (default)
     * @throws FileNotFoundException
     */
    public Operator() throws FileNotFoundException {

    }

    /**
     *
     * @return
     * @throws FileNotFoundException
     * Read cities on cities.txt
     */
    public static String readText() throws FileNotFoundException {
        try{
            File obj = new File("cities.txt") ;
            Scanner scan = new Scanner(obj);
            // Regarding ArrayList and Random I referred to following URL.
            // https://stackoverflow.com/questions/12028205/randomly-choose-a-word-from-a-text-file
            List<String> cities = new ArrayList<>();
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                cities.add(data);
            }
            Random ranWord = new Random();
            String answer = cities.get(ranWord.nextInt(cities.size()));
            return answer;
        } catch (FileNotFoundException e) {
            System.out.println("A file cannot be found.");
            e.getStackTrace();
        }
        return null;
    }

    /**
     * Operate hangman game here
     * @throws FileNotFoundException
     */
    public static void operateGame() throws FileNotFoundException {
        String city = readText();
        Checking letter = new Checking(city);
        letter.identical(letter.getCity());
    }
}