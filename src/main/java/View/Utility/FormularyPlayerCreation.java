package View.Utility;

import Controller.Controller;
import DataAccess.PlayerDBAccess;
import Model.Locality;
import Model.Player;
import Model.Team;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

import Exception.DataException;


public class FormularyPlayerCreation {
    private TextField pseudoTextField,surnameAndNameTextField,nationalityTextField;
    private Stage formularyStage,choicePlayerStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox;
    private ComboBox<String> playerComboBox;
    private CheckBox keybordButton;
    private Integer keybordBit;
    private String pseudoPlayer;
    private Player player;
    private Controller controller;
    private ArrayList<Integer> years,months,days;
    private Player playerSquelette;
    public FormularyPlayerCreation() throws DataException {
        controller = new Controller();

        this.years = new ArrayList<Integer>();
        for (int year = 2023-16; year >= 1950; year--) {
            years.add(year);
        }
        this.months = new ArrayList<Integer>();
        for (int month = 1; month <= 12; month++) {
            months.add(month);
        }
        this.days = new ArrayList<Integer>();
        for (int day = 1; day <= 31; day++) {
            days.add(day);
        }
    }


    public void  openFormulary(Stage primaryStage,String pseudoPlayer) throws Exception {
        if(!Objects.equals(pseudoPlayer, "")){
            playerSquelette = controller.getAPLayer(pseudoPlayer);
        }
        GridPane formularyLayout = new GridPane();
        formularyLayout.setAlignment(Pos.CENTER);
        formularyLayout.setHgap(20);
        formularyLayout.setVgap(20);
        formularyLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        if(playerSquelette != null){
            pseudoTextField = new TextField(playerSquelette.getPseudo());
        }else{
            pseudoTextField = new TextField();
        }

        formularyLayout.addRow(0, pseudoLabel, pseudoTextField);

        Label surnameAndNameLabel = new Label("Surname and name :");
        if(playerSquelette != null){
            surnameAndNameTextField = new TextField(playerSquelette.getPseudo());
        }
        surnameAndNameTextField = new TextField();
        formularyLayout.addRow(1, surnameAndNameLabel, surnameAndNameTextField);

        Label nationalityLabel = new Label("Nationality :");
        if(playerSquelette != null){
            nationalityTextField = new TextField(playerSquelette.getNationality());
        }
        nationalityTextField = new TextField();
        formularyLayout.addRow(2, nationalityLabel, nationalityTextField);


        // Créer les ComboBox pour l'année, le mois et le jour
        // activation des comboBox

        Label yearLabel = new Label("Year :");
        yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(years);
        if(playerSquelette != null){
            yearComboBox.setValue(player.getYearOfBirth());
        }

        formularyLayout.add(yearLabel,0,3);
        formularyLayout.add(yearComboBox,1,3);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);
        if(playerSquelette != null){
            monthComboBox.setValue(player.getMonthOfBirth());
        }

        formularyLayout.add(monthLabel,2,3);
        formularyLayout.add(monthComboBox,3,3);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);
        if(playerSquelette != null){
            dayComboBox.setValue(player.getDayOfBirth());
        }

        formularyLayout.add(dayLabel,4,3);
        formularyLayout.add(dayComboBox,5,3);

        Label playWithKaybord = new Label("Play with keybord : ");
        keybordButton = new CheckBox();
        formularyLayout.add(playWithKaybord,0,4);
        formularyLayout.add(keybordButton,1,4);


        Button validerButton = new Button("Valider");
        validerButton.setOnAction(e -> {
            try {
                validerformulary();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        formularyLayout.add(validerButton,0,10);

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formularyStage.close());
        formularyLayout.add(returnButton,10,10);

        Scene formularyScene = new Scene(formularyLayout);
        formularyStage = new Stage();
        formularyStage.setTitle("formulary");
        formularyStage.initModality(Modality.APPLICATION_MODAL);

        formularyStage.setScene(formularyScene);
        formularyStage.initOwner(primaryStage);
        formularyStage.showAndWait();
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
            playerComboBox = new ComboBox<>();
            playerComboBox.getItems().addAll(pseudoPlayers);
            pseudoPlayer = "";
            playerComboBox.getSelectionModel().select(pseudoPlayer);


            comboBoxLayout.add(pseudoChoice,0,0);
            comboBoxLayout.add(playerComboBox,1,0);


            BorderPane buttonLayout = new BorderPane();
            Button validationButton = new Button("Validation");
            validationButton.setDisable(true);


            PlayerComboBoxListener playerComboBoxListener = new PlayerComboBoxListener(validationButton);
            playerComboBox.valueProperty().addListener(playerComboBoxListener);


            Button returnButton = new Button("Return");

        returnButton.setOnAction(e -> choicePlayerStage.close());
        validationButton.setOnAction(e ->
        {
            try {
                String pseudoPlayer = playerComboBox.getSelectionModel().getSelectedItem();
                FormularyPlayerCreation formularyUpdate = new FormularyPlayerCreation();
                System.out.println(playerComboBox.getSelectionModel().getSelectedItem());
                formularyUpdate.openFormulary(primaryStage,pseudoPlayer);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });


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

    private void validerformulary() throws Exception {
        pseudoTextField.setStyle("-fx-border-color: transparent;");
        surnameAndNameTextField.setStyle("-fx-border-color: transparent;");
        nationalityTextField.setStyle("-fx-border-color: transparent;" );
        String pseudo = pseudoTextField.getText();
        String surnameAndName = surnameAndNameTextField.getText();

        String nationality = nationalityTextField.getText();
        Integer year = yearComboBox.getValue();
        Integer month = monthComboBox.getValue();
        Integer day = dayComboBox.getValue();

        StringBuilder fieldEmpty = new StringBuilder();
        Boolean formularyError = false;

        if(keybordButton.isSelected()){
            keybordBit = 1;
        }else{
            keybordBit = 0;
        }
        if(!pseudo.matches("[\\w\\d\\s\\S]+") && pseudo != null){
            fieldEmpty.append("Error : the pseudo field isn't valid.\n");
            pseudoTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!surnameAndName.matches("^[a-zA-ZÀ-ÖØ-öø-ſ]+(?:-[a-zA-ZÀ-ÖØ-öø-ſ]+)?(?: [a-zA-ZÀ-ÖØ-öø-ſ]+(?:-[a-zA-ZÀ-ÖØ-öø-ſ]+)?)*$") && surnameAndNameTextField != null) {
            fieldEmpty.append("Error : the surnameAndName field isn't valid.\n");
            surnameAndNameTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!nationality.matches("[a-zA-Z]+") && nationalityTextField != null) {
            fieldEmpty.append("Error : the nationalityfield isn't valid.\n");
            nationalityTextField.setStyle("-fx-border-color: red;" );
            formularyError = true;
        }
        if(year == null || month == null || day == null){
            fieldEmpty.append("Error : the birthdate isn't valid.\n");
            formularyError = true;
        }
        if(!formularyError){

            Date dateOfBirth = new Date(year.intValue(),month.intValue(),day.intValue());
            System.out.println("Player : "+pseudo+" du nom de : "+surnameAndName+" né le " + dateOfBirth +(keybordBit ==1? " et est un joueur Clavier Souris":""));
            Player newPlayer = new Player(pseudo,surnameAndName,dateOfBirth,nationality,keybordBit,0, (Locality) null, (Team) null);
            controller.addPlayer(newPlayer);

            formularyStage.close();
        }


    }







    private class CheckBoxListener implements ChangeListener<Integer>{
        @Override
        public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
            if(keybordButton.isSelected()){
                keybordBit = 1;
            }else{
                keybordBit = 0;
            }
        }
    }

    private class PlayerComboBoxListener implements ChangeListener<String>{
        Button validationButton;
        private PlayerComboBoxListener(Button validationButton){
            this.validationButton = validationButton;
        }
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String value) {
            if(value != ""){
                validationButton.setDisable(false);
            }
        }
    }

}

