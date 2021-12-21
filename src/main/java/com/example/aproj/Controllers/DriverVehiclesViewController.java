package com.example.aproj.Controllers;

import com.example.aproj.DBHandlers.DBConnection;
import com.example.aproj.Classes.DriverProfile;
import com.example.aproj.HelloApplication;
import com.example.aproj.Classes.Vehicle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DriverVehiclesViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<Vehicle, Integer> MakeCol;

    @FXML
    private TextField MakeField;

    @FXML
    private TableColumn<Vehicle, String> ModelCol;

    @FXML
    private TextField ModelField;

    @FXML
    private TableColumn<Vehicle, String> NameCol;

    @FXML
    private TextField NameField;

    @FXML
    private TableView<Vehicle> DriverVehiclesInfoTable;

    @FXML
    private Button RegisterButton;

    @FXML
    private TableColumn<Vehicle, String> VehicleIdCol;

    @FXML
    private TextField VehicleIdField;

    @FXML
    private Text registerPrompt;

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


    @FXML
    void RegisterButtonPressed(MouseEvent event) {

        if(VehicleIdField.getText().isEmpty())
        {
            registerPrompt.setText("Vehicle Id Missing!");
        }
        else if(NameField.getText().isEmpty())
        {
            registerPrompt.setText("Vehicle Name Missing!");
        }
        else if(ModelField.getText().isEmpty())
        {
            registerPrompt.setText("Vehicle Model Missing!");
        }
        else if(MakeField.getText().isEmpty())
        {
            registerPrompt.setText("Vehicle Make Missing!");
        }
        else
        {
            boolean a = DBConnection.getDBConnection().searchVehicle(VehicleIdField.getText());

            if(a)
            {
                registerPrompt.setText("Vehicle Id already Registered!");
            }
            else
            {
                registerPrompt.setText("Vehicle Registered Successfully!");
                Vehicle vehicle = new Vehicle(Integer.valueOf(VehicleIdField.getText()) , DriverProfile.getDriverProfile().getDriverCnic(), NameField.getText(),ModelField.getText(),MakeField.getText());
                DriverProfile.getDriverProfile().addVehicle(vehicle);
            }
        }
    }

    @FXML
    void onRegisterButtonMouseMoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #F44336");
        RegisterButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRegisterButtonMouseRemoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #ff725e");
        RegisterButton.setTextFill(Paint.valueOf("#000000"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(DriverProfile.getDriverProfile().getVehicles() == null)
        {
            System.out.println("haha");
        }
        else
        {
            ObservableList<Vehicle> data = DriverProfile.getDriverProfile().getVehicles();

            VehicleIdCol.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
            NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            ModelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
            MakeCol.setCellValueFactory(new PropertyValueFactory<>("make"));

            DriverVehiclesInfoTable.setItems(data);

        }
    }
}
