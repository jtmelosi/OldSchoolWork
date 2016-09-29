/*
 * Author: Jacob Melosi
 * Date: 6/12/14
 * Description: Check for correct input from user then make patterns.
 */

package patterns;
import javax.swing.JOptionPane;
public class Patterns {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    public static void main(String[] args) {
        
        int userNumber;
        String message = "";
        String valueString;
        String errorString = "Number must be between 1 and 9.";
        
        valueString = JOptionPane.showInputDialog
                ("Enter a number between 1 and 9:");
        userNumber = Integer.parseInt(valueString);
        
        while ((MINIMUM_NUMBER>userNumber) || (MAXIMUM_NUMBER<userNumber)) {
            JOptionPane.showMessageDialog(null, errorString);
            valueString = JOptionPane.showInputDialog
                ("Enter a number between 1 and 9:");
            userNumber = Integer.parseInt(valueString);
            }
        
        for (int value = 1; value <= userNumber; value++) {
            message = (message + "\n" + value);}
        
        message = (message + "\n");
        
        for(int value2 = 1; value2 <= userNumber; value2++) {
            message = (message + "\n" + value2);
            for(int value22 = 1; value22 <= userNumber; value22++) {
                message = (message + value2);}}
        
        message = (message + "\n");
        
        for(int value3 = 1; value3 <= userNumber; value3++) {
            message = (message + "\n" + value3);
            for(int value33 = 1; value33 < value3; value33++) {
                message = (message + value3);}}
        
        message = (message + "\n \n");
        
//        
        if (userNumber % 4 == 1)
        {
             for(int value2 = 1; value2 <= userNumber; value2++) {
            //message = (message + "\n" + value2);
            for(int value22 = 1; value22 <= userNumber; value22++) {
                if ( value2 == userNumber / 2 + 1 || value22 == userNumber/2 + 1)
                   message = (message + value2);
                else
                    message = (message + "  ");
            }
            message = message + "\n";
            }
        }
             
       
    JOptionPane.showMessageDialog(null, message);}}
