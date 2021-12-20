package com.example.aproj;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static java.lang.Integer.parseInt;

class DBConnection {

    private static DBConnection obj=new DBConnection();

    private DBConnection(){

    }

    public static DBConnection getDBConnection(){
        return obj;
    }

    public boolean searchVehicle(String vehicleId){
        try
        {//step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT vehicleId FROM ap.vehicles WHERE vehicleId = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, vehicleId);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String idFetched = rs.getString("vehicleId"); // by column name matchin

                if( parseInt(idFetched ) == parseInt(vehicleId) ) {
                    return true;
                }

            }

            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean searchUser(String cnic){

        try
        {
                //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
                //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT cnic FROM ap.users WHERE cnic = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cnic);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String cnicFetched = rs.getString("cnic"); // by column name matchin

                if( parseInt(cnicFetched ) == parseInt(cnic) ) {
                       return true;
                }

            }

            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean getUser(String cnic){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.users WHERE cnic = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cnic);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                User.getUser().setCnic( Integer.valueOf(rs.getString("cnic"))); // by column name matchin
                User.getUser().setName(rs.getString("name"));
                User.getUser().setEmail(rs.getString("email"));
                User.getUser().setPassword(rs.getString("password"));
                User.getUser().setPhoneNo(rs.getString("phoneNo"));

                if( parseInt(rs.getString("cnic")) == parseInt(cnic) ) {
                    return true;
                }

            }
            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean getVehicles(String cnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.vehicles WHERE driverCnic = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(DriverProfile.getDriverProfile().getDriverCnic()));
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Vehicle v = new Vehicle();
                v.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                v.setDriverCnic(Integer.valueOf(rs.getString("driverCnic")));
                v.setName(rs.getString("name"));
                v.setModel(rs.getString("model"));
                v.setMake(rs.getString("make"));

                if( parseInt(rs.getString("driverCnic")) == parseInt(cnic) ) {
                    DriverProfile.getDriverProfile().addVehicle(v);
                }

            }
            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public int getlastrideid(){
        int id = -1;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT rideId FROM ap.ride";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                id = (Integer.valueOf(rs.getString("rideId")));
                System.out.println("id" + id);
            }
            con.close();
            return id;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return id;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return id;
        }

    }

    public boolean getRides(String cnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE driverId = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(DriverProfile.getDriverProfile().getDriverCnic()));
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));

                if( parseInt(rs.getString("driverId")) == parseInt(cnic) ) {
                        DriverProfile.getDriverProfile().addRide(r);
                }

            }
            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }

    public ObservableList<Ride> getAvailableRides(){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "SELECT * FROM ap.ride WHERE status = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "notBooked");
            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));

                returnlist.add(r);
            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Ride> getBookedRides(int driverCnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE status = 'Booked' AND driverId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(driverCnic));

            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                returnlist.add(r);

            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Ride> getPassengerBookedRides(int passengerCnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE status = 'Booked' AND passengerId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(passengerCnic));

            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                returnlist.add(r);

            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Ride> getAcceptedRides(int driverCnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE status = 'Accepted' AND driverId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(driverCnic));

            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                returnlist.add(r);

            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Ride> getFinishedRides(int driverCnic){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE driverId = ? AND (status = 'Finished' OR status = 'Cancelled' OR status = 'notBooked') ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(driverCnic));

            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                returnlist.add(r);

            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public ObservableList<Ride> getPassengerFinishedRides(int passengerCnic){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE passengerId = ? AND (status = 'Finished' OR status = 'Cancelled') ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(passengerCnic));

            ResultSet rs = statement.executeQuery();

            ObservableList<Ride> returnlist = FXCollections.observableArrayList();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));
                returnlist.add(r);

            }
            con.close();
            return returnlist;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return null;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return null;
        }
    }

    public boolean acceptRide(int rideId){
        System.out.println(String.valueOf(rideId));
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "UPDATE ap.ride SET status = 'Accepted' WHERE rideId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(rideId));

            statement.executeUpdate();

            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }

    public boolean finishRide(int rideId){

        System.out.println(String.valueOf(rideId));
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "UPDATE ap.ride SET status = 'Finished' WHERE rideId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(rideId));

            statement.executeUpdate();

            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public boolean cancelRide(int rideId){
        System.out.println(String.valueOf(rideId));
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "UPDATE ap.ride SET status = 'Cancelled' WHERE rideId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(rideId));

            statement.executeUpdate();

            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public boolean getPassengerRides(String cnic){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.ride WHERE passengerId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(PassengerProfile.getPassengerProfile().getPassengerCnic()));
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Ride r = new Ride();
                r.setRideId(Integer.valueOf(rs.getString("rideId")));
                r.setDriverID(Integer.valueOf(rs.getString("driverId")));
                r.setPassengerId(Integer.valueOf(rs.getString("passengerId")));
                r.setDropOff(rs.getString("dropOff"));
                r.setPickUp(rs.getString("pickUp"));
                r.setStatus(rs.getString("status"));
                r.setFare(Integer.valueOf(rs.getString("fare")));
                r.setVehicleId(Integer.valueOf(rs.getString("vehicleId")));

                if( parseInt(rs.getString("passengerId")) == parseInt(cnic) ) {
                    PassengerProfile.getPassengerProfile().addRide(r);
                }

            }
            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }

    public boolean bookRide(int rideId , int passengerCnic){

        System.out.println(String.valueOf(rideId));

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");
            String sql = "UPDATE ap.ride SET status = 'Booked' , passengerId = ?  WHERE rideId = ? ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(passengerCnic));
            statement.setString(2, String.valueOf(rideId));

            statement.executeUpdate();

            con.close();
            return true;
        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }

    public boolean insertUser(String name, String email, int cnic , String phoneNo, String password){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.users(cnic,email,name,password,phoneNo) VALUES (? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            String Cnic = Integer.toString(cnic);

            statement.setString(1, Cnic);
            statement.setString(2, email);
            statement.setString(3, name);
            statement.setString(4, password);
            statement.setString(5, phoneNo);
            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public boolean insertVehicle(Vehicle v){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.vehicles(vehicleId,driverCnic,name,model,make) VALUES (? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(v.getVehicleId()));
            statement.setString(2, String.valueOf(DriverProfile.getDriverProfile().getDriverCnic()));
            statement.setString(3, v.getName());
            statement.setString(4, v.getModel());
            statement.setString(5, v.getMake());
            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }

    public boolean registerRide(Ride r){
        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tiger");
            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.ride(driverId, dropOff, pickUp, status , fare , vehicleId) VALUES (? , ? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, String.valueOf(r.getDriverID()));
            statement.setString(2, r.getDropOff());
            statement.setString(3, r.getPickUp());
            statement.setString(4, r.getStatus());
            statement.setString(5, String.valueOf(r.getFare()));
            statement.setString(6, String.valueOf(r.getVehicleId()));
            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }
    }


}

