import java.util.*;
public class Cab {
    private String driverName;
    private String driverId;
    private Location currentLocation;
    private Boolean isAvailable;

    public Cab(String name, String Id, Location location) {
        this.driverName = name;
        this.driverId = Id;
        this.currentLocation = location;
        isAvailable = true;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverID() {
        return driverId;
    }

    public Location getDriverLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    };

    public void setStatus(boolean status) {
        this.isAvailable = status;
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }

}