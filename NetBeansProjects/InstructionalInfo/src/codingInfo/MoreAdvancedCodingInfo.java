// This class is to show how the following topics are used: arrays, try-catch-final blocks, and imports.
package codingInfo;

// These are imports, they just allow you to use what they hold.
import java.util.Random;
import java.util.Scanner;

public class MoreAdvancedCodingInfo {

    // the default name I use for creating a new random object
    private static final Random rand = new Random();

    // the default name I use for creating a new scanner for input from the keyboard
    private static final Scanner kb = new Scanner(System.in);

    // This creates an int array with 10 spaces. The first space is arr[0], and it goes up to arr[9]
    public static final int[] arr = new int[10];

    public static void main(String[] args) {
        int mostRecentInt = (rand.nextInt()%12)+1;  // This divides the random by 12, and gives you whatever remainder is left,
                                                    // and then I add one to make sure it isn't 0 for the next part.

        try {
            for (int i = 0; i < arr.length + 1; i++) { // The arr.length + 1 is pushing it barely out of bounds, if the + 1 wasn't
                arr[i] = mostRecentInt;                // there, then it'd be fine.
                mostRecentInt = asksForIntegerToBeTripled(mostRecentInt);
            }
        } catch (Exception e) {
            System.out.println("Catch Block. An error was caught but isn't crashing your program.");
        } finally {
            System.out.println("Finally Block. The last dealio before exiting your try-catch-finally code.");
            sayHello();
        }
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static int asksForIntegerToBeTripled(int integerToTriple) {
        integerToTriple *= 3;
        return integerToTriple;
    }

}
