package View.Utility;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class ButtonFactory {

    public Button buttonCreation(Stage primaryStage, Scene menuScene,String info){
        Button button;
        button = new Button("Return");
        if(Objects.equals(info, "menu return")){

            button.setPrefSize(100, 50);
            button.setStyle("-fx-background-color: lightgrey;-fx-border-color: black;");
            button.setOnAction(event -> primaryStage.setScene(menuScene));
        } else if (Objects.equals(info, "close page")) {
            button.setOnAction(event -> primaryStage.close());
        }


        return button;
    }
}
/*
    BorderPane eastPanel = new BorderPane();
        eastPanel.setRight(returnButton);
                return eastPanel;
                */
