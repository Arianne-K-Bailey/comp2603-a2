import java.util.ArrayList;

//Abstract base class for all animals in the conservation system.

public abstract class Animal {
    // M1: Declare static nextId field, starting at 1
    private static int nextId = 1;

    // M1: Declare private fields:
    // animalId (int), species (String), nickname (String),
    // island (String), weightKg (double), healthStatus (String)
    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;

    // M4: Declare private ArrayList<String> sightings field
    private ArrayList<String> sightings;

    /**
     * Constructor: assigns auto-incremented ID, validates all parameters.
     * Species, nickname, island must not be null or empty.
     * weightKg must be > 0.
     * healthStatus must be "Healthy", "Injured", or "Critical".
     *
     * M4: Initialize sightings list
     */

    // M1: Implement constructor with validation
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        // M1: Validate parameters and assign fields
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be null or empty.");
        }

        if (nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("Nickname cannot be null or empty.");
        }

        if (island == null || island.trim().isEmpty()) {
            throw new IllegalArgumentException("Island cannot be null or empty.");
        }

        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }

        if (!healthStatus.equals("Healthy")
                && !healthStatus.equals("Injured")
                && !healthStatus.equals("Critical")) {
            throw new IllegalArgumentException("Invalid health status.");
        }

        // M1: Auto-assign animalId from nextId, then increment nextId
        this.animalId = nextId++;

        this.species = species;
        this.nickname = nickname;
        this.island = island;
        this.weightKg = weightKg;
        this.healthStatus = healthStatus;

        // M4: Initialize sightings ArrayList
        this.sightings = new ArrayList<>();
    }

    // M1: Write getters for all fields
    public int getAnimalId() {
        return this.animalId;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getIsland() {
        return this.island;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }

    // M2: Write setIsland(String island) method
    public void setIsland(String island) {

    }

    // M4: Write getSightings() getter that returns the ArrayList<String>
    protected ArrayList<String> getSightings() {
        return this.sightings;
    }

    // M1: Implement updateHealth - Updates the health status after validation.
    public void updateHealth(String newStatus) {
        // M1: Validate newStatus and update the field
        if (!newStatus.equals("Healthy")
                && !newStatus.equals("Injured")
                && !newStatus.equals("Critical")) {
            throw new IllegalArgumentException("Invalid health status.");
        }

        this.healthStatus = newStatus;
    }

    // M2: Declare as abstract - Returns the animal type: "Bird", "Reptile", or "Marine".
    public abstract String getType();

    // M2: Declare as abstract - Returns the daily food cost in TTD. Varies by subclass.
    public abstract double getDailyFoodCostTTD();

    // M1: Implement toString - String.format: "#%03d %s '%s' (%s) [%s] %.2f kg - %s"
    // Example: "#001 Scarlet Ibis 'Ruby' (Trinidad) [Bird] 0.35 kg - Healthy"
    @Override
    public String toString() {
        // M1: Return formatted string
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s",
                getAnimalId(), getSpecies(), getNickname(), getIsland(), getType(), getWeightKg(), getHealthStatus());
    }

    // M5: Implement equals - Two animals are equal if they have the same animalId.
    @Override
    public boolean equals(Object obj) {
        // M5: Implement equality by animalId
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Animal other = (Animal) obj;
        return animalId == other.animalId;
    }

    // M5: Implement hashCode based on animalId
    @Override
    public int hashCode() {
        // M5: Return hash based on animalId
        return Integer.hashCode(animalId);
    }
}
