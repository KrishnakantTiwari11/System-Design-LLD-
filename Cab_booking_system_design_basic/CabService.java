import java.util.*;
public class CabService {
    private List<Rider> riders;
    private List<Cab> cabs;
    private Map<String, Trip> ongoingTrips;

    public CabService() {
        this.cabs = new ArrayList<>();
        this.riders = new ArrayList<>();
        this.ongoingTrips = new HashMap<String, Trip>();
    }

    public void addRider(Rider rider) {
        riders.add(rider);
        System.out.println(rider.getRiderName() + " rider logged in successfully! Book ur trip now.");
    }

    public void addCab(Cab cab) {
        cabs.add(cab);
        System.out.println(cab.getDriverName() + " driver registered Successfully!");
    }

    public void bookCab(String riderid, Location source, Location destination) {
        Rider currRider = null;
        for (Rider temprider : riders) {
            if (riderid.equals(temprider.getRiderId())) {
                currRider = temprider;
                break;
            }
        }
        if (currRider == null) {
            System.out.println("Kindly log in first to use cab booking service.");
            return;
        }
        Cab nearestLocationCab = null;
        double minDist = Double.MAX_VALUE;

        for (Cab tempCab : cabs) {
            if (tempCab.isAvailable()) {
                double tempDist = tempCab.getDriverLocation().getDistance(source);
                if (tempDist < minDist) {
                    minDist = tempDist;
                    nearestLocationCab = tempCab;
                }
            }
        }
        if (nearestLocationCab == null) {
            System.out.println("Cabs not available for now,try again in few minutes.");
        } else {
            nearestLocationCab.setStatus(false);
            Trip currTrip = new Trip(nearestLocationCab.getDriverID(), riderid, source, destination);
            ongoingTrips.put(riderid, currTrip);
            System.out.println(currTrip);
        }
    }

    public void endCabTrip(String riderId) {
        Trip trip = ongoingTrips.remove(riderId);
        if (trip != null) {
            for (Cab cab : cabs) {
                if (cab.getDriverID().equals(trip.getDriverId())) {
                    cab.setStatus(true);
                    cab.setLocation(trip.getDestination());
                }
            }
            System.out.println("Rider: " + riderId + " Driver: " + trip.getDriverId() + " Trip ended successfully");
        } else {
            System.out.println("There is no ongoing trip with rider-ID : " + riderId);
        }

    }

    public void getFare(String riderid) {
        Trip trip = ongoingTrips.get(riderid);
        if (trip != null) {
            double result = trip.getFare();
            System.out.println("The fare of given rider with rider-ID is : " + result);
        } else {
            System.out.println("Can't get fare.There is no ongoing trip with rider-ID : " + riderid);
        }
    }

    public void getEt(String riderid) {
        Trip trip = ongoingTrips.get(riderid);
        if (trip != null) {
            double result = trip.getET();
            System.out.println("The estimated time for trip with rider-ID is : " + result);
        } else {
            System.out.println("Can't get Estimated time.There is no ongoing trip with rider-ID : " + riderid);
        }
    }

}
