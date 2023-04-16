package org.example.ParkingLot.Entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String pid;
    private int countFloors;
    private int countSlot;
    private List<Floor> allFloors;

    public ParkingLot(String pid, int countFloors, int countSlot, List<Floor> allFloors) {
        this.pid = pid;
        this.countFloors = countFloors;
        this.countSlot = countSlot;
        this.allFloors = allFloors;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getCountFloors() {
        return countFloors;
    }

    public void setCountFloors(int countFloors) {
        this.countFloors = countFloors;
    }

    public int getCountSlot() {
        return countSlot;
    }

    public void setCountSlot(int countSlot) {
        this.countSlot = countSlot;
    }

    public List<Floor> getAllFloors() {
        return allFloors;
    }

    public void setAllFloors(List<Floor> allFloors) {
        this.allFloors = allFloors;
    }
    public void initialize(){
        for(int i = 0 ; i < this.countFloors ; i++){
            Floor floor = new Floor(new ArrayList<>(),i+1);
            for(int j = 0 ; j < this.countSlot ; j++){
                Slot slot;
                if(j == 0) {
                    slot = new Slot("TRUCK",null);
                }
                else if(j < 3){
                    slot = new Slot("BIKE",null);
                }
                else {
                    slot = new Slot("CAR", null);
                }
                floor.getAllSlot().add(slot);
            }
            this.allFloors.add(floor);
        }
    }
}
