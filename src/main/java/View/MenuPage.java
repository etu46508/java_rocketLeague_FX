//region packages & imports
package View;

import Controller.Controller;
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
import java.sql.SQLException;
import Exception.DataException;

//endregion

public class MenuPage{
    private Scene menuScene;
    private final PagePlayerCRUD playerCRUD;
    private TreeTournamentPage pageRandomizer;
    private final ResearchPage pageResearch;

    public MenuPage(){
        pageResearch = new ResearchPage();
        playerCRUD = new PagePlayerCRUD();
    }

    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Programme Gestion Rocket League","menu");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(60);
        contentPane.setHgap(75);

        MenuItem menuItemPagePlayer = new MenuItem("Player CRUD");
        MenuItem menuItemResearch = new MenuItem("Research");
        MenuItem menuItemPageTree = new MenuItem("Tournament tree");
        MenuItem menuItemThread= new MenuItem("Thread evolved");

        MenuButton menuButton = new MenuButton("Options", null, menuItemPagePlayer,menuItemResearch,menuItemPageTree,menuItemThread);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button buttonPagePlayer = buttonFactory.buttonCreation(null,null,"next page","Player CRUD");
        Button buttonPageResearch = buttonFactory.buttonCreation(null,null,"next page","Research");
        Button buttonPageTree = buttonFactory.buttonCreation(null,null,"next page","Tournament tree");
        Button buttonThread = buttonFactory.buttonCreation(null,null,"next page","Thread evolved");

        contentPane.add(buttonPagePlayer, 0, 0);
        contentPane.add(buttonPageResearch, 1, 0);
        contentPane.add(buttonPageTree, 0, 1);
        contentPane.add(buttonThread , 1, 1);

        //Image backgroundImage = new Image("C:\\Users\\Léonard\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeague.jpg");
        //Image backgroundImage = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeague.jpg");
        Image backgroundImage = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\fondRocketLeague.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        BorderPane southPanel = new BorderPane();
        Button buttonLeave = buttonFactory.buttonCreation(null,null,"options","Leave");
        southPanel.setRight(buttonLeave);

        root.setTop(titlePane);
        root.setLeft(menuButton);
        root.setCenter(contentPane);
        root.setBottom(southPanel);
        root.setBackground(new Background(background));

        MovementThread movementThread = new MovementThread(southPanel);

        menuScene = new Scene(root, 1280, 720);
        primaryStage.setTitle("Programme Java");
        primaryStage.setOnCloseRequest(event -> {
            try {
                Controller controller = new Controller();
                controller.closeConnection();
                System.exit(0);
            } catch (DataException | SQLException e) {
                throw new RuntimeException(e);
            }

        });
        primaryStage.setScene(menuScene);
        primaryStage.show();

        movementThread.start();

        buttonPagePlayer.setOnAction(event -> {
            try {
                playerCRUD.start(primaryStage,menuScene);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        buttonPageResearch.setOnAction(event -> {
            try {
                pageResearch.start(primaryStage,menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });

        buttonPageTree.setOnAction(event -> {
            try {
                pageRandomizer = new TreeTournamentPage(primaryStage, menuScene);
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });

        buttonThread.setOnAction(event -> {
            try {
                ThreadEvolved threadEvolved = new ThreadEvolved(primaryStage,menuScene);
                threadEvolved.start();
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });

        buttonLeave.setOnAction(event -> {
            try {
                Controller controller = new Controller();
                controller.closeConnection();
                System.exit(0);
            } catch (DataException | SQLException e) {
                throw new RuntimeException(e);
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
        menuItemThread.setOnAction(event -> {
            try {
                ThreadEvolved threadEvolved = new ThreadEvolved(primaryStage,menuScene);
                threadEvolved.start();
            } catch (Exception e) {
                new ExceptionDisplay(e);
            }
        });

    }

}

