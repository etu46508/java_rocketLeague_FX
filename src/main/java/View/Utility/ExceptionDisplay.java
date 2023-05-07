package View.Utility;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExceptionDisplay {
    private Label textDisplay;
    private Stage primaryStage;
    private Scene scene;
    private String text;
    public ExceptionDisplay(String text) {
        this.text = text;
        display();
    }

    public void display(){
        primaryStage = new Stage();
        primaryStage.setTitle("Display Exception");

        BorderPane root = new BorderPane();

        textDisplay = new Label();
        textDisplay.setStyle(this.text);

        root.setCenter(textDisplay);

        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root, 400,200 );
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
}
