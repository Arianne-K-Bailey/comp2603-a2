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

    // M7: Implement getAnimalsOfType - Returns a new ArrayList containing only
    // animals of the given type.
    public ArrayList<Animal> getAnimalsOfType(String type) {
        // M7: Filter by getType()
        ArrayList<Animal> result = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getType().equals(type)) {
                result.add(animal);
            }
        }

        return result;
    }

    // M7: Implement getDailyFoodBudget
    // Returns the total daily food cost for all animals, rounded to 2 decimal
    // places.
    public double getDailyFoodBudget() {
        // M7: Sum getDailyFoodCostTTD() for all animals
        double total = 0.0;

        for (Animal animal : animals) {
            total += animal.getDailyFoodCostTTD();
        }

        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * Returns all animals that implement the Relocatable interface.
     * Hint: use instanceof.
     *
     * M8: Implement getRelocatableAnimals
     */
    public ArrayList<Animal> getRelocatableAnimals() {
        // M8: Filter using instanceof Relocatable
        ArrayList<Animal> relocatableAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal instanceof Relocatable) {
                relocatableAnimals.add(animal);
            }
        }

        return relocatableAnimals;
    }

    // M7: Implement getMostExpensiveAnimal
    // Returns the animal with the highest daily food cost, or null if empty.
    public Animal getMostExpensiveAnimal() {
        // M7: Find max by getDailyFoodCostTTD()
        if (animals.isEmpty()) {
            return null;
        }

        Animal mostExpensive = animals.get(0);

        for (Animal animal : animals) {
            if (animal.getDailyFoodCostTTD() > mostExpensive.getDailyFoodCostTTD()) {
                mostExpensive = animal;
            }
        }

        return mostExpensive;
    }

    /**
     * Transfers an animal to another sanctuary.
     * If the animal does not implement Relocatable, the transfer fails:
     * re-add the animal to this sanctuary and return false.
     * Otherwise, call relocateTo on the animal, then addAnimal on target.
     *
     * M8: Implement transferAnimal
     */
    public boolean transferAnimal(int animalId, Sanctuary target) {
        // M8: Remove animal, check Relocatable, relocate, add to target
        Animal animal = removeAnimal(animalId);

        if (animal == null) {
            return false;
        }

        if (!(animal instanceof Relocatable)) {
            addAnimal(animal); 
            return false;
        }

        Relocatable relocatable = (Relocatable) animal;
        relocatable.relocateTo(target.getIsland());     

        if (!target.addAnimal(animal)) {
            relocatable.relocateTo(this.getIsland());
            addAnimal(animal);
            return false;
        }

        return true;
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
