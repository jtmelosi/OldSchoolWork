/* Jacob Melosi
 * 12/5/2014
 * Description: This program is to create 10 gamers and add stats randomly 200,000 times. Every 100 additions it is to sort and output
 *              each gamer's stats and badges earned. The sort doesn't work perfectly and takes a while to get them all in order
 *              correctly, but it gets there eventually.
 */
package CS150Programs;


public class Program7 {

    public static int outputNumber = 0;
    public static final int NUMBER_OF_ITERATIONS = 200000;
    public static final int NUMBER_OF_GAMERS = 10;
    public static final Gamer[] GAMER_ARRAY = new Gamer[NUMBER_OF_GAMERS];
    public static final String[] GAMER_NAMES_ARRAY = new String[NUMBER_OF_GAMERS];

    public static void main(String[] args) {
        createGamers();
        iterateAndOutput();

        // these next two are for the final output
        sortGamers(); // set up for output
        outputGamers(); // output
    }

    public static void createGamers() {
        setUpGamerNames();
        for (int i = 0; i < NUMBER_OF_GAMERS; i++) {
            GAMER_ARRAY[i] = new Gamer(GAMER_NAMES_ARRAY[i]);
        }
    }

    public static void setUpGamerNames() {
        GAMER_NAMES_ARRAY[0] = "Arnold Palmer";
        GAMER_NAMES_ARRAY[1] = "Jose Cuervo";
        GAMER_NAMES_ARRAY[2] = "Shirley Temple";
        GAMER_NAMES_ARRAY[3] = "Peter Smirnoff";
        GAMER_NAMES_ARRAY[4] = "Jack Daniels";
        GAMER_NAMES_ARRAY[5] = "Bloody Mary";
        GAMER_NAMES_ARRAY[6] = "Tom Collins";
        GAMER_NAMES_ARRAY[7] = "Rob Roy";
        GAMER_NAMES_ARRAY[8] = "Jim Bean";
        GAMER_NAMES_ARRAY[9] = "Evan Williams";

        // if more than 10 gamers would be needed I'd come back and just use the dictionary to get names instead
        // but this way was more fun
    }

    public static void iterateAndOutput() {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            if (i % 100 == 0) {
                sortGamers(); // set up for output
                outputGamers(); // output
            }
            doRandomActionWithRandomGamer(); // iterate
        }
    }

    public static void doRandomActionWithRandomGamer() {
        int randomGamer = (int) (Math.random() * 10);
        int randomAction = (int) (Math.random() * 10);

        GAMER_ARRAY[randomGamer].doRandomAction(randomAction);
    }

    public static void sortGamers() {
        Gamer currentGamer;
        int insertionIndex;
        for (int i = 1; i < NUMBER_OF_GAMERS; i++) {
            currentGamer = GAMER_ARRAY[i];
            insertionIndex = i - 1;
            while ((insertionIndex >= 0) && (GAMER_ARRAY[i].getTotalPoints() > GAMER_ARRAY[insertionIndex].getTotalPoints())) {
                GAMER_ARRAY[insertionIndex + 1] = GAMER_ARRAY[insertionIndex];
                insertionIndex--;
            }
            GAMER_ARRAY[insertionIndex + 1] = currentGamer;
        }
    }
    
    public static void outputGamers() {
        for (int i = 0; i < NUMBER_OF_GAMERS; i++) {
            System.out.println(GAMER_ARRAY[i].getOutputString());
        }
        System.out.println("");
    }

}
