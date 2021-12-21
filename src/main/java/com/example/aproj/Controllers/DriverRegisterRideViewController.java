package com.example.aproj.Controllers;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DriverRegisterRideViewController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private Text RegisterPrompt;

    @FXML
    private TextField dropOffField;

    @FXML
    private TextField fareField;

    @FXML
    private TextField pickUpField;

    @FXML
    private ComboBox<String> vehicleComboBox;

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
    void RegisterButtonPressed(MouseEvent event) {

        if(pickUpField.getText().isEmpty())
        {
            RegisterPrompt.setText("Pick Up Location Missing!");
        }
        else if(dropOffField.getText().isEmpty())
        {
            RegisterPrompt.setText("Drop Off Location Missing!");
        }
        else if(fareField.getText().isEmpty())
        {
            RegisterPrompt.setText("Fare Missing!");
        }
        else if(vehicleComboBox.getSelectionModel().isEmpty())
        {
            RegisterPrompt.setText("No Vehicle Selected!");
        }
        else
        {
            RegisterPrompt.setText("Ride Registered Successfully!");

            String temp = "";
            String veh = vehicleComboBox.getValue();
            int k =0;
            while(veh.charAt(k) != '(')
            {
                k++;
            }
            k++;
            while(veh.charAt(k) != ')')
            {
                temp += veh.charAt(k);
                k++;
            }

            Ride newRide = new Ride(DriverProfile.getDriverProfile().getDriverCnic(), Integer.valueOf(temp),Integer.valueOf(fareField.getText()) , dropOffField.getText() , pickUpField.getText());
            DriverProfile.getDriverProfile().addRide(newRide);

            System.out.println(temp);
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
    void onRegisterButtonMouseMoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #F44336");
        RegisterButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onRegisterButtonMouseRemoved(MouseEvent event) {
        RegisterButton.setStyle("-fx-background-color: #F44336");
        RegisterButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<String> vehicles= DriverProfile.getDriverProfile().getVehiclesNames();
        vehicleComboBox.setItems(vehicles);

    }
}
