


package classInfo;



public class City {
    
    protected final static int NUMBER_OF_NATURAL_DISASTERS = 4;
    protected final static int NUMBER_OF_SEASONS = 4;
    
    protected static int numberOfCities = 0;
    protected static int year = 0;
    protected static int season = 1; // 1 is Winter, 2 is Spring, 3 is Summer, 4 is Fall
    
    protected String name;
    protected int cityNumber;
    protected int populationInHundreds;
    protected boolean coastal;
    protected double safetyRating;
    protected boolean[] naturalDisaster = new boolean[NUMBER_OF_NATURAL_DISASTERS]; // 1:flood, 2:earthquake, 3:tornado, 4:hurricane
    
    // constructors - these create the object (it creates whatever the class is, so these specific ones make a new city)
    public City(){ // this is a normal constructor wit no extra information given to create it
        numberOfCities++;
        name = "Default Inland City";
        cityNumber = numberOfCities;
        populationInHundreds = 10;
        coastal = false;
        safetyRating = 4;
        
        removeNaturalDisasters();
    }
    
    public City(String name, int population, boolean onCoast, double safety){ // this is an overloaded method for a constructor
        numberOfCities++;
        this.name = name;
        cityNumber = numberOfCities;
        populationInHundreds = population;
        coastal = onCoast;
        safetyRating = safety;
        
        removeNaturalDisasters();
    }
    
    public City(boolean onCoast){ // this is a specific constructor to create a city on the coast
        numberOfCities++;
        name = "Default Coastal City";
        cityNumber = numberOfCities;
        populationInHundreds = 10;
        coastal = true;
        safetyRating = 4;
        
        removeNaturalDisasters();
    }

    // getters - these are used in other classes to retrieve the value of a variable in this class
    public static int getNumberOfCities() {
        return numberOfCities;
    }

    public static int getYear() {
        return year;
    }
    
    public int getSeason() {
        return season;
    }
    
    public String getName() {
        return name;
    }

    public int getPopulationInHundreds() {
        return populationInHundreds;
    }

    public boolean isCoastal() {
        return coastal;
    }

    public double getSafetyRating() {
        return safetyRating;
    }
    
    public boolean hasFlood(){
        return naturalDisaster[0];
    }
    
    public boolean hasEarthquake(){
        return naturalDisaster[1];
    }
    
    public boolean hasTornado(){
        return naturalDisaster[2];
    }
    
    public boolean hasHurricane(){
        return naturalDisaster[3];
    }
    
    // setters - these are used to change the value of a variable that is in this class when called from an outside class
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulationInHundreds(int populationInHundreds) {
        this.populationInHundreds = populationInHundreds;
    }

    public void setCoastal(boolean coastal) {
        this.coastal = coastal;
    }

    public void setSafetyRating(double safetyRating) {
        this.safetyRating = safetyRating;
    }
    
    public void setFlood(boolean isOngoing){
        naturalDisaster[0] = isOngoing;
    }
    
    public void setEarthquake(boolean isOngoing){
        naturalDisaster[1] = isOngoing;
    }
    
    public void setTornado(boolean isOngoing){
        naturalDisaster[2] = isOngoing;
    }
    
    public void setHurricane(boolean isOngoing){
        naturalDisaster[3] = isOngoing;
    }
    
    // utility methods - these are everything else you will need - you want to keep these organized if possible
    public static void advanceSeason(){
        if(season == NUMBER_OF_SEASONS){
            advanceYear();
        }
        season = (season%NUMBER_OF_SEASONS) + 1;
    }
    
    public static void advanceYear(){
        year++;
    }
    
    public static String outputDateAndYear(){
        
        String seasonString;
        switch(season){
            case 1: 
                seasonString = "Winter";
                break;
            case 2: 
                seasonString = "Spring";
                break;
            case 3: 
                seasonString = "Summer";
                break;
            case 4: 
                seasonString = "Fall";
                break;
            default:
                return ("Something fucked up getting the correct season.");
        }
        
        return ("It's " + seasonString + " of year " + year + ".");
    }
    
    public String getNaturalDisasters() {
        String returnString = (name + " is currently experiencing the following disasters:\n");
        if(naturalDisaster[0]==true)
            returnString += "A flood.\n";
        if(naturalDisaster[1]==true)
            returnString += "An earthquake.\n";
        if(naturalDisaster[2]==true)
            returnString += "A tornado.\n";
        if(naturalDisaster[3]==true)
            returnString += "A hurricane.";
        return returnString;
    }
    
    public final void removeNaturalDisasters(){
        for(int i = 0; i<NUMBER_OF_NATURAL_DISASTERS; i++){
            naturalDisaster[i] = false;
        }
    }
    
    @Override
    public String toString(){
        String stringToReturn = "City name: " + name + "\n"
                + "City number: " + cityNumber + "\n"
                + "Population in hundreds: " + populationInHundreds + "\n"
                + "Is coastal: ";
        if(coastal==true){
            stringToReturn+="True\n";
        }else{
            stringToReturn+="False\n";
        }
        stringToReturn += "Safety rating: " + safetyRating + "/10\n";
        stringToReturn += getNaturalDisasters();
        
        return stringToReturn;
    }
    
}
