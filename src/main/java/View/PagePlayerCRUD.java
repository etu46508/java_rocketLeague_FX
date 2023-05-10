package View;

import View.Utility.ComboBoxPlayerChoice;
import View.Utility.ReturnMenuButton;
import View.Utility.TitleOfPage;
import View.Utility.FormularyPlayerCreation;
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

        // Création titre Page
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Interface CRUD", 40,"page");




        // Création du espace bouton
        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(50);
        contentPane.setHgap(50);

        // Création des boutons CRUD
        Button button1 = createButton("Create a Player");
        Button button2 = createButton("Read a Player");
        Button button3 = createButton("Update a Player");
        Button button4 = createButton("Delete a Player");


        // Ajout des boutons au contenu
        contentPane.add(button1, 0, 0);
        contentPane.add(button2, 0, 1);
        contentPane.add(button3, 0, 2);
        contentPane.add(button4, 0, 3);

        // création emplacement des boutons
        BorderPane centerPanel = new BorderPane();
        centerPanel.setLeft(contentPane);

        // Button retour au menu
        ReturnMenuButton returnButton = new ReturnMenuButton();
        BorderPane eastPanel = returnButton.returnMenu(primaryStage, menuScene);

        // Ajout du titre et du contenu à la page
        root.setTop(titlePane);
        root.setCenter(centerPanel);
        root.setBottom(eastPanel);

        // Création de la scène Menu et affichage de la fenêtre
        Scene playerCRUD = new Scene(root, 1000, 800);
        primaryStage.setScene(playerCRUD);
        primaryStage.show();

        // ajout au bouton
        FormularyPlayerCreation formulary = new FormularyPlayerCreation();
        button1.setOnAction(event -> {
            try {

                formulary.openFormularyAdd(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        ComboBoxPlayerChoice choicePlayer = new ComboBoxPlayerChoice();
        button3.setOnAction(event -> {
            try {
                choicePlayer.openChoicePlayer(primaryStage);
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
