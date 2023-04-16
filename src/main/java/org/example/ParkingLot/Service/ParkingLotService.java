package org.example.ParkingLot.Service;

import org.example.ParkingLot.Entity.*;

import java.util.ArrayList;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private DisplayService displayService;

    public ParkingLotService(DisplayService displayService) {
        this.displayService = displayService;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public DisplayService getDisplayService() {
        return displayService;
    }

    public void setDisplayService(DisplayService displayService) {
        this.displayService = displayService;
    }
    public void create_parking_lot(String pid,int floors,int slots){
        ParkingLot parkingLot1 = new ParkingLot(pid,floors,slots,new ArrayList<>());
        this.setParkingLot(parkingLot1);
        this.parkingLot.initialize();
        System.out.printf("Created parking lot with %d floors and %d slots per floor",
                this.parkingLot.getCountFloors(),this.parkingLot.getCountSlot());
        System.out.println();
    }
    public void park_vehicle(String vehicleType,String regNo,String color){
        boolean flag = false;
        for(int i = 0 ; i < this.parkingLot.getCountFloors() ; i++){
            Floor currFloor = this.parkingLot.getAllFloors().get(i);
            for(int j = 0 ; j < this.parkingLot.getCountSlot() ; j++){
                Slot slot = currFloor.getAllSlot().get(j);
                if(slot.getType().equalsIgnoreCase(vehicleType) && slot.getVehicle() == null){
                    String tid = this.parkingLot.getPid() + "_" + (i+1) + "_" + (j + 1);
                    Ticket ticket = new Ticket(tid);
                    Vehicle vehicle;
                    switch(vehicleType){
                        case "TRUCK":
                            vehicle = new Truck(vehicleType,regNo,color,ticket);
                            break;
                        case "BIKE":
                            vehicle = new Bike(vehicleType,regNo,color,ticket);
                            break;
                        case "CAR":
                            vehicle = new Car(vehicleType,regNo,color,ticket);
                            break;
                        default:
                            System.out.println("Pass Correct Vehicle Type");
                            return;
                    }
                    slot.setVehicle(vehicle);
                    System.out.println("Parked vehicle. Ticket ID: " + tid);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(!flag){
            System.out.println("Parking Lot Full");
        }
    }
    public void unpark_vehicle(String ticketId){
        String[] ticketArr= ticketId.split("_");
        int floorNumber = Integer.parseInt(ticketArr[1]);
        int slotNumber = Integer.parseInt(ticketArr[2]);
        if(floorNumber > this.parkingLot.getCountFloors() || slotNumber > this.parkingLot.getCountSlot() ){
            System.out.println("Invalid Ticket");
            return;
        }
        Floor currFloor = this.parkingLot.getAllFloors().get(floorNumber - 1);
        Slot slot = currFloor.getAllSlot().get(slotNumber - 1);
        if(slot.getVehicle() != null && slot.getVehicle().getTicket().getTid().equalsIgnoreCase(ticketId)){
            Vehicle vehicle = slot.getVehicle();
            System.out.printf("Unparked vehicle with Registration Number: %s and Color: %s",vehicle.getRegNo(),vehicle.getColor());
            System.out.println();
            vehicle.setTicket(null);
            slot.setVehicle(null);
        }
        else {
            System.out.println("Invalid Ticket");
        }
    }
    public void display(String command,String vehicleType){
        switch(command){
            case "free_count":
                this.displayService.freeCount(parkingLot,vehicleType);
                break;
            case "free_slots":
                this.displayService.freeSlots(parkingLot,vehicleType);
                break;
            case "occupied_slots":
                this.displayService.occupiedSlots(parkingLot,vehicleType);
                break;
            default:
                System.out.println("Incorrect Command");
        }
    }

}
