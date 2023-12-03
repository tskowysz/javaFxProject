package com.example.fpfrontend.controller;

import com.example.fpfrontend.dto.EmployeeDto;
import com.example.fpfrontend.factory.PopupFactory;
import com.example.fpfrontend.rest.EmployeeRestClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    private final PopupFactory popupfactory;
    private final EmployeeRestClient employeeRestClient;

    @FXML
    private BorderPane addEmployeeBorderPaine;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private Button saveButton;

    public AddEmployeeController() {
        popupfactory=new PopupFactory();
        employeeRestClient=new EmployeeRestClient();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCancelButton();
        initializeSaveButton();
    }

    private void initializeSaveButton() {
        saveButton.setOnAction(x->{
            EmployeeDto dto = createEmployeeDto();
            Stage waitingPopup = popupfactory.createWaitingPopup("Connecting...");
            waitingPopup.show();
            employeeRestClient.saveEmployee(dto,()->{
                waitingPopup.close();
                Stage infoPopup = popupfactory.createInfoPopup("Employee hav been saved", () -> {
                    getStage().close();
                });
                infoPopup.show();
            });

        });
    }

    private EmployeeDto createEmployeeDto() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String salary = salaryTextField.getText();
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setFirstName(firstName);
        employeeDto.setLastName(lastName);
        employeeDto.setSalary(salary);
        return employeeDto;
    }

    private void initializeCancelButton() {
        cancelButton.setOnAction((x) -> {
            getStage().close();

        });
    }

    private Stage getStage() {
        return (Stage) addEmployeeBorderPaine.getScene().getWindow();
    }
}
