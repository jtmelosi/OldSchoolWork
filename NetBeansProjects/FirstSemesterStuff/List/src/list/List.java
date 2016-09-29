/* List
 * Jacob Melosi
 * 6-19-14
 * Description: This program will accept two numbers input by the user, and count from the lowest one to the highest one.
 */
package list;
import java.util.Scanner;
public class List {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int number1;
        int number2;
                
        System.out.print("Enter a number: ");
        number1 = keyboard.nextInt();
        System.out.print("Enter another number: ");
        number2 = keyboard.nextInt();
        
        if (number2>number1)
            for (int i = number1; i <= number2; i++){
                System.out.println(i);
            }
        else
            for (int i = number2; i <= number1; i++){
                System.out.println(i);
            }
    }
}