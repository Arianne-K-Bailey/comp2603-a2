import java.util.ArrayList;

//Console-based demonstration of the Caribbean Wildlife Conservation Tracker.
//Creates sanctuaries, adds animals, and exercises all major features.


// M9: Implement the entire Driver class
public class Driver {
    public static void main(String[] args) {
        // M9: Create two sanctuaries:
        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Sanctuary blueLagoon = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);

        // M9: Create and add animals to Caroni:
        Bird ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas);


        // M9: Create and add animals to Blue Lagoon:
        Bird flash = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
        Marine shelly = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        Marine gills = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);
        
        blueLagoon.addAnimal(flash);
        blueLagoon.addAnimal(shelly);
        blueLagoon.addAnimal(gills);


        // M9: Print "=== Caroni Bird Sanctuary roster ===" then printRoster()
        System.out.println("=== Caroni Bird Sanctuary roster ===");
        caroni.printRoster();

        System.out.println();
        
        // M9: Print "=== Blue Lagoon Marine Park roster ===" then printRoster()
        System.out.println("=== Blue Lagoon Marine Park roster ===");
        blueLagoon.printRoster();
        
        System.out.println();

        // M9: Print "=== Daily food budgets ===" then each sanctuary's budget
        System.out.println("=== Daily food budgets ===");
        System.out.println(caroni.getName() + ": $" + String.format("%.2f", caroni.getDailyFoodBudget()) + " TTD");
        System.out.println(blueLagoon.getName() + ": $" + String.format("%.2f", blueLagoon.getDailyFoodBudget()) + " TTD");
        
        System.out.println();

        // M9: Print "=== Birds at Caroni ===" then getAnimalsOfType("Bird")
        System.out.println("=== Birds at Caroni ===");
        for (Animal animal : caroni.getAnimalsOfType("Bird")) {
            System.out.println("  " + animal.toString());
        }

        System.out.println();

        // M9: Print "=== Relocatable animals at Caroni ===" then getRelocatableAnimals()
        System.out.println("=== Relocatable animals at Caroni ===");
        for (Animal a : caroni.getRelocatableAnimals()) {
            System.out.println("  " + a.toString());
        }

        System.out.println();

        // M9: Print "=== Sighting logs ===" then:
        //   Log Ruby: ("2026-06-10", "Caroni Swamp"), ("2026-06-12", "Nariva Swamp")
        //   Log Atlas: ("2026-06-11", "Matura Beach")
        //   Print counts and last sightings for Ruby, Atlas, and Brutus
        System.out.println("=== Sighting logs ===");
        
        ruby.logSighting("2026-06-10", "Caroni Swamp");
        ruby.logSighting("2026-06-12", "Nariva Swamp");
        atlas.logSighting("2026-06-11", "Matura Beach");

        System.out.println("Ruby sighting count: " + ruby.getSightingCount());
        System.out.println("Ruby last sighting: " + ruby.getLastSighting());
        System.out.println("Atlas sighting count: " + atlas.getSightingCount());
        System.out.println("Atlas last sighting: " + atlas.getLastSighting());
        System.out.println("Brutus last sighting: " + brutus.getLastSighting());

        System.out.println();

        // M9: Print "=== Transfer Atlas to Blue Lagoon ===" then transfer and print result
        System.out.println("=== Transfer Atlas to Blue Lagoon ===");
        
        boolean atlasTransfer = caroni.transferAnimal(atlas.getAnimalId(), blueLagoon);
        System.out.println("Transfer successful: " + atlasTransfer);

        System.out.println("Blue Lagoon Marine Park roster after transfer:");
        blueLagoon.printRoster();
        
        System.out.println();

        // M9: Print "=== Attempt to transfer Brutus (Reptile) ===" then transfer and print result
        System.out.println("=== Attempt to transfer Brutus (Reptile) ===");

        boolean brutusTransfer = caroni.transferAnimal(brutus.getAnimalId(), blueLagoon);
        System.out.println("Transfer successful: " + brutusTransfer);
        
        System.out.println();

        // M9: Print "=== Most expensive animal at each sanctuary ==="
        System.out.println("=== Most expensive animal at each sanctuary ===");

        Animal caroniExpensive = caroni.getMostExpensiveAnimal();
        Animal blueLagoonExpensive = blueLagoon.getMostExpensiveAnimal();
       
        System.out.println("Caroni: " + caroniExpensive.toString() + " ($" + 
            String.format("%.2f", caroniExpensive.getDailyFoodCostTTD()) + " TTD/day)");

        System.out.println("Blue Lagoon: " + blueLagoonExpensive.toString() + " ($" + 
            String.format("%.2f", blueLagoonExpensive.getDailyFoodCostTTD()) + " TTD/day)");
        
        System.out.println();

        // M9: Print "=== Updated food budgets ==="
        System.out.println("=== Updated food budgets ===");

        System.out.println(caroni.getName() + ": $" + 
            String.format("%.2f", caroni.getDailyFoodBudget()) + " TTD");
        System.out.println(blueLagoon.getName() + ": $" + 
            String.format("%.2f", blueLagoon.getDailyFoodBudget()) + " TTD");
    }
}
