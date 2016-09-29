/* Jacob Melosi
 * 9/12/2014
 * Description: This program is to make code within 4 classes that shows stats of a baseball team.
 */
package baseballteam;

import java.util.Scanner;

public class Pitcher extends Player {

    // attribute list
    private int wins, saves, inningsPitched, earnedRuns, hits, walks;

    public int getWins() {
        return wins;
    }

    public int getSaves() {
        return saves;
    }

    public int getInningsPitched() {
        return inningsPitched;
    }

    public int getEarnedRuns() {
        return earnedRuns;
    }

    public int getHits() {
        return hits;
    }

    public int getWalks() {
        return walks;
    }

    
    // action list
    // constructor
    public Pitcher() {
        wins = 0;
        saves = 0;
        inningsPitched = 0;
        earnedRuns = 0;
        hits = 0;
        walks = 0;
    }

    // utility methods
    // loadData() must load values from the Scanner parameter in the same order as the attributes are in.
    @Override
    public void loadData(Scanner fin) {
        super.loadData(fin);
        wins = fin.nextInt();
        saves = fin.nextInt();
        inningsPitched = fin.nextInt();
        earnedRuns = fin.nextInt();
        hits = fin.nextInt();
        walks = fin.nextInt();
        fin.nextLine();
    }

        // generateDisplayString() must return a String that shows the player’s name, position,
    // and the four pitching stats listed above like this: Name: Mary Hansen, Position: P, Wins: 2, Saves: 1, ERA: 2.57, WHIP: 0.714
    @Override
    public String generateDisplayString() {
        String formattedERA = String.format(", ERA: %.2f", calculateERA());
        String formattedWHIP = String.format(", WHIP: %.3f", calculateWHIP());
        String displayString = super.generateDisplayString() + ", Wins: " + wins + ", Saves: " + saves
                + formattedERA + formattedWHIP;
        return displayString;
    }

    public double calculateERA() {
        if (inningsPitched == 0){
            return 0;
        } else {
        double era = ((double)earnedRuns * 9) / (double)inningsPitched;
        return era;
        }
    }

    public double calculateWHIP() {
        if (inningsPitched == 0){
            return 0;
        } else {
        double whip = ((double)walks + hits) / (double)inningsPitched;
        return whip;
        }
    }

}
