import java.util.List;
import java.util.ListIterator;

public class App {
    private int driversCount;
    List<Rider> riders;
    private boolean isEnoughDriversAndRiders;
    
    App(int driversCount, List<Rider> riders){
        isEnoughDriversAndRiders = true;
        if(driversCount < 2 || riders.size() < 2){
            System.out.println("Not enough drivers or riders");
            isEnoughDriversAndRiders = false;
        }
        this.driversCount = driversCount;
        this.riders = riders;
    }
    
    
    
    
    
    public boolean createRide(int riderId, int rideId, int origin, int destination, int seats){
        if(isEnoughDriversAndRiders){
            if (driversCount == 0) {
                System.out.println("No drivers around. Can't create rider.");
                return false;
            }
        
            for (Rider rider : riders) {
                if (rider.getId() == riderId) {
                    rider.createRide(rideId, origin, destination, seats);
                    driversCount--;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void updateRide(int riderId, int rideId, int origin, int destination, int seats){
        for(Rider rider: riders){
            if(rider.getId() == riderId){
                rider.updateRide(rideId, origin, destination, seats);
                return;
            }
        }
    }
    
    public void withdrawRide(int riderId, int rideId){
        for(Rider rider: riders){
            if(rider.getId() == riderId){
                rider.withdrawRide(rideId);
                driversCount++;
                return;
            }
        }
    }
    
    public int closeRide(int riderId, int rideId){
        for(Rider rider: riders){
            if(rider.getId() == riderId){
                driversCount++;
                return rider.closeRide(rideId);
            }
        }
        return 0;
    }
    
}
