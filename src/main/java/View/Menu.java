package View;

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
        contentPane.setVgap(50);
        contentPane.setHgap(50);

        Button button1 = createButton("Page 1");
        Button buttonPageResearch = createButton("Research");
        Button butttonPagePlayer = createButton("Player");
        Button buttonTree = createButton("Tournament tree");

        contentPane.add(button1, 0, 0);
        contentPane.add(buttonPageResearch, 1, 0);
        contentPane.add(butttonPagePlayer, 0, 1);
        contentPane.add(buttonTree, 1, 1);


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
        butttonPagePlayer.setOnAction(event -> {
            try {
                player.start(primaryStage,menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttonTree.setOnAction(event -> {
            try {
                pageRandomizer = new TreeTournamentPage(primaryStage, menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(200, 100);
        button.setStyle("-fx-background-color: darkgrey; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 25px");
        return button;
    }

}

