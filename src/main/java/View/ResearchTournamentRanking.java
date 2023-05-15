package View;

import Controller.Controller;
import Model.Ranking;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
                System.out.println(monthComboBox.getValue() + monthComboBox.getSelectionModel().getSelectedIndex());
                tournaments = new ArrayList<>(controller.getTournementOfAMonth(monthComboBox.getSelectionModel().getSelectedIndex() + 1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            tournamentComboBox.getItems().setAll(tournaments);
            tournamentComboBox.setDisable(false);
        });

        tournamentComboBox.setOnAction(event -> validationButton.setDisable(false));

        researchLayout.setTop(titlePane);
        researchLayout.setCenter(comboBoxLayout);
        researchLayout.setBottom(buttonLayout);

        Scene researchScene = new Scene(researchLayout);
        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Combo box player");

        researchStage.setScene(researchScene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();

    }

    private void rankingDisplay(String wordingTournament) throws Exception {
        Integer tournamentNumber = controller.getTournamentNumber(wordingTournament);
        ArrayList<Ranking> rankings = controller.getAllRankingOfATounament(tournamentNumber);
        TableView tableView = new TableView();


    }
}
