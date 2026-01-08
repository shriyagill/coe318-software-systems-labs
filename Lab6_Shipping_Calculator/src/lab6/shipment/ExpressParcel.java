package lab6.shipment;

class ExpressParcel extends StandardParcel {
    private final boolean sameDay;

    public ExpressParcel(double weightKg, double distanceKm, boolean insured,
                         String sizeTier, boolean sameDay) {
        // Call parent constructor to initialize weight, distance, insured, and sizeTier
        super(weightKg, distanceKm, insured, sizeTier);
        this.sameDay = sameDay;
    }

    @Override
    public double shippingCost() {
        // Build on Standard cost using super.shippingCost()
        double cost = super.shippingCost();
        
        // Express surcharge: faster delivery multiplier + optional same-day fee
        cost *= 1.35; // express speed premium (35% increase)
        
        // Add same-day delivery fee if requested
        if (sameDay) {
            cost += 7.50;
        }
        
        return cost;
    }
}