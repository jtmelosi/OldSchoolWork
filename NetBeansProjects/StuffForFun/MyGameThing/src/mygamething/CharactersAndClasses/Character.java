// finish bottom stat getters
// change up the percent getters at bottom

package mygamething.CharactersAndClasses;

public class Character {
    
    // starting stuff
    public static String name;
    public static int level;
    public static int experience;
    public static int statPointIncreases;

    // very base stats
    public static double maxHealthPoints;
    public static double healthRegen;
    public static double maxManaPoints;
    public static double manaRegen;
    public static double maxStaminaPoints;
    public static double staminaRegen;
    public static double maxFaithPoints;
    public static double faithRegen;
    
    // the current state of base stats
    public static double currentHealth;
    public static double currentMana;
    public static double currentStamina;
    public static double currentFaith;

    // gear and class dependant stats
    public static double armor; // 
    public static double magicArmor; // 
    public static double quickness; // how far you move per turn

    // upgradeable stats
    public static double strength;        // phys damage, crushing hit, block, and phys pen
    public static double fortitude;       // health and block potential
    public static double toughness;       // health and overall damage resistance
    public static double recovery;        // stamina regen and health regen
    public static double speed;           // how fast your turn comes
    public static double physicalDefense; // reduces phys damage
    public static double magicDefense;    // reduces magic damage
    public static double determination;   // phys armor pen, block potential, block break, and crushing hit damage
    public static double willpower;       // magic armor pen and mana
    public static double resolve;         // health regen
    public static double agility;         // dodge and block
    public static double skill;           // ranged damage, crit damage, crushing hit, hit, and parry
    public static double precision;       // ranged damage, phys crit, and hit
    public static double manipulation;    // crit damage and crushing hit damage
    public static double intelligence;    // spell power, mana, spell crit
    public static double faith;           // heal effectiveness, max mana, mana regen, and magic pen
    public static double willingness;     // healing recieved modifier

    // status effects
    public static boolean dead = false;
    public static boolean stunned = false;
    public static boolean resting = false;
//    public static boolean name  = false;
    
    public Character(String newName) {
        name = newName;
        level = 1;
        experience = 0;
        statPointIncreases = 0;
        
        // base stats
        maxHealthPoints = 0; // 
        healthRegen = 0; // 
        maxManaPoints = 0; // 
        manaRegen = 0; // 
        maxStaminaPoints = 0; // 
        staminaRegen = 0; // 
        maxFaithPoints = 0; // 
        faithRegen = 0; // 

        // gear and class dependant stats
        armor = 0; // 
        magicArmor = 0; // 
        quickness = 1.0; // how far you move per turn

        // upgradeable stats
        strength = 30; 
        fortitude = 30;
        toughness = 30;
        recovery = 30; 
        speed = 5;
        physicalDefense = 30; 
        magicDefense = 30; 
        determination = 30; 
        willpower = 30; 
        resolve = 30; 
        agility = 30; 
        skill = 30;         
        precision = 30; 
        manipulation = 30; 
        intelligence = 30;  
        faith = 30; 
        willingness = 30; 
        
        
        // now to set all the stats that depend on previous stats
        setMaxHealthPoints();
        setMaxManaPoints();
        setMaxStaminaPoints();
        setMaxFaithPoints();
        setHealthRegen();
        setManaRegen();
        setStaminaRegen();
        setFaithRegen(); // if(getCurrentHealth()>=(getMaxHealthPoints*.5)){setCurrentFaith(getFaithRegen());}
        setCurrentStatusStatsToMax();
    }
    
    // setters
    public static void addOneLevel() {
        level++;
    }

    public static void addExperience(int change) {
        experience += change;
    }

    public static void setMaxHealthPoints() {
        // 21+90+39=150 base
        maxHealthPoints = 21 + (fortitude*3) + (toughness*1.3);
    }

    public static void setHealthRegen() {
        // 4.5+10.5-5=10 base
        healthRegen = (resolve*.15)+(recovery*.35)-5;
    }

    public static void setMaxManaPoints() {
        // 60+30+45+15=150 base
        maxManaPoints = (intelligence*2)+(willpower*1)+(faith*1.5)+15;
    }

    public static void setManaRegen() {
        // 9+15+3-17=10 base
        manaRegen = (willingness*.3)+(faith*.5)+(intelligence*.1)-17;
    }

    public static void setMaxStaminaPoints() {
        // 90+60=150 base
        maxStaminaPoints = 90+(2*fortitude);
    }

    public static void setStaminaRegen() {
        // 6+4=10 base
        staminaRegen = (recovery*.2)+4;
    }

    public static void setMaxFaithPoints() {
        // 45+5=50 base
        maxFaithPoints = (faith*(5/3));
    }

    public static void setFaithRegen() {
        // 25=25 base
        faithRegen = (faith*(5/6));
    }
    
    public static void setCurrentStatusStatsToMax() {
        currentHealth = maxHealthPoints;
        currentMana = maxManaPoints;
        currentStamina = maxStaminaPoints;
        currentFaith = maxFaithPoints;
    }
    
    //
    public static void setCurrentHealth(double change) {
        
        currentHealth += change;
    }

    public static void setCurrentMana(double change) {
        
        currentMana += change;
    }

    public static void setCurrentStamina(double change) {
        
        currentStamina += change;
    }

    public static void setCurrentFaith(double change) {
        
        currentFaith += change;
    }
    
    //
    public static void setArmor(double change) {
        armor += change;
    }

    public static void setMagicArmor(double change) {
        magicArmor += change;
    }

    public static void setQuickness(double change) {
        quickness += change;
    }
    
    // 
    public static void addStrength() {
        
        strength++;
    }

    public static void addFortitude() {
        
        fortitude++;
    }

    public static void addToughness() {
        
        toughness++;
    }

    public static void addRecovery() {
        recovery++;
    }

    public static void addSpeed(double change) {
        speed+=change;
    }

    public static void addPhysicalDefense() {
        physicalDefense++;
    }

    public static void addMagicalDefense() {
        magicDefense++;
    }

    public static void addDetermination() {
        determination++;
    }

    public static void addWillpower() {
        willpower++;
    }

    public static void addResolve() {
        resolve++;
    }

    public static void addAgility() {
        
        agility++;
    }

    public static void addSkill() {
        
        skill++;
    }

    public static void addPrecision() {
        precision++;
    }

    public static void addManipulation() {
        manipulation++;
    }

    public static void addIntelligence() {
        intelligence++;
    }

    public static void addFaith() {
        faith++;
    }

    public static void addWillingness() {
        willingness++;
    }
    
    
    // getters
    public static String getName() {
        return name;
    }

    public static int getLevel() {
        return level;
    }

    public static int getExperience() {
        return experience;
    }

    public static double getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public static double getHealthRegen() {
        return healthRegen;
    }

    public static double getMaxManaPoints() {
        return maxManaPoints;
    }

    public static double getManaRegen() {
        return manaRegen;
    }

    public static double getMaxStamina() {
        return maxStaminaPoints;
    }

    public static double getStaminaRegen() {
        return staminaRegen;
    }

    public static double getMaxFaithPoints() {
        return maxFaithPoints;
    }

    public static double getFaithPointRegen() {
        return faithRegen;
    }

    public static double getCurrentHealth() {
        return currentHealth;
    }

    public static double getCurrentMana() {
        return currentMana;
    }

    public static double getCurrentStamina() {
        return currentStamina;
    }
    
    public static double getCurrentFaithPoints() {
        return currentFaith;
    }

    public static double getArmor() {
        return armor;
    }

    public static double getMagicArmor() {
        return magicArmor;
    }

    public static double getQuickness() {
        return quickness;
    }

    public static double getStrength() {
        return strength;
    }

    public static double getForitude() {
        return fortitude;
    }

    public static double getToughness() {
        return toughness;
    }

    public static double getRecovery() {
        return recovery;
    }

    public static double getSpeed() {
        return speed;
    }

    public static double getPhysicalDefense() {
        return physicalDefense;
    }

    public static double getMagicalDefense() {
        return magicDefense;
    }

    public static double getDetermination() {
        return determination;
    }

    public static double getWillpower() {
        return willpower;
    }

    public static double getResolve() {
        return resolve;
    }

    public static double getAgility() {
        return agility;
    }

    public static double getSkill() {
        return skill;
    }

    public static double getPrecision() {
        return precision;
    }

    public static double getManipulation() {
        return manipulation;
    }

    public static double getIntelligence() {
        return intelligence;
    }

    public static double getFaith() {
        return faith;
    }

    public static double getWillingness() {
        return willingness;
    }
    
    //
    public static double getMeleePhysicalPower() {
        // 60-20=40 base
        return (strength*2)-20;
    }
    
    public static double getRangedPhysicalPower() {
        // 60+36-56=40 base
        return (skill*2)+(precision*1.2)-56;
    }
    
    public static double getMagicPower() {
        // 60-20=40 base
        return (intelligence*2)-20;
    }
    
    public static double getPhysicalCritChance() {
        // (10+90)/1000=.1 base
        return ((precision/3)+90)/1000;
    }
    
    public static double getMagicCritChance() {
        // (6+94)/1000=.1 base
        return ((intelligence/5)+94)/1000;
    }
    
    public static double getCritDamage() {
        // (45+105)/100=1.5 base
        return ((manipulation*1.5)+105)/100;
    }
    
    public static double getCrushingHitChance() {
        // (6+10+84)/1000=.1 base
        return ((strength/5)+(skill/3)+94)/1000;
    }
    
    public static double getCrushingHitDamage() {
        // (30+85)/100=1.15 base
        return ((determination*.25)+(manipulation*.75)+85)/100;
    }
    
    public static double getBlockChance() {
        // (30+30+90)/1000=.15 base
        return ((strength)+(agility)+90)/1000;
    }
    
    public static double getBlockPercent() {
        // (15+10+30+75)/100=1.3 base
        return ((fortitude/2)+(determination/3)+(manipulation)+75)/100;
    }
    
    public static double getDodgeChance() {
        // (45+5)/1000=.05
        return ((agility*1.5)+5)/1000;
    }
    
    public static double getParryChance() {
        // (++)/1000=.05 base
        return ((skill)+(resolve*.5)+5)/1000;
    }
    
    public static double getPhysicalDamageReduction() {
        // 
        return (physicalDefense)+(armor);
    }
    
    public static double getMagicDamageReduction() {
        // 
        return (magicDefense)+(magicArmor);
    }
    
    public static double getPhysicalPenetration() {
        // 
        return (determination)+(strength);
    }
    
    public static double getMagicPenetration() {
        // 
        return (willpower)+(faith);
    }
    
    public static double getHealingDonePercent() {
        // 
        return (faith);
    }
    
    public static double getHealingTakenPercent() {
        // 10+90=100 base
        return (willingness/3)+90;
    }
    
    public static double getHitChance() {
        // 
        return (precision)+(skill);
    }
    
    public static double getBlockBreak() {
        // 
        return (determination);
    }
    
    
    
    //
    public static boolean isDead() {
        return dead;
    }

    public static boolean isStunned() {
        return stunned;
    }

    public static boolean isResting() {
        return resting;
    }
    
    //
    public static void setDead(boolean isDead) {
        dead = isDead;
    }

    public static void setStunned(boolean isStunned) {
        stunned = isStunned;
    }

    public static void setResting(boolean isResting) {
        resting = isResting;
    }
}
