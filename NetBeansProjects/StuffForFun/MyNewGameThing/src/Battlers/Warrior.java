package Battlers;

public class Warrior extends Battler {

    // constructor
    public Warrior() {
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
        name = "Warrior";
        battlerDescription = "A fighter with decent survivability, the warrior has many status effect causing abilities.\n"
                + "His main stats are power and health.";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Slash";
        abilityNames[1] = "Shield Bash";
        abilityNames[2] = "Sever Limb";
        abilityNames[3] = "Sword and Board";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 4;
        abilityCooldowns[3] = 8;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals moderate damage and reduces the enemy's defense.";
        abilityDescriptions[1] = "Deals low damage, but has a chance to stun the enemy.";
        abilityDescriptions[2] = "Severs a leg or arm to deal damage as well as either reduce speed or power.";
        abilityDescriptions[3] = "Causes the warrior to reduce damage taken by 50% and deal 50% of the damage taken back to the enemy for the next 5 attacks recieved.";
                                    // need to add a variable for the 5 rounds thing, and have taking damage reduce that by 1
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 1;
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