/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circledata;

import java.util.Scanner;
/**
 *
 * @author Jacob Melosi
 * Date: 6-12-14
 * Description: This program will calculate the area and circumference of a circle using a user-provided radius.
 */
public class CircleData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double radius;
        double area;
        double circumference;
        final double pi = 3.14159; // final eliminates the possibility of the value being altered
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("Please enter the radius of the circle:");
        radius = keyboard.nextDouble();
        area = pi * radius * radius;
        circumference = 2 * pi * radius;
        
        System.out.println("Area of Circle: " + area);
        System.out.println("Circumference of Circle: " + circumference);
        
        
                if (radius <5){
                    System.out.println("You're a twat because you picked a small radius!!");
                } else 
            System.out.println("You're a boss because you picked a decently sized radius!");
        }
    }
