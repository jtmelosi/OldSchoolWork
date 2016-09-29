/* Jacob Melosi
 * 6-19-14
 * Description: This program is to make a quiz that has randomly generated numbers in its addition problems.
 */
package program2;
//*imported in two things that I will need (random number generator and the scanner for the keyboard)
import java.util.Scanner;
import java.util.Random;
public class Program2 {
    //*set what the numbers the random numbers could be between
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 100;
    //*set how many questions would be asked
    public static final int NUMBER_OF_QUESTIONS = 10;
    
    public static void main(String[] args) { 
        //*set up what I had imported in
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        
        //*added all the variables and set those that needed it to their base values
        int rndm1;
        int rndm2;
        int correctAnswer;
        int studentAnswer;
        int numberCorrect;
        numberCorrect = 0;
        int currentQuestion;
        currentQuestion = 1;
        double percentageCorrect;
        
        //*start of the for loop
        //*this is to keep track of which question the program is on, and also to
        //make sure that it doesnt go over the number of questions
        for (int i = currentQuestion; i <= NUMBER_OF_QUESTIONS ;i++){
        //*these two are to set two random variables
        rndm1 = rand.nextInt(100) + 1;
        rndm2 = rand.nextInt(100) + 1;
        //*this asks the question
        System.out.print("Question #"+ i + "\n" + rndm1 + " + " + rndm2 + " = ");
        //*allows user to input their answer
        studentAnswer = keyboard.nextInt();
        //*calculates the correct answer
        correctAnswer = rndm1 + rndm2;
        
        //*start of the if statement
        //*if the answer is correct, it prints correct and increases the tally
        //of how many answers are correct by one
        if (studentAnswer == correctAnswer){
            System.out.println("Correct!");
            numberCorrect++;
        }
        else
            //*if the answer is incorrect it prints "incorrect" and then the correct answer
            System.out.println("Incorrect! (" + correctAnswer + " )");
    }
        //*this calculates the percentage of questions the user correctly answered
        percentageCorrect = numberCorrect * 100 / NUMBER_OF_QUESTIONS;
        //*this prints the percentage of questions the user correctly answered
        System.out.println("Percentage: " + percentageCorrect + "%");
    }
}
