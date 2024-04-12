package hu.progmasters.sovietville.Home;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private double electricityCost;

    public Room(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    public double getElectricityCost() {
        return electricityCost;
    }
}
