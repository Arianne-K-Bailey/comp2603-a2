//Trackable interface for animals that can have sighting logs.

// M3: Define three method signatures:
public interface Trackable {
    // M3: Declare logSighting method
    void logSighting(String date, String location);

    // M3: Declare getSightingCount method
    int getSightingCount();

    // M3: Declare getLastSighting method
    String getLastSighting();
}
