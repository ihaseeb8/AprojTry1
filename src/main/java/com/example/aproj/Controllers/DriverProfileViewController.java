package com.example.aproj.Controllers;

import com.example.aproj.Classes.DriverProfile;
import com.example.aproj.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DriverProfileViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button AcceptRideButton;

    @FXML
    private Button MyVehiclesButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button MyRidesButton;

    @FXML
    private Button FinishRideButton;

    @FXML
    private Button RegisterRideButton;

    @FXML
    private Text promptText;


    @FXML
    void FinishRideButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-finish-ride-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onFinishRideButtonMouseMoved(MouseEvent event) {
        FinishRideButton.setStyle("-fx-background-color: #F44336");
        FinishRideButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }


    @FXML
    void onFinishRideButtonMouseRemoved(MouseEvent event) {
        FinishRideButton.setStyle("-fx-background-color: #ff725e");
        FinishRideButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void RegisterRideButtonPressed(MouseEvent event) throws IOException {

        if(DriverProfile.getDriverProfile().getVehicles().size() == 0)
        {
           promptText.setText("Register A Vehicle First");
        }
        else
        {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-register-ride-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                //Node node = (Node) event.getSource();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                throw e;
            }
        }
    }

    @FXML
    void onRegisterRideButtonMouseMoved(MouseEvent event) {
        RegisterRideButton.setStyle("-fx-background-color: #F44336");
        RegisterRideButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRegisterRideButtonMouseRemoved(MouseEvent event) {
        RegisterRideButton.setStyle("-fx-background-color: #ff725e");
        RegisterRideButton.setTextFill(Paint.valueOf("#000000"));
    }


    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/profiles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AcceptRideButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-accept-ride-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ProfileButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MyRidesButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-my-rides-view.fxml"));
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
    void onAcceptRideButtonMouseMoved(MouseEvent event) {
        AcceptRideButton.setStyle("-fx-background-color: #F44336");
        AcceptRideButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onAcceptRideButtonMouseRemoved(MouseEvent event) {
        AcceptRideButton.setStyle("-fx-background-color: #ff725e");
        AcceptRideButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void onMyVehiclesButtonMouseMoved(MouseEvent event) {
        MyVehiclesButton.setStyle("-fx-background-color: #F44336");
        MyVehiclesButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onMyVehiclesButtonMouseRemoved(MouseEvent event) {
        MyVehiclesButton.setStyle("-fx-background-color: #ff725e");
        MyVehiclesButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void onMyVehiclesButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-vehicles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onProfileButtonMouseMoved(MouseEvent event) {
        ProfileButton.setStyle("-fx-background-color: #F44336");
        ProfileButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onProfileButtonMouseRemoved(MouseEvent event) {
        ProfileButton.setStyle("-fx-background-color: #ff725e");
        ProfileButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void onMyRidesButtonMouseMoved(MouseEvent event) {
        MyRidesButton.setStyle("-fx-background-color: #F44336");
        MyRidesButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onMyRidesButtonMouseRemoved(MouseEvent event) {
        MyRidesButton.setStyle("-fx-background-color: #ff725e");
        MyRidesButton.setTextFill(Paint.valueOf("#000000"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
