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
import java.util.ArrayList;
import java.util.Arrays;

public class ResearchTournamentRanking {
    private final Controller controller;
    private final ComboBox<String> monthComboBox,tournamentComboBox;


    public ResearchTournamentRanking(Stage primaryStage) throws Exception {
        controller = new Controller();
        Stage researchStage = new Stage();

        BorderPane researchLayout = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Ranking of a tournament :","research display");

        ArrayList<String> months = new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        ));

        GridPane comboBoxLayout = new GridPane();
        comboBoxLayout.setAlignment(Pos.CENTER);
        comboBoxLayout.setHgap(20);
        comboBoxLayout.setVgap(20);
        comboBoxLayout.setPadding(new Insets(20));

        Label monthChoice = new Label("Choose the month : ");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);

        Label tournamentChoice = new Label("Tournament : ");
        tournamentComboBox = new ComboBox<>();
        tournamentComboBox.setDisable(true);

        comboBoxLayout.add(monthChoice,0,0);
        comboBoxLayout.add(monthComboBox,1,0);
        comboBoxLayout.add(tournamentChoice,0,1);
        comboBoxLayout.add(tournamentComboBox,1,1);

        BorderPane buttonLayout = new BorderPane();
        Button validationButton = new Button("Validation");
        validationButton.setDisable(true);
        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(researchStage,null,"close page");

        buttonLayout.setLeft(validationButton);
        buttonLayout.setRight(returnButton);

        monthComboBox.setOnAction(event -> {
            ArrayList<String> tournaments;
            try {
                tournaments = new ArrayList<>(controller.getTournamentOfAMonth(monthComboBox.getSelectionModel().getSelectedIndex() + 1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            tournamentComboBox.getItems().setAll(tournaments);
            tournamentComboBox.setDisable(false);

        });

        tournamentComboBox.setOnAction(event -> validationButton.setDisable(false));

        validationButton.setOnAction(event -> {
            try {
                rankingDisplay(researchStage,tournamentComboBox.getValue());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        researchLayout.setTop(titlePane);
        researchLayout.setCenter(comboBoxLayout);
        researchLayout.setBottom(buttonLayout);

        Scene researchScene = new Scene(researchLayout,300,200);
        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Tournament choice");

        researchStage.setScene(researchScene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();

    }


    private void rankingDisplay(Stage researchStage,String wordingTournament) throws Exception {
        Integer tournamentNumber = controller.getTournamentNumber(wordingTournament);
        ArrayList<Ranking> rankings = controller.getAllRankingOfATounament(tournamentNumber);

        TableView<InfoRank> tableView = new TableView<>();

        TableColumn<InfoRank, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<InfoRank, String> goalScoredColumn = new TableColumn<>("Goal scored");
        goalScoredColumn.setCellValueFactory(new PropertyValueFactory<>("goalScored"));

        TableColumn<InfoRank, String> goalConcededColumn = new TableColumn<>("Goal conceded");
        goalConcededColumn.setCellValueFactory(new PropertyValueFactory<>("goalConceded"));

        TableColumn<InfoRank, String> cashPrizeColumn = new TableColumn<>("cash prize");
        cashPrizeColumn.setCellValueFactory(new PropertyValueFactory<>("cashPrize"));

        TableColumn<InfoRank, String> teamColumn = new TableColumn<>("Team");
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("nameTeam"));

        TableColumn<InfoRank, String> nameCoachColumn = new TableColumn<>("Name of coach");
        nameCoachColumn .setCellValueFactory(new PropertyValueFactory<>("nameCoach"));

        TableColumn<InfoRank, String> clubColumn = new TableColumn<>("Club");
        clubColumn.setCellValueFactory(new PropertyValueFactory<>("wordingClub"));

        tableView.getColumns().addAll(positionColumn,teamColumn,nameCoachColumn,clubColumn,goalScoredColumn,goalConcededColumn,cashPrizeColumn);

        for(Ranking rank : rankings){
            tableView.getItems().add(new InfoRank(rank.getPosition(),
                    rank.getNbGoalScored(),
                    rank.getNbGoalConceded(),
                    rank.getCashPrize(),
                    rank.getTeam().getWordingTeam(),
                    rank.getTeam().getNameCoach(),
                    rank.getTeam().getClub().getName()));
        }

        VBox root = new VBox(10);
        root.getChildren().addAll(tableView);
        Stage rankDisplayStage = new Stage();
        Scene rankDisplayScene = new Scene(root);
        rankDisplayStage.initModality(Modality.APPLICATION_MODAL);
        rankDisplayStage.setTitle("TableView ranking display");

        rankDisplayStage.setScene(rankDisplayScene);
        rankDisplayStage.initOwner(researchStage);
        rankDisplayStage.showAndWait();


    }


    public static class InfoRank {
        private final SimpleStringProperty position;
        private final SimpleStringProperty goalScored;
        private final SimpleStringProperty goalConceded;
        private final SimpleStringProperty cashPrize;
        private final SimpleStringProperty nameTeam;
        private final SimpleStringProperty nameCoach;
        private final SimpleStringProperty wordingClub;
        public InfoRank(Integer position,Integer goalScored, Integer goalConceded, Integer cashPrize, String nameTeam, String nameCoach, String wordingClub){
            this.position = new SimpleStringProperty(position.toString());
            this.goalScored = new SimpleStringProperty(goalScored.toString());
            this.goalConceded = new SimpleStringProperty(goalConceded.toString());
            this.cashPrize = new SimpleStringProperty(cashPrize.toString());
            this.nameCoach = new SimpleStringProperty(nameCoach);
            this.nameTeam = new SimpleStringProperty(nameTeam);
            this.wordingClub = new SimpleStringProperty(wordingClub);
        }

        public String getPosition() {
            return position.get();
        }
        public String getGoalScored() {
            return goalScored.get();
        }
        public String getGoalConceded() {
            return goalConceded.get();
        }
        public String getCashPrize() {
            return cashPrize.get();
        }
        public String getNameTeam() {
            return nameTeam.get();
        }
        public String getNameCoach() {
            return nameCoach.get();
        }
        public String getWordingClub() {
            return wordingClub.get();
        }
    }
}
