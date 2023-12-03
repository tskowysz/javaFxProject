module com.example.fpfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires spring.web;


    opens com.example.fpfrontend to javafx.fxml;
    exports com.example.fpfrontend;
    exports com.example.fpfrontend.controller;
    opens com.example.fpfrontend.controller to javafx.fxml;
    exports com.example.fpfrontend.dto;
    opens com.example.fpfrontend.dto to javafx.fxml;
    exports com.example.fpfrontend.table;
    opens com.example.fpfrontend.table to javafx.fxml;
}