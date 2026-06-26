import java.util.ArrayList;

//Manages a collection of animals at a single location.

public class Sanctuary {
    // M5: Declare private fields:
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    // M5: Implement constructor
    public Sanctuary(String name, String island, int capacity) {
        // M5: Initialize all fields, create empty ArrayList
        this.name = name;
        this.island = island;
        this.capacity = capacity;

        this.animals = new ArrayList<>();
    }

    // M5: Write getters for name, island, capacity, and animals
    public String getName() {
        return this.name;
    }

    public String getIsland() {
        return this.island;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    /**
     * Adds an animal to this sanctuary.
     * Rejects null animals, rejects if at capacity, rejects if animal's island
     * does not match this sanctuary's island.
     *
     * M5: Implement addAnimal
     */
    public boolean addAnimal(Animal a) {
        // M5: Validate and add
        if ((a == null) || (animals.size() >= capacity) || (!a.getIsland().equals(island)))
            return false;

        animals.add(a);
        return true;
    }

    /**
     * Removes and returns the animal with the given ID, or null if not found.
     * M5: Implement removeAnimal
     */
    public Animal removeAnimal(int animalId) {
        // M5: Find by ID, remove, and return
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalId() == animalId) {
                return animals.remove(i);
            }
        }

        return null;
    }

    // M5: Implement getAnimalCount
    public int getAnimalCount() {
        return animals.size();
    }

    /**
     * Returns a new ArrayList containing only animals of the given type.
     *
     * TODO M7: Implement getAnimalsOfType
     */
    public ArrayList<Animal> getAnimalsOfType(String type) {
        // TODO M7: Filter by getType()
        return new ArrayList<Animal>();
    }

    /**
     * Returns the total daily food cost for all animals, rounded to 2 decimal
     * places.
     *
     * TODO M7: Implement getDailyFoodBudget
     */
    public double getDailyFoodBudget() {
        // TODO M7: Sum getDailyFoodCostTTD() for all animals
        return 0.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     * TODO M8: Implement getRelocatableAnimals
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        // TODO M8: Filter using instanceof Relocatable
        return new ArrayList<Animal>();
    }

    /**
     * Returns the animal with the highest daily food cost, or null if empty.
     *
     * TODO M7: Implement getMostExpensiveAnimal
     */
    public Animal getMostExpensiveAnimal() {
        // TODO M7: Find max by getDailyFoodCostTTD()
        return null;
    }

    /**
     * Transfers an animal to another sanctuary.
     * If the animal does not implement Relocatable, the transfer fails:
     * re-add the animal to this sanctuary and return false.
     * Otherwise, call relocateTo on the animal, then addAnimal on target.
     *
     * TODO M8: Implement transferAnimal
     */
    public boolean transferAnimal(int animalId, Sanctuary target) {
        // TODO M8: Remove animal, check Relocatable, relocate, add to target
        return false;
    }

    // M5: Implement printRoster - Prints each animal's toString, indented by 2
    // spaces.
    public void printRoster() {
        for (Animal animal : animals) {
            System.out.println("  " + animal.toString());
        }
    }

    /**
     * Format: "Name (Island) [count/capacity animals]"
     * Example: "Caroni Bird Sanctuary (Trinidad) [12/50 animals]"
     * M5: Implement toString
     */
    @Override
    public String toString() {
        return String.format("%s (%s) [%d/%d animals]", getName(), getIsland(), getAnimalCount(), getCapacity());
    }
}
