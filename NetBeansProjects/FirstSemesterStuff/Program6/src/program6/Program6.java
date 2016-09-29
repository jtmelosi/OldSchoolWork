/* Jacob Melosi
 * 7-16-2014
 * Description: Main method of the granary project.
 */
package program6;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class Program6 extends JFrame {

    private static Granary silo;
    private static Random rand;

    public static void main(String[] args) {
        Program6 myFrame = new Program6();
        silo = new Granary();
        silo.setCapacity(1000);
        silo.setTypeOfGrain("Corn");
        myFrame.setSize(430, 400);
        myFrame.setTitle("Silo of " + silo.getTypeOfGrain());
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rand = new Random();
        int addOrTake;
        int howMuchGrain;
        int leftovers;
        String message;
        myFrame.setVisible(true);
        while (true) {
            addOrTake = rand.nextInt(2);
            howMuchGrain = rand.nextInt(500);
            if (addOrTake == 0) {
                leftovers = silo.addGrain(howMuchGrain);
                message = "Added " + howMuchGrain;
                if (leftovers > 0) {
                    message += ", " + leftovers + " did  not fit.";
                }
            } else {
                leftovers = silo.removeGrain(howMuchGrain);
                message = "Removed " + howMuchGrain;
                if (leftovers > 0) {
                    message += ", " + leftovers + " were not available.";
                }
            }
            silo.setMessage(message);
            myFrame.repaint();
            Wait.manySec(2);
        }
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        Graphics g = getContentPane().getGraphics();
        silo.draw(g);
    }
}