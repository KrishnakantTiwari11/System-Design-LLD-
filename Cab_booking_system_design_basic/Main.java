import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabService service = new CabService();
        while (true) {
            System.out.println("1.Register Cab.\n");
            System.out.println("2.Register user.\n");
            System.out.println("3.Book a trip.\n");
            System.out.println("4.End a trip.\n");
            System.out.println("5.Fare price for ongoing trip.\n");
            System.out.println("6.Estimated time for ongoing trip.\n");
            System.out.println("7.Exit cab service \n");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> {
                    System.out.println("Enter Driver name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Driver-ID : ");
                    String ID = sc.nextLine();
                    System.out.println("Enter x co-ordinate of location : ");
                    double x = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter y co-ordinate of location : ");
                    double y = sc.nextDouble();
                    sc.nextLine();
                    Location currLocation = new Location(x, y);
                    Cab cab = new Cab(name, ID, currLocation);
                    service.addCab(cab);
                }
                case 2 -> {
                    System.out.println("Enter Rider name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Rider-ID : ");
                    String ID = sc.nextLine();
                    Rider rider = new Rider(name, ID);
                    service.addRider(rider);
                }
                case 3 -> {
                    System.out.println("Enter Rider-ID : ");
                    String ID = sc.nextLine();
                    System.out.println("Enter source x co-ordinate : ");
                    double sx = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter source y co-ordinate : ");
                    double sy = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter destination x co-ordinate : ");
                    double dx = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter destination y co-ordinate : ");
                    double dy = sc.nextInt();
                    sc.nextLine();
                    Location source = new Location(sx, sy);
                    Location destination = new Location(dx, dy);
                    service.bookCab(ID, source, destination);
                }

                case 4 -> {
                    System.out.println("Enter rider ID to end a trip : ");
                    String id = sc.nextLine();
                    service.endCabTrip(id);
                }
                case 5 -> {
                    System.out.println("Enter ongoing rider's ID for geting fare: ");
                    String id = sc.nextLine();
                    service.getFare(id);
                }
                case 6 -> {
                    System.out.println("Enter ongoing rider's ID for geting estimated time: ");
                    String id = sc.nextLine();
                    service.getEt(id);
                }
                case 7 -> {
                    System.out.println("Exiting...........");
                }
                default -> {
                    System.out.println("Invalid choice.");
                }
            }

        }

    }
}