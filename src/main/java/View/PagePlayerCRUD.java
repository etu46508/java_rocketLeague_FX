package View;

import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class PagePlayerCRUD  {
    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        BorderPane root = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Interface CRUD","secondary page");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(50);
        contentPane.setHgap(50);

        ButtonFactory buttonFactory = new ButtonFactory();
        Button button1 = buttonFactory.buttonCreation(null,null,"next page","Create a Player");
        Button button2 = buttonFactory.buttonCreation(null,null,"next page","Read a Player");
        Button button3 = buttonFactory.buttonCreation(null,null,"next page","Update a Player");
        Button button4 = buttonFactory.buttonCreation(null,null,"next page","Delete a Player");

        contentPane.add(button1, 1, 1);
        contentPane.add(button2, 1, 2);
        contentPane.add(button3, 1, 3);
        contentPane.add(button4, 1, 4);

        BorderPane centerPanel = new BorderPane();
        centerPanel.setLeft(contentPane);

        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);

        Image backgroundImage = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeagueCRUD.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        root.setTop(titlePane);
        root.setCenter(centerPanel);
        root.setBottom(eastPanel);
        root.setBackground(new Background(background));

        Scene playerCRUD = new Scene(root, 1280, 720);
        primaryStage.setScene(playerCRUD);
        primaryStage.show();


        FormularyPlayer formulary = new FormularyPlayer();
        button1.setOnAction(event -> {
            try {

                formulary.openFormulary(primaryStage,null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button2.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"read");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button3.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"update");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button4.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"delete");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

}
