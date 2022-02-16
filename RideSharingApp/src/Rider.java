import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class Rider extends Person{
    private int id;
    private List<Ride> allRides;
    private Ride currentRide;
    
    public Rider(int id, String name){
        this.id = id;
        this.name = name;
        allRides = new ArrayList<>();
        currentRide = new Ride();
    }
    
    public int getId() {
        return id;
    }
    
    public void createRide(int id, int origin, int destination, int seats){
        if(origin >= destination){
            System.out.println("Wrong Direction! Can't create ride.");
        }
        Ride currentRide = new Ride();
        currentRide.setId(id);
        currentRide.setOrigin(origin);
        currentRide.setDestination(destination);
        currentRide.setSeats(seats);
        currentRide.setRideStatus(RideStatus.CREATED);
        allRides.add(currentRide);
    }
    
    public void updateRide(int id, int origin, int destination, int seats){
        ListIterator<Ride> rideIterator = allRides.listIterator(allRides.size());
        while(rideIterator.hasPrevious()){
            Ride currentRide = rideIterator.previous();
            if(currentRide.getId() == id){
                if(currentRide.getRideStatus() == RideStatus.WITHDRAWN){
                    System.out.println("Can't update ride as it was withdrawn.");
                    return;
                }
    
                if(currentRide.getRideStatus() == RideStatus.COMPLETED){
                    System.out.println("Can't upadte ride as it was completed.");
                    return;
                }
                currentRide.setOrigin(origin);
                currentRide.setDestination(destination);
                currentRide.setSeats(seats);
                return;
            }
        }
        createRide(id, origin, destination, seats);
    }
    
    public void withdrawRide(int id){
        ListIterator<Ride> rideIterator = allRides.listIterator(allRides.size());
        while(rideIterator.hasPrevious()){
            Ride currentRide = rideIterator.previous();
            if (currentRide.getId() == id) {
                if (currentRide.getRideStatus() != RideStatus.CREATED) {
                    System.out.println("Can't withdraw a ride not in progress.");
                    return;
                }
                currentRide.setRideStatus(RideStatus.WITHDRAWN);
                allRides.remove(currentRide);
                return;
            }
        }
        System.out.println("Wrong id as input. Can't withdraw currentRide.");
        return;
    }
    
    public int closeRide(int id){
        ListIterator<Ride> rideIterator = allRides.listIterator(allRides.size());
        Ride currentRide = null;
        while(rideIterator.hasPrevious()){
            currentRide = rideIterator.previous();
            if (currentRide.getId() == id) {
                if (currentRide.getRideStatus() != RideStatus.CREATED) {
                    System.out.println("Can't close a ride not in progress.");
                    return 0;
                }
                currentRide.setRideStatus(RideStatus.COMPLETED);
                break;
            }
        }
        return currentRide.calculateFare(allRides.size() > 10);
    }
    
}
