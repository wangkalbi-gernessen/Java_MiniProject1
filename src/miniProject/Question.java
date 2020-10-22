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

    public static void operateGame() throws FileNotFoundException {
        String answer = readText();
        Checking letter = new Checking(answer);
        letter.identical(answer);
    }
}