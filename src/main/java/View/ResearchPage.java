package View;

import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResearchPage {

    public void start(Stage primaryStage, Scene menuScene) {
        BorderPane root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Research","secondary page");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.TOP_CENTER);
        contentPane.setVgap(30);
        contentPane.setHgap(30);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button button1 = buttonFactory.buttonCreation(null,null,"next page","Tournament Ranking");
        Button button2 = buttonFactory.buttonCreation(null,null,"next page","Historic of a player");
        Button button3 = buttonFactory.buttonCreation(null,null,"next page","Tournament won by a club");

        contentPane.add(button1, 1, 4);
        contentPane.add(button2, 0, 8);
        contentPane.add(button3, 2, 8);

        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);

        Image backgroundImage = new Image("C:\\Users\\Léonard\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeagueResearch.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(eastPanel);
        root.setBackground(new Background(background));

        Scene researchMenu = new Scene(root, 1280, 720);
        primaryStage.setScene(researchMenu);
        primaryStage.show();

        button1.setOnAction(event -> {
            try {
                ResearchTournamentRanking researchTournamentRanking = new ResearchTournamentRanking(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        button2.setOnAction(event -> {
            try {
                ResearchTournamentPlayedByPlayer researchTournamentPlayedByPlayer = new ResearchTournamentPlayedByPlayer(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        button3.setOnAction(event -> {
            try {
                ResearchTournamentWonByClub researchTournamentWonByClub = new ResearchTournamentWonByClub(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }



}
