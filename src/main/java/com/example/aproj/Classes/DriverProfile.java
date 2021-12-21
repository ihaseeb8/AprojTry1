package com.example.aproj.Classes;

import com.example.aproj.DBHandlers.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DriverProfile {

    private int driverCnic;
    private ObservableList<Vehicle> vehicles ;
    private ObservableList<Ride> rides;

    private static DriverProfile driverProfile = new DriverProfile();

    private DriverProfile() {
        vehicles = FXCollections.observableArrayList();
        rides = FXCollections.observableArrayList();
        driverCnic = 0;
    }

    public static DriverProfile getDriverProfile(){
        return driverProfile;
    }

    public ObservableList<Ride> getRides() {
        return rides;
    }

    public void setRides(ObservableList<Ride> rides) {
        this.rides = rides;
    }

    public DriverProfile(int driverCnic) {
        this.driverCnic = driverCnic;
    }

    public int getDriverCnic() {
        return driverCnic;
    }

    public void setDriverCnic(int driverCnic) {
        this.driverCnic = driverCnic;
    }

    public void addVehicle(Vehicle v){

        for (Vehicle tabPane : vehicles){
            if(tabPane.getVehicleId() == v.getVehicleId())
                return;
        }

        vehicles.add(v);
        DBConnection.getDBConnection().insertVehicle(v);

    }

    public void addRide(Ride r){

        if(r.getRideId() == 0) {
            DBConnection.getDBConnection().registerRide(r);
            r.setRideId(DBConnection.getDBConnection().getlastrideid());
            rides.add(r);
        }
        else
        {
            if(rides.isEmpty())
            {
                rides.add(r);
            }
            else
            {
                if(r.getRideId() > rides.get(rides.size()-1).rideId)
                {
                    rides.add(r);
                }
            }
        }

    }

    public void deleteVehicle(Vehicle v){
        vehicles.remove(v);
    }

    public void deleteVehicles(){
       vehicles.clear();
    }

    public void deleteRides(){
        rides.clear();
    }

    public ObservableList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ObservableList<String> getVehiclesNames(){

        ObservableList<String> vehString = FXCollections.observableArrayList();

        for (Vehicle tabPane : vehicles){
            vehString.add( tabPane.getName() +"("+ tabPane.getVehicleId() + ")");
            //System.out.println(tabPane.getName() +"("+ tabPane.getVehicleId() + ")");
        }
        return vehString;

    }

    public void setVehicles(ObservableList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}