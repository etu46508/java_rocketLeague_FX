package View;

import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
        Button button2 = buttonFactory.buttonCreation(null,null,"next page","Tournament won by a player");
        Button button3 = buttonFactory.buttonCreation(null,null,"next page","Tournament won by a club");


        contentPane.add(button1, 2, 5);
        contentPane.add(button2, 0, 8);
        contentPane.add(button3, 3, 8);


        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);

        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(eastPanel);

        Scene researchMenu = new Scene(root, 1000, 800);
        primaryStage.setScene(researchMenu);
        primaryStage.show();

    }



}
