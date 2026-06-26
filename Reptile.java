/**
 * Reptile subclass. Implements Trackable but NOT Relocatable.
 *
 * TODO M3: Make this class implement Trackable
 */
public class Reptile extends Animal /* TODO M3: implements Trackable */ {
    // M2: Declare private fields: isVenomous (boolean), lengthCm (double)
    private boolean isVenomous;
    private double lengthCm;

    // M2: Implement constructor that calls super() and sets Reptile-specific fields
    public Reptile(String species, String nickname, String island, double weightKg, String healthStatus,
            boolean isVenomous, double lengthCm) {
        // M2: Call super constructor
        super(species, nickname, island, weightKg, healthStatus);

        // M2: Set isVenomous and lengthCm
        this.isVenomous = isVenomous;
        this.lengthCm = lengthCm;
    }

    // M2: Write isVenomous() and getLengthCm() getters
    public boolean isVenomous() {
        return this.isVenomous;
    }

    public double getLengthCm() {
        return this.lengthCm;
    }

    // M2: Implement getType() - returns "Reptile"
    public String getType() {
        return "Reptile";
    }

    // M2: Implement getDailyFoodCostTTD() - Daily food cost = 25.0 + weightKg * 2.0
    public double getDailyFoodCostTTD() {
        return 25.0 + getWeightKg() * 2.0;
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)

    // TODO M4: Implement getSightingCount()

    // TODO M4: Implement getLastSighting()
}
