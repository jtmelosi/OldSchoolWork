package Battlers;

public class Lifebender extends Battler {

    // constructor
    public Lifebender() {
        super();
        alterBaseStats();
        setDescriptionAndAbilites();
    }

    public void addCustomizedStatPointIncreasePerLevel() {
        // specific implementation
    }

    public void alterBaseStats() {
        // specific implementation
    }

    public void setDescriptionAndAbilites() {
        name = "Lifebender";
        battlerDescription = "A tanky support hero with many heals and shields. Mastery increases all shields and heals.\n"
                + "Main stats are health, power, and mastery.";
        activeAbilities = 4;
        abilityReady = false;
        abilityNames[0] = "Vitality Swap";
        abilityNames[1] = "Siphon Life";
        abilityNames[2] = "Sacrificial Guardian";
        abilityNames[3] = "Restoration Through Destruction";
        abilityCooldowns[0] = 0;
        abilityCooldowns[1] = 4;
        abilityCooldowns[2] = 2;
        abilityCooldowns[3] = 6;
        abilityCooldownsProgress[0] = abilityCooldowns[0];
        abilityCooldownsProgress[1] = abilityCooldowns[1];
        abilityCooldownsProgress[2] = abilityCooldowns[2];
        abilityCooldownsProgress[3] = abilityCooldowns[3];
        abilityDescriptions[0] = "Attacks a random enemy three times, stealing 5% of their max health each attack and giving it to a random ally.";
        abilityDescriptions[1] = "Deals 10% of own max health to an enemy, and self-heals for 20% of own max health, plus up to another 10% based on how much health is currently missing.";
        abilityDescriptions[2] = "Sacrifices 37.5% of own max health to shield two allies for 25% of own max health each.";
        abilityDescriptions[3] = "Continually steals random enemies' health to restore own until reaching 100% or all enemies are dead.";
        abilityTargetingMethod[0] = 2;
        abilityTargetingMethod[1] = 1;
        abilityTargetingMethod[2] = 4;
        abilityTargetingMethod[3] = 2;
    }

    public void abilityOne(Battler[] enemyTeam, Battler[] allyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .05;
        

        for (int i = 0; i < 3; i++) {
            int enemyIndex = (int) (enemyTeam.length * Math.random());
            double rawDamageDealt = enemyTeam[enemyIndex].getHealth() * coefficient;
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }

            if (didHit(enemyTeam[enemyIndex].getDodgeChance())) {//
                enemyTeam[enemyIndex].takeDamage(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemyTeam[enemyIndex].getDefensePen());
                int allyIndex = (int) (enemyTeam.length * Math.random());
                allyTeam[allyIndex].heal(getDamageDone(rawDamageDealt, defensePen) * getHealingBoost());
            } else {
                System.out.println(name + " missed " + enemyTeam[enemyIndex].getName() + ".");
            }
        }

        emptyTurnProgress();
    }

    public void abilityTwo(Battler enemy) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .1;
        double rawDamageDealt = coefficient * getHealth();
        
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
            
            heal(getHealth() * .2  * getHealingBoost());
            heal((1 - (getCurrentHealth()/getHealth())) * (.1 * getHealth()) * getHealingBoost());

        abilityCooldownsProgress[1] = 0;
        emptyTurnProgress();
    }

    public void abilityThree(Battler[] allyTeam) {//
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .25;
        
        takeTrueDamage(getHealth()*.375);
        
        for(int i = 0; i < 2; i++){
            int allyIndex = (int) (allyTeam.length * Math.random());
            allyTeam[allyIndex].changeCurrentShields(getHealth() * coefficient * getHealingBoost());
        }

        abilityCooldownsProgress[2] = 0;
        emptyTurnProgress();
    }

    public void abilityFour(Battler[] enemyTeam, Battler[] allyTeam) {
        System.out.println(name + " uses " + abilityNames[0] + ":\n" + abilityDescriptions[0]);
        double coefficient = .25;
        double coefficientTwo = .01;
        
        // if over 100% DR on the enemy, this ability can actually kill self, but is unlikely
        while((getHealth() > getCurrentHealth()) && (getCurrentHealth() > 0)){
            int enemyIndex = (int) (enemyTeam.length * Math.random());
            double rawDamageDealt = (power * coefficient) + (health * coefficientTwo);
            if (didCrit()) {
                rawDamageDealt *= critDamage;
                System.out.println(name + " critically attacks for " + (int) rawDamageDealt + " raw damage.");
            } else {
                System.out.println(name + " attacks for " + (int) rawDamageDealt + " raw damage.");
            }
            
            if (didHit(enemyTeam[enemyIndex].getDodgeChance())) {//
                enemyTeam[enemyIndex].takeDamage(rawDamageDealt, defensePen);
                takeDamage(damageReturned(rawDamageDealt), enemyTeam[enemyIndex].getDefensePen());
                heal(getDamageDone(rawDamageDealt, defensePen) * getHealingBoost());
            }
        }

        abilityCooldownsProgress[3] = 0;
        emptyTurnProgress();
    }

    
    private double getHealingBoost(){
        if((1 + (mastery / 50)) > 1)
            return 1 + (mastery / 50);
        return 1;
    }
}
