package View.Utility;

import Controller.Controller;
import Model.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Exception.DataException;
public class PlayerSheetDisplay {
    private Player player;
    private Controller controller;
    public PlayerSheetDisplay(String pseudoPlayer) throws Exception {
        controller = new Controller();
        this.player = controller.getAPLayer(pseudoPlayer);

        BorderPane contentDisplay = new BorderPane();

        StackPane titlePane = new StackPane();
        titlePane.setAlignment(Pos.CENTER);

        Label titleSheet = new Label("Player sheet : ");
        titlePane.getChildren().add(titleSheet);

        Label textSheet = new Label(player.toString());

        contentDisplay.setTop(titleSheet);
        contentDisplay.setCenter(textSheet);

        Scene displayScene = new Scene(contentDisplay);
        Stage displayStage = new Stage();

        displayStage.setScene(displayScene);
        displayStage.show();

    }
}
