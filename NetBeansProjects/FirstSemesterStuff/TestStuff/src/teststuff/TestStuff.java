package teststuff;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestStuff {

    public static void main(String[] args) {
        
        
        
        
    }
    
    public static int returnsAnInt(){
        return 4;
    }
    
    private static void howCompareToWorks(){
        String first = "all";
        String second = "ball";
        System.out.println(first.compareTo(second));
        // returns -1
    }
    
    private static void moveLastCharacterOneLater(){
        String baseWordNext = "Hellz";
        
        while (baseWordNext.charAt(baseWordNext.length()-1) == 'z') {
            if (baseWordNext.length() > 1) {
                baseWordNext = removeLastChar(baseWordNext);
            } else {
                break;
            }
        }
        if ((baseWordNext.length() > 1) || baseWordNext.charAt(0) != 'z') {
            char last = baseWordNext.charAt(baseWordNext.length()-1);
            last += 1;
            baseWordNext = removeLastChar(baseWordNext);
            baseWordNext = baseWordNext.trim();
            baseWordNext += last;
        }else{
            baseWordNext = "zzzzzzzzzzzzzzzzzzzzzzz";
        }
        System.out.println(baseWordNext);
    }
    
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
    
    public void addTwoArraysIntoOne(){
        Random rand = new Random();
        int[] firstArray = new int[20];
        int[] secondArray = new int[20];
        int[] thirdArray = new int[20];
        
        System.out.println("Array 1 + Array 2 = Array 3");
        for (int i = 0; i < thirdArray.length; i++) {
            firstArray[i] = rand.nextInt(10);
            secondArray[i] = rand.nextInt(10);
            thirdArray[i] = firstArray[i] + secondArray[i];
            System.out.println("    " + firstArray[i] + "    +    " + secondArray[i] + "   =   " + thirdArray[i]);
        }
    }
    
    public boolean firstSmallerThan(String first, String second){
        return (first.compareTo(second) < 0);
        
    }

    public void setRefNumber(String ref) {
        String refNumber = ref;
        if (refNumber.length() < 3) {
            System.out.println("ERROR");
        } else {
            refNumber = ref;
        }
    }

    public int twoDimArrayThing(int[][] array1, int[][] array2) {
        int correctColumn = 0;
        for (int i = 0; i < array1[0].length; i++) {
            if(Arrays.equals(array1[i], array2[0])){
                correctColumn = i;
                i = array1[0].length;
            }
        }
        return correctColumn;
    }
}
