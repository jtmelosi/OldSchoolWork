package Battlers;

public class Broadswordsman extends Battler {

    // constructor
    public Broadswordsman() {
        super();
        alterBaseStats();
        setDescriptionAndAbilites();
    }

    @Override
    public void addCustomizedStatPointIncreasePerLevel() {
        // specific implementation
    }

    @Override
    public void alterBaseStats() {
        // specific implementation
    }

    public void setDescriptionAndAbilites() {
        name = "Broadswordsman";
        battlerDescription = "A warrior battler with strong AoE, single target, and survivability.\n"
                + "His main stat is power, but can utilize many different stats.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames[0] = "Cleave";
        abilityNames[1] = "Double Slash";
        abilityNames[2] = "Keep Going!";
        abilityNames[3] = "Determination (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 4;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals moderate damage to all enemies.";
        abilityDescriptions[1] = "Slashes an enemy twice, dealing moderate damage each hit with a"
                + "\n50% higher chance to critically hit compared to the regular chance.";
        abilityDescriptions[2] = "Creates a shield based on power and heals yourself by 10% of your health each turn for 2 turns.";
        abilityDescriptions[3] = "Attack bar increases by your speed when you are attacked.";
        abilityTargetingMethod[0] = 2;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 0;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler[] enemyTeam) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.25;
        double coefficientTwo = .04;
        double rawDamageDealt = (getCurrentPower() * coefficient) * (1 + (mastery * coefficientTwo));

        if (didCrit()) {
            rawDamageDealt *= (critDamage);
            System.out.println(name + " critically swings for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " swings for " + (int) rawDamageDealt + " raw damage.");
        }

        for (Battler enemy : enemyTeam) {
            if (didHit(enemy.getDodgeChance())) {
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficientOne = 1.75;
        double coefficientTwo = 10.5;

        double rawDamageDealt = (getCurrentPower() * coefficientOne) + (mastery * coefficientTwo);
        for (int i = 0; i < 2; i++) {
            if (didCrit(critRate * .5)) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically swings for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " swings for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }

        abilityCooldownsProgress[1] = 0;
        emptyTurnProgress();
    }

    public void abilityThree() {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 2.5;

        double shieldingAmount = coefficient * getCurrentPower();
        currentShields += shieldingAmount;

        changeDotDamageInOneRound(-health * .1);
        changeDotDamageInTwoRounds(-health * .1);

        abilityCooldownsProgress[2] = 0;
        emptyTurnProgress();
    }

    public void abilityFour() {
        increaseSpeed();
        System.out.println(name + "'s turn progress increased by " + (int) getCurrentSpeed() + ".");
    }

    // specific modifications
    @Override
    public void takeTrueDamage(double damageTaken) {
        incapacitated = false;

        damageTaken -= flatDamageReduction;
        if (damageTaken <= 0) {
            damageTaken = 0;
        }

        if (getCurrentShields() == 0) {
            if (getCurrentShields() < damageTaken) {
                System.out.println(name + "'s shields blocked " + (int) currentShields + " damage.");
                damageTaken -= currentShields;
            } else {
                System.out.println(name + "'s shields blocked all the damage (" + (int) damageTaken + ").");
                changeCurrentShields(-damageTaken);
                damageTaken = 0;
            }
        }

        if (damageTaken != 0) {
            changeCurrentHealth(-damageTaken);
        }
        
        if (damageTaken < 0) {
            if (currentHealth > health) {
                currentHealth = health;
            }
        }

        if (damageTaken > 0) {
            if (currentHealth <= 0) {
                System.out.println(name + " took " + (int) damageTaken + " damage and is now dead.");
                isDead();
            } else {
                System.out.println(name + " took " + (int) damageTaken + " damage and now has " + currentHealth + " health left.");
                abilityFour();
            }
        }
    }

}
