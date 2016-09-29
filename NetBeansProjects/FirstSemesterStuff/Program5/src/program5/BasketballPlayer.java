/* Jacob Melosi
 * 7-16-2014
 * Description: Basketball player class that is called from the program 5 class.
 */
package program5;


public class BasketballPlayer {
    
    // attribute list:
    private String name; 
    private int shotsAttempted;
    private int shotsMade;  
    private int threePointersAttempted; 
    private int threePointersMade; 
    private int freeThrowsAttempted; 
    private int freeThrowsMade; 
    
    
    // action list:
    // constructor:
    public BasketballPlayer() {
        name = "";
        shotsAttempted = 0;
        shotsMade = 0;
        threePointersAttempted = 0;
        threePointersMade = 0;
        freeThrowsAttempted = 0;
        freeThrowsMade = 0;
    }
    
    
    // accessors/getters
    public String getName() {
        return name;
    }
    
    public int getShotsAttempted() {
        return shotsAttempted;
    }
    
    public int getShotsMade() {
        return shotsMade;
    }
    
    public int threePointersAttempted() {
        return threePointersAttempted;
    }
    
    public int threePointersMade() {
        return threePointersMade;
    }
    
    public int freeThrowsAttempted() {
        return freeThrowsAttempted;
    }
    
    public int freeThrowsMade() {
        return freeThrowsMade;
    }
    
    
    // mutators/setters
    public void setName(String newName) {
        name = newName;
    }
    
    
    // utility methods:
    // main attribute alterations
    public void addMissedShot() {
        ++shotsAttempted;
    }
    
    public void addMadeShot() {
        ++shotsMade;
        ++shotsAttempted;
    }
    
    public void addMissedThreePointer() {
        ++threePointersAttempted;
        ++shotsAttempted;
    }
    
    public void addMadeThreePointer() {
        ++threePointersMade;
        ++threePointersAttempted;
        ++shotsMade;
        ++shotsAttempted;
    }
    
    public void addMissedFreeThrow() {
        ++freeThrowsAttempted;
        
    }
    
    public void addMadeFreeThrow() {
        ++freeThrowsMade;
        ++freeThrowsAttempted;
    }
    
    // percentages
    public double shootingPercentage() {
        if(shotsAttempted==0){
            return 0;}
        double shootingPercentage = (((double)shotsMade/shotsAttempted)*100);
        return  shootingPercentage;
    }
    
    public double threePointPercentage() {
        if(threePointersAttempted==0){
            return 0;}
        double threePointPercentage = (((double)threePointersMade/threePointersAttempted)*100);
        return threePointPercentage;
    }
    
    public double freeThrowPercentage() {
        if(freeThrowsAttempted==0){
            return 0;}
        double freeThrowPercentage = (((double)freeThrowsMade/freeThrowsAttempted)*100);
        return freeThrowPercentage;
    }
    
    
    // other
    public int totalPointsScored() {
        int totalPointsScored;
        totalPointsScored = ((shotsMade-threePointersMade)*2)+(threePointersMade*3)+(freeThrowsMade);
        return totalPointsScored;
    }
    
    public void clearStats() {
        shotsAttempted = 0;
        shotsMade = 0;
        threePointersAttempted = 0;
        threePointersMade = 0;
        freeThrowsAttempted = 0;
        freeThrowsMade = 0;
    }
    

    
    public void printPlayerData() {
        System.out.print(name+": shots: "+shotsMade+"/"+shotsAttempted+" ");
        System.out.printf("%.2f",shootingPercentage());
        System.out.print("%, 3ptrs: "+threePointersMade+"/"+threePointersAttempted+" ");
        System.out.printf("%.2f",threePointPercentage());
        System.out.print("%, free throws: "+freeThrowsMade+"/"+freeThrowsAttempted+" ");
        System.out.printf("%.2f",freeThrowPercentage());
        System.out.println("%, total points: "+totalPointsScored());
    }
}
