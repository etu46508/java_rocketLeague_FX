package View.Utility;

import Controller.Controller;
import Model.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Date;
import java.util.ArrayList;


import Exception.DataException;


public class FormularyPlayerCreation {
    private TextField pseudoTextField,surnameAndNameTextField,nationalityTextField;
    private Stage formularyStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox;
    private CheckBox keyboardButton;
    private Integer keyboardBit;
    private final Controller controller;
    private final ArrayList<Integer> years,months,days;
    private ComboBox<String> localitiesComboBox, teamComboBox;

    public FormularyPlayerCreation() throws DataException {
        controller = new Controller();

        this.years = new ArrayList<>();
        for (int year = 2023-16; year >= 1950; year--) {
            years.add(year);
        }
        this.months = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            months.add(month);
        }
        this.days = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            days.add(day);
        }
    }


    public void openFormularyAdd(Stage primaryStage) throws Exception {

        GridPane formularyLayout = new GridPane();
        formularyLayout.setAlignment(Pos.CENTER);
        formularyLayout.setHgap(20);
        formularyLayout.setVgap(20);
        formularyLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        pseudoTextField = new TextField();
        formularyLayout.addRow(0, pseudoLabel, pseudoTextField);

        Label surnameAndNameLabel = new Label("Surname and name :");
        surnameAndNameTextField = new TextField();
        formularyLayout.addRow(1, surnameAndNameLabel, surnameAndNameTextField);

        Label nationalityLabel = new Label("Nationality :");
        nationalityTextField = new TextField();
        formularyLayout.addRow(2, nationalityLabel, nationalityTextField);

        Label yearLabel = new Label("Year :");
        yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(years);

        formularyLayout.add(yearLabel,0,3);
        formularyLayout.add(yearComboBox,1,3);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);

        formularyLayout.add(monthLabel,2,3);
        formularyLayout.add(monthComboBox,3,3);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);

        formularyLayout.add(dayLabel,4,3);
        formularyLayout.add(dayComboBox,5,3);

        Label playWithKeyboard = new Label("Play with keyboard : ");
        keyboardButton = new CheckBox();
        formularyLayout.add(playWithKeyboard,0,4);
        formularyLayout.add(keyboardButton,1,4);

        Label localityHome = new Label("Town of residence : ");
        formularyLayout.add(localityHome,0,5);
        localitiesComboBox = new ComboBox<>();
        localitiesComboBox.getItems().addAll(controller.getAllNameLocalities());
        formularyLayout.add(localitiesComboBox,1,5);

        Label team = new Label("Team : ");
        formularyLayout.add(team,0,6);

        Button validerButton = new Button("Valider");

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formularyStage.close());
        formularyLayout.add(returnButton,10,10);

        validerButton.setOnAction(e -> {
            try {
                Player newPlayer = validationformulary();
                controller.addPlayer(newPlayer);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        formularyLayout.add(validerButton,0,10);



        Scene formularyScene = new Scene(formularyLayout);
        formularyStage = new Stage();
        formularyStage.setTitle("formulary");
        formularyStage.initModality(Modality.APPLICATION_MODAL);

        formularyStage.setScene(formularyScene);
        formularyStage.initOwner(primaryStage);
        formularyStage.showAndWait();
    }



    

    private Player validationformulary(){
        pseudoTextField.setStyle("-fx-border-color: transparent;");
        surnameAndNameTextField.setStyle("-fx-border-color: transparent;");
        nationalityTextField.setStyle("-fx-border-color: transparent;");
        String pseudo = pseudoTextField.getText();
        String surnameAndName = surnameAndNameTextField.getText();

        String nationality = nationalityTextField.getText();
        String locality = localitiesComboBox.getValue();
        Integer year = yearComboBox.getValue();
        Integer month = monthComboBox.getValue();
        Integer day = dayComboBox.getValue();


        StringBuilder fieldEmpty = new StringBuilder();
        boolean formularyError = false;

        if (keyboardButton.isSelected()) {
            keyboardBit = 1;
        } else {
            keyboardBit = 0;
        }
        if (!pseudo.matches("[\\w\\d\\s\\S]+")) {
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
            nationalityTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (year == null || month == null || day == null) {
            fieldEmpty.append("Error : the birthdate isn't valid.\n");
            formularyError = true;
        }
        if(locality == null){
            fieldEmpty.append("Error : the locality isn't valid.\n");
            formularyError = true;
        }
        if (!formularyError) {
            Date dateOfBirth = new Date(year.intValue(), month.intValue(), day.intValue());
            System.out.println("Player : " + pseudo + " du nom de : " + surnameAndName + " né le " + dateOfBirth + (keyboardBit == 1 ? " et est un joueur Clavier Souris" : ""));
            Player newPlayer = new Player(pseudo, surnameAndName, dateOfBirth, nationality, keyboardBit, null,locality,null);
            formularyStage.close();
            return newPlayer;

        }else{
            System.out.println(fieldEmpty.toString());
            return null;
        }


    }

    public void openFormularyUpdate(Stage primaryStage,String pseudoPlayer) throws Exception {

        Player playerSquelette = controller.getAPLayer(pseudoPlayer);

        GridPane formularyLayout = new GridPane();
        formularyLayout.setAlignment(Pos.CENTER);
        formularyLayout.setHgap(20);
        formularyLayout.setVgap(20);
        formularyLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        pseudoTextField = new TextField();
        formularyLayout.addRow(0, pseudoLabel, pseudoTextField);


        Label surnameAndNameLabel = new Label("Surname and name :");
        surnameAndNameTextField = new TextField();
        formularyLayout.addRow(1, surnameAndNameLabel, surnameAndNameTextField);


        Label nationalityLabel = new Label("Nationality :");
        nationalityTextField = new TextField();
        formularyLayout.addRow(2, nationalityLabel, nationalityTextField);

        Label yearLabel = new Label("Year :");
        yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(years);

        formularyLayout.add(yearLabel,0,3);
        formularyLayout.add(yearComboBox,1,3);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);

        formularyLayout.add(monthLabel,2,3);
        formularyLayout.add(monthComboBox,3,3);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);

        formularyLayout.add(dayLabel,4,3);
        formularyLayout.add(dayComboBox,5,3);

        Label playWithKeyboard = new Label("Play with keyboard : ");
        keyboardButton = new CheckBox();
        formularyLayout.add(playWithKeyboard,0,4);
        formularyLayout.add(keyboardButton,1,4);

        Label localityHome = new Label("Town of residence : ");
        formularyLayout.add(localityHome,0,5);
        localitiesComboBox = new ComboBox<>();
        localitiesComboBox.getItems().addAll(controller.getAllNameLocalities());
        formularyLayout.add(localitiesComboBox,1,5);

        Label team = new Label("Team : ");
        formularyLayout.add(team,0,6);


        Button validerButton = new Button("Valider");

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formularyStage.close());
        formularyLayout.add(returnButton,10,10);

        validerButton.setOnAction(e -> {
            try {
                Player newPlayer = validationformulary();
                controller.updatePlayer(newPlayer,pseudoPlayer);

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        formularyLayout.add(validerButton,0,10);



        pseudoTextField.setText(playerSquelette.getPseudo());
        surnameAndNameTextField.setText(playerSquelette.getName());
        nationalityTextField.setText(playerSquelette.getNationality());
        keyboardButton.setSelected(playerSquelette.getPlayKeyboard());


        Scene formularyScene = new Scene(formularyLayout);
        formularyStage = new Stage();
        formularyStage.setTitle("formulary");
        formularyStage.initModality(Modality.APPLICATION_MODAL);

        formularyStage.setScene(formularyScene);
        formularyStage.initOwner(primaryStage);
        formularyStage.showAndWait();
    }





    private class CheckBoxListener implements ChangeListener<Integer>{
        @Override
        public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
            if(keyboardButton.isSelected()){
                keyboardBit = 1;
            }else{
                keyboardBit = 0;
            }
        }
    }



}

