package View;

import Controller.Controller;
import Model.Ranking;
import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;


public class TreeTournamentPage {
    private final Controller controller;
    private Label zoneTextInfo;
    private ComboBox tournamentComboBox;
    private BorderPane root,contentPane;
    private Button drawButton;

    public TreeTournamentPage (Stage primaryStage, Scene menuScene) throws Exception {
        controller = new Controller();
        this.start(primaryStage, menuScene);
    }

    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Randomizer of tournament tree","secondary page");

        GridPane choicePane = new GridPane();
        choicePane.setAlignment(Pos.CENTER);
        choicePane.setVgap(30);
        choicePane.setHgap(30);

        Label zoneTextInfo = new Label();
        zoneTextInfo.setStyle("-fx-font-size:15");

        tournamentComboBox = new ComboBox<>();
        tournamentComboBox.getItems().addAll(controller.getAllFutureTournament());
        tournamentComboBox.setPromptText("Select Tournament");

        choicePane.add(tournamentComboBox,1,0);

        tournamentComboBox.setOnAction(actionEvent -> {
            drawButton.setDisable(false);
        });

        ButtonFactory buttonFactory = new ButtonFactory();
        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);

        drawButton = new Button("draw");
        drawButton.setDisable(true);
        choicePane.add(drawButton, 2, 0);
        drawButton.setOnAction(event -> {
            try {
                draw(tournamentComboBox.getSelectionModel().getSelectedItem().toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Image backgroundImage = new Image("https://github.com/etu46508/java_rocketLeague_FX/blob/master/src/images/fondRocketLeagueTree.jpg?raw=true");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        root.setTop(titlePane);
        root.setLeft(choicePane);
        root.setBottom(eastPanel);
        root.setBackground(new Background(background));

        Scene tournamentScene = new Scene(root, 1280, 720);
        primaryStage.setScene(tournamentScene);
        primaryStage.show();

    }

    public void draw (String tournament) throws Exception {
        ArrayList<Ranking> rankings = controller.getAllRankingOfATournament(controller.getTournamentNumber(tournament));

        if(rankings.size() == controller.getNbTeamOfTournament(tournament)){
            GridPane drawPane = new GridPane();
            drawPane.setAlignment(Pos.CENTER);
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
                teamLabel.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
                teamLabel.setStyle("-fx-text-fill: White;");
                if(against){
                    drawPane.add(teamLabel, 0, iTeam);
                }else{
                    Label againstLabel = new Label("against");
                    againstLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                    againstLabel.setStyle("-fx-text-fill: White;");
                    drawPane.add(againstLabel, 1,iTeam);
                    drawPane.add(teamLabel, 2, iTeam);
                    iTeam++;
                }
                teams.remove(rnd);
                against = !against;
            }
            root.setCenter(drawPane);
        }else{
            zoneTextInfo.setText("The number of teams isn't complete");
        }
    }
    public BorderPane getRoot(){
        return root;
    }

    public Button getDrawButton() {
        return drawButton;
    }
    public ComboBox getTournamentComboBox() {
        return tournamentComboBox;
    }

    public Label getZoneTextInfo() {
        return zoneTextInfo;
    }
}
