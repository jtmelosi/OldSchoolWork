/*Gasoline
 * Jacob Melosi
 * 6-19-14
 * Description: This program will calculate all the needed
 *              information for a road trip.
 */
package gasoline;
import java.util.Scanner;
public class Gasoline {
    public static void main(String[] args) {
    
        Scanner keyboard = new Scanner(System.in);
        
        int numberOfPassengers;
        int tripLength;
        double tankCapacity;
        double gasPrice;
        double mpgOfCar;
        
        double gallonsNeeded;
        double tanksNeeded;
        double pricePerTank;
        double totalGasCost;
        double pricePerPassenger;
        
        System.out.print("Please enter the number of passengers: ");
        numberOfPassengers = keyboard.nextInt();
        
        System.out.print("Please enter the trip length in miles: ");
        tripLength = keyboard.nextInt();
        
        System.out.print("Please enter the capacity of the gas tank in gallons: ");
        tankCapacity = keyboard.nextDouble();
        
        System.out.print("Please enter the price of gas per gallon: ");
        gasPrice = keyboard.nextDouble();
        
        System.out.print("Please enter the miles per gallon your vehicle uses: ");
        mpgOfCar = keyboard.nextDouble();
        
        System.out.println("");
        
        gallonsNeeded = tripLength/mpgOfCar;
        tanksNeeded = gallonsNeeded/tankCapacity;
        pricePerTank = tankCapacity*gasPrice;
        totalGasCost = pricePerTank*tanksNeeded;
        pricePerPassenger = totalGasCost/numberOfPassengers;
        
        System.out.println("Number of tanks of gas needed: "+tanksNeeded);
        System.out.printf("Total cost of gas: $%.2f", totalGasCost);
        System.out.println("");
        System.out.printf("The cost of gas per passenger: $%.2f", pricePerPassenger);
        
        
    }
}
