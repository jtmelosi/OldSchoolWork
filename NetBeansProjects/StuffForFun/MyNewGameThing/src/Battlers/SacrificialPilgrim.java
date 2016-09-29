package Battlers;

public class SacrificialPilgrim extends Battler {

    // constructor
    public SacrificialPilgrim() {
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
        name = "Sacrificial Pilgrim";
        battlerDescription = "A support battler that expends health as a resource, but regenerates it quite quickly."
                + "\nMastery and health are the main stats as mastery increases all healing and shielding done to others.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Smash Into";
        abilityNames[1] = "Sacrificial Lamb";
        abilityNames[2] = "Refuse Rations";
        abilityNames[3] = "Determined Journeyer (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 4;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Sacrifices 5% of current health to deal twice that amount of true damage to an enemy as well as slow them by 20%.";
        abilityDescriptions[1] = "Sacrifices 30% of max health to give all allies a shield for 20% of his max health.";
        abilityDescriptions[2] = "Sacrifices 20% of max health to heal all allies for 15% of their max health, and give them 35% extra power.";
        abilityDescriptions[3] = "Recovers 10% max health every turn if under 70% health. Also, while below 35% health, damage taken will be reduced by 50%.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 4;
        abilityTargetingMethod[2] = 4;
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

    public void abilityTwo(Battler[] team) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public void abilityThree(Battler[] team) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public void abilityFour() {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

}