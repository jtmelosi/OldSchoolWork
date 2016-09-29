package CS150Programs;

import java.io.Serializable;

public class Gamer implements Serializable {

    private int[] statValues = new int[10];
    private String name;
    private int[] statPointValues = new int[10];

    private static final long serialVersionUID = 2035206522292292923L;

    // constructor
    public Gamer() {
        name = "";
        setStatPointValues();
    }

    // utility methods
    public int getTotalPoints() {
        statPointValues = new int[10];
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
        formattedName = String.format("%10s", name);
        String description = (": lvl " + getLevel() + ", points: ");
        formattedPoints = String.format("%,d", getTotalPoints());
        return (formattedName + "" + description + "" + formattedPoints);
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

}
