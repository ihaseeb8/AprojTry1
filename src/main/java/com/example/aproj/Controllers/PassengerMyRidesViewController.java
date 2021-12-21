package com.example.aproj.Controllers;

import com.example.aproj.DBHandlers.DBConnection;
import com.example.aproj.HelloApplication;
import com.example.aproj.Classes.PassengerProfile;
import com.example.aproj.Classes.Ride;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassengerMyRidesViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private TableView<Ride> PassengerMyRidesInfoTable;

    @FXML
    private TableColumn<Ride, String> DropOffCol;

    @FXML
    private TableColumn<Ride, Integer> FareCol;

    @FXML
    private TableColumn<Ride, Integer> DriverIdCol;

    @FXML
    private TableColumn<Ride, String> PickUpCol;

    @FXML
    private TableColumn<Ride, String> StatusCol;

    @FXML
    private TableColumn<Ride, Integer> VehicleIdCol;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/passenger-profile-view.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<Ride> rides = DBConnection.getDBConnection().getPassengerFinishedRides(PassengerProfile.getPassengerProfile().getPassengerCnic());

        PickUpCol.setCellValueFactory(new PropertyValueFactory<>("pickUp"));
        DropOffCol.setCellValueFactory(new PropertyValueFactory<>("dropOff"));
        DriverIdCol.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        VehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        FareCol.setCellValueFactory(new PropertyValueFactory<>("fare"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        PassengerMyRidesInfoTable.setItems(rides);


    }
}
