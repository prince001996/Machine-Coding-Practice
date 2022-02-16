import java.util.List;

public class Scheduler {
    private List<Room> rooms;
    
    Scheduler(List<Room> rooms){
        this.rooms = rooms;
    }
    
    public String book(int day, int startTime, int endTime){
        for(Room room: rooms){
            boolean isBookedSuccessfully = room.book(day, startTime, endTime);
            if(isBookedSuccessfully){
                return room.getName();
            }
        }
        return "No rooms available!";
    }
}
