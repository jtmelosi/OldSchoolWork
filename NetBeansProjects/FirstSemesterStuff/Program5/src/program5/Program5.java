/* Jacob Melosi
 * 7-16-2014
 * Description: Stores the main method portion of the basketball player program which as a whole keeps track of shooting stats.
 */

package program5;

import java.util.Random;

public class Program5 {

    public static void main(String[] args) {
        Random rand = new Random();
        
        BasketballPlayer a = new BasketballPlayer();
        a.setName("DunkMastah");
        
        for(int i=0;i<25;i++){
            int scenario = rand.nextInt(6) + 1;
            
            if(scenario==1){
                a.addMissedShot();
                System.out.println("The player missed a 2 pointer.");
            }else if(scenario==2){
                a.addMadeShot();
                System.out.println("The player made a 2 pointer.");
            }else if(scenario==3){
                a.addMissedThreePointer();
                System.out.println("The player missed a 3 pointer.");
            }else if(scenario==4){
                a.addMadeThreePointer();
                System.out.println("The player made a 3 pointer.");
            }else if(scenario==5){
                a.addMissedFreeThrow();
                System.out.println("The player missed a free throw.");
            }else if(scenario==6){
                a.addMadeFreeThrow();
                System.out.println("The player made a free throw.");
            }
            a.printPlayerData();
            }
    }
}
