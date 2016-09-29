package Battlers;

public class Crossbowman extends Battler {

    private int bolts = 7;
    private final int MAX_BOLTS = 7;

    // constructor
    public Crossbowman() {
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
        name = "Crossbowman";
        battlerDescription = "Battler with high spike damage potential, but down-time between bursts of damage.\n"
                + "His main stats are power and defense penetration.";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames[0] = "Shoot Bolt (Reload Bolts)";
        abilityNames[1] = "Unload Bolts (Reload Bolts)";
        abilityNames[2] = "Quick Reload";
        abilityNames[3] = "Kick";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 4;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals damage and has a chance (based on defense penetration) to make an enemy bleed next turn.\nIf empty, any bolt attack reloads all arrows.";
        abilityDescriptions[1] = "Unleashes all bolts that are still loaded for moderate damage per hit, and also has a chance each arrow to make an enemy bleed next turn.";
        abilityDescriptions[2] = "Reloads bolts and restores 100% turn progress, minus 5% per bolt that needs reloaded.";
        abilityDescriptions[3] = "Deals low damage and has a chance to stun the target.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 0;
        abilityTargetingMethod[3] = 1;
    }

    public void abilityOne(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.25;
        double rawDamageDealt = power * coefficient;

        if (bolts != 0) {
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                bleedEnemy(enemy);
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        } else {
            reloadBolts();
        }
        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .625;
        double rawDamageDealt = power * coefficient;

        if (bolts != 0) {
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                bleedEnemy(enemy);
                enemy.takeDamage(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        } else {
            reloadBolts();
        }

        abilityCooldownsProgress[1] = 0;
        emptyTurnProgress();
    }

    public void abilityThree(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);

        reloadBolts(bolts);

        abilityCooldownsProgress[2] = 0;
        emptyTurnProgress();
    }

    public void abilityFour(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .75;
        double rawDamageDealt = power * coefficient;

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
            if ((Math.random() * 100) < 50) {
                enemy.setStunned(true);
            }
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void reloadBolts() {
        bolts = MAX_BOLTS;
    }

    public void reloadBolts(int boltsLoaded) {
        double percentToSubtract = bolts * .05;

        changeTurnProgress(PROGRESS_NEEDED_TO_ACT * (1 - percentToSubtract));

    }

    public void bleedEnemy(Battler enemy) {
        if (didOccur(getDefensePenChange() + 8)) {
            enemy.changeDotDamageInOneRound(power * .3125 + 10 * mastery);
        }
    }

}
