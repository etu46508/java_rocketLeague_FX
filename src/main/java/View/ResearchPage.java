package View;

import View.Utility.ReturnMenuButton;
import View.Utility.TitleOfPage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ResearchPage {
    private Stage primaryStage;
    private Scene researchMenu;

    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        this.primaryStage = primaryStage;
        BorderPane root = new BorderPane();

        // Création titre Page
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Research", 40,"page");




        // Création du espace content bouton, message, comboBox
        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.TOP_CENTER);
        contentPane.setVgap(30);
        contentPane.setHgap(30);


        // Création des boutons CRUD
        Button button1 = createButton("Tournament Ranking");
        Button button2 = createButton("Tournament won by a player");
        Button button3 = createButton("Tournament won by a club ");

        // Ajout des boutons au contenu
        contentPane.add(button1, 2, 5);
        contentPane.add(button2, 0, 8);
        contentPane.add(button3, 3, 8);

        // Button retour au menu
        ReturnMenuButton returnButton = new ReturnMenuButton();
        BorderPane eastPanel = returnButton.returnMenu(primaryStage, menuScene);




        // Ajout du titre et du contenu à la page
        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(eastPanel);


        // Création de la scène Menu et affichage de la fenêtre
        researchMenu = new Scene(root, 1000, 800);
        primaryStage.setScene(researchMenu);
        primaryStage.show();

    }


    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(350, 100);
        button.setStyle("-fx-background-color: darkgrey; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 20px");
        return button;
    }

}
