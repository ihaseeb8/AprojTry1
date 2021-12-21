package com.example.aproj.Controllers;

import com.example.aproj.DBHandlers.DBConnection;
import com.example.aproj.Classes.DriverProfile;
import com.example.aproj.HelloApplication;
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

public class DriverAcceptRideViewController implements Initializable {

    @FXML
    private Button AcceptButton;

    @FXML
    private Button CancelButton;

    @FXML
    private Button BackButton;

    @FXML
    private TableView<Ride> BookedRidesInfoTable;

    @FXML
    private TableColumn<?, ?> DropOffCol;

    @FXML
    private TableColumn<?, ?> FareCol;

    @FXML
    private TableColumn<?, ?> PassengerIdCol;

    @FXML
    private TableColumn<?, ?> PickUpCol;

    @FXML
    private TableColumn<?, ?> VehicleIdCol;

    @FXML
    private Text promptText;


    @FXML
    void onCancelButtonMouseMoved(MouseEvent event) {
        CancelButton.setStyle("-fx-background-color: #F44336");
        CancelButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onCancelButtonMouseRemoved(MouseEvent event) {
        CancelButton.setStyle("-fx-background-color: #ff725e");
        CancelButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void CancelButtonPressed(MouseEvent event) {
        if(BookedRidesInfoTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select A Ride First");
        }
        else {
            Ride temp = BookedRidesInfoTable.getSelectionModel().getSelectedItem();
            DBConnection.getDBConnection().cancelRide(temp.getRideId());
            //System.out.println(temp.vehicleId);
            BookedRidesInfoTable.getItems().remove(temp);
            promptText.setText("Ride Cancelled !");
        }
    }


    @FXML
    void AcceptButtonPressed(MouseEvent event) {

        if(BookedRidesInfoTable.getSelectionModel().isEmpty())
        {
            promptText.setText("Please Select A Ride First");
        }
        else {
            Ride temp = BookedRidesInfoTable.getSelectionModel().getSelectedItem();
            DBConnection.getDBConnection().acceptRide(temp.getRideId());
            //System.out.println(temp.vehicleId);
            BookedRidesInfoTable.getItems().remove(temp);
            promptText.setText("Ride Accepted !");
        }

    }


    @FXML
    void onAcceptButtonMouseMoved(MouseEvent event) {
        AcceptButton.setStyle("-fx-background-color: #F44336");
        AcceptButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onAcceptButtonMouseRemoved(MouseEvent event) {
        AcceptButton.setStyle("-fx-background-color: #ff725e");
        AcceptButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/driver-profile-view.fxml"));
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

        ObservableList<Ride> rides = DBConnection.getDBConnection().getBookedRides(DriverProfile.getDriverProfile().getDriverCnic());

        PickUpCol.setCellValueFactory(new PropertyValueFactory<>("pickUp"));
        DropOffCol.setCellValueFactory(new PropertyValueFactory<>("dropOff"));
        PassengerIdCol.setCellValueFactory(new PropertyValueFactory<>("passengerId"));
        VehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        FareCol.setCellValueFactory(new PropertyValueFactory<>("fare"));

        BookedRidesInfoTable.setItems(rides);

    }
}
