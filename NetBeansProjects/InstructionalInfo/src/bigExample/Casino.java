package bigExample;
    
    
public class Casino {
    
    private int lowValue, midValue, midHighValue, highValue;
    private int lowPayout, midPayout, highPayout, midHighPayout, maxPayout;
    private final int maxValue = 100;
    
    // constructors
    public Casino(){
        lowValue = 35;
        midValue = 50;
        midHighValue = 67;
        highValue = 89;
      //maxValue = 100
        lowPayout = 50;
        midPayout = 100;
        midHighPayout = 153;
        highPayout = 1200;
        maxPayout = 5000;
    }
    public Casino(int newLowPayout, int newMidPayout, int newMidHighPayout, int newHighPayout, int newMaxPayout){
        lowValue = 35;
        midValue = 50;
        midHighValue = 67;
        highValue = 89;
      //maxValue = 100
        lowPayout = newLowPayout;
        midPayout = newMidPayout;
        midHighPayout = newMidHighPayout;
        highPayout = newHighPayout;
        maxPayout = newMaxPayout;
    }
    
    // getters
    public int getLowValue() {
        return lowValue;
    }

    public int getMidValue() {
        return midValue;
    }

    public int getMidHighValue() {
        return midHighValue;
    }

    public int getHighValue() {
        return highValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }

    public double getLowPayout() {
        return (double)lowPayout/100.0;
    }

    public double getMidPayout() {
        return (double)midPayout/100.0;
    }
    
    public double getMidHighPayout() {
        return (double)midHighPayout/100.0;
    }

    public double getHighPayout() {
        return (double)highPayout/100.0;
    }

    public double getMaxPayout() {
        return (double)maxPayout/100.0;
    }
    
}
