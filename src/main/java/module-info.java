module com.example.aproj {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires java.naming;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens com.example.aproj to org.hibernate.orm.core,javafx.fxml ;

    exports com.example.aproj;
    exports com.example.aproj.Controllers;
    opens com.example.aproj.Controllers to javafx.fxml, org.hibernate.orm.core;
    exports com.example.aproj.DBHandlers;
    opens com.example.aproj.DBHandlers to javafx.fxml, org.hibernate.orm.core;
    exports com.example.aproj.Classes;
    opens com.example.aproj.Classes to javafx.fxml, org.hibernate.orm.core;

}