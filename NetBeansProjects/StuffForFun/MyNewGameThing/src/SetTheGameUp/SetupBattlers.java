package SetTheGameUp;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class SetupBattlers {

    public static final ArrayList<Battlers.Battler> ownTeamBattlers = new ArrayList<>();
//    private static final ArrayList<Battlers.Battler> enemyTeamBattlers = new ArrayList<>();
    
    private static final Scanner kb = new Scanner(System.in);
    private static final Random rand = new Random();

    private static final int NUMBER_OF_TOTAL_BATTLERS = 24;
    private static int numberOfBattlers = 0;


    public static void setupOwnBattlers() {
        selectNumberOfBattlers();
        selectBattlers();
    }

    private static void selectNumberOfBattlers() {
        System.out.println("You start the game with 1500 coins, and each battler beyond your first that you start with will reduce your coins by 375.\n"
                + "How many battlers would you like to start with? (Type an integer between 1 and 5)");
        
        boolean finishedPickingNumberOfBattlers = false;
        do {
            try {
                numberOfBattlers = parseInt(kb.nextLine());
                if (!((numberOfBattlers >= 1) && (numberOfBattlers <= 5))) {
                    System.out.println("Please enter an acceptable number.");

                }
                if ((numberOfBattlers >= 1) && (numberOfBattlers <= 5)) {
                    finishedPickingNumberOfBattlers = true;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("That wasn't an acceptable input type.");
            }
        } while (finishedPickingNumberOfBattlers == false);
        
        System.out.println("");
    }

    private static void selectBattlers() {
        int numberOfPickedBattlers = 0;
        String displayBattlerList;
        displayBattlerList = ("Select your battlers to start with from the list by typing the numbers of the battlers you want (you may read up on them in their classes):\n"
                + "1.Broadswordsman\n2.Cloudwalker\n3.Crossbowman\n4.Earthshaker\n5.Executioner\n6.Flag Bearer\n7.Forest Archer\n"
                + "8.Gladiator\n9.Holystone Cleric\n10.Lifebender\n11.Pummeler\n12.PyroMancer\n13.Rage Consumed\n14.Rapier Duelist"
                + "\n15.Rock Golem\n16.SacrificalPilgrim\n17.Sharpshooter\n18.Shieldzerker\n19.Skeleton Knight\n20.SoulShifter"
                + "\n21.TemporalWizard\n22.TrappedSoul\n23.TribalShaman\n24.Warrior");
        System.out.println(displayBattlerList);
        
        boolean selectedBattler = false; 
        boolean selectedNumberOfBattlers = false;
        int battlerChosen;
        
        do {
            do {
                try {
                    battlerChosen = parseInt(kb.nextLine());

                    if (!((battlerChosen >= 1) && (battlerChosen <= NUMBER_OF_TOTAL_BATTLERS))) {
                        System.out.println("Please enter an acceptable number.");
                    }

                    if ((battlerChosen >= 1) && (battlerChosen <= NUMBER_OF_TOTAL_BATTLERS)) {
                        selectedBattler = true;
                        createBattler(battlerChosen);
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("That wasn't an acceptable input type.");
                }
            } while (selectedBattler == false);

            numberOfPickedBattlers++;
            if (numberOfPickedBattlers == numberOfBattlers) {
                selectedNumberOfBattlers = true;
            }
        } while (selectedNumberOfBattlers == false);
        System.out.println("");
    }

    private static void createBattler(int battlerNumber) {
        if (battlerNumber == 1) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Broadswordsman());
        } else if (battlerNumber == 2) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Cloudwalker());
        } else if (battlerNumber == 3) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Crossbowman());
        } else if (battlerNumber == 4) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Earthshaker());
        } else if (battlerNumber == 5) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Executioner());
        } else if (battlerNumber == 6) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.FlagBearer());
        } else if (battlerNumber == 7) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.ForestArcher());
        } else if (battlerNumber == 8) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Gladiator());
        } else if (battlerNumber == 9) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.HolystoneCleric());
        } else if (battlerNumber == 10) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Lifebender());
        } else if (battlerNumber == 11) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Pummeler());
        } else if (battlerNumber == 12) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Pyromancer());
        } else if (battlerNumber == 13) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.RageConsumed());
        } else if (battlerNumber == 14) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.RapierDuelist());
        } else if (battlerNumber == 15) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.RockGolem());
        } else if (battlerNumber == 16) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.SacrificialPilgrim());
        } else if (battlerNumber == 17) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Sharpshooter());
        } else if (battlerNumber == 18) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Shieldzerker());
        } else if (battlerNumber == 19) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.SkeletonKnight());
        } else if (battlerNumber == 20) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.SoulShifter());
        } else if (battlerNumber == 21) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.TemporalWizard());
        } else if (battlerNumber == 22) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.TrappedSoul());
        } else if (battlerNumber == 23) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.TribalShaman());
        } else if (battlerNumber == 24) {
            ownTeamBattlers.add(new <Battlers.Battler> Battlers.Warrior());
        } // add staticSlinger

    }
    
    public static int getNumberOfBattlers(){
        return numberOfBattlers;
    }
}

//        Battlers.Battler newBattler = new Battlers.Battler();
