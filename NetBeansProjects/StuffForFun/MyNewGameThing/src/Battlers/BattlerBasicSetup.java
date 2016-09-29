package Battlers;

public class BattlerBasicSetup extends Battler {

    // constructor
    public BattlerBasicSetup() {
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
        name = "";
        battlerDescription = "";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "";
        abilityNames[1] = "";
        abilityNames[2] = "";
        abilityNames[3] = "";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 0;
        abilityCooldowns[2] = 0;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "";
        abilityDescriptions[1] = "";
        abilityDescriptions[2] = "";
        abilityDescriptions[3] = "";
        abilityTargetingMethod[0] = 0;
        abilityTargetingMethod[1] = 0;
        abilityTargetingMethod[2] = 0;
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
