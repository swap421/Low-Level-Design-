package org.example.ParkingLot.Service;

import org.example.ParkingLot.Entity.Floor;
import org.example.ParkingLot.Entity.ParkingLot;
import org.example.ParkingLot.Entity.Slot;

import java.util.ArrayList;
import java.util.List;

public class DisplayService {
    public void freeCount(ParkingLot parkingLot,String vehicleType){
        List<Floor> allFloor = parkingLot.getAllFloors();
        for(int i = 0 ; i < allFloor.size() ; i++){
            Floor currFloor = allFloor.get(i);
            List<Slot> allSlot = currFloor.getAllSlot();
            int emptySlot = 0;
            for (Slot slot : allSlot) {
                if (slot.getType().equalsIgnoreCase(vehicleType) && slot.getVehicle() == null) {
                    emptySlot++;
                }
            }
            System.out.printf("No. of free slots for %s on Floor %s: %s",vehicleType,i+1,emptySlot);
            System.out.println();
        }
    }
    public void freeSlots(ParkingLot parkingLot,String vehicleType){
        List<Floor> allFloor = parkingLot.getAllFloors();
        for(int i = 0 ; i < allFloor.size() ; i++){
            Floor currFloor = allFloor.get(i);
            List<Slot> allSlot = currFloor.getAllSlot();
            List<Integer> slotNumber = new ArrayList<>();
            for (int j = 0; j < allSlot.size(); j++) {
                Slot slot = allSlot.get(j);
                if (slot.getType().equalsIgnoreCase(vehicleType) && slot.getVehicle() == null) {
                    slotNumber.add(j+1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0 ; k < slotNumber.size() ; k++){
                if(k < slotNumber.size() - 1) sb.append(slotNumber.get(k)).append(",");
                else sb.append(slotNumber.get(k));
            }
            String sn = sb.toString();
            System.out.printf("Free slots for %s on Floor %s: %s",vehicleType,i+1,sn);
            System.out.println();
        }
    }
    public void  occupiedSlots(ParkingLot parkingLot,String vehicleType){
        List<Floor> allFloor = parkingLot.getAllFloors();
        for(int i = 0 ; i < allFloor.size() ; i++){
            Floor currFloor = allFloor.get(i);
            List<Slot> allSlot = currFloor.getAllSlot();
            List<Integer> slotNumber = new ArrayList<>();
            for (int j = 0; j < allSlot.size(); j++) {
                Slot slot = allSlot.get(j);
                if (slot.getType().equalsIgnoreCase(vehicleType) && slot.getVehicle() != null) {
                    slotNumber.add(j+1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0 ; k < slotNumber.size() ; k++){
                if(k < slotNumber.size() - 1) sb.append(slotNumber.get(k)).append(",");
                else sb.append(slotNumber.get(k));
            }
            String sn = sb.toString();
            System.out.printf("Occupied slots for %s on Floor %s: %s",vehicleType,i+1,sn);
            System.out.println();
        }
    }
}
