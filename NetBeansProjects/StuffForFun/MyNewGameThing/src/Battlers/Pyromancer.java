package Battlers;

import static Battlers.Battler.name;

public class Pyromancer extends Battler {

    // constructor
    public Pyromancer() {
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
        name = "Pyromancer";
        battlerDescription = "Pyromancer is a high single target damage battler that focuses on mastery, power, and crit rate.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Magma Spew";
        abilityNames[1] = "Hell Burst";
        abilityNames[2] = "Lashing Flames";
        abilityNames[3] = "Infernal Rage (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 3;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Attacks an enemy 3 times, adding damage for up to three turns randomly. Damage is based on power and mastery.";
        abilityDescriptions[1] = "Deals high damage to a single target with increased critical damage.";
        abilityDescriptions[2] = "Deals moderate damage based on power to random enemies 4 or more times based on mastery.";
        abilityDescriptions[3] = "Whenever the Pyromancer is hit, increase power and mastery by a percent of health lost.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 2;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;
        double rawDamageDealt = power * coefficient;

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

    public void abilityTwo(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public void abilityThree(Battler[] enemyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public void abilityFour(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

}