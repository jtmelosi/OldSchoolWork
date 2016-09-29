/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetTheGameUp;

import static SetTheGameUp.LoadBattlerTeam.readInBattlers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Save {

    private static final Scanner kb = new Scanner(System.in);
    
    public static void saveGame(){
        setupAndSaveTeam();
        setupAndSavePlayer();
    }

    public static void setupAndSaveTeam() {
        System.out.println("What would you like the name of your saved battlers file to be?"); // unsure about the .dat
        String fileName = kb.nextLine();
        saveBattlers(fileName);
        System.out.println("");
    }

    public static void saveBattlers(String nameOfFile) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nameOfFile + ""))) {
            for (Battlers.Battler battler : SetupBattlers.ownTeamBattlers) {
                output.writeObject(battler);
            }
            System.out.println("All battlers have been saved.");
        } catch (Exception e) {
            System.out.println("Something messed up while saving battlers.");
        }
    }

    public static void setupAndSavePlayer() {
        System.out.println("The name of your saved player file will be your current player name.");
        String fileName = Player.getName();
        saveBattlers(fileName);
        System.out.println("");
    }

    public static void savePlayer(String nameOfFile) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nameOfFile + ""))) {
            while (true) {
                for (Battlers.Battler battler : SetupBattlers.ownTeamBattlers) {
                    output.writeObject(battler);
                }
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

}
