/* Jacob Melosi
 * 8/8/2014
 * Description: Program 8 is about modifying an array in various ways.
 * 
 */
package program8;

import java.util.Scanner;

public class Program8 {

    public static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int[] a = new int[ARRAY_SIZE];
        int option;
        reset(a);

        do {
            System.out.println("The array is:");
            for (int i = 0; i < ARRAY_SIZE; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.print("1) square \n"
                    + "2) halve \n"
                    + "3) accumulate \n"
                    + "4) transpose \n"
                    + "5) shift \n"
                    + "6) reverse \n"
                    + "7) reset \n"
                    + "0) Quit \n?: ");
            do {
                option = kb.nextInt();
            } while (0 >= option && option >= 7);

            switch (option) {
                case 1:
                    square(a);
                    break;
                case 2:
                    halve(a);
                    break;
                case 3:
                    accumulate(a);
                    break;
                case 4:
                    transpose(a);
                    break;
                case 5:
                    shift(a);
                    break;
                case 6:
                    reverse(a);
                    break;
                case 7:
                    reset(a);
                    break;
                case 0:
            }
        } while (option != 0);

        System.out.println("Goodbye.");

//        square(a);
//        halve(a);
//        accumulate(a);
//        transpose(a);
//        shift(a);
//        reverse(a);
//        for (int i = 0;i<=ARRAY_SIZE-1;i++){
//            System.out.println("The value of array slot " + i + " is: "+a[i]);
//        }
    }

    // Resets the array given
    public static
            void reset(int b[]) {
        for (int i = 0; i <= ARRAY_SIZE - 1; i++) {
            b[i] = i+1;
        }
    }

    public static void square(int a[]) {
        for (int i = 0; i <= ARRAY_SIZE - 1; i++) {
            a[i] = a[i] * a[i];
        }
    }

    public static void halve(int a[]) {
        for (int i = 0; i <= ARRAY_SIZE - 1; i++) {
            a[i] = a[i] / 2;
        }
    }

    public static void accumulate(int a[]) {
        for (int i = (ARRAY_SIZE - 1); i >= 0; i--) {
            int accumulation = 0;
            for (int j = 0; j <= i - 1; j++) {
                accumulation += a[j];
            }
            a[i] = a[i] + accumulation;
        }
    }

    public static void transpose(int a[]) {
        int temp;
        for (int i = 0; i <= (ARRAY_SIZE - 1); i = i + 2) {
            temp = a[i + 1];
            a[i + 1] = a[i];
            a[i] = temp;
        }
    }

    public static void shift(int a[]) {
        int temp = -75;
        for (int i = 0; i <= ARRAY_SIZE - 1; i++) {
            if (i == 0) {
                temp = a[i];
                a[i] = a[i + 1];
            } else if (i == (ARRAY_SIZE - 1)) {
                a[i] = temp;
            } else {
                a[i] = a[i + 1];
            }

//            a[i] = a[(i+1)%ARRAY_SIZE];
//            if (i == (ARRAY_SIZE - 1)){
//            a[i] = a[i]-1;
//        }
        }
    }

    public static void reverse(int a[]) {
        int temp;
        for (int i = 0; i <= (ARRAY_SIZE / 2) - 1; i++) {
            temp = a[i];
            a[i] = a[ARRAY_SIZE - 1 - i];
            a[ARRAY_SIZE - 1 - i] = temp;
        }
    }
}
