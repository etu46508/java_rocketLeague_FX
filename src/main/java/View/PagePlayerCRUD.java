//region packages & imports
package View;

import View.Utility.ButtonFactory;
import View.Utility.ComboBoxPlayerChoice;
import View.Utility.FormularyPlayer;
import View.Utility.TitleOfPage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

//endregion

public class PagePlayerCRUD  {
    private final StringBuilder listeningCRUD;
    private Stage primaryStage;
    public PagePlayerCRUD(){
        listeningCRUD = new StringBuilder();
    }

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

        Button listiningButton = buttonFactory.buttonCreation(null,null,"options","Listening actions");

        contentPane.add(listiningButton, 1, 5);

        BorderPane centerPanel = new BorderPane();
        centerPanel.setLeft(contentPane);

        BorderPane eastPanel = new BorderPane();
        Button returnButton = buttonFactory.buttonCreation(primaryStage,menuScene,"menu return");
        eastPanel.setRight(returnButton);

        //Image backgroundImage = new Image("C:\\Users\\Léonard\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeagueCRUD.jpg");
        //Image backgroundImage = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeagueCRUD.jpg");
        Image backgroundImage = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\fondRocketLeagueCRUD.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        root.setTop(titlePane);
        root.setCenter(centerPanel);
        root.setBottom(eastPanel);
        root.setBackground(new Background(background));

        Scene playerCRUD = new Scene(root, 1280, 720);
        primaryStage.setScene(playerCRUD);
        primaryStage.show();

        listiningButton.setOnAction(event -> displayListeningAction(listeningCRUD));


        button1.setOnAction(event -> {
            try {
                FormularyPlayer formulary = new FormularyPlayer();
                formulary.openFormulary(primaryStage,null,listeningCRUD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button2.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"read",listeningCRUD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button3.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"update",listeningCRUD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        button4.setOnAction(event -> {
            try {
                ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
                choicePlayer.openChoicePlayer(primaryStage,"delete",listeningCRUD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
    private void displayListeningAction(StringBuilder listeningCRUD){
        Stage displayStage = new Stage();
        BorderPane contentDisplay = new BorderPane();
        contentDisplay.setPadding(new Insets(20));

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Listening actions :","display");

        Label listeningText = new Label();
        if(listeningCRUD.toString().equals("")){
            listeningText.setText("no action during this session");
        }else{
           listeningText.setText(listeningCRUD.toString());
        }

        contentDisplay.setTop(titlePane);
        contentDisplay.setCenter(listeningText );

        listeningText.setStyle("-fx-font-size: 18;");
        listeningText.setWrapText(true);
        listeningText.setMaxWidth(Double.MAX_VALUE);
        listeningText.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin( listeningText , new Insets(20));

        Scene displayScene = new Scene(contentDisplay,600,400);
        displayStage.initModality(Modality.APPLICATION_MODAL);
        displayStage.setScene(displayScene);

        displayStage.initOwner(primaryStage);
        displayStage.showAndWait();
    }

}
