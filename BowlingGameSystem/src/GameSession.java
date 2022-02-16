import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class GameSession {
    private static int uniqueId = 0;
    @Setter
    private int alley;
    @Setter
    @Getter
    private int id;
    @Setter
    private List<Player> players;
    
    public GameSession(){
        this.alley = -1;
        this.id = getUniqueId();
        players = new ArrayList<>();
    }
    
    
    private int getUniqueId(){
        return uniqueId++;
    }
    
    public boolean declareWinner(){
        int maxScore = 0;
        Player winner = null;
        for(Player player: players){
            if(player.isCanPlay()){
                System.out.println("Match in progress!!");
                return false;
            }
            if(player.getScore() > maxScore){
                maxScore = player.getScore();
                winner = player;
            }
        }
        if(winner != null){
            System.out.println("The winner is : " + winner.getName() + " with the score of " + winner.getScore());
        }
        Game.makeActive(alley);
        
        return true;
    }
    
    public void makeRoll(Player player, int numberOfPins) {
        for(Player p: players){
            if(p.getName().equalsIgnoreCase(player.getName())){
                p.roll(numberOfPins);
            }
        }
        return;
    }
}
