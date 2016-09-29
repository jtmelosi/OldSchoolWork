/* Jacob Melosi
 * 9/12/2014
 * Description: This program is to make code within 4 classes that shows stats of a baseball team.
 */

package baseballteam;

import java.util.Scanner;

public class Player {
    
    // attribute list
    private String name, position;

    
    // constructor
    public Player(){
        name = "";
        position = "";
    }
    
    // getters
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    // utility methods
    
        // loadData() must load values from the Scanner parameter in the same order as the attributes are in.
    public void loadData(Scanner fin){
        name = fin.nextLine();
        position = fin.next();
        if (fin.hasNextInt()){
            
        } else {
            fin.nextLine();
        }
}
    
        // generateDisplayString() must return a String that lists the player’s name followed by
        // their position like this: Name: Sandy Koufax, Position: P
    public String generateDisplayString(){
        String displayString = "Name: " + name + ", Position: " + position;
        return displayString;
    }
}
