public class Trip {
    private String driverId;
    private String riderId;
    private Location source;
    private Location destination;

    public Trip(String dId, String rId, Location sLocation, Location dLocation) {
        this.driverId = dId;
        this.riderId = rId;
        this.source = sLocation;
        this.destination = dLocation;
    }

    // Getters
    public String getDriverId() {
        return driverId;
    }

    public String getRiderId() {
        return riderId;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    // Setters
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Rider: " + riderId + " is riding cab: " + driverId;
    }

    public double getFare() {
        double distance = source.getDistance(destination);
        double result = 10 + distance * 15;
        return result;
    }

    public double getET() {
        double distance = source.getDistance(destination);
        double time = Math.ceil(distance / 0.5);
        return time;
    }
}