package View;

import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Menu  {

    private Scene menuScene;
    private PagePlayerCRUD player;
    private TreeTournamentPage pageRandomizer;
    private ResearchPage pageResearch;


    public void start(){
        BorderPane root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Programme Gestion Rocket League","menu");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(60);
        contentPane.setHgap(75);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button button1 = buttonFactory.buttonCreation(null,null,"next page","IDK ");
        Button buttonPageResearch = buttonFactory.buttonCreation(null,null,"next page","Research");
        Button buttonPagePlayer = buttonFactory.buttonCreation(null,null,"next page","Player CRUD");
        Button buttonPageTree = buttonFactory.buttonCreation(null,null,"next page","Tournament tree");

        contentPane.add(button1, 0, 0);
        contentPane.add(buttonPageResearch, 1, 0);
        contentPane.add(buttonPagePlayer, 0, 1);
        contentPane.add(buttonPageTree, 1, 1);

        // Création espace image
        BorderPane southPanel = new BorderPane();
        Label image = new Label("Image");
        image.setStyle("fx-font-size: 10 px;-fx-border-color: red;");
        southPanel.setRight(image);

        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(southPanel);

        menuScene = new Scene(root, 1000, 800);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Programme Java");

        primaryStage.setScene(menuScene);
        primaryStage.show();

        pageResearch = new ResearchPage();
        buttonPageResearch.setOnAction(event -> {
            try {
                pageResearch.start(primaryStage,menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        player = new PagePlayerCRUD();
        buttonPagePlayer.setOnAction(event -> {
            try {
                player.start(primaryStage,menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttonPageTree.setOnAction(event -> {
            try {
                pageRandomizer = new TreeTournamentPage(primaryStage, menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}

