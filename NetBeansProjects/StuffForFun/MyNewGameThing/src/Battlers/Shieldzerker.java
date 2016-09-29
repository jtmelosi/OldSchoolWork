package Battlers;

public class Shieldzerker extends Battler {

    public boolean usedAbilityTwo = false;
    public double defenseFromDamage;
    
    // constructor
    public Shieldzerker() {
        super();
        defenseFromDamage = 0;
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
        name = "Shieldzerker";
        battlerDescription = "A defensive battler with great offensive ramp-up potential. Defense is the main stat.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames[0] = "Shield Swipe";
        abilityNames[1] = "Shield Slam";
        abilityNames[2] = "Launch Shield";
        abilityNames[3] = "The Best Defense (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 2;
        abilityCooldowns[2] = 5;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Hits the enemy twice, or more times with mastery, to deal low damage each hit.";
        abilityDescriptions[1] = "Deals moderate-high damage to an and increases defense by 20% of base for a turn.";
        abilityDescriptions[2] = "Deals high damage and stuns the target for a turn.";
        abilityDescriptions[3] = "Defense increases the damage of all attacks, and defense is increased, for one turn, by the percentage of raw damage dealt of the enemy's max health. Also, defense adds to damage return.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 1;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .6;
        double coefficientTwo = .75;
        int numberOfAttacks = 2 + (int) (mastery * .1);

        for (int i = 0; i < numberOfAttacks; i++) {
            double rawDamageDealt = (power * coefficient) + (defense * coefficientTwo);

            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                abilityFour(rawDamageDealt,enemy.getHealth());
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[1] + ":\n" + abilityDescriptions[1]);
        double coefficient = 1.6;
        double coefficientTwo = 3;
        double rawDamageDealt = (power * coefficient) + (defense * coefficientTwo);

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically bashes for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " bashes for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {
            abilityFour(rawDamageDealt,enemy.getHealth());
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        usedAbilityTwo = true;
        System.out.println(name + " additionally increased temporary defense by " + (.2 * defense) + ".");

        emptyTurnProgress();
    }

    public void abilityThree(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[2] + ":\n" + abilityDescriptions[2]);
        double coefficient = 2;
        double coefficientTwo = 3.75;
        double rawDamageDealt = (power * coefficient) + (defense * coefficientTwo);
        
        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically bashes for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " bashes for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {
            abilityFour(rawDamageDealt,enemy.getHealth());
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
            enemy.setStunned(true);
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityFour(double rawDamage, double enemyMaxHealth) {
        defenseFromDamage += defense * (rawDamage / enemyMaxHealth);
    }

    @Override
    public double damageReturned(double rawDamageDealt) {
        return rawDamageDealt * (damageReturn + (defense * .1));
    }

    @Override
    public void addDamageReturn() {
        damageReturn += .03;
    }

    @Override
    public void startTurn() {
        isDead();
        decayNegativeHealth();
        applyDotDamage();
        updateDotDamage();
        decayShields();
        progressCooldowns();
        defenseFromDamage=0;
    }

    @Override
    public void endTurn() {
        abilityReady = false;
        setStunned(false);
        setIncapacitated(false);
        resetTemporaryStats();
        defenseChange += defenseFromDamage;
        if (usedAbilityTwo == true) {
            defenseChange += .2 * defense;
            usedAbilityTwo = false;
        }
    }

}
