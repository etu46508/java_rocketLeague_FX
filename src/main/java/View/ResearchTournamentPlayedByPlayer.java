package View;

import Controller.Controller;
import Model.Ranking;
import Model.Tournament;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import Exception.DataException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;


public class ResearchTournamentPlayedByPlayer {

    private final Controller controller;
    private final ComboBox<String> teamComboBox,playerInTeamComboBox;

    public ResearchTournamentPlayedByPlayer(Stage primaryStage) throws DataException {
        controller = new Controller();
        Stage researchStage = new Stage();

        BorderPane researchLayout = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Tournament by a player  :","research display");

        GridPane comboBoxLayout = new GridPane();
        comboBoxLayout.setAlignment(Pos.CENTER);
        comboBoxLayout.setHgap(20);
        comboBoxLayout.setVgap(20);
        comboBoxLayout.setPadding(new Insets(20));

        Label teamsChoice = new Label("Team : ");
        teamComboBox = new ComboBox<>();
        teamComboBox.getItems().addAll(controller.getWordingFullTeam());

        Label playerChoice = new Label("Player : ");
        playerInTeamComboBox = new ComboBox<>();
        playerInTeamComboBox.setDisable(true);

        comboBoxLayout.add(teamsChoice,0,0);
        comboBoxLayout.add(teamComboBox,1,0);
        comboBoxLayout.add(playerChoice,0,1);
        comboBoxLayout.add(playerInTeamComboBox,1,1);

        BorderPane buttonLayout = new BorderPane();
        Button validationButton = new Button("Validation");
        validationButton.setDisable(true);
        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(researchStage,null,"close page");

        buttonLayout.setLeft(validationButton);
        buttonLayout.setRight(returnButton);

        teamComboBox.setOnAction(event -> {
            ArrayList<String> players;
            try {
                players = new ArrayList<>(controller.getPseudoPlayerInTeam(teamComboBox.getValue()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            playerInTeamComboBox.getItems().setAll(players);
            playerInTeamComboBox.setDisable(false);
        });

        playerInTeamComboBox.setOnAction(event -> validationButton.setDisable(false));

        validationButton.setOnAction(event -> {
            try {
                historicDisplay(researchStage,playerInTeamComboBox.getValue());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        researchLayout.setTop(titlePane);
        researchLayout.setCenter(comboBoxLayout);
        researchLayout.setBottom(buttonLayout);

        Scene researchScene = new Scene(researchLayout,300,200);
        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Player choice");

        researchStage.setScene(researchScene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();


    }

    private void historicDisplay(Stage researchStage,String pseudoPlayer) throws Exception {
        ArrayList<Ranking> rankings = new ArrayList<>(controller.getAllRankingOfAPlayer(pseudoPlayer));

        TableView<InfoPerformancePlayer> tableView = new TableView<>();

        TableColumn<InfoPerformancePlayer, String> wordingTournamentColumn = new TableColumn<>("Tournament");
        wordingTournamentColumn.setCellValueFactory(new PropertyValueFactory<>("wordingTournament"));

        TableColumn<InfoPerformancePlayer, String>  dateTournamentColumn = new TableColumn<>("Date");
        dateTournamentColumn.setCellValueFactory(new PropertyValueFactory<>("dateTournament"));

        TableColumn<InfoPerformancePlayer, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<InfoPerformancePlayer, String> wordingTeamColumn = new TableColumn<>("Team");
        wordingTeamColumn.setCellValueFactory(new PropertyValueFactory<>("wordingTeam"));

        TableColumn<InfoPerformancePlayer, String> cashPrizeColumn = new TableColumn<>("CashPrize");
        cashPrizeColumn.setCellValueFactory(new PropertyValueFactory<>("cashPrize"));

        TableColumn<InfoPerformancePlayer, String> nbGoalScoredColumn = new TableColumn<>("NbGoalScored");
        nbGoalScoredColumn.setCellValueFactory(new PropertyValueFactory<>("nbGoalScored"));

        TableColumn<InfoPerformancePlayer, String> nbGoalConcededColumn = new TableColumn<>("nNbGoalConceded");
        nbGoalConcededColumn.setCellValueFactory(new PropertyValueFactory<>("nbGoalConceded"));

        TableColumn<InfoPerformancePlayer, String> nbSpectatorColumn = new TableColumn<>("Number Of Spectator");
        nbSpectatorColumn.setCellValueFactory(new PropertyValueFactory<>("nbSpectator"));

        TableColumn<InfoPerformancePlayer, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView.getColumns().addAll(wordingTournamentColumn,dateTournamentColumn,positionColumn,wordingTeamColumn,cashPrizeColumn,nbGoalScoredColumn,nbGoalConcededColumn,nbSpectatorColumn,addressColumn);

        for(Ranking rank : rankings){
            Tournament tournament = controller.getTournament(rank.getTournament().getWording());

            if(tournament.getLocation() == null){
                tableView.getItems().add(new InfoPerformancePlayer(rank.getTournament().getWording(),
                        tournament.getStartDate(),
                        rank.getPosition(),
                        rank.getTeam().getWordingTeam(),
                        rank.getCashPrize(),
                        rank.getNbGoalScored(),
                        rank.getNbGoalConceded()));

            }
            else{
                tableView.getItems().add(new InfoPerformancePlayer(rank.getTournament().getWording(),
                        tournament.getStartDate(),
                        rank.getPosition(),
                        rank.getTeam().getWordingTeam(),
                        rank.getCashPrize(),
                        rank.getNbGoalScored(),
                        rank.getNbGoalConceded(),
                        tournament.getNbSpectator(),
                        tournament.getStreetAndNumber(),
                        tournament.getLocation().getWording(),
                        tournament.getLocation().getPostalCode(),
                        tournament.getLocation().getCountry()));
            }
        }

        VBox root = new VBox(10);
        root.getChildren().addAll(tableView);
        Stage rankDisplayStage = new Stage();
        Scene rankDisplayScene = new Scene(root);
        rankDisplayStage.initModality(Modality.APPLICATION_MODAL);
        rankDisplayStage.setTitle("TableView player performance display");

        rankDisplayStage.setScene(rankDisplayScene);
        rankDisplayStage.initOwner(researchStage);
        rankDisplayStage.showAndWait();
    }

    public static class InfoPerformancePlayer {

        private final SimpleStringProperty wordingTournament;
        private final SimpleStringProperty dateTournament;
        private final SimpleStringProperty position;
        private final SimpleStringProperty wordingTeam;
        private final SimpleStringProperty cashPrize;
        private final SimpleStringProperty nbGoalScored;
        private final SimpleStringProperty nbGoalConceded;
        private SimpleStringProperty nbSpectator;
        private SimpleStringProperty address;


        public InfoPerformancePlayer(String wordingTournament, LocalDate dateTournament,Integer position, String wordingTeam, Integer cashPrize, Integer nbGoalScored, Integer nbGoalConceded, Integer nbSpectator, String streetAndNumber, String wordingLocality, Integer codePostal, String country) {
            this.wordingTournament = new SimpleStringProperty(wordingTournament);
            this.dateTournament = new SimpleStringProperty(dateTournament.toString());
            this.position = new SimpleStringProperty(position.toString());
            this.wordingTeam = new SimpleStringProperty(wordingTeam);
            this.cashPrize = new SimpleStringProperty(cashPrize.toString());
            this.nbGoalScored = new SimpleStringProperty(nbGoalScored.toString());
            this.nbGoalConceded = new SimpleStringProperty(nbGoalConceded.toString());
            setNbSpectator(nbSpectator);
            setAddress(streetAndNumber,wordingLocality,codePostal,country);
        }
        public InfoPerformancePlayer(String wordingTournament, LocalDate dateTournament,Integer position, String wordingTeam, Integer cashPrize, Integer nbGoalScored, Integer nbGoalConceded) {
            this.wordingTournament = new SimpleStringProperty(wordingTournament);
            this.dateTournament = new SimpleStringProperty(dateTournament.toString());
            this.position = new SimpleStringProperty(position.toString());
            this.wordingTeam = new SimpleStringProperty(wordingTeam);
            this.cashPrize = new SimpleStringProperty(cashPrize.toString());
            this.nbGoalScored = new SimpleStringProperty(nbGoalScored.toString());
            this.nbGoalConceded = new SimpleStringProperty(nbGoalConceded.toString());
            setNbSpectator(0);
            setAddress(null,null,null,null);
        }


        public String getWordingTournament() {
            return wordingTournament.get();
        }
        public String getDateTournament() {
            return dateTournament.get();
        }
        public String getPosition() {
            return position.get();
        }
        public String getWordingTeam() {
            return wordingTeam.get();
        }
        public String getCashPrize() {
            return cashPrize.get();
        }
        public String getNbGoalScored() {
            return nbGoalScored.get();
        }
        public String getNbGoalConceded() {
            return nbGoalConceded.get();
        }
        public String getNbSpectator() {
            return nbSpectator.get();
        }
        public String getAddress() {
            return address.get();
        }

        public void setNbSpectator(Integer nbSpectator){
            if(nbSpectator == 0){
                this.nbSpectator = new SimpleStringProperty("<unknowm>");
            }else{
                this.nbSpectator = new SimpleStringProperty(nbSpectator.toString());
            }
        }

        public void setAddress(String streetAndNumber, String wordingLocality, Integer codePostal, String country){
            if(streetAndNumber == null ){
                this.address = new SimpleStringProperty("In streaming");
            }else{
                this.address = new SimpleStringProperty(streetAndNumber+", "+codePostal.toString()+" "+" "+wordingLocality+", "+country);
            }
        }
    }

}
