package org.example.ParkingLot.Entity;

public class Slot {
    private String type;
    private Vehicle vehicle;

    public Slot(String type, Vehicle vehicle) {
        this.type = type;
        this.vehicle = vehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
