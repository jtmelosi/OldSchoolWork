/*
 * Project1
 * author: Maria Scharth
 * date: February 12th, 2015
 * description: Solution for Project1
 */
package teststuff;

import java.util.Date;
import java.util.Scanner;

public class HelpingStuff {

    public static void main(String[] args) {

        //declare an object of type Scanner for user input
        Scanner keyboard = new Scanner(System.in);

        // Declare your variables
        String letter = "letter";
        String letters = "package";
        String cityOne = "Ankh-Morpork";
        String cityTwo = "StoLat";
        String CityThree = "Quirm";
        String CityFour = "Pseudopolis";

// Set up a Scanner to read from the keyboard
        Scanner input = new Scanner(System.in);

// Ask user what they are shipping today
        System.out.print("What are you shipping today?: ");

        //Accept the item from the user.
        letter = input.nextLine();

        System.out.print("Where are you shipping your item?: ");

        //Accept the destination from the user
        cityOne = input.nextLine();
        System.out.println("\n--------------------------------------------------------");

        //Date
        Date now = new Date();

        System.out.println(now);

        //Determine price
        double price = 0;
        // case "letter "
    }

    // side methods
    public static void capitalizationIgnore() {  // This requires a bit more work, and is kinda clunky,
        Scanner input = new Scanner(System.in); // so I suggest using what I have below.
        String chosenCity = input.nextLine();
        String specifiedCity = "EdWaRdsViLlE";

        if (chosenCity.equalsIgnoreCase(specifiedCity)) {
            System.out.println("They're equal!");
        } else {
            System.out.println("They're not equal!");
        }
    }

    public static void changeToLowercase() {
        Scanner input = new Scanner(System.in);
        String chosenCity = input.nextLine();
        chosenCity = chosenCity.toLowerCase();

        String specifiedCity = "edwardsville";

        if (chosenCity.equalsIgnoreCase(specifiedCity)) {
            System.out.println("They're equal!");
        } else {
            System.out.println("They're not equal!");
        }
    }

    public static void useSwitchCase() {
        Scanner input = new Scanner(System.in);
        String chosenCity = input.nextLine();
        chosenCity = chosenCity.toLowerCase();

        final String otherCity1 = "highland";
        final String otherCity2 = "marine";
        final String otherCity3 = "jerseyville";
        final String otherCity4 = "troy";

        switch (chosenCity) {
            case otherCity1:
                System.out.println("Yay for city 1!");
                break;
            case otherCity2:
                System.out.println("Yay for city 2!");
                break;
            case otherCity3:
                System.out.println("Yay for city 3!");
                break;
            case otherCity4:
                System.out.println("Yay for city 4!");
                break;
            default:
                System.out.println("Your stupidass didn't type out a correct city. Stupidass.");
                System.exit(0);
        }

    }
}
