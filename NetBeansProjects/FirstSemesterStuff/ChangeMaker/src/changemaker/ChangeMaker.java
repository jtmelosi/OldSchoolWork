/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changemaker;
import java.util.Scanner;
/**
 *
 * Author: Jacob Melosi
 * 
 * Date: 6/12/14
 * 
 * Description: This program will notify the user of the correct amount of each coin to give
 * someone as change with the fewest possible coins given.
 */
public class ChangeMaker{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int cents;
        System.out.print("Enter the amount of money to make into change: ");
        cents = keyboard.nextInt();
        
        int numberOfQuarters = cents/25;
        cents = cents%25;
        int numberOfDimes = cents/10;
        cents = cents%10;
        int numberOfNickels = cents/5;
        cents = cents%5;
        int numberOfPennies = cents;
        
        System.out.println("Quarters: " + numberOfQuarters);
        System.out.println("Dimes:\t  " + numberOfDimes);
        System.out.println("Nickels:  " + numberOfNickels);
        System.out.println("Pennies:  " + numberOfPennies);
    }
}
