package miniProject;
import java.io.FileNotFoundException;

/**
 * @author Kazunobu Someya
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Operator game = new Operator();
        game.operateGame();
    }
}
