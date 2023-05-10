package View.Utility;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private Controller controller;
    Stage choicePlayerStage;

    private String pseudoPlayer;
    private ComboBox<String> playerComboBox;
    public ComboBoxPlayerChoice() throws DataException {
        controller = new Controller();

    }



    public void openChoicePlayer(Stage primaryStage) throws Exception {
        ArrayList<String> pseudoPlayers = controller.getAllPseudo();

        BorderPane pageLayout = new BorderPane();

        GridPane comboBoxLayout = new GridPane();
        comboBoxLayout.setAlignment(Pos.CENTER);
        comboBoxLayout.setHgap(20);
        comboBoxLayout.setVgap(20);
        comboBoxLayout.setPadding(new Insets(20));

        Label pseudoChoice = new Label("Choose the player : ");
        ComboBox<Object> playerComboBox = new ComboBox<>();
        playerComboBox.getItems().addAll(pseudoPlayers);
        playerComboBox.getSelectionModel().select("");

        comboBoxLayout.add(pseudoChoice,0,0);
        comboBoxLayout.add(playerComboBox,1,0);

        BorderPane buttonLayout = new BorderPane();
        Button validationButton = new Button("Validation");
        validationButton.setDisable(true);

        PlayerComboBoxListener playerComboBoxListener = new PlayerComboBoxListener(validationButton);
        playerComboBox.valueProperty().addListener(playerComboBoxListener);

        ValidationButtonListener validationButtonListener = new ValidationButtonListener(primaryStage,playerComboBox.getSelectionModel().getSelectedItem());
        validationButton.setOnAction(validationButtonListener);

        Button returnButton = new Button("Return");

        returnButton.setOnAction(event -> choicePlayerStage.close());

        buttonLayout.setRight(returnButton);
        buttonLayout.setLeft(validationButton);

        pageLayout.setTop(comboBoxLayout);
        pageLayout.setBottom(buttonLayout);

        Scene choicePlayerScene = new Scene(pageLayout);
        choicePlayerStage = new Stage();
        choicePlayerStage.initModality(Modality.APPLICATION_MODAL);

        choicePlayerStage.setScene(choicePlayerScene);
        choicePlayerStage.initOwner(primaryStage);
        choicePlayerStage.showAndWait();
    }

    private class ValidationButtonListener implements EventHandler<ActionEvent> {
        private Stage primaryStage;
        private String pseudoPlayer;
        private FormularyPlayerCreation formularyUpdate;

        public ValidationButtonListener(Stage primaryStage,String pseudoPlayer) throws DataException {
            this.primaryStage = primaryStage;
            this.pseudoPlayer = pseudoPlayer;
            this.formularyUpdate = new FormularyPlayerCreation();
        }
        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                formularyUpdate.openFormularyUpdate(primaryStage,playerComboBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class PlayerComboBoxListener implements ChangeListener<String> {
        Button validationButton;
        private PlayerComboBoxListener(Button validationButton){
            this.validationButton = validationButton;
        }
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String value) {
            if(!Objects.equals(value, "")){
                validationButton.setDisable(false);
            }
        }
    }
}
