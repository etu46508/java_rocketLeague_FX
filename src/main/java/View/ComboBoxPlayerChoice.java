package View;


import View.Utility.ButtonFactory;
import View.Utility.PlayerSheetDisplay;
import View.Utility.VerificationPlayerDeletion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;
import Controller.Controller;


public class ComboBoxPlayerChoice {
    private final Controller controller;
    private ComboBox<String> playerComboBox;

    public ComboBoxPlayerChoice() throws Exception {
        controller = new Controller();
    }



    public void openChoicePlayer(Stage primaryStage,String nextOpen) throws Exception {
        Stage choicePlayerStage = new Stage();
        ArrayList<String> pseudoPlayers = controller.getAllPseudo();

        BorderPane pageLayout = new BorderPane();
        GridPane comboBoxLayout = new GridPane();
        comboBoxLayout.setAlignment(Pos.CENTER);
        comboBoxLayout.setHgap(20);
        comboBoxLayout.setVgap(20);
        comboBoxLayout.setPadding(new Insets(20));

        Label pseudoChoice = new Label("Choose the player : ");
        playerComboBox = new ComboBox<>();
        playerComboBox.getItems().addAll(pseudoPlayers);
        playerComboBox.getSelectionModel().select("");

        comboBoxLayout.add(pseudoChoice,0,0);
        comboBoxLayout.add(playerComboBox,1,0);

        BorderPane buttonLayout = new BorderPane();
        Button validationButton = new Button("Validation");
        validationButton.setDisable(true);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(choicePlayerStage,null,"close page");


        playerComboBox.setOnAction(event -> validationButton.setDisable(false));

        if(Objects.equals(nextOpen, "update")){
            validationButton.setOnAction(event -> {
                try {
                    FormularyPlayer formularyUpdate = new FormularyPlayer();
                    formularyUpdate.openFormulary(primaryStage,playerComboBox.getValue());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(Objects.equals(nextOpen, "delete")){
            validationButton.setOnAction(event -> {
                try {
                    VerificationPlayerDeletion verification = new VerificationPlayerDeletion();
                    verification.openWindowVerification(primaryStage,playerComboBox.getValue());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

        }
        if(Objects.equals(nextOpen, "read")){
            validationButton.setOnAction(event -> {
                try {
                    PlayerSheetDisplay display = new PlayerSheetDisplay(playerComboBox.getValue());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }


        buttonLayout.setRight(returnButton);
        buttonLayout.setLeft(validationButton);
        pageLayout.setTop(comboBoxLayout);
        pageLayout.setBottom(buttonLayout);

        Scene choicePlayerScene = new Scene(pageLayout);

        choicePlayerStage.initModality(Modality.APPLICATION_MODAL);
        choicePlayerStage.setTitle("Combo box player");
        choicePlayerStage.setScene(choicePlayerScene);
        choicePlayerStage.initOwner(primaryStage);
        choicePlayerStage.showAndWait();
    }
}

