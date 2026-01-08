package labs.lab7;

public class Truck extends Vehicle {
    private double loadCapacityInTons;

    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
        super(plateNumber, model, year);
        this.loadCapacityInTons = loadCapacityInTons;
    }

    public double getLoadCapacityInTons() {
        return loadCapacityInTons;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() +
               " [Capacity: " + loadCapacityInTons + " tons]";
    }

    @Override
    public double calculateRentalPrice(int days) {
        double dailyRate = 90.0 + (10.0 * loadCapacityInTons);
        return dailyRate * days;
    }

    @Override
    public double calculateInsurancePremium(int days) {
        return getBaseInsuranceRate() * 1.50 * days;
    }

    public static void printVehicleType() {
        System.out.println("Truck");
    }
}