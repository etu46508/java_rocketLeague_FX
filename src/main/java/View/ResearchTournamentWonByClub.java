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
import javafx.scene.layout.VBox;
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

        Button buttonDisplayTournament = new Button("Afficher");
        buttonDisplayTournament.setDisable(true);


        clubs.setOnAction(actionEvent -> {
            buttonDisplayTournament.setDisable(false);
        });

        buttonDisplayTournament.setOnAction(actionEvent -> {
            ArrayList<String> tournaments;
            try {
                Integer clubSelected = controller.getSerialNumber(clubs.getValue());
                tournaments = new ArrayList<>(controller.getTournamentWonByClub(clubSelected));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            TableColumn<String, String> nameColumn = new TableColumn<>("Nom");
            nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().split("\\|")[0]));

            TableColumn<String, String> dateColumn = new TableColumn<>("Date");
            dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().split("\\|")[1]));

            TableView<String> wonByClubTable = new TableView<>();
            wonByClubTable.getColumns().addAll(nameColumn, dateColumn);

            ObservableList<String> tournamentList = FXCollections.observableArrayList(tournaments);
            wonByClubTable.setItems(tournamentList);


            VBox root = new VBox(10);
            root.getChildren().addAll(wonByClubTable);
            Scene displayScene = new Scene(root, 300, 300);
            Stage displayStage = new Stage();
            displayStage.initModality(Modality.APPLICATION_MODAL);
            displayStage.setTitle("Tournament won by " + clubs.getValue());
            displayStage.setScene(displayScene);
            displayStage.initOwner(researchStage);
            displayStage.showAndWait();
        });

        researchClub.setLeft(clubs);

        Scene scene = new Scene(researchClub, 200,200);
        researchClub.setBottom(buttonDisplayTournament);
        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Tournament(s) won by a club");
        researchStage.setScene(scene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();
    }
}
