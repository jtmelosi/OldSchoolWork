package Battlers;

import static Battlers.Battler.name;

public class TemporalWizard extends Battler {

    // constructor
    public TemporalWizard() {
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
        name = "Temporal Wizard";
        battlerDescription = "A debilitating support battler that is based off of mastery and accuracy to change the battle over multiple turns.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Decay Health";
        abilityNames[1] = "Alter Future";
        abilityNames[2] = "Regress Time";
        abilityNames[3] = "Foreboding Visions (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 3;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Advances time, reducing the enemy's defense and speed as well as dealing damage for 3 turns based off power, mastery, and accuracy. Reduction is based off mastery and accuracy.";
        abilityDescriptions[1] = "Either reverses or triples damage or healing over time effects on an ally or enemy depending on the target.";
        abilityDescriptions[2] = "Reduces an enemy's power, or heals an ally's wounds over time based on mastery and accuracy.";
        abilityDescriptions[3] = "Increases all allies' turn progress after each time the Temporal Wizard acts. Effects based on mastery and accuracy.";
        abilityTargetingMethod[0] = 21;
        abilityTargetingMethod[1] = 27;
        abilityTargetingMethod[2] = 27;
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