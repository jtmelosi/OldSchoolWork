/* 
 * This class is to show how the following topics work: classes, methods, calls, visibility, and static.
 * I'm going to be playing around with a shitty simulation of a city just as an example. It has no error catching either.
 */
package classInfo;

import static java.lang.Integer.parseInt;
import java.util.Random;
import java.util.Scanner;

public class BasicClassInfo {
    
    private static final Random rand = new Random();
    private static final Scanner kb = new Scanner(System.in);
    
    private City[] cityArray = new City[10];
    
    
    
    public static void main(String[] args) {
        
        
        
        
        
        
        
    }
    
    public void citySetup(){
        System.out.println("We're going to be setting up our cities right now.\n"
                + "Type 1 and press enter if you would like a default city,\n"
                + "or 2 if you would like to specify the values for your city: ");
        int cityType;
        cityType = parseInt(kb.nextLine());
        
        if(cityType == 1){
            
        }else if(cityType == 2){
            boolean coastalCity;
            String cityName;
            
            System.out.println("Alright, let's give your city a name.\n"
                    + "Please type the name you would like for your city: ");
            cityName = kb.nextLine();
            
            System.out.println("And now, type 1 if you would like the city to be on the coast,\n"
                    + "or 2 if you would like the city to not be on the coast: ");
            cityType = parseInt(kb.nextLine());
            if(cityType==1){
                
            }else{ // really any number that isn't 1 will be redirected here
                
            }
        }
    }
    
    
    
    
    
    
    
}
