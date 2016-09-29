package helpkris;

import java.util.Random;

public class HelpKris {
    
    public static final int NUMBER_OF_SECS_IN_DEGREE = 3600;
    public static final int NUMBER_OF_SECS_IN_MINUTE = 60;
    

    public static void main(String[] args) {
        
        Random rand = new Random();
        
        // sets up the two angles and the rest of the variables
        int ang1Deg, ang1Min, ang1Sec, ang2Deg, ang2Min, ang2Sec, ang1TotSec, ang2TotSec, totalSec, totalDegs, totalMins, totalSecs;
        ang1Deg = rand.nextInt(80)+10;
        ang2Deg = rand.nextInt(80)+10;
        ang1Min = rand.nextInt(59)+1;
        ang2Min = rand.nextInt(59)+1;
        ang1Sec = rand.nextInt(59)+1;
        ang2Sec = rand.nextInt(59)+1;
        
        // reports the deg/min/sec of each angle to see if it is working correctly
        System.out.println("ang1deg/min/sec and ang2deg/min/sec: "+ang1Deg+"/"+ang1Min+"/"+ang1Sec+" and "+ang2Deg+"/"+ang2Min+"/"+ang2Sec);
        
        // adds up each angle's seconds into two totals
        ang1TotSec=(ang1Deg*NUMBER_OF_SECS_IN_DEGREE)+(ang1Min*NUMBER_OF_SECS_IN_MINUTE)+(ang1Sec);
        ang2TotSec=(ang2Deg*NUMBER_OF_SECS_IN_DEGREE)+(ang2Min*NUMBER_OF_SECS_IN_MINUTE)+(ang2Sec);
        System.out.println("Ang1TotalSec and Ang2TotalSec:"+" "+ang1TotSec+" and "+ang2TotSec);
        
        // this finds the total seconds of each angle for the part without extra credit
        totalSec = ang1TotSec+ang2TotSec;
        System.out.println("The angles added together causes the total seconds to be:" + totalSec);
        
        // now we have the total seconds added together we need to bring it back out to the original degrees/minutes/seconds format
        totalDegs = totalSec/3600;
        totalMins = (totalSec - totalDegs*3600)/60;
        totalSecs = totalSec - (totalDegs*3600 + totalMins*60);
        System.out.println("The angle is this measurement:" + totalDegs + " Degrees, "+totalMins+" Minutes, and "+totalSecs+" Seconds when added together.");
        
        // this part is for extra credit, but very easy to manage
        // this is now gonna find out if the size of ang1TotSec is bigger than ang2TotSec or not
        // it then uses that information to make sure you get a positive answer. an absolute value
        // piece of code would work just as well so you wouldn't need the if statements, but that's up to you
        if (ang1TotSec>ang2TotSec){
            totalSec = ang1TotSec-ang2TotSec;
        } else {
            totalSec = ang2TotSec-ang1TotSec;
        }
        System.out.println("The smaller angle subtracted from the larger angle causes the total seconds to be:" + totalSec);
        
        // this is the same code as from above, but is used for when the angles are subtracted from each other
        totalDegs = totalSec/3600;
        totalMins = (totalSec - totalDegs*3600)/60;
        totalSecs = totalSec - (totalDegs*3600 + totalMins*60);
        System.out.println("The angle is this measurement:" + totalDegs + " Degrees, "+totalMins+" Minutes, and "+totalSecs+" Seconds when subtracted.");
    }
}
