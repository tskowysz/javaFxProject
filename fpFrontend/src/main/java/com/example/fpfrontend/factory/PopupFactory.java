package com.example.fpfrontend.factory;

import com.example.fpfrontend.handler.InfoPopupOkHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupFactory {
    public Stage createWaitingPopup(String text){
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        VBox pane=new VBox();
        pane.setStyle(waitingPopupPaneStyle());
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        Scene scene=new Scene(pane,200,100);
        Label label=new Label(text);
        ProgressBar progressBar=new ProgressBar();
        pane.getChildren().add(label);
        pane.getChildren().add(progressBar);

        stage.setScene(scene);

        return stage;

    }

    private String waitingPopupPaneStyle() {
        return "-fx-background-color: #c7c7c7: -fx-border-color: #003366;";
    }
    private  String okButtonStyle(){
        return null;
    }

    private String okBUttonHoverStyle(){
        return null;
    }


    public Stage createInfoPopup(String text, InfoPopupOkHandler handler) {
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        VBox pane=new VBox();
        pane.setStyle(waitingPopupPaneStyle());
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        Label label=new Label(text);
        Button okButton=new Button("Ok");
        okButton.setOnAction(x->{
            stage.close();
            handler.hadle();
        });

        pane.getChildren().addAll(label,okButton);
        stage.setScene(new Scene(pane,200,100));
        stage.initModality(Modality.APPLICATION_MODAL);

        return stage;
    }
}
