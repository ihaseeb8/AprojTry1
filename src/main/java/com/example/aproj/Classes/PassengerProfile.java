package com.example.aproj.Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PassengerProfile {

    private int passengerCnic;
    private ObservableList<Ride> rides;

    private static PassengerProfile passengerProfile = new PassengerProfile();

    private PassengerProfile() {
        rides = FXCollections.observableArrayList();
        passengerCnic = 0;
    }

    public static PassengerProfile getPassengerProfile(){
        return passengerProfile;
    }

    public ObservableList<Ride> getRides() {
        return rides;
    }

    public void setRides(ObservableList<Ride> rides) {
        this.rides = rides;
    }

    public PassengerProfile(int passengerCnic) {
        this.passengerCnic = passengerCnic;
    }

    public int getPassengerCnic() {
        return passengerCnic;
    }

    public void setPassengerCnic(int passengerCnic) {
        this.passengerCnic = passengerCnic;
    }


    public void addRide(Ride r){
        rides.add(r);
    }

    public void deleteRides(){
        rides.clear();
    }


}