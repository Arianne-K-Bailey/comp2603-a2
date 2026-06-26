//Relocatable interface for animals that can be transferred between islands.

//M3: Define three method signatures:
public interface Relocatable {
    // M3: Declare canRelocateTo method
    boolean canRelocateTo(String targetIsland);

    // M3: Declare getRelocationCost method
    double getRelocationCost();

    // M3: Declare relocateTo method
    void relocateTo(String island);
}
