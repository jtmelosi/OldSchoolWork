package Battlers;

public class Battler {

    // random junk that is needed
    protected static final int MAX_NUMBER_OF_LEVELS = 99;
    protected static final int LEVEL_TWO_EXP_REQ = 100;
    protected static final int STAT_POINT_INCREASES_PER_LEVEL = 5;
    protected static final int[] experienceRequirements = new int[MAX_NUMBER_OF_LEVELS - 1]; // requirements for level 2 are in [0]
    protected final double PROGRESS_NEEDED_TO_ACT = 2000;

    // starting stuff
    protected String name;
    protected int level;
    protected int experience;
    protected int statPointIncreases;
    protected boolean ally; // unsure if needed right now

    // stats
    protected double health;
    protected double speed;
    protected double power;
    protected double defense;
    protected double defensePen;
    protected double critRate;
    protected double critDamage;
    protected double dodge;
    protected double accuracy;
    protected double mastery;
    protected double damageReturn;
    protected double flatDamageReduction;

    // current status
    protected double currentHealth;
    protected double currentShields;
    protected double turnProgress;
    protected int[] dotDamage = new int[3];
    protected boolean incapacitated;
    protected boolean stunned;
    protected boolean dead;

    // current stat changes
    protected double speedChange;
    protected double powerChange;
    protected double defenseChange;
    protected double defensePenChange;
    protected double critRateChange;
    protected double dodgeChange;
    protected double accuracyChange;
    protected double damageReturnChange;

    // ability stuff
    protected String[] abilityNames = new String[4];
    protected int[] abilityCooldowns = new int[4];
    protected int[] abilityCooldownsProgress = new int[4];
    protected String[] abilityDescriptions = new String[4];
    protected int activeAbilities;
    protected String battlerDescription;
    protected boolean abilityReady;
    protected int[] abilityTargetingMethod = new int[15];
    // The numbers for targeting are as follows:
    // 0 = none/self        1 = enemy           2 = enemy team
    // 3 = ally             4 = ally team       5 = single enemy and ally team
    // 6 = both teams       7 = ally or enemy   8 = 
    // add 20 to it to include the exact target and own team

    // constructor
    public Battler() {
        name = "";
        level = 1;
        experience = 0;
        statPointIncreases = 0;

        health = 500;
        speed = 40;
        power = 40;
        defense = 20;
        defensePen = 0;
        critRate = .05;
        critDamage = 1.5;
        dodge = .05;
        accuracy = 1;
        mastery = 0;
        damageReturn = 0;

        currentHealth = health;
        dotDamage[0] = 0;
        dotDamage[1] = 0;
        dotDamage[2] = 0;
        incapacitated = false;
        stunned = false;
        dead = false;

        speedChange = 0;
        powerChange = 0;
        defenseChange = 0;
        defensePenChange = 0;
        critRateChange = 0;
        dodgeChange = 0;
        accuracyChange = 0;

        setExperienceRequirements();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getStatPointIncreases() {
        return statPointIncreases;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPower() {
        return power;
    }

    public double getDefense() {
        return defense;
    }

    public double getDefensePen() {
        return defensePen;
    }

    public double getCritRate() {
        return critRate;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public double getDodge() {
        return dodge;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getMastery() {
        return mastery;
    }

    public double getTurnProgress() {
        return turnProgress;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public double getDamageReturn() {
        return damageReturn;
    }

    public int getDotDamageInOneRound() {
        return dotDamage[0];
    }

    public int getDotDamageInTwoRounds() {
        return dotDamage[1];
    }

    public int getDotDamageInThreeRounds() {
        return dotDamage[2];
    }

    public void setAlly(boolean isAlly) {
        ally = isAlly;
    }

    public boolean isAlly() {
        return ally;
    }

    public boolean isIncapacitated() {
        return incapacitated;
    }

    public boolean isStunned() {
        return stunned;
    }

    public boolean isDead() {
        if ((currentHealth > 0) && (dead == true)) {
            dead = false;
            System.out.println(name + " revived!");
        } else if ((dead == false) && (currentHealth < 0)) {
            dead = true;
            changeCurrentHealth((currentHealth) - (2 * health));
        }
        return dead;
    }

    public double getSpeedChange() {
        return speedChange;
    }

    public double getPowerChange() {
        return powerChange;
    }

    public double getDefenseChange() {
        return defenseChange;
    }

    public double getDefensePenChange() {
        return defensePenChange;
    }

    public double getCritRateChange() {
        return critRateChange;
    }

    public double getDodgeChange() {
        return dodgeChange;
    }

    public double getAccuracyChange() {
        return accuracyChange;
    }

    public double getDamageReturnChange() {
        return damageReturnChange;
    }

    public double getCurrentShields() {
        return currentShields;
    }
    
    public double getCurrentHealthPercent(){
        return currentHealth / health;
    }

    public void changeCurrentShields(double currentShieldChange) {
        currentShields += currentShieldChange;
    }

    // setters, changers, and adders
    public void addStatPointIncreases(int addedStatPoints) {
        statPointIncreases += addedStatPoints;
    }

    public void changeCurrentHealth(double currentHealthChange) {
        currentHealth += currentHealthChange;
    }

    public void changeTurnProgress(double turnProgressChange) {
        turnProgress += turnProgressChange;
    }

    public void setIncapacitated(boolean isIncapacitated) {
        incapacitated = isIncapacitated;
    }

    public void setStunned(boolean isStunned) {
        stunned = isStunned;
    }

    public void setDead(boolean isDead) {
        dead = isDead;
    }

    public void changeSpeedChange(double changeInSpeed) {
        speedChange += changeInSpeed;
    }

    public void changePowerChange(double changeInPower) {
        powerChange += changeInPower;
    }

    public void changeDefenseChange(double changeInDefense) {
        defenseChange += changeInDefense;
    }

    public void changeDefensePenChange(double changeInDefensePen) {
        defensePenChange += changeInDefensePen;
    }

    public void changeCritRateChange(double changeInCritRate) {
        critRateChange += changeInCritRate;
    }

    public void changeDodgeChange(double changeInDodge) {
        dodgeChange += changeInDodge;
    }

    public void changeAccuracyChange(double changeInAccuracy) {
        accuracyChange += changeInAccuracy;
    }

    public void changeDotDamageInOneRound(double changedDotDamage) {
        dotDamage[0] += changedDotDamage;
    }

    public void changeDotDamageInTwoRounds(double changedDotDamage) {
        dotDamage[1] += changedDotDamage;
    }

    public void changeDotDamageInThreeRounds(double changedDotDamage) {
        dotDamage[2] += changedDotDamage;
    }

    // adding stats methods
    public void addHealthPoints() {
        health += 40;
        currentHealth += 40;
    }

    public void addSpeed() {
        speed += 2;
    }

    public void addPower() {
        power += 4;
    }

    public void addDefense() {
        defense += 2.5;
    }

    public void addDefensePen() {
        defensePen += 2;
    }

    public void addCritRate() {
        critRate += .015;
    }

    public void addCritDamage() {
        critDamage += .035;
    }

    public void addDodge() {
        dodge += .025;
    }

    public void addAccuracy() {
        accuracy += .02;
    }

    public void addMastery() {
        mastery++;
    }

    public void addDamageReturn() {
        damageReturn += .015;
    }
    
    public void addFlatDamageReduction(){
        flatDamageReduction += 1.5;
    }

    // get current stat value methods
    public double getCurrentSpeed() {
        return speed + speedChange;
    }

    public double getCurrentPower() {
        return power + powerChange;
    }

    public double getCurrentDefense() {
        return defense + defenseChange;
    }

    public double getCurrentDefensePen() {
        return defensePen + defensePenChange;
    }

    public double getCurrentCritRate() {
        return critRate + critRateChange;
    }

    public double getCurrentDodge() {
        return dodge + dodgeChange;
    }

    public double getCurrentAccuracy() {
        return accuracy + accuracyChange;
    }

    public double getCurrentDamageReturn() {
        return damageReturn + damageReturnChange;
    }

    // string methods
    // statusString, toString, statsString, turnProgressString
    public String statusString() {
        String isBattlerStunned;
        if (stunned == true) {
            isBattlerStunned = "Battler is stunned. ";
        } else {
            isBattlerStunned = "Battler isn't stunned. ";
        }

        String isBattlerIncapacitated;
        if (incapacitated == true) {
            isBattlerIncapacitated = "Battler is incapacitated.";
        } else {
            isBattlerIncapacitated = "Battler isn't incapacitated.";
        }

        return (name + " has " + currentHealth + " health out of " + health + ". Turn progress is " + turnProgress + " out of " + PROGRESS_NEEDED_TO_ACT + ".\n"
                + "Shields are at " + currentShields + ". " + isBattlerStunned + isBattlerIncapacitated);
    }

    public String statsString() {
        return (name + "'s unaltered stats are as follows:\n"
                + "Health: " + health + ". "
                + "");
    }

    @Override
    public String toString() {
        return (name + " is level " + level + ", and has " + experience + " out of " + experienceRequirements[level - 1] + " experience towards the next level.");
    }

    public String turnProgressString() {
        return (name + "'s turn progress is currently " + turnProgress + " out of " + PROGRESS_NEEDED_TO_ACT + ".");
    }

    // utility (& multifunctional setter/getter) methods
    public void setExperienceRequirements() {
        for (int i = 0; i < MAX_NUMBER_OF_LEVELS - 1; i++) {
            experienceRequirements[i] = (int) Math.pow(LEVEL_TWO_EXP_REQ, (1 + (i / 7)));
        }
    }

    public void addCustomizedStatPointIncreasePerLevel() {
        // to be implemented in subclasses
    }

    public void alterBaseStats() {
        // to be implemented in subclasses
    }

    public void addLevel() {
        level++;
        addCustomizedStatPointIncreasePerLevel();
        statPointIncreases += STAT_POINT_INCREASES_PER_LEVEL;
    }

    public void changeExperience(int experienceChange) {
        experience += experienceChange;
        checkIfLeveled();
    }

    public void checkIfLeveled() {
        if (experience >= experienceRequirements[level - 1]) {
            addLevel();
        }
    }

    public void updateDotDamage() {
        changeDotDamageInOneRound(-dotDamage[0] + dotDamage[1]);
        changeDotDamageInTwoRounds(dotDamage[1] + dotDamage[2]);
        changeDotDamageInThreeRounds(-dotDamage[2]);
    }

    public void applyDotDamage() {
        if (dotDamage[0] < 0) {
            heal(-dotDamage[0]);
        } else {
            takeTrueDamage(dotDamage[0]);
        }

    }

    public void emptyTurnProgress() {
        turnProgress -= PROGRESS_NEEDED_TO_ACT;
    }

    public void healToFull() {
        currentHealth = health;
    }

    public void listAbilitiesAndCooldowns() {
        for (int i = 0; i < activeAbilities; i++) {
            int turnsLeft = (abilityCooldowns[i] - abilityCooldownsProgress[i]);
            System.out.println(abilityNames[i] + ": " + abilityDescriptions[i] + " Cooldown remaining: " + turnsLeft + " turns.");
        }
    }

    public void progressCooldowns() {
        for (int i = 0; i < activeAbilities; i++) {
            if ((abilityCooldowns[i] - abilityCooldownsProgress[i]) > 0) {
                abilityCooldownsProgress[i]++;
            } else if ((abilityCooldowns[i] - abilityCooldownsProgress[i]) < 0) {
                abilityCooldownsProgress[i] = abilityCooldowns[i];
            }
        }

    }

    public void regressCooldowns() {
        for (int i = 0; i < activeAbilities; i++) {
            if (i == 0) {
                if (i != 0) {
                    abilityCooldownsProgress[i]--;
                }
            }
        }
        System.out.println(getName() + "'s cooldowns have been increased by 1 turn.");
    }

    public void checkCooldown(int abilityNumber) {
        if (((abilityNumber <= activeAbilities) && (abilityNumber >= 1))
                && (abilityCooldownsProgress[abilityNumber] >= abilityCooldowns[abilityNumber])) {
            abilityReady = true;
        }
    }

    public void startTurn() {
        isDead();
        decayNegativeHealth();
        applyDotDamage();
        updateDotDamage();
        decayShields();
        progressCooldowns();
    }

    public void endTurn() {
        abilityReady = false;
        setStunned(false);
        setIncapacitated(false);
        resetTemporaryStats();
    }

    public double getDamageDone(double rawDamageTaken, double defensePenetration) {
        double actualDefense = (defense + defenseChange - defensePenetration);
        double damageTakenModifier;
        if (actualDefense >= 0) {
            damageTakenModifier = (100 / (100 + actualDefense));
        } else {
            damageTakenModifier = 2 - (100 / (100 - actualDefense));
        }
        double actualDamageTaken = rawDamageTaken * damageTakenModifier;

        return actualDamageTaken;
    }

    public void takeDamage(double rawDamageTaken, double defensePenetration) {
        double actualDefense = (defense + defenseChange - defensePenetration);
        double damageTakenModifier;
        if (actualDefense >= 0) {
            damageTakenModifier = (100 / (100 + actualDefense));
        } else {
            damageTakenModifier = 2 - (100 / (100 - actualDefense));
        }
        double actualDamageTaken = rawDamageTaken * damageTakenModifier;

        takeTrueDamage(actualDamageTaken);
    }

    public void takeTrueDamage(double damageTaken) {
        incapacitated = false;
        
        damageTaken -= flatDamageReduction;
        if (damageTaken <= 0) {
            damageTaken = 0;
        }
        
        if (getCurrentShields() == 0) {
            if (getCurrentShields() < damageTaken) {
                System.out.println(name + "'s shields blocked " + (int) currentShields + " damage.");
                damageTaken -= currentShields;
            } else {
                System.out.println(name + "'s shields blocked all the damage (" + (int) damageTaken + ").");
                changeCurrentShields(-damageTaken);
                damageTaken = 0;
            }
        }

        if (damageTaken != 0) {
            changeCurrentHealth(-damageTaken);
        }

        if (damageTaken < 0) {
            if (currentHealth > health) {
                currentHealth = health;
            }
        }

        if (damageTaken > 0) {
            if (currentHealth <= 0) {
                System.out.println(name + " took " + (int) damageTaken + " damage and is now dead.");
                isDead();
            } else {
                System.out.println(name + " took " + (int) damageTaken + " damage and now has " + currentHealth + " health left.");
            }
        }
    }

    public void updateSpeed() {
        double speedToAdd = speed + speedChange;
        changeTurnProgress(speedToAdd);
    }

    public void resetTemporaryStats() {
        speedChange = 0;
        powerChange = 0;
        defenseChange = 0;
        defensePenChange = 0;
        critRateChange = 0;
        dodgeChange = 0;
        accuracyChange = 0;
        damageReturnChange = 0;
    }

    public void decayShields() {
        currentShields *= .75;
    }

    public void decayNegativeHealth() {
        if (currentHealth < 0) {
            currentHealth *= .75;
        }
    }

    public void increaseSpeed() {
        changeTurnProgress(getCurrentSpeed());
    }

    public double getCritChance() {
        return getCurrentCritRate();
    }

    public double getCritChance(double increasedPercent) {
        double chanceToCrit = getCurrentCritRate() + increasedPercent;
        return chanceToCrit;
    }

    public boolean didCrit() {
        if ((Math.random() * 100) < getCritChance()) {
            return true;
        }
        return false;
    }

    public boolean didCrit(double increasedPercent) {
        if ((Math.random() * 100) < getCritChance(increasedPercent)) {
            return true;
        }
        return false;
    }

    public double getHitChance() {
        double chanceToHit = getCurrentAccuracy();
        return chanceToHit;
    }

    public double getHitChance(double increasedPercent) {
        double chanceToHit = getCurrentAccuracy() + (increasedPercent / 100);
        return chanceToHit;
    }

    public double getDodgeChance() {
        return getCurrentDodge();
    }

    public boolean didHit(double dodgeChance) {
        if ((Math.random() * 100) < (getHitChance() - dodgeChance) * 100) {
            return true;
        }
        return false;
    }

    public boolean didHit(double dodgeChance, double increasedPercent) {
        if ((Math.random() * 100) < (getHitChance(increasedPercent) - dodgeChance) * 100) {
            return true;
        }
        return false;
    }

    public double damageReturned(double rawDamageDealt) {
        return rawDamageDealt * getCurrentDamageReturn();
    }

    public void heal(double healingReceived) {
        currentHealth += healingReceived;
        if (currentHealth > health) {
            currentHealth = health;
        }
        System.out.println(name + " received " + (int) healingReceived + " healing, and now has " + (int) currentHealth + " health (" + getCurrentHealthPercent() + "%).");
    }
    
    public boolean didOccur(double percentChance){
        return (Math.random() * 100) < percentChance;
    }

}
