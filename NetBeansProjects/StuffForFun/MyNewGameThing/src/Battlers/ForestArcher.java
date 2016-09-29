package Battlers;

import java.util.Random;

public class ForestArcher extends Battler {

    private final Random rand = new Random();
    
    // constructor
    public ForestArcher() {
        super();
        alterBaseStats();
        setDescriptionAndAbilites();
    }

    public static void addCustomizedStatPointIncreasePerLevel() {
        // specific implementation
    }

    public void alterBaseStats() {
        // specific implementation
    }

    public void setDescriptionAndAbilites() {
        name = "Forest Archer";
        battlerDescription = "A support and damage hybrid fighter that does ramp-up damage over time.\n"
                + "Her main stat is mastery, and benefits little from power and defense penetration.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Shoot Arrow";
        abilityNames[1] = "Volley";
        abilityNames[2] = "Healing Balm";
        abilityNames[3] = "Poison Coated Arrows(Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 2;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals low damage.";
        abilityDescriptions[1] = "Fires 8 arrows at random enemies (first ability).";
        abilityDescriptions[2] = "Heals an ally for a low-moderate amount, and then again the next two turns for increasing amounts. Heal based on mastery.";
        abilityDescriptions[3] = "Shoot arrow and volley deal damage for 1-3 turns afterwards. Damage over time increases with mastery.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 2;
        abilityTargetingMethod[2] = 3;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .5;
        double rawDamageDealt = power * coefficient;

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically fires for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " fires for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {//
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
            abilityFour(enemy);
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler[] enemyTeam) {//
        System.out.println(name + " uses " + abilityNames[1] + ":\n" + abilityDescriptions[1]);
        int whichEnemy = rand.nextInt(enemyTeam.length);
        
        for(int i = 0; i<8; i++){
            abilityOne(enemyTeam[whichEnemy]);
        }

        emptyTurnProgress();
    }

    public void abilityThree(Battler ally) {//
        System.out.println(name + " uses " + abilityNames[2] + ":\n" + abilityDescriptions[2]);
        double coefficient = 2;
        double amountHealed = mastery * coefficient; // total amount will be just below 3.5x this
        
        double totalHealing = 0;
        
        for(int i = 0; i<3; i++){
            if(i==0){
                ally.changeDotDamageInOneRound(-amountHealed);
            } else if (i==1){
                amountHealed *= 1.15;
                ally.changeDotDamageInTwoRounds(-amountHealed);
            } else if (i==2){
                amountHealed *= 1.15;
                ally.changeDotDamageInThreeRounds(-amountHealed);
            }
            totalHealing+=amountHealed;
        }
        
        System.out.println(name + " is healing " + ally.getName() + " " + totalHealing + " health over three rounds.");
        
        emptyTurnProgress();
    }

    public void abilityFour(Battler enemy) {
        double coefficient = 1.5;
        double coefficientTwo = .25;
        double dotPower = (coefficient*mastery)+(coefficientTwo*power);
        int dotLength = rand.nextInt(3)+1;
        
        System.out.println(name + " applies " + abilityNames[3] + "for " + dotLength + " turns with a power of " + dotPower + ".");
        
        switch(dotLength){
            case 1:
                enemy.changeDotDamageInOneRound(dotPower);
                break;
            case 2:
                enemy.changeDotDamageInOneRound(dotPower);
                enemy.changeDotDamageInTwoRounds(dotPower);
                break;
            case 3:
                enemy.changeDotDamageInOneRound(dotPower);
                enemy.changeDotDamageInTwoRounds(dotPower);
                enemy.changeDotDamageInThreeRounds(dotPower);
                break;
            default:
                enemy.changeDotDamageInOneRound(dotPower);
                enemy.changeDotDamageInTwoRounds(dotPower);
                enemy.changeDotDamageInThreeRounds(dotPower);
                break;
        }
        
        emptyTurnProgress();
    }

}
