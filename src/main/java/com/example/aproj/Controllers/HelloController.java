package com.example.aproj.Controllers;

import com.example.aproj.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloController {

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;

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
    void onSignUpButtonMouseMoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #F44336");
        SignUpButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onSignUpButtonMouseRemoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #ff725e");
        SignUpButton.setTextFill(Paint.valueOf("#000000"));
    }

    @FXML
    void LoginButtonClicked(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SignUpButtonPressed(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
