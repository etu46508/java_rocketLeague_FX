package View.Utility;

import Controller.Controller;
import Model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


import Exception.DataException;


public class FormularyPlayer {
    private final Controller controller;
    private final ArrayList<Integer> years,months,days, yearWorldChampionshipFull;
    private TextField pseudoTextField,surnameAndNameTextField,nationalityTextField;
    private Stage formularyStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox,yearWorldChampionComboBox;
    private CheckBox keyboardButton;
    private ComboBox<String> localitiesComboBox, teamsAvailableComboBox;

    public FormularyPlayer() throws DataException {
        controller = new Controller();

        this.years = new ArrayList<>();
        for (int year = LocalDate.now().getYear()-16; year >= 1950; year--) {
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
        this.yearWorldChampionshipFull = new ArrayList<>();
        for (int year = LocalDate.now().getYear(); year >= 2016; year--) {
            yearWorldChampionshipFull.add(year);
        }


    }


    public void openFormulary(Stage primaryStage,String pseudoPlayer) throws Exception {

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

        Label worldVictory = new Label("Year of last worldchampionship victory : ");
        formularyLayout.add(worldVictory ,0,5);
        yearWorldChampionComboBox = new ComboBox<>();
        yearWorldChampionshipFull.removeAll(controller.getYearFilledOfWorldChampions());
        yearWorldChampionComboBox.getItems().addAll(yearWorldChampionshipFull);
        yearWorldChampionComboBox.getItems().add(0, null);
        formularyLayout.add(yearWorldChampionComboBox,1,5);

        Label localityHome = new Label("Town of residence : ");
        formularyLayout.add(localityHome,0,6);
        localitiesComboBox = new ComboBox<>();
        localitiesComboBox.getItems().addAll(controller.getAllNameLocalities());
        formularyLayout.add(localitiesComboBox,1,6);

        Label team = new Label("Team : ");
        formularyLayout.add(team,0,7);
        teamsAvailableComboBox = new ComboBox<>();
        teamsAvailableComboBox.getItems().add(0,"<none>");
        teamsAvailableComboBox.getItems().addAll(controller.getTeamAvailable());


        formularyLayout.add(teamsAvailableComboBox,1,7);

        Button validerButton = new Button("Valider");


        formularyLayout.add(validerButton,0,10);

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formularyStage.close());
        formularyLayout.add(returnButton,10,10);


        if (pseudoPlayer != null){
            Player player = controller.getAPLayer(pseudoPlayer);
            pseudoTextField.setText(player.getPseudo());
            surnameAndNameTextField.setText(player.getName());
            nationalityTextField.setText(player.getNationality());
            keyboardButton.setSelected(player.getPlayKeyboard());
            yearComboBox.setValue(player.getYearOfBirth());
            monthComboBox.setValue(player.getMonthOfBirth());
            dayComboBox.setValue(player.getDayOfBirth());
            if(player.getYearWorldChampion() != 0){
                yearWorldChampionComboBox.setValue(player.getYearWorldChampion());
                yearWorldChampionComboBox.getItems().add(player.getYearWorldChampion());
            }else{
                yearWorldChampionComboBox.setValue(null);
            }


            localitiesComboBox.setValue(player.getHome().getWording());
            if(player.getActualTeam().getWordingTeam() != null){
                teamsAvailableComboBox.setValue(player.getActualTeam().getWordingTeam());
            }else{
                teamsAvailableComboBox.setValue("<none>");
            }


            validerButton.setOnAction(e -> {
                try {
                    Player playerUpdate = validationFormulary();
                    if(playerUpdate != null)
                        controller.updatePlayer(playerUpdate,pseudoPlayer);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        }else{
            teamsAvailableComboBox.setValue("<none>");
            validerButton.setOnAction(e -> {
                try {
                    Player newPlayer = validationFormulary();
                    if(newPlayer != null)
                        controller.addPlayer(newPlayer);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        Scene formularyScene = new Scene(formularyLayout);
        formularyStage = new Stage();
        formularyStage.setTitle("formulary add");
        formularyStage.initModality(Modality.APPLICATION_MODAL);

        formularyStage.setScene(formularyScene);
        formularyStage.initOwner(primaryStage);
        formularyStage.showAndWait();
    }

    

    private Player validationFormulary(){
        pseudoTextField.setStyle("-fx-border-color: transparent;");
        surnameAndNameTextField.setStyle("-fx-border-color: transparent;");
        nationalityTextField.setStyle("-fx-border-color: transparent;");
        String pseudo = pseudoTextField.getText();
        String surnameAndName = surnameAndNameTextField.getText();
        String nationality = nationalityTextField.getText();

        Integer year = yearComboBox.getValue() ;
        Integer month = monthComboBox.getValue();
        Integer day = dayComboBox.getValue();
        Integer team = null;

        if(!Objects.equals(teamsAvailableComboBox.getValue(), "<none>")){
            team = controller.getTeamNumber(teamsAvailableComboBox.getValue());
        }

        StringBuilder fieldEmpty = new StringBuilder();
        boolean formularyError = false;

        int keyboardBit;
        if (keyboardButton.isSelected()) {
            keyboardBit = 1;
        } else {
            keyboardBit = 0;
        }
        if (!pseudo.matches("[\\w\\d\\s\\S]{3,20}")) {
            fieldEmpty.append("Error : the pseudo field isn't valid.\n");
            pseudoTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!surnameAndName.matches("^(?=.{5,30}$)[A-Z][a-zÀ-ÖØ-öø-ſ]*(?:-[A-Z][a-zÀ-ÖØ-öø-ſ]*)*(?: [A-Z][a-zÀ-ÖØ-öø-ſ]*(?:-[A-Z][a-zÀ-ÖØ-öø-ſ]*)*)*(?: [A-Z][a-zÀ-ÖØ-öø-ſ]*(?: [A-Z][a-zÀ-ÖØ-öø-ſ]*)*)$") && surnameAndNameTextField != null) {
            fieldEmpty.append("Error : the surnameAndName field isn't valid.\n");
            surnameAndNameTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!nationality.matches("[a-zA-Z]+[a-zA-Z]{4,20}") && nationalityTextField != null) {
            fieldEmpty.append("Error : the nationalityfield isn't valid.\n");
            nationalityTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (year == null || month == null || day == null) {
            fieldEmpty.append("Error : the birthdate isn't valid.\n");
            formularyError = true;
        }
        if(localitiesComboBox.getValue() == null){
            fieldEmpty.append("Error : the locality isn't valid.\n");
            formularyError = true;
        }
        if (!formularyError) {
            LocalDate birthday = LocalDate.of(year, month, day);
            System.out.println("Player : " + pseudo + " du nom de : " + surnameAndName + " né le " + birthday + (keyboardBit == 1 ? " et est un joueur Clavier Souris" : ""));
            Player newPlayer = new Player(pseudo, surnameAndName, birthday, nationality, keyboardBit, yearWorldChampionComboBox.getValue(),localitiesComboBox.getValue(),team);
            formularyStage.close();
            return newPlayer;

        }else{
            System.out.println(fieldEmpty);
            return null;
        }


    }

}

