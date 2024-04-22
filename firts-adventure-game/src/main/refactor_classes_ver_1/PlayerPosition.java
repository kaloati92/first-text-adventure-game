package refactor_classes_ver_1;

public class PlayerPosition {
    private String currentLocation; // Ez lehet enum is, ha szigorúbban kezelnéd a helyszíneket.

    public PlayerPosition(String startLocation) {
        this.currentLocation = startLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}
