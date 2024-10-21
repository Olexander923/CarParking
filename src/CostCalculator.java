public class CostCalculator {
     private double costRate;


    public CostCalculator(double costRate) {
        this.costRate = costRate;
    }

    public double getCost(long parkingDuration, double costRate) {
        return parkingDuration * costRate;
    }
}
