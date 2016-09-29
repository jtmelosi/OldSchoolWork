/* Jacob Melosi
 * 7/31/2014
 * Description: This is to create a golf scorecard according to the par and player scores we received. Array assignment.
 */

package program7;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Program7 {

    public static final String INPUT_PARSCORES = "parScores.txt";
    public static final String INPUT_PLAYERSCORES = "playerScores.txt";
    public static final String OUTPUT_FILE_NAME = "Scorecard.txt";
    public static final int HOLES = 18;
    
    public static void main(String[] args) {
        
        Scanner finPar = null;
        Scanner finScores = null;
        PrintWriter fout = null;
        
        String Header = "Shady Elm Golf Course";
        String playerName;
        
        String holeStr = " Hole #";
        String parStr = " Par:";
        String scoreStr = " Score:";
        String resultStr = " Result:";
        int hole = 0;
        int par;
        int score;
        String result = "";
        int[] parArray = new int[HOLES];
        int[] scoreArray = new int[HOLES];
        String[] resultArray = new String[HOLES];
        int totalPar = 0;
        int totalScore = 0;
        int overallScore;
        
        
        // try and catch for the files
        try {
            finPar = new Scanner(new File(INPUT_PARSCORES));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + INPUT_PARSCORES);
            System.exit(1);}// end try
        try {
            finScores = new Scanner(new File(INPUT_PLAYERSCORES));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + INPUT_PLAYERSCORES);
            System.exit(1);}// end try
        //reads player's name from the player score card 
        try {
            fout = new PrintWriter(OUTPUT_FILE_NAME);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + OUTPUT_FILE_NAME);
            System.exit(1);}// end try
        
        
        // gets the par for each hole
        while (finPar.hasNextInt()){
            par = finPar.nextInt();
            parArray[hole] = par;
            hole++;
        }
        hole = 0; // resets hole for next retrieval of data
        
        
        // gets the player name and then the player score for each hole
        playerName = finScores.nextLine();
        while (finScores.hasNextInt()){
            score = finScores.nextInt();
            scoreArray[hole] = score;
            hole++;
        }
        
        
        // code for getting results
        for (int i = 0;i<=HOLES-1;i++){
            
            if (scoreArray[i] == 1){
            result = "Hole in One";
            } else if (scoreArray[i] - parArray[i] == -3){
                result = "Double Eagle";
            } else if (scoreArray[i] - parArray[i] == -2){
                result = "Eagle";
            } else if (scoreArray[i] - parArray[i] == -1){
                result = "Birdie";
            } else if (scoreArray[i] == parArray[i]){
                result = "Par";
            } else if (scoreArray[i] - parArray[i] == 1){
                result = "Bogey";
            } else if (scoreArray[i] - parArray[i] == 2){
                result = "Double Bogey";
            } else if (scoreArray[i] - parArray[i] == 3){
                result = "Triple Bogey";
            } else if (scoreArray[i] - parArray[i] >= 4){
                result = "Oh No";
            }
            resultArray[i] = result;
        }
        
        
        // calculates total values
        for (int i = 0;i<=HOLES-1;i++){
            totalPar=parArray[i]+totalPar;
            totalScore=scoreArray[i]+totalScore;
        }
        overallScore = (totalScore - totalPar);
        
        
        // outputs the scorecard
        // outputs the start that has the header portion
        fout.printf("%30s%n%n",Header);
        fout.printf(" Scorecard for " + playerName + "%n%n");
        fout.printf("%-9s"+"%-7s"+"%-9s"+"%-11s%n",holeStr,parStr,scoreStr,resultStr);
        fout.println("------------------------------------");
        // outputs the next portion that has info for each hole
        for(int i = 0;i<=HOLES-1;i++){
            fout.printf("%4s   "+"%5s "+"%7s  "+" %8s  " + "%n",(i+1),parArray[i],scoreArray[i],resultArray[i]);
        }
        fout.println("------------------------------------");
        // outputs the final portion that has the totals and overall score
        fout.printf("Totals:%5s%8s %n",totalPar,totalScore);
        fout.printf("Overall Score:%+3d  ",overallScore);
        
        // closes finA and finB
        finPar.close();
        finScores.close();
        fout.close();
    }
}
