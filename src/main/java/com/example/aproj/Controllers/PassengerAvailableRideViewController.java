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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassengerAvailableRideViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button BookButton;

    @FXML
    private Text promptText;

    @FXML
    private TableColumn<Ride, Integer> CarNoCol;

    @FXML
    private TableColumn<Ride, Integer> DriverNameCol;

    @FXML
    private TableColumn<Ride, String> DropOffCol;

    @FXML
    private TableColumn<Ride, Double> FareCol;

    @FXML
    private TableView<Ride> PassengerAvailableRideTable;

    @FXML
    private TableColumn<Ride, String> PickUpCol;

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
    void BookButtonPressed(MouseEvent event) {


        if(PassengerAvailableRideTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select A Ride First");
        }
        else {
            Ride temp = PassengerAvailableRideTable.getSelectionModel().getSelectedItem();
            DBConnection.getDBConnection().bookRide(temp.getRideId() , PassengerProfile.getPassengerProfile().getPassengerCnic());
            //System.out.println(temp.vehicleId);
            PassengerAvailableRideTable.getItems().remove(temp);
            promptText.setText("Ride Registered Successfully !");
        }
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
    void onBookButtonMouseMoved(MouseEvent event) {
        BookButton.setStyle("-fx-background-color: #F44336");
        BookButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onBookButtonMouseRemoved(MouseEvent event) {
        BookButton.setStyle("-fx-background-color: #ff725e");
        BookButton.setTextFill(Paint.valueOf("#000000"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<Ride> data = DBConnection.getDBConnection().getAvailableRides();

        CarNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        DriverNameCol.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        DropOffCol.setCellValueFactory(new PropertyValueFactory<>("dropOff"));
        FareCol.setCellValueFactory(new PropertyValueFactory<>("fare"));
        PickUpCol.setCellValueFactory(new PropertyValueFactory<>("pickUp"));

        if(data != null) {
            PassengerAvailableRideTable.setItems(data);
        }
    }
}
