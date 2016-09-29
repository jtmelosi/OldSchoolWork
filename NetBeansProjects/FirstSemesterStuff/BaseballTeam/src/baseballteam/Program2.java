/* Jacob Melosi
 * 9/12/2014
 * Description: This program is to make code within 4 classes that shows stats of a baseball team.
 *              This class has the main method and grabs methods from other classes output the requested data in the requested format.
 */

package baseballteam;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Program2 {
    
    private static final String FILE_NAME = "baseballTeam.txt";
    
    public static void main(String[] args) {
        
        Team team = new Team();
        
        Scanner fin = null;
        // try and catch for the files
        try {
            fin = new Scanner(new File(FILE_NAME));
        }catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + FILE_NAME);
            System.exit(1);
        }// end try
        
        team.loadTeam(fin);
        team.outputTeam(fin);
        
        fin.close();
        
    }
}
