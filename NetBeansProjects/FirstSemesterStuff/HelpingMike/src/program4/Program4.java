/*
Name: Michael Bellina
Date: 7-8-2014
Desc: This program simulates the "Let's Make a Deal" Monte Hall problem offering the user 
 */
package program4;
            import java.util.Random;
            import java.util.Scanner;
public class Program4 {
            Scanner kb = new Scanner(System.in);
  
  
  
  
  
  
    
    
public static void main(String[] args) 
{
    
    //the problem is that Im calling things into the main to no avail.
    
    
   
}   
    
    
    
   
public static int runASim(int typeOfSim)
{  Random random = new Random();
    
   typeOfSim = getTypeOfSim();
        int prizeDoor = 0; 
        int revealedDoor = 0; 
        int chosenDoor = random.nextInt(3)+1;
        int numberOfSims=0;
        int wonGames = 0;
        int chosenDoorBeforeSwap = 0;
            chosenDoorBeforeSwap = chosenDoor;
        int i;
// remember that chosenDoor will be labeled as "final chosen door" and chosenDoorBeforeSwap is labeled "Chosen door" in the output for simtype1.
        
   if (typeOfSim == 1) // what I need to do here is move the if/else to the PSVM, leave the for and do/whiles, the main method can grab the numberOfSims
       //                 but this method only uses typeOfSim
   {        
            for (i = 1; i <= numberOfSims; i++){
                        do { revealedDoor = random.nextInt(3)+1; }
                             while ((revealedDoor == chosenDoor));
                       do { prizeDoor = random.nextInt(3)+1; }
                            while ( prizeDoor == revealedDoor);
                       do { chosenDoor = random.nextInt(3)+1; } 
                             while ((chosenDoor == revealedDoor) || (chosenDoor == chosenDoorBeforeSwap));   }
           
    if ((chosenDoor == prizeDoor))  {  System.out.print("Prize Door =  " + prizeDoor + "Chosen Door =  " + chosenDoorBeforeSwap + 
                                                        "Revealed Door = " + revealedDoor + "Final door chosen =  " + 
                                                        chosenDoor + ": player wins");}    
                            else   {  System.out.print("Prize Door =  " + prizeDoor + "Chosen Door =  " + chosenDoor + 
                                                     "Revealed Door = " + revealedDoor + " : player loses"); }                  
   }
        
      
   else if (typeOfSim == 2)
   {      
    for ( i = 1; i <= numberOfSims; i++)
    {    do { prizeDoor = random.nextInt(3)+1; }
                while ( prizeDoor == revealedDoor);
         do { revealedDoor = random.nextInt(3)+1; }
                 while ((revealedDoor == chosenDoor || revealedDoor == prizeDoor));
          
                            if ((chosenDoor == prizeDoor))  {
                                wonGames = wonGames +1; 
                                System.out.print("Prize Door =  " + prizeDoor + "Chosen Door =  " + chosenDoor + " : player wins");
                             } 
    
                                    else {  System.out.print("Prize Door =  " + prizeDoor + "Chosen Door =  " + chosenDoor + 
                                                                "Revealed Door = " + revealedDoor + " : player loses");
                                         }
    }
                                    
                            
   }                        
                return 0;
}
 public static int getTypeOfSim()
 {   
     Scanner kb = new Scanner(System.in);
     int typeOfSim = 0;
            
                        do { System.out.println("Enter a 1 for switching doors, enter a 2 to keep the original."); 
                        typeOfSim= kb.nextInt(); } 
        
                                while (!(typeOfSim == 1 ) && !(typeOfSim == 2));
     return typeOfSim;
 }
      
   public static int getNumberOfSims()
   {
       Scanner kb = new Scanner(System.in);
       int numberOfSims = 0;
       int wonGames = 0;
       int i=1;
       System.out.println("How many sims do you want to run?");
       {
 
                if (numberOfSims < 1) 
                { System.out.println("The number must be positive");
                  numberOfSims = kb.nextInt();
                }                        
                else if( numberOfSims >=0) 
                  {
                         numberOfSims = kb.nextInt();
                  } 
       }
          
   return numberOfSims;    }}