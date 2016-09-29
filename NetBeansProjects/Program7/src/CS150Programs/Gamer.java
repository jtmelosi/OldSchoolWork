package CS150Programs;

public class Gamer {
    
    private final int NUMBER_OF_STATS = 10;
    private final int NUMBER_OF_BADGES = 5;
    
    private int[] statValues = new int[NUMBER_OF_STATS];
    private String name;
    private int[] statPointValues = new int[NUMBER_OF_STATS];

    // new stuff
    private String[] statNames = new String[NUMBER_OF_STATS];
    private String[] badgeNames = new String[NUMBER_OF_STATS];
    private int[][] badgeValues = new int[NUMBER_OF_STATS][NUMBER_OF_BADGES];

    // constructor
    public Gamer(String newName) {
        name = newName;
        setStatPointValues();
        setStatAndBadgeNames();
        setBadgeValues();
    }

    // utility methods
    public int getTotalPoints() {
        statPointValues = new int[NUMBER_OF_STATS];
        setStatPointValues();
        int totalPoints = 0;
        for (int i = 0; i < statValues.length; i++) {
            totalPoints += statValues[i] * statPointValues[i];
        }
        return totalPoints;
    }

    public int getLevel() {
        int level = 1;
        int pointsAcquired = getTotalPoints();
        if (pointsAcquired >= 35000000) {
            level = 12;
        } else if (pointsAcquired >= 20000000) {
            level = 11;
        } else if (pointsAcquired >= 10000000) {
            level = 10;
        } else if (pointsAcquired >= 4500000) {
            level = 9;
        } else if (pointsAcquired >= 2200000) {
            level = 8;
        } else if (pointsAcquired >= 1000000) {
            level = 7;
        } else if (pointsAcquired >= 300000) {
            level = 6;
        } else if (pointsAcquired >= 150000) {
            level = 5;
        } else if (pointsAcquired >= 80000) {
            level = 4;
        } else if (pointsAcquired >= 25000) {
            level = 3;
        } else if (pointsAcquired >= 10000) {
            level = 2;
        }
        return level;
    }

    @Override
    public String toString() {
        String theToString = "Gamer{name=" + name + ", statValues: Health Points Restored="
                + getHealthPointsRestored() + " Areas Visited=" + getAreasVisited() + " Players Encountered="
                + getPlayersEncountered() + " Maps Created=" + getMapsCreated() + " Items Gathered="
                + getItemsGathered() + " Items Repaired=" + getItemsRepaired() + " Items Merged="
                + getItemsMerged() + " Top Scores=" + getTopScores() + " Damage Points Dealt="
                + getDamagePointsDealt() + " Maps Completed=" + getMapsCompleted() + " }";

        return theToString;
    }

    public String shortDescription() {

        String formattedName;
        String formattedPoints;
        formattedName = String.format("%14s", name);
        String description = (": lvl " + getLevel() + ", points: ");
        formattedPoints = String.format("%,10d", getTotalPoints());
        return (formattedName + "" + description + "" + formattedPoints + " ");
    }

    private void setStatPointValues() {
        statPointValues[0] = 23;
        statPointValues[1] = 200;
        statPointValues[2] = 175;
        statPointValues[3] = 1500;
        statPointValues[4] = 20;
        statPointValues[5] = 100;
        statPointValues[6] = 125;
        statPointValues[7] = 250;
        statPointValues[8] = 17;
        statPointValues[9] = 750;
    }

    // stat & name getters
    public String getName() {
        return name;
    }

    public int getHealthPointsRestored() {
        return statValues[0];
    }

    public int getAreasVisited() {
        return statValues[1];
    }

    public int getPlayersEncountered() {
        return statValues[2];
    }

    public int getMapsCreated() {
        return statValues[3];
    }

    public int getItemsGathered() {
        return statValues[4];

    }

    public int getItemsRepaired() {
        return statValues[5];
    }

    public int getItemsMerged() {
        return statValues[6];
    }

    public int getTopScores() {
        return statValues[7];
    }

    public int getDamagePointsDealt() {
        return statValues[8];
    }

    public int getMapsCompleted() {
        return statValues[9];
    }

    // stat & name setters
    public void setName(String newName) {
        name = newName;
    }

    public void setHealthPointsRestored(int newHealthPointsRestored) {
        statValues[0] = newHealthPointsRestored;
    }

    public void setAreasVisited(int newAreasVisited) {
        statValues[1] = newAreasVisited;
    }

    public void setPlayersEncountered(int newPlayersEncountered) {
        statValues[2] = newPlayersEncountered;
    }

    public void setMapsCreated(int newMapsCreated) {
        statValues[3] = newMapsCreated;
    }

    public void setItemsGathered(int newItemsGathered) {
        statValues[4] = newItemsGathered;
    }

    public void setItemsRepaired(int newItemsRepaired) {
        statValues[5] = newItemsRepaired;
    }

    public void setItemsMerged(int newItemsMerged) {
        statValues[6] = newItemsMerged;
    }

    public void setTopScores(int newTopScores) {
        statValues[7] = newTopScores;
    }

    public void setDamagePointsDealt(int newDamagePointsDealt) {
        statValues[8] = newDamagePointsDealt;
    }

    public void setMapsCompleted(int newMapsCompleted) {
        statValues[9] = newMapsCompleted;
    }

    // new methods
    public void setStatAndBadgeNames() {
        statNames[0] = "Health Points Restored";
        statNames[1] = "Areas Visited";
        statNames[2] = "Players Encountered";
        statNames[3] = "Creating New Map";
        statNames[4] = "Items Gathered";
        statNames[5] = "Items Repaired";
        statNames[6] = "Items Merged";
        statNames[7] = "Top Scores";
        statNames[8] = "Damage Points Dealt";
        statNames[9] = "Maps Completed";

        badgeNames[0] = "Healer";
        badgeNames[1] = "Explorer";
        badgeNames[2] = "Socialite";
        badgeNames[3] = "Contributor";
        badgeNames[4] = "Hoarder";
        badgeNames[5] = "Fixer";
        badgeNames[6] = "Joiner";
        badgeNames[7] = "Leader";
        badgeNames[8] = "Punisher";
        badgeNames[9] = "Obsessed";
    }

    public void setBadgeValues() { // [10][5] dimensions
        badgeValues[0][0] = 2000;
        badgeValues[1][0] = 50;
        badgeValues[2][0] = 100;
        badgeValues[3][0] = 3;
        badgeValues[4][0] = 2000;
        badgeValues[5][0] = 100;
        badgeValues[6][0] = 100;
        badgeValues[7][0] = 20;
        badgeValues[8][0] = 2000;
        badgeValues[9][0] = 10;

        badgeValues[0][1] = 10000;
        badgeValues[1][1] = 1000;
        badgeValues[2][1] = 1000;
        badgeValues[3][1] = 10;
        badgeValues[4][1] = 10000;
        badgeValues[5][1] = 1000;
        badgeValues[6][1] = 500;
        badgeValues[7][1] = 200;
        badgeValues[8][1] = 10000;
        badgeValues[9][1] = 50;

        badgeValues[0][2] = 30000;
        badgeValues[1][2] = 5000;
        badgeValues[2][2] = 2000;
        badgeValues[3][2] = 20;
        badgeValues[4][2] = 30000;
        badgeValues[5][2] = 5000;
        badgeValues[6][2] = 2000;
        badgeValues[7][2] = 1000;
        badgeValues[8][2] = 30000;
        badgeValues[9][2] = 200;

        badgeValues[0][3] = 100000;
        badgeValues[1][3] = 17000;
        badgeValues[2][3] = 10000;
        badgeValues[3][3] = 90;
        badgeValues[4][3] = 100000;
        badgeValues[5][3] = 15000;
        badgeValues[6][3] = 10000;
        badgeValues[7][3] = 5000;
        badgeValues[8][3] = 100000;
        badgeValues[9][3] = 500;

        badgeValues[0][4] = 200000;
        badgeValues[1][4] = 40000;
        badgeValues[2][4] = 30000;
        badgeValues[3][4] = 150;
        badgeValues[4][4] = 200000;
        badgeValues[5][4] = 40000;
        badgeValues[6][4] = 40000;
        badgeValues[7][4] = 20000;
        badgeValues[8][4] = 300000;
        badgeValues[9][4] = 5000;
    }

    public String statsString() {
        String stringToReturn = "\n         Stats: Health Points Restored=" + statValues[0] + " Areas Visited=" + statValues[1]
                + " Players Encountered=" + statValues[2] + " Maps Created=" + statValues[3] + " Items Gathered=" + statValues[4]
                + "\n                Items Repaired=" + statValues[5] + " Items Merged=" + statValues[6] + " Top Scores=" + statValues[7]
                + " Damage Points Dealt=" + statValues[8] + " Maps Completed=" + statValues[9] + "\n        ";

        return stringToReturn;
    }

    public String getBadge(int index) {
        if (statValues[index] >= badgeValues[index][4]) {
            return (badgeNames[index] + ":Platinum ");
        } else if (statValues[index] >= badgeValues[index][3]) {
            return (badgeNames[index] + ":Gold ");
        } else if (statValues[index] >= badgeValues[index][2]) {
            return (badgeNames[index] + ":Silver ");
        } else if (statValues[index] >= badgeValues[index][1]) {
            return (badgeNames[index] + ":Bronze ");
        } else if (statValues[index] >= badgeValues[index][0]) {
            return (badgeNames[index] + ":Tin ");
        } else {
            return (badgeNames[index] + ":none "); 
        }
    }

    public String getBadges() {
        String stringToReturn = "Badges: ";
        for(int i = 0; i < NUMBER_OF_STATS; i++){
            stringToReturn += ("" + getBadge(i));
            if(i==4){
                stringToReturn += "\n                ";
            }
        }
//        stringToReturn += "\n";
        return stringToReturn;
    }

    public void doRandomAction(int whichAction) {
        statValues[whichAction]++;
    }
    
    public String getOutputString(){
        String outputString = (shortDescription()+statsString()+getBadges()+"");
        return outputString;
    }

}
