/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetTheGameUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author Jake
 */
public class LoadBattlerTeam {
    
    private static final Scanner kb = new Scanner(System.in);
    
    public static void setupAndLoadTeam(){
        System.out.println("What is the name of your save file (including the .dat)?");
        String fileName = kb.nextLine();
        readInBattlers(fileName);
        System.out.println("");
    }
    
    public static void readInBattlers(String nameOfFile) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(nameOfFile+""))) {
            while (true) {
//                System.out.println(input.readObject());
                SetupBattlers.ownTeamBattlers.add((Battlers.Battler) input.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("All battlers have been loaded.");
        }
    }
    
}
