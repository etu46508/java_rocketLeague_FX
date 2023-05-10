package View.Utility;

import Controller.Controller;
import Exception.DataException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VerificationPlayerDeletion {
    private final Controller controller;
    Stage verificationStage;
    public VerificationPlayerDeletion() throws DataException {
        controller = new Controller();
    }

    public void openWindowVerification(Stage primaryStage,String pseudoPlayer){
        GridPane verificationPane = new GridPane();

        verificationPane.setPadding(new Insets(25, 25, 25, 25));
        verificationPane.setHgap(40);
        verificationPane.setVgap(20);

        Label questionlabel = new Label("Do you want really delete the player - "+pseudoPlayer+" :");
        Button yesButton = new Button("yes");
        Button noButton = new Button("no");

        verificationPane.add(questionlabel,0,0);
        verificationPane.add(yesButton,1,0);
        verificationPane.add(noButton,2,0);

        yesButton.setOnAction(event -> {
            try {
                controller.deletePlayer(pseudoPlayer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        noButton.setOnAction(event ->verificationStage.close());

        Scene verificationScene = new Scene(verificationPane);
        verificationStage = new Stage();
        verificationStage.setTitle("Verification question");
        verificationStage.initModality(Modality.APPLICATION_MODAL);

        verificationStage.setScene(verificationScene);
        verificationStage.initOwner(primaryStage);
        verificationStage.showAndWait();
    }


}
