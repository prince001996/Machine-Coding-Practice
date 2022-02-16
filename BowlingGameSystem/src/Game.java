import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<Integer, GameSession> gameSessions;
    public static List<Integer> alleys = new ArrayList<>();
    
    static{
        for(int i=0; i<4; i++) {
            alleys.add(i);
        }
    }
    
    Game(){
        gameSessions = new HashMap<>();
    }
    
    public static void makeActive(int alley){
        alleys.add(alley);
    }
    
    public int createSession(List<Player> players){
        if(alleys.size() == 0){
            System.out.println("All alleys are occupied");
            return 0;
        }
        
        GameSession gameSession = new GameSession();
        // will be added later to alleys list when a winner is declared for the game and the game ends
        gameSession.setAlley(alleys.remove(0));
        gameSession.setPlayers(players);
    
        gameSessions.put(gameSession.getId(), gameSession);
        return gameSession.getId();
    }
    
    public void roll(int gameSessionId, Player player, int numberOfPins){
        GameSession gameSession = gameSessions.get(gameSessionId);
        gameSession.makeRoll(player, numberOfPins);
    }
    
    public boolean decalerWinner(int gameSessionId){
        boolean winnerFlag = gameSessions.get(gameSessionId).declareWinner();
        if(!winnerFlag){
            System.out.println("No winners yet!!");
        }
        return winnerFlag;
    }
    
}
