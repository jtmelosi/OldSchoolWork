


package runTheGame;




public class Player {
    
    private static String name;
    private static int coins;
    private static int numberOfCharacters;
    
    public Player(String newName, int newNumberOfCharacters){
        name = newName;
        numberOfCharacters = newNumberOfCharacters;
        coins = 1500-((newNumberOfCharacters-1)*750);
    }
    
    
}
