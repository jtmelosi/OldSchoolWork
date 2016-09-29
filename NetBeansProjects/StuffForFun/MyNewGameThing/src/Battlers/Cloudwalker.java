package Battlers;

public class Cloudwalker extends Battler {

    // constructor
    public Cloudwalker() {
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
        name = "Cloudwalker";
        battlerDescription = "A very fast battler that excels at dealing a lot of damage and taking little in return.\n"
                + "Main stats are speed and power, with dodge being optional, but scaling very well to give much needed survivability.";
        activeAbilities = 3;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Aerial Kick";
        abilityNames[1] = "Burst of Air";
        abilityNames[2] = "Cloud Hopping";
        abilityNames[3] = "Cloud Illusions (Passive)";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 3;
        abilityCooldowns[2] = 5;
        abilityCooldowns[3] = 0;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Deals low-moderate damage based on power and speed, and has a 25% chance to increase speed by 40%.";
        abilityDescriptions[1] = "Deals moderate damage based on power and speed, and stuns the target.";
        abilityDescriptions[2] = "Attacks each enemy with either Aerial Kick twice, or Burst of Air once.";
        abilityDescriptions[3] = "Increases dodge chance by 200% of regular dodge. Attacks have a 35% chance to strike twice.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 2;
        abilityTargetingMethod[3] = 0;
    }

    public void abilityOne(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .5;
        double coefficientTwo = .5;
        double rawDamageDealt = power * coefficient + speed * coefficientTwo;

        // increase speed
        if (didOccur(25)) {
            changeSpeedChange(.4 * getCurrentSpeed());
        }
        
        for (int i = 0; i < abilityFour(); i++) {
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                enemy.takeDamage(rawDamageDealt, defensePen);
                if ((Math.random() * 100) < 25) {
                    changeSpeedChange(.4 * getCurrentSpeed());
                    System.out.println(name + " received a 40% increase to speed.");
                }
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }
        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .875;
        double coefficientTwo = 1;
        double rawDamageDealt = power * coefficient + speed * coefficientTwo;

        for (int i = 0; i < abilityFour(); i++) {
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemy.getDodgeChance())) {
                enemy.setStunned(true);
                enemy.takeDamage(rawDamageDealt, defensePen);
            } else {
                System.out.println(name + " missed " + enemy.getName() + ".");
            }
        }

        emptyTurnProgress();
    }

    public void abilityThree(Battler[] enemyTeam) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);

        for (Battler enemy : enemyTeam) {
            for (int i = 0; i < abilityFour(); i++) {
                if ((Math.random() * 100) < 50) {
                    abilityOne(enemy);
                    abilityOne(enemy);
                } else {
                    abilityTwo(enemy);
                }
            }
        }

        emptyTurnProgress();
    }

    public int abilityFour() {
        if (didOccur(35)) {
            return 2;
        }
        return 1;
    }
    
    @Override
    public double getCurrentDodge() {
        return 2*(dodge + dodgeChange);
    }
    
}
