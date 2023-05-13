package View;

import View.Utility.ComboBoxPlayerChoice;
import View.Utility.ReturnMenuButton;
import View.Utility.TitleOfPage;
import View.Utility.FormularyPlayer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class PagePlayerCRUD  {
    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        BorderPane root = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Interface CRUD", 40,"page");

        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(50);
        contentPane.setHgap(50);

        Button button1 = createButton("Create a Player");
        Button button2 = createButton("Read a Player");
        Button button3 = createButton("Update a Player");
        Button button4 = createButton("Delete a Player");

        contentPane.add(button1, 0, 0);
        contentPane.add(button2, 0, 1);
        contentPane.add(button3, 0, 2);
        contentPane.add(button4, 0, 3);

        BorderPane centerPanel = new BorderPane();
        centerPanel.setLeft(contentPane);

        ReturnMenuButton returnButton = new ReturnMenuButton();
        BorderPane eastPanel = returnButton.returnMenu(primaryStage, menuScene);

        root.setTop(titlePane);
        root.setCenter(centerPanel);
        root.setBottom(eastPanel);

        Scene playerCRUD = new Scene(root, 1000, 800);
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

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(200, 100);
        button.setStyle("-fx-background-color: darkgrey; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 20px");
        return button;
    }
}
