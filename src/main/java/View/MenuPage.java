package View;

import View.Utility.ButtonFactory;
import View.Utility.ExceptionDisplay;
import View.Utility.MovementThread;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MenuPage{

    private Scene menuScene;
    private final PagePlayerCRUD playerCRUD;
    private TreeTournamentPage pageRandomizer;
    private final ResearchPage pageResearch;

    public MenuPage(){
        pageResearch = new ResearchPage();
        playerCRUD = new PagePlayerCRUD();
    }

    public void start(Stage primaryStage, Scene welcomeScene){
        BorderPane root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Programme Gestion Rocket League","menu");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(60);
        contentPane.setHgap(75);

        MenuItem menuItem1 = new MenuItem("IDK");
        MenuItem menuItemResearch = new MenuItem("Research");
        MenuItem menuItemPagePlayer = new MenuItem("Player CRUD");
        MenuItem menuItemPageTree = new MenuItem("Tournament tree");

        MenuButton menuButton = new MenuButton("Options", null, menuItem1,menuItemResearch, menuItemPagePlayer,menuItemPageTree);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button button1 = buttonFactory.buttonCreation(null,null,"next page","IDK ");
        Button buttonPageResearch = buttonFactory.buttonCreation(null,null,"next page","Research");
        Button buttonPagePlayer = buttonFactory.buttonCreation(null,null,"next page","Player CRUD");
        Button buttonPageTree = buttonFactory.buttonCreation(null,null,"next page","Tournament tree");

        contentPane.add(button1, 0, 0);
        contentPane.add(buttonPageResearch, 1, 0);
        contentPane.add(buttonPagePlayer, 0, 1);
        contentPane.add(buttonPageTree, 1, 1);

        Image backgroundImage = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeague.jpg");
        //Image backgroundImage = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\fondRocketLeague.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        BorderPane southPanel = new BorderPane();
        Button buttonThreadEvolved = buttonFactory.buttonCreation(null,null,"options","Thread Evolved");
        southPanel.setRight(buttonThreadEvolved);

        root.setTop(titlePane);
        root.setLeft(menuButton);
        root.setCenter(contentPane);
        root.setBottom(southPanel);
        root.setBackground(new Background(background));

        MovementThread movementThread = new MovementThread(southPanel);

        menuScene = new Scene(root, 1280, 720);
        primaryStage.setTitle("Programme Java");
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });
        primaryStage.setScene(menuScene);
        primaryStage.show();

        movementThread.start();

        button1.setOnAction(event -> {
            try {
                System.out.println("Gestion");
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });
        buttonPageResearch.setOnAction(event -> {
            try {
                pageResearch.start(primaryStage,menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });
        buttonPagePlayer.setOnAction(event -> {
            try {
                playerCRUD.start(primaryStage,menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttonPageTree.setOnAction(event -> {
            try {
                pageRandomizer = new TreeTournamentPage(primaryStage, menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });
        buttonThreadEvolved.setOnAction(event -> {
            try {
                ThreadEvolved threadEvolved = new ThreadEvolved(primaryStage,menuScene);
                threadEvolved.start();
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });

        menuItemResearch.setOnAction(event -> {
            try {
                pageResearch.start(primaryStage,menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });
        menuItemPagePlayer.setOnAction(event -> {
            try {
                playerCRUD.start(primaryStage,menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });
        menuItemPageTree.setOnAction(event -> {
            try {
                pageRandomizer = new TreeTournamentPage(primaryStage, menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });


    }
}

