package SetTheGameUp;

import static java.lang.Integer.parseInt;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DecideToLoad {
    
    private static final Scanner kb = new Scanner(System.in);
    private static boolean decidedToLoad;
    
    public static boolean decideToLoad(){
        System.out.println("Would you like to load progress from a previous game?\n"
                + "Type 1 to start a new game, or 2 to load previous progress.");
        
        int decision = 0;
        boolean finishedDeciding = false;
        
        do {
            try {
                decision = parseInt(kb.nextLine());
                if (!((decision >= 1) && (decision <= 2))) {
                    System.out.println("Please enter an acceptable number.");

                }
                if ((decision >= 1) && (decision <= 2)) {
                    finishedDeciding = true;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("That wasn't an acceptable input type.");
            }
        } while (finishedDeciding == false);
        
        if (decision == 1) {
            decidedToLoad = false;
        } else if (decision == 2) {
            decidedToLoad = true;
        }
        
        System.out.println("");
        
        return decidedToLoad;
    }
}
