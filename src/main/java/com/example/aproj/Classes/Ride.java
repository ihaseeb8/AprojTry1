package com.example.aproj.Classes;


public class Ride {

    int rideId;
    int driverID;
    int passengerId;
    int vehicleId;
    int fare;
    String dropOff;
    String pickUp;
    String status;

    public Ride() {
        this.rideId = 0;
        driverID = 0;
        passengerId = 0;
        vehicleId = 0;
        fare = 0;
        dropOff = "";
        pickUp = "";
        status ="notBooked";
    }

    public Ride(int driverID, int vehicleId, int fare, String dropOff, String pickUp) {
        this.rideId = 0;
        this.driverID = driverID;
        passengerId = 0;
        this.vehicleId = vehicleId;
        this.fare = fare;
        this.dropOff = dropOff;
        this.pickUp = pickUp;
        this.status = "notBooked";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
