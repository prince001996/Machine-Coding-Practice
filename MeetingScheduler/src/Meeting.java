public class Meeting {
    private int day;
    private int startTime;
    private int endTime;
    private Room room;
    
    Meeting(int day, int startTime, int endTime, Room room){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public int getEndTime() {
        return endTime;
    }
}
