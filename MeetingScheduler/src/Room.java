import java.util.ArrayList;

public class Room {
    private String name;
    private Calendar calendar;
    
    Room(String name){
        this.name = name;
        calendar = new Calendar();
    }
    
    
    public String getName() {
        return name;
    }
    
    public boolean book(int day, int startTime, int endTime){
        if(calendar.containsKey(day)){
            for (Meeting meeting : calendar.get(day)) {
                if (meeting.getStartTime() < endTime && startTime < meeting.getEndTime()) {
                    return false;
                }
            }
        }
        Meeting meeting = new Meeting(day, startTime, endTime, this);
        if(calendar.containsKey(day)){
            calendar.get(day).add(meeting);
        }
        else{
            calendar.put(day, new ArrayList<>());
            calendar.get(day).add(meeting);
        }
        return true;
    }
    
}
