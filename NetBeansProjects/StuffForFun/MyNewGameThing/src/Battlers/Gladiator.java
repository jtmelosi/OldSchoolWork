package Battlers;

public class Gladiator extends Battler {

    // constructor
    public Gladiator() {
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
        name = "Gladiator";
        battlerDescription = "A very situational battler that strives against higher health battlers."
                + "\nMain stats are speed, armor penetration, and mastery, and defense is also alright. Power scales poorly, and crits don't really affect his damage much.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames[0] = "Double Slash";
        abilityNames[1] = "Fight to Survive";
        abilityNames[2] = "Please the Crowd";
        abilityNames[3] = "Underdog (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 4;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals low damage two times and reduces the enemy's speed by 10% of its regular amount.";
        abilityDescriptions[1] = "Deals damage three times and reduces an enemy's accuracy by 1 if any hit makes contact. If Gladiator is below 50% health, also generates a shield for half the damage.";
        abilityDescriptions[2] = "Either deals extremely high or low damage based on chance related to your enemy's percent health remaining.";
        abilityDescriptions[3] = "If you have less current health than your opponent, then you will do an additional 5% of their max health per attack, modified by mastery.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 1;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .35;
        double rawDamageDealt = power * coefficient;

        for (int i = 0; i < 2; i++) {
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {//
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
                enemy.changeSpeedChange(-.1 * enemy.getSpeed());
                abilityFour(enemy);
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .075;
        double rawDamageDealt = power * coefficient;
        boolean abilityHit = false;
        double damageDoneThisAttack = 0;

        for (int i = 0; i < 3; i++) {
            rawDamageDealt *= 2;
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {//
                abilityHit = true;
                enemy.takeDamage(rawDamageDealt, defensePen);
                damageDoneThisAttack += enemy.getDamageDone(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
                abilityFour(enemy);
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }
        if (abilityHit == true) {
            changeCurrentShields(.5 * damageDoneThisAttack);
            enemy.changeAccuracyChange(-1);
        }

        abilityCooldownsProgress[1] = 0;
        emptyTurnProgress();
    }

    public void abilityThree(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .8;
        double enemyHealthPercent = (enemy.getCurrentHealth() / enemy.getHealth())*85; // -15% of max hp
        if ((Math.random() * 100) > (enemyHealthPercent)) {
            coefficient *= 10;
            System.out.println(getName() + " finishes " + enemy.getName() + "!");
        }else{
            System.out.println(getName() + " botches an attempt at finishing " + enemy.getName() + "!");
        }
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
            enemy.changeSpeedChange(-.1 * enemy.getSpeed());
            abilityFour(enemy);
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        abilityCooldownsProgress[2] = 0;
        emptyTurnProgress();
    }

    public void abilityFour(Battler enemy) {
        if (currentHealth < enemy.getCurrentHealth()) {
            enemy.takeTrueDamage(enemy.getHealth() * .05);
            System.out.println(enemy.getName() + " takes 5% of max health from " + getName() + "'s Underdog passive.");
        }
    }

}
