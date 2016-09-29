



package PlayTheGame;

import static java.lang.Integer.parseInt;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;





public class Action {
    
    private static final Random rand = new Random();
    private static final Scanner kb = new Scanner(System.in);

    public static int chosenAction;

    public static void chooseAction() {
        try {
            System.out.println(""); // type in what their options are
            chosenAction = parseInt(kb.nextLine());
            switch (chosenAction) {
                case 1:
                    // code
                    break;
                case 2:
                    // code
                    break;
                // add in other cases
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("That wasn't an acceptable input.");
        }
    }
}
