package Battlers;

public class StaticSlinger extends Battler {

    // constructor
    public StaticSlinger() {
        super();
        alterBaseStats();
        setDescriptionAndAbilites();
    }

    @Override
    public static void addCustomizedStatPointIncreasePerLevel() {
        // specific implementation
    }

    @Override
    public void alterBaseStats() {
        // specific implementation
    }

    public void setDescriptionAndAbilites() {
        name = "Static Slinger";
        battlerDescription = "";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames[0] = "Chain Shock";
        abilityNames[1] = "Overload";
        abilityNames[2] = "Unleash Static";
        abilityNames[3] = "Build-Up (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 3;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals low damage to the entire enemy team with a 10% chance to stun.";
        abilityDescriptions[1] = "Deals massive damage to an enemy's shields.";
        abilityDescriptions[2] = "Deals low damage, as well as the damage from build-up";
        abilityDescriptions[3] = "Every two points of damage to shields is stored as extra damage to be unleashed, adding more from mastery.";
        abilityTargetingMethod[0] = 2;
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
            takeDamage(enemy.damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[1] + ":\n" + abilityDescriptions[1]);
        double coefficient = 0;

        abilityCooldownsProgress[1] = 0;
        emptyTurnProgress();
    }

    public void abilityThree(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[2] + ":\n" + abilityDescriptions[2]);
        double coefficient = 0;

        abilityCooldownsProgress[2] = 0;
        emptyTurnProgress();
    }

    public void abilityFour(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[3] + ":\n" + abilityDescriptions[3]);
        double coefficient = 0;

        abilityCooldownsProgress[3] = 0;
        emptyTurnProgress();
    }

}
