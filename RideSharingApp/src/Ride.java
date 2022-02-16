public class Ride {
    private int id;
    private int origin;
    private int destination;
    private int seats;
    private RideStatus rideStatus;
    
    private static final int AMOUNT_PER_KM = 20;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setOrigin(int origin) {
        this.origin = origin;
    }
    
    public void setDestination(int destination) {
        this.destination = destination;
    }
    
    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
    
    public int getId() {
        return id;
    }
    
    public RideStatus getRideStatus() {
        return rideStatus;
    }
    
    public int calculateFare(boolean isPrefferredRider){
        int distanceTravelled = destination - origin;
        if(seats >= 2){
            return (int) (AMOUNT_PER_KM * distanceTravelled * seats * (isPrefferredRider ? 0.5 : 0.75));
        }
        return (int) (AMOUNT_PER_KM * distanceTravelled * seats * (isPrefferredRider ? 0.75 : 1));
    }
    
    
}
