package View.Utility;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.Objects;

public class ButtonFactory {

    public Button buttonCreation(Stage primaryStage, Scene nextScene,String info,String ... text){
        Button button = new Button();

        if(Objects.equals(info, "menu return")){
            button.setText("Return");
            button.setPrefSize(100, 50);
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
        return button;
    }
}

