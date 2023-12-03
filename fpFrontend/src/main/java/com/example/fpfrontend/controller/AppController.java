package com.example.fpfrontend.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private Pane appPaine;

    public AppController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadView();
    }
    private void loadView() {
        try {
            BorderPane borderPane= FXMLLoader.load(getClass().getResource("/com/example/fpfrontend/employee.fxml"));
            appPaine.getChildren().add(borderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
