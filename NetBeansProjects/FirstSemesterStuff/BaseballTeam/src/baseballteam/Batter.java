/* Jacob Melosi
 * 9/12/2014
 * Description: This program is to make code within 4 classes that shows stats of a baseball team.
 */

package baseballteam;

import java.util.Scanner;

public class Batter extends Player {
    
    // attribute list
    private int atBats, hits, homeRuns, rbi, stolenBases;

    public int getAtBats() {
        return atBats;
    }

    public int getHits() {
        return hits;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public int getRbi() {
        return rbi;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    
    // Constructor
    public Batter() {
        atBats = 0;
        hits = 0;
        homeRuns = 0;
        rbi = 0;
        stolenBases = 0;
    }
    
    // utility methods
    
        // loadData() must load values from the Scanner parameter in the same order as the attributes are in.
    @Override
    public void loadData(Scanner fin){
        super.loadData(fin);
        atBats = fin.nextInt();
        hits = fin.nextInt();
        homeRuns = fin.nextInt();
        rbi = fin.nextInt();
        stolenBases = fin.nextInt();
        fin.nextLine();
        }
    
        // generateDisplayString() must return a String that shows the player’s name, position,
        // four batting stats listed above like this: Name: Joe Schmough, Position: OF, Batting Average: 0.300, Home Runs: 2, RBI: 5, Stolen Bases: 1
    @Override
    public String generateDisplayString() {
        String formattedBattingAverage = String.format(", Batting Average: %.3f", calculateBattingAverage());
        String displayString = (super.generateDisplayString() + formattedBattingAverage + ", Home runs: "
                + homeRuns + ", RBI's " + rbi + ", Stolen Bases: " + stolenBases);
        return displayString;
    }
    
    public double calculateBattingAverage(){
        if (atBats==0){
            return 0;
        } else {
        double battingAverage = (double)hits/(double)atBats;
        return battingAverage;
        }
    }
    
}
