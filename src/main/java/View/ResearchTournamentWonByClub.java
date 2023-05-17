//region packages & imports
package View;

import Controller.Controller;
import Model.Ranking;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

//endregion

public class ResearchTournamentWonByClub {
    private final Controller controller;
    private final ComboBox<String> clubComboBox;
    private final Spinner<Integer> daySpinner,monthSpinner,yearSpinner;


    public ResearchTournamentWonByClub(Stage primaryStage) throws Exception{
        controller = new Controller();

        Stage researchStage = new Stage();

        BorderPane researchLayout = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Victories of a club after a date :","research display");

        GridPane comboBoxLayout = new GridPane();
        comboBoxLayout.setAlignment(Pos.CENTER);
        comboBoxLayout.setHgap(20);
        comboBoxLayout.setVgap(20);
        comboBoxLayout.setPadding(new Insets(20));

        Label clubChoice = new Label("Choose the Club : ");
        clubComboBox = new ComboBox<>();
        clubComboBox.getItems().addAll(controller.getAllClubName());

        comboBoxLayout.add(clubChoice,0,0);
        comboBoxLayout.add(clubComboBox,1,0);

        Label dayChoice = new Label("Day : ");
        Label monthChoice = new Label("Month: ");
        Label yearChoice = new Label("Year : ");

        daySpinner = new Spinner<>();
        monthSpinner = new Spinner<>();
        yearSpinner = new Spinner<>();

        SpinnerValueFactory<Integer> dayValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 31);
        SpinnerValueFactory<Integer> monthValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
        SpinnerValueFactory<Integer> yearValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2016, 2023);

        daySpinner.setValueFactory(dayValueFactory);
        monthSpinner.setValueFactory(monthValueFactory);
        yearSpinner.setValueFactory(yearValueFactory);

        comboBoxLayout.add(dayChoice,0,1);
        comboBoxLayout.add(daySpinner,1,1);

        comboBoxLayout.add(monthChoice,0,2);
        comboBoxLayout.add(monthSpinner,1,2);

        comboBoxLayout.add(yearChoice,0,3);
        comboBoxLayout.add(yearSpinner,1,3);

        daySpinner.setDisable(true);
        monthSpinner.setDisable(true);
        yearSpinner.setDisable(true);

        BorderPane buttonLayout = new BorderPane();
        Button buttonDisplayTournament = new Button("Display");
        buttonDisplayTournament.setDisable(true);
        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(researchStage,null,"close page");

        buttonLayout.setLeft(buttonDisplayTournament);
        buttonLayout.setRight(returnButton);

        clubComboBox.setOnAction(actionEvent -> {
            daySpinner.setDisable(false);
            monthSpinner.setDisable(false);
            yearSpinner.setDisable(false);
            buttonDisplayTournament.setDisable(false);
        });
        buttonDisplayTournament.setOnAction(actionEvent -> {
            ArrayList<Ranking> victories;
            try {

                LocalDate date = LocalDate.of(yearSpinner.getValue(), monthSpinner.getValue(),daySpinner.getValue());
                Integer clubSelected = controller.getSerialNumberOfClub(clubComboBox.getValue());
                victories = controller.getVictoryOfAClub(clubSelected,date);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            TableView<InfoVictory> wonByClubTable = new TableView<>();

            TableColumn<InfoVictory, String> tournamentColumn = new TableColumn<>("Tournament");
            tournamentColumn.setCellValueFactory(new PropertyValueFactory<>("wordingTournament"));

            TableColumn<InfoVictory, String> dateColumn = new TableColumn<>("Date");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

            TableColumn<InfoVictory, String> teamColumn = new TableColumn<>("Team");
            teamColumn.setCellValueFactory(new PropertyValueFactory<>("wordingTeam"));

            TableColumn<InfoVictory, String> goalScoredColumn = new TableColumn<>("Goal scored");
            goalScoredColumn.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

            TableColumn<InfoVictory, String> goalConcededColumn = new TableColumn<>("Goal conceded");
            goalConcededColumn.setCellValueFactory(new PropertyValueFactory<>("goalConceded"));

            wonByClubTable.getColumns().addAll(tournamentColumn,dateColumn,teamColumn,goalScoredColumn,goalConcededColumn);

            for(Ranking victory : victories){
                wonByClubTable.getItems().add(new InfoVictory(victory.getTournament().getWording(),
                        victory .getTournament().getStartDate().toString(),
                        victory.getTeam().getWordingTeam(),
                        victory.getNbGoalScored(),
                        victory.getNbGoalConceded()));
            }

            VBox root = new VBox(10);
            root.getChildren().addAll(wonByClubTable);
            Scene displayScene = new Scene(root, 500, 250);
            Stage displayStage = new Stage();
            displayStage.initModality(Modality.APPLICATION_MODAL);
            displayStage.setTitle("Tournament won by " + clubComboBox.getValue());
            displayStage.setScene(displayScene);
            displayStage.initOwner(researchStage);
            displayStage.showAndWait();

        });
        researchLayout.setTop(titlePane);
        researchLayout.setCenter(comboBoxLayout);
        researchLayout.setBottom(buttonLayout);

        Scene scene = new Scene(researchLayout,350,300);

        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Tournament(s) won by a club");
        researchStage.setScene(scene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();
    }


    public static class InfoVictory {

        private final SimpleStringProperty wordingTournament;
        private final SimpleStringProperty date;
        private final SimpleStringProperty wordingTeam;
        private final SimpleStringProperty goalScored;
        private final SimpleStringProperty goalConceded;


        public InfoVictory(String wordingTournament,String date,String wordingTeam,Integer goalScored,Integer goalConceded){
            this.wordingTournament = new SimpleStringProperty(wordingTournament);
            this.date = new SimpleStringProperty(date);
            this.wordingTeam = new SimpleStringProperty(wordingTeam);
            this.goalScored = new SimpleStringProperty(goalScored.toString());
            this.goalConceded = new SimpleStringProperty(goalConceded.toString());
        }

        public String getWordingTournament() {
            return wordingTournament.get();
        }
        public String getDate() {
            return date.get();
        }
        public String getWordingTeam() {
            return wordingTeam.get();
        }
        public String getGoalScored() {
            return goalScored.get();
        }
        public String getGoalConceded() {
            return goalConceded.get();
        }

    }
}
