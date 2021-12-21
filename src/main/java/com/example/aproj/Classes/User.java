package com.example.aproj.Classes;

public class User {

    private int cnic;
    private String name;
    private String email;
    private String phoneNo;
    private String password;
    private DriverProfile driverProfile;
    private PassengerProfile passengerProfile;

    private static User user = new User();

    private User(){
        name = null;
        email = null;
        phoneNo = null;
        password = null;
        driverProfile=null;
        passengerProfile = null;
    }

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public PassengerProfile getPassengerProfile() {
        return passengerProfile;
    }

    public void setPassengerProfile(PassengerProfile passengerProfile) {
        this.passengerProfile = passengerProfile;
    }

    public static User getUser(){
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

}
