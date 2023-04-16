package org.example.ParkingLot.Entity;

import java.util.List;

public class Floor {
    private List<Slot> allSlot;
    private int number;

    public Floor(List<Slot> allSlot, int number) {
        this.allSlot = allSlot;
        this.number = number;
    }

    public List<Slot> getAllSlot() {
        return allSlot;
    }

    public void setAllSlot(List<Slot> allSlot) {
        this.allSlot = allSlot;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

