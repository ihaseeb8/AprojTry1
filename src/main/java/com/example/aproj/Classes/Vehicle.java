package com.example.aproj.Classes;

public class Vehicle {
    private int vehicleId;
    private int driverCnic;
    private String name;
    private String model;
    private String make;

    public Vehicle(){
        this.vehicleId = 0;
        this.driverCnic = 0;
        this.name = "";
        this.model = "";
        this.make = "";
    }

    public Vehicle(int vehicleId, int driverCnic, String carName, String model, String make) {
        this.vehicleId = vehicleId;
        this.driverCnic = driverCnic;
        this.name = carName;
        this.model = model;
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDriverCnic() {
        return driverCnic;
    }

    public void setDriverCnic(int driverCnic) {
        this.driverCnic = driverCnic;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
