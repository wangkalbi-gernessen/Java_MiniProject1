package miniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Question {

    public Question() throws FileNotFoundException {

    }

    public static String readText() throws FileNotFoundException {
        try{
            File obj = new File("cities.txt") ;
            Scanner scan = new Scanner(obj);
            // Regarding ArrayList and Random I referred to following URL.
            // https://stackoverflow.com/questions/12028205/randomly-choose-a-word-from-a-text-file
            List<String> cities = new ArrayList<>();
            while(scan.hasNextLine()) {
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

    // first input
    public static void inputChar() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Here's the question.");
        String answer = readText();
        for(int i = 0; i <= answer.length() - 1; i++){
            System.out.print("_");
        }
        System.out.println("");
        System.out.print("Guess a letter: ");
        char alphabet = in.next().charAt(0);
        Checking letter = new Checking(alphabet, answer);
        letter.identical(letter.getLetter(alphabet), letter.getWord(answer));
    }
}