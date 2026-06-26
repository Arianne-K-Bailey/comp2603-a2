/**
 * Marine subclass. Implements Trackable and Relocatable.
 *
 * TODO M3: Make this class implement Trackable and Relocatable
 */
public class Marine extends Animal /* TODO M3: implements Trackable, Relocatable */ {
    // M2: Declare private fields: maxDepthM (double), tankSizeLitres (int)
    private double maxDepthM;
    private int tankSizeLitres;

    // M2: Implement constructor that calls super() and sets Marine-specific fields
    public Marine(String species, String nickname, String island, double weightKg, String healthStatus,
            double maxDepthM, int tankSizeLitres) {
        // M2: Call super constructor
        super(species, nickname, island, weightKg, healthStatus);

        // M2: Set maxDepthM and tankSizeLitres
        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }

    // M2: Write getMaxDepthM() and getTankSizeLitres() getters
    public double getMaxDepthM() {
        return this.maxDepthM;
    }

    public int getTankSizeLitres() {
        return this.tankSizeLitres;
    }

    // M2: Implement getType() - returns "Marine"
    public String getType() {
        return "Marine";
    }

    // M2: Implement getDailyFoodCostTTD() - Daily food cost = 50.0 + weightKg * 3.0
    public double getDailyFoodCostTTD() {
        return 50.0 + getWeightKg() * 3.0;
    }

    // --- Trackable methods ---
    // TODO M4: Implement logSighting(String date, String location)

    // TODO M4: Implement getSightingCount()

    // TODO M4: Implement getLastSighting()

    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    // Returns true only if targetIsland is NOT the animal's current island

    // TODO M6: Implement getRelocationCost()
    // Returns 2000.0 + tankSizeLitres * 5.0

    // TODO M6: Implement relocateTo(String island)
    // Updates the island using setIsland()
}
