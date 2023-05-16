//region packages & imports
package View;

import Controller.Controller;
import Model.Ranking;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

//endregion

public class TreeTournamentPage {
    private final Controller controller;
    private Scene tournamentScene;
    private ToggleGroup teamGroup;
    private RadioButton team4, team8, team16;
    private Label zoneTextInfo;
    private ComboBox<Object> tournamentComboBox;
    private BorderPane root;
    private Button drawButton;

    public TreeTournamentPage (Stage primaryStage, Scene menuScene) throws Exception {
        controller = new Controller();
        this.start(primaryStage, menuScene);
    }

    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Randomizer of tournament tree","secondary page");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.TOP_LEFT);
        contentPane.setVgap(30);
        contentPane.setHgap(30);

        Label zoneTextInfo = new Label();
        zoneTextInfo.setStyle("-fx-font-size:15");

        tournamentComboBox = new ComboBox<>();
        tournamentComboBox.getItems().addAll(controller.getAllFutureTournament());
        tournamentComboBox.setPromptText("Select Tournament");

        contentPane.add(tournamentComboBox,1,4);

        tournamentComboBox.setOnAction(actionEvent -> {
            drawButton.setDisable(false);
        });

        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);

        drawButton = new Button("draw");
        drawButton.setDisable(true);
        contentPane.add(drawButton, 2, 4);
        drawButton.setOnAction(event -> {
            try {
                draw(tournamentComboBox.getSelectionModel().getSelectedItem().toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(eastPanel);

        tournamentScene = new Scene(root, 1280, 720);
        primaryStage.setScene(tournamentScene);
        primaryStage.show();

    }

    /*
    private javafx.scene.control.Label createLabel(String text, int size) {
        javafx.scene.control.Label label = new javafx.scene.control.Label(text);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, size));
        label.setStyle("-fx-text-fill: black;");
        return label;
    }
     */

    public void draw (String tournament) throws Exception {
        ArrayList<Ranking> rankings = controller.getAllRankingOfATounament(controller.getTournamentNumber(tournament));

        if(rankings.size() == controller.getNbTeamOfTournament(tournament)){
            GridPane drawPane = new GridPane();
            drawPane.setVgap(20);
            drawPane.setHgap(50);
            boolean against = true;
            int rnd;
            ArrayList<String> teams = new ArrayList<>();
            for(Ranking ranking : rankings){
                teams.add(ranking.getTeam().getWordingTeam());
            }
            int iTeam = 1;

            while(teams.size() != 0){
                rnd = new Random().nextInt(teams.size());
                Label teamLabel = new Label(teams.get(rnd));
                if(against){
                    drawPane.add(teamLabel, 0, iTeam);
                }else{
                    Label againstLabel = new Label("against");
                    drawPane.add(againstLabel, 1,iTeam);
                    drawPane.add(teamLabel, 2, iTeam);
                    iTeam++;
                }
                teams.remove(rnd);
                against = !against;
            }
            root.setBottom(drawPane);
        }else{
            zoneTextInfo.setText("The number of teams isn't complete");
        }
    }
}
