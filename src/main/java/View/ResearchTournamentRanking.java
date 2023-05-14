package View;

import Controller.Controller;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class ResearchTournamentRanking {
    private final Controller controller;
    private final ComboBox<String> monthComboBox,tournamentComboBox;



    public ResearchTournamentRanking(Stage primaryStage) throws Exception {
        controller = new Controller();

        ArrayList<String> months = new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        ));

        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);

        tournamentComboBox = new ComboBox<>();
        tournamentComboBox.setDisable(true);

        monthComboBox.setOnAction(event -> {
            ArrayList<String> tournaments = new ArrayList<>();
            try {
                tournaments.addAll(controller.getTournementOfAMonth(monthComboBox.getSelectionModel().getSelectedIndex() + 1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            tournamentComboBox.getItems().addAll(tournaments);
            tournamentComboBox.setDisable(false);
        });

    }
}
