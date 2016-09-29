package bigExample;
    
    
public class Player {
    
    
    
    // These are the attributes of this class. They can't directly be accessed from other classes
    // because they are private. Here I am just decalaring them, and not initializing them.
    private String name; // Declaring is basically just saying you are creating them.
    private int chips, turnsLeft; // Initializing them is giving them a value.
    private double baseMultiplier, multiplier; // Like here & above, you can declare 2 on the same line.
    private final int STARTING_CHIPS = 300;// This int is final, so its name
                                           // IS_IN_ALL_CAPS_AND_UNDERLINES_ARE_SPACES
                                           // , and it also can't be changed, ever.
    
    // This is a constructor, and it just pretty much starts off a class with info.
    // I made multiple constructors that require different information to do slightly different things.
    // Doing this is called "Overloading" a method.
      // This first one is the baseline constructor with no special changes to it.
    public Player(){
        name = "";
        chips = STARTING_CHIPS;
        turnsLeft = 0;
        baseMultiplier = 1.0;
        multiplier = baseMultiplier;
    } // The second one allows you to decide how many chips to start off with.
    public Player(int chosenStartingChips){
        name = "";
        chips = chosenStartingChips;
        turnsLeft = 0;
        baseMultiplier = 1.0;
        multiplier = baseMultiplier;
    } // The third one allows you to decide what the base multiplier will be for gaining chips.
    public Player(double chosenMultiplier){
        name = "";
        chips = STARTING_CHIPS;
        turnsLeft = 0;
        baseMultiplier = chosenMultiplier;
        multiplier = baseMultiplier;
    } // This one allows you to both choose starting chips and the base multiplier.
    public Player(int chosenStartingChips, double chosenMultiplier){
        name = "";
        chips = chosenStartingChips;
        turnsLeft = 0;
        baseMultiplier = chosenMultiplier;
        multiplier = baseMultiplier;
    }
    
    // These are the getters. They will tell you the value of what a player's attribute is.
    public String getName(){
        return name;
    }
    
    public int getChips(){
        return chips;
    }
    
    public int getTurnsLeftThisRound(){
        return turnsLeft;
    }
    
    public double getMultiplier(){
        return multiplier;
    }
    
    public double getBaseMultiplier(){
        return baseMultiplier;
    }
    
    public int getStartingChips(){
        return STARTING_CHIPS;
    }
    
    // These are the setters. They will allow you to change the values of a player's attributes.
    public void setTurns(int newAmountOfTurns){
        turnsLeft = newAmountOfTurns;
    }
    
    public void setMutliplier(double newMultiplier){
        multiplier = newMultiplier;
    }
    
    public void changeChips(int chipChange){
        chips = chips + chipChange;
    }
    
    public void setChips(int chipsNow){
        chips = chipsNow;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    // These are utility methods. They're just anything else you might need this class to do.
    public void addATurn(){
        turnsLeft++;
    }
    public void subtractATurn(){
        turnsLeft--;
    }
    
}
