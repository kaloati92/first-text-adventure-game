package hu.progmasters.sovietville.Home;

public enum Device {
    FRIDGE(1.5),
    STOVE(1.2),
    TV(1),
    COMPUTER(0.7);
    public final double electricityCost;

    private Device(double electricityCost) {
        this.electricityCost = electricityCost;
    }

    public double getElectricityCost() {
        return electricityCost;
    }
}
