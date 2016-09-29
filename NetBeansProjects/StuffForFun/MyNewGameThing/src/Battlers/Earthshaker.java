package Battlers;

public class Earthshaker extends Battler {

    private double tremorSeverity;

    // constructor
    public Earthshaker() {
        super();
        alterBaseStats();
        setDescriptionAndAbilites();
    }

    public static void addCustomizedStatPointIncreasePerLevel() {
        // specific implementation
    }

    @Override
    public void alterBaseStats() {
        // specific implementation
    }

    public void setDescriptionAndAbilites() {
        name = "Earthshaker";
        battlerDescription = "";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Shockwave";
        abilityNames[1] = "Epicenter";
        abilityNames[2] = "Burrow";
        abilityNames[3] = "Echoing Tremors (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 5;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Slams the ground, sending a wave through land at the enemy to deal moderate damage.";
        abilityDescriptions[1] = "Causes a massive earthquake, dealing highly varying damage to all enemies.";
        abilityDescriptions[2] = "Dives into the ground, recovering health, as well as increasing defense.";
        abilityDescriptions[3] = "Responds to attacks with a portion of the potential damage of own last attack (none after burrowing).";
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
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler[] enemyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public void abilityThree() {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        emptyTurnProgress();
    }

    public double abilityFour() {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 0;

        return 0;
    }

    @Override
    public double getCurrentDamageReturn() {
        return damageReturn + damageReturnChange + abilityFour();
    }
}
