package com.example.fpfrontend.controller;

import com.example.fpfrontend.dto.EmployeeDto;
import com.example.fpfrontend.handler.EmployeeLoadedHandler;
import com.example.fpfrontend.rest.EmployeeRestClient;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEmployeeController implements Initializable {

    private final EmployeeRestClient employeeRestClient;
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Button okButton;

    @FXML
    private TextField salaryTextField;

    @FXML
    private BorderPane viewEmployeeBorderPaine;

    public ViewEmployeeController() {
        employeeRestClient = new EmployeeRestClient();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        salaryTextField.setEditable(false);
        initializeOkButton();

    }

    public  void loadEmployeeData(Long idEmployee, EmployeeLoadedHandler handler){
        Thread thread = new Thread(()->{
            EmployeeDto dto = employeeRestClient.getEmployee(idEmployee);
            Platform.runLater(()->{
                firstNameTextField.setText(dto.getFirstName());
                lastNameTextField.setText(dto.getLastName());
                salaryTextField.setText(dto.getSalary());
                handler.handle();
            });
        });
        thread.start();
    }

    private void initializeOkButton() {
        okButton.setOnAction(x->{
            getStage().close();
        });
    }

    private Stage getStage() {
        return (Stage) viewEmployeeBorderPaine.getScene().getWindow();
    }
}
