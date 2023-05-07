package View.Utility;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ReturnMenuButton {

    public BorderPane returnMenu(Stage primaryStage, Scene menuScene){
        // Création du bouton "Return"
        Button returnButton = new Button("Return");
        returnButton.setPrefSize(100, 50);
        returnButton.setStyle("-fx-background-color: lightgrey;-fx-border-color: black;");

        // création emplacement bouton Return
        Scene finalMenuScene = menuScene;
        returnButton.setOnAction(event -> primaryStage.setScene(finalMenuScene));
        BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);
        return eastPanel;
    }

}
