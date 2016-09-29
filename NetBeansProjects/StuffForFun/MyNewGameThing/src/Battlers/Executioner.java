package Battlers;

public class Executioner extends Battler {

    // constructor
    public Executioner() {
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
        name = "Executioner";
        battlerDescription = "A battler that excels at finishing enemies off, and especially racking up extreme overkill so it is difficult for the enemy to revive.\n"
                + "Mastery, crit rate, and power are the main stats.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Hang";
        abilityNames[1] = "Decapitate";
        abilityNames[2] = "Flawless Execution";
        abilityNames[3] = "Swift End (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 6;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals low-moderate damage, and increases the cooldown of an enemy's non-basic ability by 1 turn.";
        abilityDescriptions[1] = "Deals moderate-high damage to an enemy with greatly increased critical damage.";
        abilityDescriptions[2] = "Deals moderate damage, but receives triple the effect from Swift End.";
        abilityDescriptions[3] = "Deals increased damage in relation to an enemy's missing health, increased by mastery.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 1;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.1;
        double rawDamageDealt = power * coefficient;

        rawDamageDealt *= abilityFour(enemy, 1);

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {//
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
            enemy.regressCooldowns();
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.8;
        double rawDamageDealt = power * coefficient;

        rawDamageDealt *= (abilityFour(enemy, 2));

        if (didCrit()) {
            rawDamageDealt *= ((critDamage * 1.25) + .5);
            System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {//
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityThree(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.5;
        double rawDamageDealt = power * coefficient;

        rawDamageDealt *= abilityFour(enemy, 3);

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {//
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public double abilityFour(Battler enemy, int abilityNumber) {
        double percentHPMissingMultiplier = 1 + (enemy.getCurrentHealth() / enemy.getHealth()); // 95% hp so 5% missing, so 1.05x
        double coefficient = .01; // 20 mastery
        double increaseFromMastery = 1 + (coefficient * mastery); // .2, or 20% increase, so 1.2x
        double finalMultiplier = (percentHPMissingMultiplier * increaseFromMastery); // 1.05*1.2=1.26

        if (abilityNumber == 3) {
            finalMultiplier = ((finalMultiplier - 1) * 3) + 1;
        }

        String thisString = abilityNames[3] + " multiplied the damage by ";
        String formattedString = String.format("%.4s", finalMultiplier);
        thisString += (formattedString + ".");

        System.out.println(thisString);
        
        return finalMultiplier;
    }

}
