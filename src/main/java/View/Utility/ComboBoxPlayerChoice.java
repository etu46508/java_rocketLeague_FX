package View.Utility;


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
import Exception.DataException;
public class ComboBoxPlayerChoice {
    private final Controller controller;
    Stage choicePlayerStage;
    private ComboBox<String> playerComboBox;
    public ComboBoxPlayerChoice() throws DataException {
        controller = new Controller();
        choicePlayerStage = new Stage();

    }



    public void openChoicePlayer(Stage primaryStage,String nextOpen) throws Exception {

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

        Button returnButton = new Button("Return");


        buttonLayout.setRight(returnButton);
        buttonLayout.setLeft(validationButton);

        pageLayout.setTop(comboBoxLayout);
        pageLayout.setBottom(buttonLayout);

        playerComboBox.setOnAction(event -> validationButton.setDisable(false));

        if(Objects.equals(nextOpen, "update")){
            validationButton.setOnAction(event -> {
                try {
                    FormularyPlayerCreation formularyUpdate = new FormularyPlayerCreation();
                    formularyUpdate.openFormularyUpdate(primaryStage,playerComboBox.getValue());
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
            System.out.println("read");
        }



        returnButton.setOnAction(event -> choicePlayerStage.close());

        System.out.println(playerComboBox.getSelectionModel().getSelectedItem());



        Scene choicePlayerScene = new Scene(pageLayout);
        choicePlayerStage.initModality(Modality.APPLICATION_MODAL);
        choicePlayerStage.setTitle("Combo box player");
        choicePlayerStage.setScene(choicePlayerScene);
        choicePlayerStage.initOwner(primaryStage);
        choicePlayerStage.showAndWait();






    }
}

