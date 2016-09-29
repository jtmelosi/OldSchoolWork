


package SetTheGameUp;




public class Player {
    
    private static String name;
    private static int coins;
    private static final int[][] stageProgress = new int[5][3]; // [number of stages][number of battles in each stage]
    
    public Player (String newName){
        name = newName;
        coins = 1500-((SetupBattlers.getNumberOfBattlers()-1)*375);
    }
    
    public static String getName(){
        return name;
    }
    
    
    
}
