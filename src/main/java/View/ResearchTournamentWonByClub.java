package View;

import Controller.Controller;
import Model.Club;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ResearchTournamentWonByClub {
    private final Controller controller;
    private final ComboBox<String> clubComboBox;

    public ResearchTournamentWonByClub(Stage primaryStage) throws Exception{
        controller = new Controller();
        Stage researchStage = new Stage();

        BorderPane researchLayout = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Victories of a club :","research display");

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

        BorderPane buttonLayout = new BorderPane();
        Button buttonDisplayTournament = new Button("Display");
        buttonDisplayTournament.setDisable(true);
        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(researchStage,null,"close page");

        buttonLayout.setLeft(buttonDisplayTournament);
        buttonLayout.setRight(returnButton);


        clubComboBox.setOnAction(actionEvent -> {
            buttonDisplayTournament.setDisable(false);
        });

        buttonDisplayTournament.setOnAction(actionEvent -> {
            ArrayList<String> tournaments;
            try {
                Integer clubSelected = controller.getSerialNumber(clubComboBox.getValue());
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
            Scene displayScene = new Scene(root, 350, 250);
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

        Scene scene = new Scene(researchLayout,350,200);

        researchStage.initModality(Modality.APPLICATION_MODAL);
        researchStage.setTitle("Tournament(s) won by a club");
        researchStage.setScene(scene);
        researchStage.initOwner(primaryStage);
        researchStage.showAndWait();
    }
}
