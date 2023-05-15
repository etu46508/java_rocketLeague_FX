package View;

import Controller.Controller;
import Model.Club;
import View.Utility.TitleOfPage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ResearchTournamentWonByClub {
    private final Controller controller;

    private final ComboBox<String> clubs;

    public ResearchTournamentWonByClub(Stage primaryStage) throws Exception{
        controller = new Controller();

        Stage researchStage = new Stage();

        clubs = new ComboBox<>();
        clubs.getItems().addAll(controller.getAllClubName());

        BorderPane researchClub = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Clubs :","research display");

        Button buttonDisplayTournament = new Button("Afficher");
        buttonDisplayTournament.setDisable(true);

        clubs.setOnAction(actionEvent -> {
            ArrayList<String> tournaments;
            try {
                Integer clubSelected = controller.getSerialNumber(clubs.getValue());
                tournaments = new ArrayList<>(controller.getTournamentWonByClub(clubSelected));
                //!!!!!!!!!!!ERREUR!!!!!!! affiche tt les tournois jpense
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //----code de chatGPT pour tableView-----------------------------------------
            TableView<String[]> tableView = new TableView<>();

            TableColumn<String[], String> nameColumn = new TableColumn<>("Nom");
            nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0]));

            TableColumn<String[], String> dateColumn = new TableColumn<>("Date");
            dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1]));

            tableView.getColumns().addAll(nameColumn, dateColumn);

            ObservableList<String[]> data = FXCollections.observableArrayList();
            for (String tournament : tournaments) {
                String[] parts = tournament.split(",");
                data.add(parts);
            }

            tableView.setItems(data);
            Scene displayScene = new Scene(tableView, 500,300);
            researchStage.setTitle("Tournament won by " + clubs.getValue());
            researchStage.setScene(displayScene);
            //------------------------------------------------------------------------------
        });

        researchClub.setLeft(clubs);

        Scene scene = new Scene(researchClub, 500,300);
        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Tournament(s) won by a club");
        researchStage.setScene(scene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();
    }
}
