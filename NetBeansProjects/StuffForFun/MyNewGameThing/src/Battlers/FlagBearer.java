package Battlers;

public class FlagBearer extends Battler {

    // constructor
    public FlagBearer() {
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
        name = "Flag Bearer";
        battlerDescription = "A support battler that can stun enemies, and heal and buff party members. His main stats are power and mastery.";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames = new String[4];
        abilityCooldowns = new int[4];
        abilityCooldownsProgress = new int[4];
        abilityDescriptions = new String[4];
        abilityNames[0] = "Banner Smash";
        abilityNames[1] = "Wave Banner";
        abilityNames[2] = "Encourage";
        abilityNames[3] = "Motivational Chant";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 0;
        abilityCooldowns[2] = 2;
        abilityCooldowns[3] = 5;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Smashes the enemy with your team's battle standard and has a 20% chance to stun.";
        abilityDescriptions[1] = "Heals all allies according to power and mastery.";
        abilityDescriptions[2] = "Heals a specific ally greatly according to mastery and power, and lends them his power for a turn.";
        abilityDescriptions[3] = "Increases allies' power and speed by 35% for one round.";
        abilityTargetingMethod[0] = 1;
        abilityTargetingMethod[1] = 4;
        abilityTargetingMethod[2] = 3;
        abilityTargetingMethod[3] = 4;
    }

    public void abilityOne(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.1;
        double rawDamageDealt = power * coefficient;

        if (didCrit()) {
            rawDamageDealt *= critDamage;
            System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
        } else {
            System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
        }

        if (didHit(enemy.getDodgeChance())) {
            if(didOccur(20)){
                enemy.setStunned(true);
            }
            enemy.takeDamage(rawDamageDealt, defensePen);
            takeDamage(damageReturned(rawDamageDealt), enemy.getDefensePen());
        } else {
            System.out.println(name + " missed " + enemy.getName() + ".");
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler[] allyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .6;
        double coefficientTwo = 8;
        double healingDone = power * coefficient + mastery * coefficientTwo;
        
        for (Battler ally : allyTeam) {
            ally.heal(healingDone);
            ally.changePowerChange(power);
        }

        emptyTurnProgress();
    }

    public void abilityThree(Battler ally) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = 1.6;
        double coefficientTwo = 15;
        double healingDone = power * coefficient + mastery * coefficientTwo;
        
        ally.heal(healingDone);
        ally.changePowerChange(power);

        emptyTurnProgress();
    }

    public void abilityFour(Battler[] allyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        
        for (Battler ally : allyTeam) {
            ally.changePowerChange(.35*ally.getPower());
            ally.changeSpeedChange(.35*ally.getSpeed());
        }
        System.out.println("All allies of " + name + " have 35% increased speed and power for a turn.");

        emptyTurnProgress();
    }

}
