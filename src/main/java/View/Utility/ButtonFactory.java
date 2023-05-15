package View.Utility;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Objects;

public class ButtonFactory {

    public Button buttonCreation(Stage primaryStage, Scene nextScene,String info,String ... text){
        Button button = new Button();

        if(Objects.equals(info, "menu return")){
            button.setText("Return");
            button.setPrefSize(150, 70);
            button.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 15));
            button.setStyle("-fx-background-color: lightgrey;-fx-border-color: black;");
            button.setOnAction(event -> primaryStage.setScene(nextScene));
        } else if (Objects.equals(info, "close page")) {
            button.setText("Return");
            button.setOnAction(event -> primaryStage.close());
        } else if (Objects.equals(info, "next page")) {
            button.setText(text[0]);
            button.setPrefSize(300, 100);
            button.setStyle("-fx-background-color: darkgrey; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 20px");
        }
        else if (Objects.equals(info, "welcome")){
            button.setText(text[0]);
            button.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
            button.setPrefSize(200, 75);
            button.setStyle("-fx-background-color: E0E0E0; -fx-border-color: black;-fx-background-radius: 30; -fx-border-radius: 30;");
        }
        return button;
    }
}

