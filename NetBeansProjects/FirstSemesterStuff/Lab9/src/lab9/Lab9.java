/* Jacob Melosi
 * 7/24/2014
 * Description: Lab8 requirements plus sorting the numbers along with finding and reporting the median.
 */
    
package lab9;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab9 {

    public static final String INPUT_FILE_NAME = "numbers2.txt";
    public static final String OUTPUT_FILE_NAME = "numberStats.txt";

    public static void main(String[] args) {
        
        Scanner fin = null;
        PrintWriter fout = null;
        
        double justRead;
        int count = 0;
        double total = 0;
        double largestNumber = 0;
        int numbersOverZero = 0;
        double average;
        double[] arr = new double[50];                                                          //part of new code
        double medianValue;                                                                     //part of new code
        
        try {
            fin = new Scanner(new File(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + INPUT_FILE_NAME);
            System.exit(1);
        }// end try
        
        while (fin.hasNextDouble()){
            justRead = fin.nextDouble();
            
            arr[(count)] = justRead;                                                            //part of new code
            
            if (justRead>=0){
                total+=justRead;
                count++;
            }
            
            if (justRead>largestNumber){
                largestNumber=justRead;
            }
            
            if (justRead>0){
                numbersOverZero++;
            }
            
            System.out.println("Just read: "+justRead+", count = "+count+", total = "+total);
        }
        
        bubbleSort (arr, count);                                                                //part of new code
        
        if (count%2==0){                                                                        //part of new code
            medianValue = (arr[(count/2)] + arr[(count/2 - 1)])/2.0;
        } else {
            medianValue = arr[(count/2)];
        }
        
        System.out.println("File numberStats.txt was created successfully.");
        
        try {
            fout = new PrintWriter(OUTPUT_FILE_NAME);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + OUTPUT_FILE_NAME);
            System.exit(1);
        }
        
        average = total/(double)count;
        
        fout.println("Stats on file 'numbers.txt'");
        fout.println("Number of numbers in the file: "+count);
        fout.println("Sum of the numbers in the file: "+total);
        fout.printf("Average of the numbers in the file: "+"%.2f",average);
        fout.println();
        fout.println("The largest number in the file: "+largestNumber);
        fout.println("The number of numbers greater than 0: "+numbersOverZero);
        fout.println("The median value is: " + medianValue);
        fin.close();
        fout.close();
        
        System.out.println(medianValue);
    }
    
    public static void bubbleSort(double[] array, int count) {
        boolean swapped = true;
        int j = 0;
        double tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < count - j; i++) {
                if (array[i] < array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
