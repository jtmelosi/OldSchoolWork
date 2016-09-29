package classexamples;

import java.util.Random;

public class Frog {

    // attribute list:
    private int hoppingDice; // should always be between 1 and 4
    private String name;
    private int length;  // should always be between 4 and 8
    private String printChar; // character printed when the frog is drawn
    private int distanceTravelled; // should never be negative
    private double jumpiness; // should always be between 0.0 and 1.0

    // action list:
    // constructor:
    public Frog() {
        name = "";
        hoppingDice = 2;
        length = 6;
        printChar = "O";
        distanceTravelled = 0;
        jumpiness = 0.5;
    }

    // accessors/getters
    public int getHoppingDice() {
        return hoppingDice;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getPrintChar() {
        return printChar;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getJumpiness() {
        return jumpiness;
    }

    // mutators/setters
    public void setHoppingDice(int newHoppingDice) {
        if ((newHoppingDice >= 1) && (newHoppingDice <= 4)) {
            hoppingDice = newHoppingDice;
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setLength(int newLength) {
        if ((newLength >= 4) && (newLength <= 8)) {
            length = newLength;
        }
    }

    public void setPrintChar(String newPrintChar) {
        printChar = newPrintChar;
    }

    public void setDistanceTravelled(int newDistanceTravelled) {
        if (newDistanceTravelled >= 0) {
            distanceTravelled = newDistanceTravelled;
        }
    }

    public void setJumpiness(double newJumpiness) {
        if ((newJumpiness >= 0.0) && (newJumpiness <= 1.0)) {
            jumpiness = newJumpiness;
        }
    }
    
    // utility methods:
    //jump
    public int jump() {
        int distance = 0;
        Random rand = new Random();
        for (int i = 1; i <= hoppingDice; i++) {
            distance += rand.nextInt(6) + 1;
        }
        distanceTravelled += distance;
        return distance;
    }
    
    //goad
    public int goad() {
       if(Math.random() <= jumpiness) {
           return jump();
       }
       return 0;
    }
    
    //randomize 
    public void randomize() {
        Random rand = new Random();
        jumpiness = Math.random();
        hoppingDice = rand.nextInt(4) + 1;
        length = rand.nextInt(5) + 4;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Frog{" + "hoppingDice=" + hoppingDice + ", name=" + name + ", length=" + length + ", printChar=" + printChar + ", distanceTravelled=" + distanceTravelled + ", jumpiness=" + jumpiness + '}';
    }
    
}