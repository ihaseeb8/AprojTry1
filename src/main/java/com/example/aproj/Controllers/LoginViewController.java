package com.example.aproj.Controllers;

import com.example.aproj.*;
import com.example.aproj.Classes.DriverProfile;
import com.example.aproj.Classes.PassengerProfile;
import com.example.aproj.Classes.User;
import com.example.aproj.DBHandlers.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class LoginViewController {

    @FXML
    private TextField CnicField;

    @FXML
    private Button LogInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button BackButton;


    @FXML
    private Text promptText;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBackButtonMouseMoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #F44336");
        BackButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onBackButtonMouseRemoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #ff725e");
        BackButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void LoginButtonClicked(MouseEvent event) {



    }

    @FXML
    void onLoginButtonMouseMoved(MouseEvent event) {
        LogInButton.setStyle("-fx-background-color: #F44336");
        LogInButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onLoginButtonMouseRemoved(MouseEvent event) {
        LogInButton.setStyle("-fx-background-color: #ff725e");
        LogInButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void LoginButtonPressed(MouseEvent event) throws IOException {


        if(!CnicField.getText().isEmpty()){

        String cnic = CnicField.getText();
        int cnicInt = parseInt(cnic);
        if (cnicInt < 100000000 || cnicInt > 199999999) {
            promptText.setText("Invalid CNIC!");
        }
        else {

            DBConnection dbConnection = DBConnection.getDBConnection();

            if (dbConnection.getUser(cnic) == true) {

                if(!passwordField.getText().isEmpty())
                {
                    if(passwordField.getText().equals(User.getUser().getPassword()))
                    {
                        DriverProfile.getDriverProfile().setDriverCnic(User.getUser().getCnic());
                        User.getUser().setDriverProfile(DriverProfile.getDriverProfile());
                        DBConnection.getDBConnection().getVehicles(String.valueOf(DriverProfile.getDriverProfile().getDriverCnic()));
                        DBConnection.getDBConnection().getRides(String.valueOf(DriverProfile.getDriverProfile().getDriverCnic()));

                        //passenger Filling
                        PassengerProfile.getPassengerProfile().setPassengerCnic(User.getUser().getCnic());
                        User.getUser().setPassengerProfile(PassengerProfile.getPassengerProfile());
                        DBConnection.getDBConnection().getPassengerRides(String.valueOf(PassengerProfile.getPassengerProfile().getPassengerCnic()));

                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/profiles-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        //Node node = (Node) event.getSource();
                        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    }
                    else
                    {
                        promptText.setText("Incorrect Password!");
                    }

                }
                else
                {
                    promptText.setText("Please Enter Password!");
                }

            }

             }
        }
        else
        {
            promptText.setText("Please Enter Cnic!");
        }
    }

}
