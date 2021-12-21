package com.example.aproj.Controllers;

import com.example.aproj.Classes.DriverProfile;
import com.example.aproj.HelloApplication;
import com.example.aproj.Classes.PassengerProfile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileViewController implements Initializable {

    @FXML
    private Button DriverProfileButton;

    @FXML
    private Button PassengerProfileButton;

    @FXML
    private Button BackButton;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {


            DriverProfile.getDriverProfile().deleteVehicles();
            DriverProfile.getDriverProfile().deleteRides();
            PassengerProfile.getPassengerProfile().deleteRides();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/login-view.fxml"));
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
    void DriverProfileButtonClicked(MouseEvent event) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PassengerProfileButtonClicked(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/passenger-profile-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onDriverProfileButtonMouseMoved(MouseEvent event) {
        DriverProfileButton.setStyle("-fx-background-color: #455A64 ; -fx-background-radius : 25 ");
    }

    @FXML
    void onDriverProfileButtonMouseRemoved(MouseEvent event) {
        DriverProfileButton.setStyle("-fx-background-color: #BDBDBD; -fx-background-radius : 25 " );
    }

    @FXML
    void onPassengerProfileButtonMouseMoved(MouseEvent event) {
        PassengerProfileButton.setStyle("-fx-background-color:  #607D8B ; -fx-background-radius : 25 ");
    }

    @FXML
    void onPassengerProfileButtonMouseRemoved(MouseEvent event) {
        PassengerProfileButton.setStyle("-fx-background-color: #BDBDBD ; -fx-background-radius : 25 ");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
