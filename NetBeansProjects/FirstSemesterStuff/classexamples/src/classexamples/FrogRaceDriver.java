package classexamples;

import java.util.Scanner;

public class FrogRaceDriver {

    public static void main(String[] args) {
        int raceDistance;
        Scanner keyboard = new Scanner(System.in);
        Frog f = new Frog();
        Frog g = new Frog();
        f.randomize();
        g.randomize();
        f.setName("Bull");
        g.setName("LeBron");
        System.out.print("Enter a race distance: ");
        raceDistance = keyboard.nextInt();
        System.out.println(f.toString());
        System.out.println(g.toString());
        do {
            f.goad();
            g.goad();
            System.out.println(f.getName() + ": " + f.getDistanceTravelled());
            System.out.println(g.getName() + ": " + g.getDistanceTravelled());
            System.out.println("");
        } while ((f.getDistanceTravelled() < raceDistance)
                && (g.getDistanceTravelled() < raceDistance));
    }
}