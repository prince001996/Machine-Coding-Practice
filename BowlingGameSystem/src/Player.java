import lombok.Getter;

public class Player {
    private static final int MAX_ROLLS_ALLOWED = 23;
    @Getter
    private String name;
    @Getter
    private int score;
    private int[] rolls;
    private boolean isFirstRoll;
    private int frameIndex;
    @Getter
    private boolean canPlay;
    private int currentRoll;
    
    Player(String name){
        this.name = name;
        this.score = 0;
        this.rolls = new int[MAX_ROLLS_ALLOWED];
        this.isFirstRoll = true;
        this.frameIndex = 0;
        this.canPlay = true;
        this.currentRoll = 0;
    }
    
    public void roll(int numberOfPins){
        if(!this.canPlay){
            return;
        }
        rolls[currentRoll] = numberOfPins;
        currentRoll++;
        updateScore();
    
    }
    
    private void updateScore() {
        if(isStrike()){
            score += 20;
            rolls[currentRoll] = 0;
            currentRoll++;
            frameIndex += 2;
            if(frameIndex >= MAX_ROLLS_ALLOWED){
                this.canPlay = false;
            }
        }
        else{
            if(frameIndex >= MAX_ROLLS_ALLOWED - 1){
                score += rolls[frameIndex];
                this.canPlay = false;
            }
            else if(isFirstRoll){
                isFirstRoll = false;
            }
            else{
                if(isSpare()) {
                    score += 5;
                }
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
                isFirstRoll = true;
                if(frameIndex >= MAX_ROLLS_ALLOWED - 3){
                    this.canPlay = false;
                }
            }
        }
    }
    
    public boolean isStrike(){
        return (this.isFirstRoll && rolls[frameIndex]==10);
    }
    
    public boolean isSpare(){
        return (this.rolls[frameIndex] + this.rolls[frameIndex + 1] == 10);
    }
    
    
}
