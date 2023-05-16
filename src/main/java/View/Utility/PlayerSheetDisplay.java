//region packages & imports
package View.Utility;

import Controller.Controller;
import Model.Player;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.time.LocalDate;

//endregion

public class PlayerSheetDisplay {
    public PlayerSheetDisplay(String pseudoPlayer,StringBuilder listeningCRUD) throws Exception {
        Controller controller = new Controller();
        Player player = controller.getAPLayer(pseudoPlayer);

        Stage displayStage = new Stage();
        BorderPane contentDisplay = new BorderPane();
        contentDisplay.setPadding(new Insets(20));

        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Player sheet :","display");

        Label textSheet = new Label(player.toString());
        textSheet.setStyle("-fx-font-size: 18;");
        textSheet.setWrapText(true);
        textSheet.setMaxWidth(Double.MAX_VALUE);
        textSheet.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin( textSheet , new Insets(20));

        contentDisplay.setTop(titlePane);
        contentDisplay.setCenter(textSheet);

        displayStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            titlePane.setPrefWidth(newVal.doubleValue());
            textSheet.setPrefWidth(newVal.doubleValue());
        });

        displayStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double height = newVal.doubleValue() - titlePane.getHeight() - 3 * contentDisplay.getPadding().getTop() - 2 * textSheet.getPadding().getTop() - textSheet.getPadding().getBottom();
            textSheet.setPrefHeight(height);
        });
        listeningCRUD.append(LocalDate.now()).append(" : Reading of the player - ").append(player.getPseudo()).append("\n");
        Scene displayScene = new Scene(contentDisplay,600,400);
        displayStage.setScene(displayScene);
        displayStage.show();

    }

}
