package Battlers;

public class SoulShifter extends Battler {

    // constructor
    public SoulShifter() {
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
        name = "Soul Shifter";
        battlerDescription = "A high sustain battler with moderate damage that is centered around power and mastery.";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Siphon Soul";
        abilityNames[1] = "Soul Shatter";
        abilityNames[2] = "Soul Drain";
        abilityNames[3] = "Mass Drain";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 3;
        abilityCooldowns[3] = 6;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals damage and returns health. Health return is based off of damage done and mastery.";
        abilityDescriptions[1] = "Deals true damage to an enemy.";
        abilityDescriptions[2] = "Deals damage to an enemy over two turns, and restores equivalent health to you over two turns. Health return increases with mastery and damage done.";
        abilityDescriptions[3] = "Deals damage to all enemies, and returns health to all allies. Health return increases with damage done and power.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 1;
        abilityTargetingMethod[3] = 6;
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

    public void abilityThree(Battler enemy) {//
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