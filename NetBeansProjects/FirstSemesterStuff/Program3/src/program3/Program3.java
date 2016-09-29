/* Jacob Melosi
 * 7-1-2014
 * Description: Making the Pig! game.
 */
package program3;

import java.util.Random;
import javax.swing.JOptionPane;

public class Program3 {

    private static final int DIE_SIDES = 6;
    private static final int TARGET_SCORE = 100;

    public static void main(String[] args) {

        Random rand = new Random();


        int player1 = 0;
        int player2 = 0;
        int turn = 0;
        String openingMessage = "Welcome to Pig!";
        String commands = "Click 'Yes' to roll, 'no' to hold.";
        int roundScore =0;
        String scoreForRound = "Score for round = ";
        int whoseTurn;

        JOptionPane.showMessageDialog(null, openingMessage);

        do {
            whoseTurn = turn % 2 + 1;
            
            int reply = JOptionPane.showConfirmDialog(null,
                    "Player 1: " + player1
                    + "\n" + "Player 2: " + player2
                    + "\n" + "Player " + whoseTurn + "'s turn."
                    + "\n" + commands
                    + "\n" + scoreForRound + roundScore,
                    "Pig!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                int die = rand.nextInt(DIE_SIDES) + 1;
                JOptionPane.showMessageDialog(null,"You rolled a " + die);
                if (die == 1) {
                    roundScore = 0;
                    turn++;
                    JOptionPane.showMessageDialog(null, "Pigged Out!");
                    
                }
                else {
                    roundScore= die + roundScore;
                }


                
            } 
            else {


                if (whoseTurn == 1) {
                    player1 += roundScore;
                } else {
                    player2 += roundScore;
                }
                roundScore = 0;
                turn++;
            }
        }while (player1 < TARGET_SCORE && player2 < TARGET_SCORE);




            if (player1 >= TARGET_SCORE) {
                JOptionPane.showMessageDialog(null,"Player 1: "+player1+"\n"+"Player 2: "+player2+"\nPlayer 1 wins!");
            } else
                JOptionPane.showMessageDialog(null,"Player 1: "+player1+"\n"+"Player 2: "+player2+"\nPlayer 2 wins!");
            {
            }
        }

    }
