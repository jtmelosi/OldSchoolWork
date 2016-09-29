package SetTheGameUp;

import java.util.Scanner;

public class SetupPlayer {

    private static final Scanner kb = new Scanner(System.in);

    public static void setupPlayer() {
        System.out.println("So now to you, what would you like to be called?");
        String playerName = kb.nextLine();
        Player player = new Player(playerName);
        System.out.println("");
        System.out.println("Alright, " + playerName + ", let's start the game.\n");
    }
    
}
