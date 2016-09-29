/* Jacob Melosi
 * 7/8/2014
 * Program4 is about recreating the Monty Hall problem and simulating to figure
 * prove the truth behind what the best option is with a variable amount of
 * simulations that the user will determine.
 */

package program4;

import java.util.Random;
import java.util.Scanner;

public class Program4 {
    
    
    
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        
        int numberOfSims = getNumberOfSims(); // gets the number of sims
        int typeOfSim = getTypeOfSim(); // gets the sim type
        int totalWins = 0;
        int simResults;
        
        //starts the for loop until it reaches the # of sims
        for (int i = 1; i <= numberOfSims; i++) {
            
            simResults = runASim(typeOfSim); //runs the sim and gets the results
            
            
            totalWins = simResults + totalWins; //keeps track of the number of wins
        }
        
        
        int totalLosses = numberOfSims-totalWins;
        //prints out the results of the simulation
        System.out.println("\n"
                + "Results: \n"
                + "Times played: " + numberOfSims + "\n"
                + "Times won: " + totalWins + "\n"
                + "Times lost: " + totalLosses + "\n"
                + "Percentage of wins: " + (double)100*totalWins/numberOfSims + "%"
                );
        
    }
    
    public static int getNumberOfSims() {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        
        int numberOfSims;
        do {
        System.out.print("How many sims do you want to run? ");
        numberOfSims = kb.nextInt();
        if (numberOfSims<1){
            System.out.println("The number must be positive.");
        }
        } while(numberOfSims <= 0);
        System.out.println("The simulation will run " + numberOfSims + " times.");
        return numberOfSims;}
    
    public static int getTypeOfSim() {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        
        int typeOfSim;
        do{
        System.out.print("Enter a 1 for switching doors, or 2 for keeping original door: ");
        typeOfSim = kb.nextInt();
        } while(typeOfSim != 1 && typeOfSim != 2);
        
        
    return typeOfSim;}
    
    public static int runASim(int typeOfSim) {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        
        int result;
        int chosenDoor = rand.nextInt(3)+1;
        int finalDoor;
        int correctDoor = rand.nextInt(3)+1;
        int revealedDoor;
        
        
        
        
        //decides which door to reveal
        if (correctDoor != 1 && chosenDoor !=1){
            revealedDoor = 1;
        }
        else if (correctDoor != 2 && chosenDoor !=2){
            revealedDoor = 2;
        }
        else {
            revealedDoor = 3;
        }
        
        
        //decides on final door
        if (typeOfSim == 2){
            finalDoor = chosenDoor;
        }
        else {
            if (chosenDoor != 1 && revealedDoor !=1){
                finalDoor = 1;
            }
            else if (chosenDoor != 2 && revealedDoor !=2){
                finalDoor = 2;
            }
            else {
                finalDoor = 3;
            }
        }
        
        
        //marks if the simulation was a win or loss
        if (finalDoor == correctDoor) {
            result = 1;
        }
        else {
            result = 0;
        }
        
        
        //tells which door was which and includes the final chosen door
        //as well if the type of sim was to swap doors.
        //this also mentions if the player wins or loses.
        if (typeOfSim == 2){
            System.out.print("Prize door = " + correctDoor + " Chosen door = " + chosenDoor + " Revealed door = " + revealedDoor + " : ");
            if (result == 1){
                System.out.println("player wins.");
            }
            else {
                System.out.println("player loses.");
            }
        }
        else{
            System.out.print("Prize door = " + correctDoor + " Chosen door = " + chosenDoor + " Revealed door = " + revealedDoor + " Final chosen door = " + finalDoor + " : ");
            if (result == 1){
                System.out.println("player wins.");
            }
            else {
                System.out.println("player loses.");
            }
        }
        
    return result;}
}

