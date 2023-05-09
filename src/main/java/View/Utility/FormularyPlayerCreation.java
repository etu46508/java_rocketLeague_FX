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
import Exception.DataException;


public class FormularyPlayerCreation {
    private TextField pseudoTextField,surnameAndNameTextField,nationalityTextField;
    private Stage formularyStage,choicePlayerStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox;
    private ComboBox<String> playerComboBox;
    private CheckBox keybordButton;
    private Integer keybordBit;
    private Player player;
    private PlayerDBAccess playerDBAccess;
    private Controller controller;

    private ArrayList<Integer> years,months,days;
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


    public void openFormularyAdd(Stage primaryStage) {
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



        // Créer les ComboBox pour l'année, le mois et le jour
        // activation des comboBox

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


    public void openChoicePlayerUpdate(Stage primaryStage) throws Exception {
            ArrayList<String> pseudoPlayer = controller.getAllPseudo();

            BorderPane pageLayout = new BorderPane();

            GridPane comboBoxLayout = new GridPane();
            comboBoxLayout.setAlignment(Pos.CENTER);
            comboBoxLayout.setHgap(20);
            comboBoxLayout.setVgap(20);
            comboBoxLayout.setPadding(new Insets(20));

            Label pseudoChoice = new Label("Choose the player : ");
            playerComboBox = new ComboBox<>();
            playerComboBox.getItems().addAll(pseudoPlayer);
            playerComboBox.getSelectionModel().select("");

            comboBoxLayout.add(pseudoChoice,0,0);
            comboBoxLayout.add(playerComboBox,1,0);

            BorderPane buttonLayout = new BorderPane();

            Button validationButton = new Button("Validation");


            Button returnButton = new Button("Return");
            validationButton.setOnAction(e -> openFormularyUpdate(choicePlayerStage,playerComboBox.getValue()));

            buttonLayout.setRight(returnButton);
            buttonLayout.setLeft(validationButton);

            pageLayout.setTop(comboBoxLayout);
            pageLayout.setBottom(buttonLayout);
            returnButton.setOnAction(e -> choicePlayerStage.close());


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

    private void openFormularyUpdate(Stage choicePlayerStage,String pseudoPlayer){
        try {
            player = controller.getAPLayer(pseudoPlayer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        GridPane formularyLayout = new GridPane();
        formularyLayout.setAlignment(Pos.CENTER);
        formularyLayout.setHgap(20);
        formularyLayout.setVgap(20);
        formularyLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        pseudoTextField = new TextField(player.getPseudo());
        formularyLayout.addRow(0, pseudoLabel, pseudoTextField);

        Label surnameAndNameLabel = new Label("Surname and name :");
        surnameAndNameTextField = new TextField(player.getName());
        formularyLayout.addRow(1, surnameAndNameLabel, surnameAndNameTextField);

        Label nationalityLabel = new Label("Nationality :");
        nationalityTextField = new TextField(player.getNationality());
        formularyLayout.addRow(2, nationalityLabel, nationalityTextField);


        // Créer les ComboBox pour l'année, le mois et le jour
        // activation des comboBox

        Label yearLabel = new Label("Year :");
        yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(years);
        yearComboBox.setValue(player.getBirthday().getYear());
        formularyLayout.add(yearLabel,0,3);
        formularyLayout.add(yearComboBox,1,3);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);
        monthComboBox.setValue(player.getBirthday().getMonth());
        formularyLayout.add(monthLabel,2,3);
        formularyLayout.add(monthComboBox,3,3);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);
        dayComboBox.setValue(player.getBirthday().getDay());
        formularyLayout.add(dayLabel,4,3);
        formularyLayout.add(dayComboBox,5,3);

        Label playWithKaybord = new Label("Play with keybord : ");
        keybordButton = new CheckBox();
        if(player.isPlayKeyboard()){keybordButton.setSelected(true);}
        formularyLayout.add(playWithKaybord,0,4);
        formularyLayout.add(keybordButton,1,4);

        Button validerButton = new Button("Valider");
        formularyLayout.add(validerButton,0,10);

        Button returnButton = new Button("Return");
        formularyLayout.add(validerButton,10,10);

        Scene formularyScene = new Scene(formularyLayout);
        choicePlayerStage.setTitle("formulary update");
        choicePlayerStage.setScene(formularyScene);
        choicePlayerStage.show();

        returnButton.setOnAction(e -> choicePlayerStage.close());

        validerButton.setOnAction(e -> {
            try {
                validerformulary();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

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

}

