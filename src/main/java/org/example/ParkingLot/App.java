package org.example.ParkingLot;

import org.example.ParkingLot.Service.DisplayService;
import org.example.ParkingLot.Service.ParkingLotService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService(new DisplayService());
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")) break;
            else{
                switch(input){
                    case "create_parking_lot":
                        String pid = sc.next();
                        int floors = sc.nextInt();
                        int slots = sc.nextInt();
                        parkingLotService.create_parking_lot(pid,floors,slots);
                        break;
                    case "park_vehicle":
                        String type = sc.next();
                        String regNo = sc.next();
                        String color = sc.next();
                        parkingLotService.park_vehicle(type,regNo,color);
                        break;
                    case "unpark_vehicle":
                        String tid = sc.next();
                        parkingLotService.unpark_vehicle(tid);
                        break;
                    case "display":
                        String command = sc.next();
                        String vehicleType = sc.next();
                        parkingLotService.display(command,vehicleType);
                        break;
                }
            }
        }
        parkingLotService.create_parking_lot("PR1234",2,6);
    }
}
