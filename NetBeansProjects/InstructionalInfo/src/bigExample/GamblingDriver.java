package bigExample;

import java.util.Random;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.util.InputMismatchException;

public class GamblingDriver {
    
    // When I did this I was just stupid about static shit, so completely ignore that stuff.

    private static final Random rand = new Random();
    private static final Scanner kb = new Scanner(System.in);
    private static Player[] playerArray;
    private static Casino myCasino;
    private static final int CHIP_WIN_REQUIREMENT = 3000;
    private static final int MAX_BET = 300, MIN_BET = 1;
    private static final int CHIP_FORGIVENESS_AMOUNT = 75;
    private static int numberOfPlayers = 0;
    private static int gameType = 0;
    private static int currentRoll, currentBet;
    private static int winningPlayer;
    private static int round = 0;
    private static int donePlaying;
    private static int turnsToAdd;
    private static boolean gameWon = false;
    private static boolean isFinishedPlaying = false;

    public static void main(String[] args) {
        setupGame();
        playGameTilFinished();
    }

    public static void waitSecondsDiv1000(int secsDiv1000) {
        try {
            Thread.sleep(secsDiv1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void setupGame() {
        System.out.println("Welcome to the random number game!");
        waitSecondsDiv1000(1500);
        createPlayers();
        waitSecondsDiv1000(3000);

        System.out.println("Now, let's set up the game and explain the rules to you!");
        System.out.println("We are going to start you all out with 300 chips per person.");
        System.out.println("Your goal is to get " + CHIP_WIN_REQUIREMENT + " chips.");
        System.out.println("When you win a bet, you will receive chips based on how much you bet, "
                + "the payout percent modifier,\nand what your current multiplier is.\n"
                + "Also, your multiplier will increase by .5 if you roll at or above the top threshhold,\n"
                + ".3 for the next, then .2, .1, then it will stay stagnant at the second to lowest, and\n"
                + "finally it will be lowered by .1 if you don't hit a single payout threshhold.\n");

        waitSecondsDiv1000(4500);
        setupPayoutModifiers();
        System.out.println("Alright, you're all setup. Time to play!");
    }

    public static void playGameTilFinished() {
        do {
            playGame();
            System.out.println("\nWould you like to play another game with the same settings?\n"
                    + "Type 1 for yes, or 2 to exit the program:\n");
            try {
                donePlaying = parseInt(kb.nextLine());
                if (!((donePlaying == 1) || (donePlaying == 2))) {
                    System.out.println("Please enter an acceptable number.");

                }
                if (donePlaying == 2) {
                    isFinishedPlaying = true;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("That wasn't an acceptable input type.");
            }
            if (donePlaying == 1) {
                resetGame();
            }
        } while (isFinishedPlaying == false);
    }

    public static void createPlayers() {
        do {
            System.out.println("How many players are going to play?\nEnter a number between 2 and 5:");
            try {
                numberOfPlayers = parseInt(kb.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("That wasn't an acceptable input type.");
            }
            if ((numberOfPlayers > 1) && (numberOfPlayers < 6)) {
                System.out.println("Alright, how about we introduce ourselves now...\n");
            } else {
                System.out.println("Please enter a valid number of players.");
            }
        } while (!((numberOfPlayers > 1) && (numberOfPlayers < 6)));
        playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerArray[i] = new Player();
            System.out.println("Player " + (i + 1) + ", please enter your name:");
            playerArray[i].setName(kb.nextLine());
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            if (numberOfPlayers > 2) {
                System.out.print(playerArray[i].getName() + ", ");
                if ((i + 2) == numberOfPlayers) {
                    System.out.print("and ");
                }
            } else if (numberOfPlayers == 2) {
                System.out.print(playerArray[i].getName() + "");
                if ((i + 2) == numberOfPlayers) {
                    System.out.print(" and ");
                }
                if ((i + 1) == numberOfPlayers) {
                    System.out.print(", ");
                }
            }
        }
        if (numberOfPlayers == 2) {
            System.out.println("I hope you both brought your A-game.\n");
        } else {
            System.out.println("I hope you all brought your A-game.\n");
        }
    }

    public static void setupPayoutModifiers() {
        System.out.println("Now it's time to decide what you want the percent modifiers to be. "
                + "Would you like to play with the recommended base percent\npayout modifiers provided, "
                + "or set the payout percent modifiers yourself?\n"
                + "Type 1 for base modifiers or type 2 to set them yourself:");
        do {
            try {
                gameType = parseInt(kb.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("That wasn't an acceptable input type.");
            }
            if ((gameType == 1)) {
                System.out.println("Good choice, you will be playing with the base percent modifiers.");
            } else if (gameType == 2) {
                System.out.println("\nAlright then, I'll let you choose your modifiers.\n"
                        + "The order will go low, mid, mid-high, high, and max for payouts.\n"
                        + "You get the highest payout you qualify for if you roll higher than "
                        + "or equal to the following:\n"
                        + "low: 35, mid: 50, mid-high: 67, high: 89, max: 100");
            } else {
                System.out.println("Please enter a valid number for the game type.");
            }
        } while (!((gameType > 0) && (gameType < 3)));
        waitSecondsDiv1000(7000);
        if (gameType == 1) {
            myCasino = new Casino();
        } else if (gameType == 2) {
            int low = 0, mid = 0, midHigh = 0, high = 0, max = 0;
            while (!(low > 0)) {
                System.out.println("Please enter what you want the low payout percentage modifier to be.");
                try {
                    low = parseInt(kb.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            }
            while (!(mid > 0)) {
                System.out.println("Please enter what you want the mid payout percentage modifier to be.");
                try {
                    mid = parseInt(kb.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            }
            while (!(midHigh > 0)) {
                System.out.println("Please enter what you want the mid-high payout "
                        + "percentage modifier to be.");
                try {
                    midHigh = parseInt(kb.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            }
            while (!(high > 0)) {
                System.out.println("Please enter what you want the high payout percentage modifier to be.");
                try {
                    high = parseInt(kb.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            }
            while (!(max > 0)) {
                System.out.println("Please enter what you want the max payout percentage modifier to be.");
                try {
                    max = parseInt(kb.nextLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            }
            myCasino = new Casino(low, mid, midHigh, high, max);
        }
    }

    public static void checkForWin() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerArray[i].getChips() >= CHIP_WIN_REQUIREMENT) {
                winningPlayer = i;
                gameWon = true;
                System.out.println(playerArray[i].getName() + " has won ending with "
                        + playerArray[i].getChips() + " chips!");
            }
        }
    }

    public static void gambleForAllTurnsThisRound() {

        // Tells the users whose turn it is, as well as how many turns and chips they have.
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerArray[i].getTurnsLeftThisRound() >= 1) {
                do {
                    System.out.println("\n\n" + playerArray[i].getName() + "'s turn.");
                    System.out.println("You currently have " + playerArray[i].getChips() + " chips.");
                    System.out.println("You currently have "
                            + playerArray[i].getTurnsLeftThisRound() + " turn(s).");
                    System.out.println("Your current multiplier is " + playerArray[i].getMultiplier());

                    // Figures out how many chips the player wants to bet.
                    do {
                        currentBet = 0;
                        if(playerArray[i].getChips()<MAX_BET)
                        System.out.println("How many chips would you like to bet? (1-" + playerArray[i].getChips() + "):");
                        else
                        System.out.println("How many chips would you like to bet? (1-" + MAX_BET + "):");
                        try {
                            currentBet = parseInt(kb.nextLine());
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("That wasn't an acceptable input type.");
                        }
                        if (!((currentBet >= MIN_BET) && (currentBet <= MAX_BET))) {
                            System.out.println("Please enter a value between " + MIN_BET + " and " + MAX_BET + ".");
                        }
                        if (playerArray[i].getChips() < currentBet) {
                            System.out.println("I'm sorry, you don't have that many chips.");
                            currentBet = 0;
                        }
                    } while (!((currentBet >= MIN_BET) && (currentBet <= MAX_BET)));

                    // Removes chips before calculating if any are added back.
                    playerArray[i].changeChips(-currentBet);

                    if (currentBet != 0) {
                        // Rolls a random number 1-100
                        currentRoll = (rand.nextInt(100) + 1);
                        System.out.println("You just rolled a " + currentRoll + ".");
                        waitSecondsDiv1000(2000);

                        // Calculates how much you won, or if you won nothing back. It also adjusts win multiplier.
                        if (currentRoll >= myCasino.getMaxValue()) {
                            playerArray[i].changeChips((int) ((currentBet) * (playerArray[i].getMultiplier())
                                    * (myCasino.getMaxPayout())));
                            playerArray[i].setMutliplier(playerArray[i].getMultiplier() + .5);
                            System.out.println("You just won big!");
                        } else if (currentRoll >= myCasino.getHighValue()) {
                            playerArray[i].changeChips((int) (currentBet * playerArray[i].getMultiplier()
                                    * myCasino.getHighPayout()));
                            playerArray[i].setMutliplier(playerArray[i].getMultiplier() + .3);
                            System.out.println("You just won chips!");
                        } else if (currentRoll >= myCasino.getMidHighValue()) {
                            playerArray[i].changeChips((int) (currentBet * playerArray[i].getMultiplier()
                                    * myCasino.getMidHighPayout()));
                            playerArray[i].setMutliplier(playerArray[i].getMultiplier() + .2);
                            System.out.println("You just won chips!");
                        } else if (currentRoll >= myCasino.getMidValue()) {
                            playerArray[i].changeChips((int) (currentBet * playerArray[i].getMultiplier()
                                    * myCasino.getMidPayout()));
                            playerArray[i].setMutliplier(playerArray[i].getMultiplier() + .1);
                            System.out.println("You at least broke even, if not pulling ahead.");
                        } else if (currentRoll >= myCasino.getLowValue()) {
                            playerArray[i].changeChips((int) (currentBet * playerArray[i].getMultiplier()
                                    * myCasino.getLowPayout()));
                            System.out.println("You didn't lose your entire bet.");
                        } else {
                            System.out.println("You lost your entire bet and your win "
                                    + "multiplier has been reduced by one-tenth (cannot be reduced below the base).");
                            playerArray[i].setMutliplier(playerArray[i].getMultiplier()-.1);
                            if(playerArray[i].getMultiplier()<1)
                                playerArray[i].setMutliplier(playerArray[i].getBaseMultiplier());
                        }

                        // Tells the player where they currently stand after their last roll. It also removes a turn.
                        System.out.println("Now you have " + playerArray[i].getChips() + " chips.");
                        System.out.println("Your win multiplier is now at " + playerArray[i].getMultiplier() + "\n");
                        waitSecondsDiv1000(3000);
                        playerArray[i].subtractATurn();
                        checkForZeroBalance();
                    }
                } while (playerArray[i].getTurnsLeftThisRound() >= 1);
            }

        }
    }

    public static void checkForZeroBalance() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerArray[i].getChips() <= 0) {
                playerArray[i].subtractATurn();
                playerArray[i].changeChips(CHIP_FORGIVENESS_AMOUNT);
                System.out.println(playerArray[i].getName() + ", you were out of chips, so"
                        + " we took a turn from you and gave you " + CHIP_FORGIVENESS_AMOUNT + " chips\n");
                waitSecondsDiv1000(1500);
            }
        }
    }

    public static void startNewRound() {
        if (round != 0) {
            System.out.println("Here is where everyone stands at the end of round " + round + ".\n");
        }
        for (int i = 0; i < numberOfPlayers; i++) {

            playerArray[i].addATurn();
            if (playerArray[i].getMultiplier() >= 2.0) {
                turnsToAdd = (int) playerArray[i].getMultiplier();
                playerArray[i].setTurns(playerArray[i].getTurnsLeftThisRound() + turnsToAdd);
                System.out.println(playerArray[i].getName() + ", your multiplier just earned you "
                        + turnsToAdd + " extra turns!");
                waitSecondsDiv1000(1000);

            }
            if (round != 0) {
                System.out.println(playerArray[i].getName() + " has " + playerArray[i].getChips() + " chips.");
                System.out.println(playerArray[i].getName() + " has a " + playerArray[i].getMultiplier() + " multiplier.");
                System.out.println(playerArray[i].getName() + " has " + playerArray[i].getTurnsLeftThisRound() + " turns.");
                System.out.println("");
            }
        }
        System.out.println("");
        round++;
        waitSecondsDiv1000(3000);
    }

    public static void playGame() {
        while (gameWon == false) {
            gambleForAllTurnsThisRound();
            checkForWin();
            startNewRound();
        }
    }

    public static void resetGame() {
        round = 0;
        isFinishedPlaying = false;
        gameWon = false;
        for (int i = 0; i < numberOfPlayers; i++) {
            playerArray[i].setMutliplier(1);
            playerArray[i].setChips(playerArray[i].getStartingChips());
        }
    }
}