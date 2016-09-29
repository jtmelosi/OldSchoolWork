/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goofing.around;

import java.util.Scanner;
/**
 * Author: Jacob Melosi
 * Date: 6/12/14
 * Description: Me just goofing around and getting a feel for coding... hopefully.
 */
public class GoofingAround_Height {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double heightInInches;
        final double conversionFactorFromInchesToCm = 2.54;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter your height in inches: ");
        heightInInches = keyboard.nextDouble();
        
        double heightInCm;
        heightInCm = heightInInches * conversionFactorFromInchesToCm;
        
        System.out.println("Your height in Centimeters is " + heightInCm);
        
        if (heightInInches<60)
            System.out.println("You a short-ass mutha fucka!");
        else if (heightInInches>=60 && heightInInches<=72)
            System.out.println("You're pretty average in terms of height.");
        else if (heightInInches>72 && heightInInches<=78)
            System.out.println("You're actually kinda tall, ho!");
        else if (heightInInches>78)
            System.out.println("You a tall-ass mutha fucka!");
        
    }
}
