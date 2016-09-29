/* Jacob Melosi
 * 7-16-2014
 * Description: The granary portion of project 6's code.
 */

package program6;

import java.awt.Color;
import java.awt.Graphics;

public class Granary {
    
    private String typeOfGrain;
    private int amountOfGrain;
    private int capacity;
    private String message;
    
    
    
    // constructor
    
     public Granary() {
        this.typeOfGrain = "Not set";
        this.amountOfGrain = 0;
        this.capacity = 0;
        this.message = "Not set";
    }
     
     
     
    // getters
     
    public String getTypeOfGrain() {
        return typeOfGrain;
    }
    
    public int getAmountOfGrain() {
        return amountOfGrain;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getMessage() {
        return message;
    }
    
    
    
    // setters
    
    public void setTypeOfGrain(String typeOfGrain) {
            this.typeOfGrain = typeOfGrain;
    }

    public void setAmountOfGrain(int amountOfGrain) {
        if ((amountOfGrain > 0) && (amountOfGrain < capacity)) {
            this.amountOfGrain = amountOfGrain;
        }
    }

    public void setCapacity(int capacity) {
        if (capacity > amountOfGrain) {
        this.capacity = capacity;
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    // utility & other
    
    public int addGrain (int grainToAdd){
        if (grainToAdd >= 0){
            amountOfGrain+= grainToAdd;
            if(amountOfGrain>capacity){
                int excessGrain;
                excessGrain = amountOfGrain - capacity;
                amountOfGrain = capacity;
                return excessGrain;
            }
        }
        return 0;
    }
    
    public int removeGrain (int grainToRemove){
        if (grainToRemove >= 0){
            amountOfGrain-= grainToRemove;
            if(amountOfGrain<0){
                int notAdded;
                notAdded = 0 - amountOfGrain;
                amountOfGrain = 0;
                return notAdded;
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "Granary{"+"typeOfGrain="+typeOfGrain +", grain="+amountOfGrain+", capacity="+capacity+"}";
    }
    
        public void draw(Graphics canvas){
        int percentOfCapacity;
        percentOfCapacity = (int)(((double)amountOfGrain)/capacity*300);
        canvas.setColor(Color.GRAY);
        canvas.fillRect(20, 40, 50, 300);
        canvas.setColor(Color.GREEN);
        canvas.fillRect(20, 40 + (300 - percentOfCapacity), 50, percentOfCapacity);
        canvas.setColor(Color.BLACK);
        canvas.drawRect(20, 40, 50, 300);
        canvas.drawString(toString(), 100, 60);
        canvas.drawString(getMessage(), 100, 40);
    }
}
