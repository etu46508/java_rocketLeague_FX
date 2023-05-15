package View;

import Controller.Controller;
import Model.Club;
import View.Utility.TitleOfPage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
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
                int clubSelected = controller.getSerialNumber(clubs.getValue());
                tournaments = new ArrayList<>(controller.getTournamentWonByClub(clubSelected));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
