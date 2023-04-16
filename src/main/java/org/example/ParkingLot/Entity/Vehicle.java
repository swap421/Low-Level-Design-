package org.example.ParkingLot.Entity;

public abstract class Vehicle {
    private String type;
    private String regNo;
    private String color;
    private Ticket ticket;

    public Vehicle(String type, String regNo, String color, Ticket ticket) {
        this.type = type;
        this.regNo = regNo;
        this.color = color;
        this.ticket = ticket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
