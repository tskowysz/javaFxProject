package com.example.fpfrontend.controller;

import com.example.fpfrontend.dto.OperatorCredentialsDto;
import com.example.fpfrontend.factory.PopupFactory;
import com.example.fpfrontend.rest.Authenticator;
import com.example.fpfrontend.rest.AuthenticatorImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public static final String APP_FXML = "/com/example/fpfrontend/app.fxml";
    public static final String APP_TITLE = "ERP System";
    private PopupFactory popupfactory;
    private Authenticator authenticator;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private Button loginButton;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;

    public LoginController() {
        popupfactory = new PopupFactory();
        authenticator = new AuthenticatorImpl();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeExitButton();
        initializeLoginButton();
    }

    private void initializeLoginButton() {
        loginButton.setOnAction((x) -> {
            performAuthentication();
        });
    }


    private void performAuthentication() {
        Stage waitingPopup = popupfactory.createWaitingPopup("Connecting....");
        waitingPopup.show();
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        OperatorCredentialsDto dto = new OperatorCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
        authenticator.authenticate(dto, (authenticationResult) -> {
            Platform.runLater(() -> {
                waitingPopup.close();
                if (authenticationResult.isAuthenticated()) {
                        openAppAndCloseLoginStage();

                } else {
                    showIncorrectCredentialsMessage();
                }
            });
        });
    }

    private void showIncorrectCredentialsMessage() {
        //TODO
        System.out.println("Incorrect credentials");
    }

    private void openAppAndCloseLoginStage(){
        Stage appStage = new Stage();
        Parent appRoot = null;
        try {
            appRoot = FXMLLoader.load(getClass().getResource(APP_FXML));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(appRoot, 1024, 768);
        appStage.setTitle(APP_TITLE);
        appStage.setScene(scene);
        appStage.show();

        getStage().close();
    }

    private void initializeExitButton() {
        exitButton.setOnAction((x) -> getStage().close());
    }

    private Stage getStage() {
        return (Stage) loginAnchorPane.getScene().getWindow();
    }

}
