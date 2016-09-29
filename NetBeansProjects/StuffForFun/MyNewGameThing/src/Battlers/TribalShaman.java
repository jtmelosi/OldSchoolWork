package Battlers;

public class TribalShaman extends Battler {

    // constructor
    public TribalShaman() {
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
        name = "Tribal Shaman";
        battlerDescription = "A debilitating battler with strong debuffs and decent damage.\n"
                + "His main stat is mastery, and secondary stats are accuracy, health, speed, and defense due to power barely scaling on him.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Voodoo Curse";
        abilityNames[1] = "Bad Juju";
        abilityNames[2] = "Voodoo Ritual";
        abilityNames[3] = "Tribal Voodoo (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 5;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals damage equal to 20% of the enemy's current health, and then 5% of the enemy's max health their next turn.";
        abilityDescriptions[1] = "Causes the enemy's accuracy to be reduced by its regular amount for a turn as well as deal damage.";
        abilityDescriptions[2] = "Causes all allies to gain 100% additional damage return until their next turn.";
        abilityDescriptions[3] = "When using an ability on an enemy, reduce their attack bar by 25% of its maximum with a 60% chance. All abilities except Bad Juju are increased by mastery.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
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