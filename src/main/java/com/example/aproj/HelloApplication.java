
package com.example.aproj;
import org.hibernate.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CABIGO");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {






        launch();


    }
}