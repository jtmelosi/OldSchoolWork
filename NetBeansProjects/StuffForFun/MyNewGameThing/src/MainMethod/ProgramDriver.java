

package MainMethod;


public class ProgramDriver {
    
    public static void main(String[] args) {
        
        // this bit sets up the game
        if(!SetTheGameUp.DecideToLoad.decideToLoad()){ // this is if they don't load
            SetTheGameUp.SetupBattlers.setupOwnBattlers();
            SetTheGameUp.SetupPlayer.setupPlayer();
        } else { // this is if they do load
            SetTheGameUp.LoadBattlerTeam.setupAndLoadTeam();
        } //1 8 18 are the ones done so far
        
        // this bit plays the game
        
        
    }
    
}
