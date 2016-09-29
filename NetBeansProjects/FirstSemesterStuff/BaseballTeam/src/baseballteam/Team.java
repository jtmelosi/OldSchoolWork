/* Jacob Melosi
 * 9/12/2014
 * Description: This program is to make code within 4 classes that shows stats of a baseball team.
 */
package baseballteam;

import java.util.Scanner;

public class Team {

    private static final int NUMBER_OF_PLAYERS = 25;

    // attribute list
    private Player[] roster = new Player[NUMBER_OF_PLAYERS];
    private String nameOfTeam;
    

    // action list
    // getter and setter for team name
    public String getNameOfTeam() {
        return this.nameOfTeam;
    }

    // utility methods
    public void loadTeam(Scanner fin) {

        for (int i = 0; i <= 9; i++) {
            roster[i] = new Pitcher();
        }
        for (int i = 10; i <= 19; i++) {
            roster[i] = new Batter();
        }

        for (int i = 20; i <= roster.length - 1; i++) {
            roster[i] = new Player();
        }

        nameOfTeam = fin.nextLine();

        for (int i = 0; i < roster.length; i++) {
            if (roster[i] instanceof Pitcher) {
                ((Pitcher) roster[i]).loadData(fin);
            } else if (roster[i] instanceof Batter) {
                ((Batter) roster[i]).loadData(fin);
            } else {
                ((Player) roster[i]).loadData(fin);
            }
        }
    }

    public void outputTeam(Scanner fin) {
        for (int i = 0; i < roster.length; i++){
            System.out.println(roster[i].generateDisplayString());
        }
        System.out.println("Team Wins: " + calculateTeamWins());
        System.out.println("Team Saves: " + calculateTeamSaves());
        System.out.println("Team ERA: " + calculateTeamERA());
        System.out.println("Team WHIP: " + calculateTeamWHIP());
        System.out.println("Team Batting Average: " + calculateTeamBattingAverage());
        System.out.println("Team Home Runs: " + calculateTeamHomeRuns());
        System.out.println("Team RBI: " + calculateTeamRBI());
        System.out.println("Team Stolen Bases: " + calculateTeamStolenBases());
        
    }
    
    public int calculateTeamWins() {
        int teamWins = 0;
        for (int i = 0; i <= 9; i++) {
            if (roster[i] instanceof Pitcher) {
                teamWins += ((Pitcher) roster[i]).getWins();
            }
        }
        return teamWins;
    }

    public int calculateTeamSaves() {
        int teamSaves = 0;
        for (int i = 0; i <= 9; i++) {
            if (roster[i] instanceof Pitcher) {
                teamSaves += ((Pitcher) roster[i]).getSaves();
            }
        }
        return teamSaves;
    }

    public double calculateTeamERA() {
        int teamERA = 0;
        for (int i = 0; i <= 9; i++) {
            if (roster[i] instanceof Pitcher) {
                teamERA += ((Pitcher) roster[i]).calculateERA();
            }
        }
        return teamERA/(double)10;
    }

    public double calculateTeamWHIP() {
        double teamWHIP = 0;
        for (int i = 0; i <= 9; i++) {
            if (roster[i] instanceof Pitcher) {
                teamWHIP += ((Pitcher) roster[i]).calculateWHIP();
            }
        }
        return teamWHIP/(double)10;
    }

    public double calculateTeamBattingAverage() {
        double teamBattingAverage = 0;
        for (int i = 10; i <= 19; i++) {
            if (roster[i] instanceof Batter) {
                teamBattingAverage += ((Batter) roster[i]).calculateBattingAverage();
            }
        }
        return teamBattingAverage/(double)10;
    }

    public int calculateTeamHomeRuns() {
        int teamHomeRuns = 0;
        for (int i = 10; i <= 19; i++) {
            if (roster[i] instanceof Batter) {
                teamHomeRuns += ((Batter) roster[i]).getHomeRuns();
            }
        }
        return teamHomeRuns;
    }

    public int calculateTeamRBI() {
        int teamRBI = 0;
        for (int i = 10; i <= 19; i++) {
            if (roster[i] instanceof Batter) {
                teamRBI += ((Batter) roster[i]).getRbi();
            }
        }
        return teamRBI;
    }

    public int calculateTeamStolenBases() {
        int teamStolenBases = 0;
        for (int i = 10; i <= 19; i++) {
            if (roster[i] instanceof Batter) {
                teamStolenBases += ((Batter) roster[i]).getStolenBases();
            }
        }
        return teamStolenBases;
    }
}
