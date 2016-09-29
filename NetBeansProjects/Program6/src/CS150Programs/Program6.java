/* Name: Jacob Melosi
 * Date: 11/18/2014
 * Class: CS150
 * Assignment: Program 6
 * Description: This program uploads Gamer objects and then outputs them
 * after various sorting procedures occur.
 */

package CS150Programs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program6 {

    private static List<Gamer> listOfGamers = new ArrayList();

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        readInGamers();

        System.out.println("Players read from file:");
        displayShortDescription();

        System.out.println("Players sorted by TotalPoints:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getTotalPoints() - g1.getTotalPoints());
        displayShortDescription();

        System.out.println("Players sorted by Name:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g1.getName().compareTo(g2.getName()));
        displayShortDescription();

        System.out.println("Players sorted by Health Points Restored:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getHealthPointsRestored() - g1.getHealthPointsRestored());
        displayToString();

        System.out.println("Players sorted by Areas Visited:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getAreasVisited() - g1.getAreasVisited());
        displayToString();

        System.out.println("Players sorted by Players Encountered:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getPlayersEncountered() - g1.getPlayersEncountered());
        displayToString();

        System.out.println("Players sorted by Maps Created:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getMapsCreated() - g1.getMapsCreated());
        displayToString();

        System.out.println("Players sorted by Items Gathered:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getItemsGathered() - g1.getItemsGathered());
        displayToString();

        System.out.println("Players sorted by Items Repaired:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getItemsRepaired() - g1.getItemsRepaired());
        displayToString();

        System.out.println("Players sorted by Items Merged:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getItemsMerged() - g1.getItemsMerged());
        displayToString();

        System.out.println("Players sorted by Top Scores:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getTopScores() - g1.getTopScores());
        displayToString();

        System.out.println("Players sorted by Damage Points Dealt:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getDamagePointsDealt() - g1.getDamagePointsDealt());
        displayToString();

        System.out.println("Players sorted by Maps Completed:");
        Collections.sort(listOfGamers, (Gamer g1, Gamer g2) -> g2.getMapsCompleted() - g1.getMapsCompleted());
        displayToString();
    }

    public static void readInGamers() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("gamers.dat"))) {
            while (true) {
//                System.out.println(input.readObject());
                listOfGamers.add((Gamer) input.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
        }
    }

    public static void displayShortDescription() {
        for (Gamer g : listOfGamers) {
            System.out.println(g.shortDescription());
        }
    }

    public static void displayToString() {
        for (Gamer g : listOfGamers) {
            System.out.println(g.toString());
        }
    }

}
