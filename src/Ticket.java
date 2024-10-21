public class Ticket {

    private int ticketID;
    private int slotNumberOnParking;
    private final long startTime = System.currentTimeMillis();
    private final Vehicle vehicle;

    public Ticket(int ticketID, int slotNumberOnParking, Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }

    public long calculateParkingDuration() {
        return System.currentTimeMillis() - startTime;
    }

    public double calculateCost(CostCalculator calculator) {
        return calculator.getCost(calculateParkingDuration(), vehicle.getCostRate());
    }

    public Vehicle Ticket() {
        return vehicle;
    }
}
