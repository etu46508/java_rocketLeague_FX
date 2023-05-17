//region packages & imports
package View;

import View.Utility.ButtonFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//endregion

public class WelcomePage {

    public void start() {
            Stage primaryStage = new Stage();
            BorderPane root = new BorderPane();

            Image picture = new Image("https://github.com/etu46508/java_rocketLeague_FX/blob/master/src/images/logoRocketLeagueBlanc.png?raw=true");
            Rectangle pictureContent = new Rectangle(400,200);
            BorderPane nordPane = new BorderPane();
            pictureContent.setFill(new ImagePattern(picture));

            ButtonFactory factory = new ButtonFactory();
            Button entryButton = factory.buttonCreation(primaryStage ,null,"welcome","Enter");

            Image backgroundImage = new Image("https://github.com/etu46508/java_rocketLeague_FX/blob/master/src/images/fondRocketLeague.jpg?raw=true");
            BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
            BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

            nordPane.setLeft(pictureContent);
            nordPane.setRight(entryButton);
            root.setBottom(nordPane);
            root.setBackground(new Background(background));

            Scene welcomeScene = new Scene(root, 1280, 720);
            welcomeScene.setFill(Color.TRANSPARENT);
            primaryStage.setTitle("Programme Java");

            primaryStage.setScene(welcomeScene);
            primaryStage.setOnCloseRequest(event -> System.exit(0));

            primaryStage.show();

            entryButton.setOnAction(event ->{
                MenuPage mainPage = new MenuPage();
                mainPage.start(primaryStage);
            });

    }

}
