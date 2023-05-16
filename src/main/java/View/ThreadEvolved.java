//region packages & imports
package View;

import View.Utility.ButtonFactory;
import View.Utility.TitleOfPage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

//endregion

public class ThreadEvolved extends Thread{
    private final Rectangle pictureRectangle;
    private int speed = 20;
    public ThreadEvolved(Stage primaryStage, Scene menuScene){
        BorderPane root = new BorderPane();
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Thread Evolved", "secondary page");

        BorderPane contentPane = new BorderPane();

        pictureRectangle = new Rectangle(400,400);
        Image picture = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\rocketLeagueFly.png");
        //Image picture = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\rocketLeagueFly.png");
        pictureRectangle.setFill(new ImagePattern(picture));
        contentPane.setCenter(pictureRectangle);


        ButtonFactory buttonFactory = new ButtonFactory();
        BorderPane buttonPane = new BorderPane();
        Button increaseSpeedButton = new Button("Increase Speed");
        increaseSpeedButton.setOnAction(e -> {
            if (speed > 3) {
                speed -= 2;
            }
            if (speed > 2) {
                speed -= 1;
            }
        });

        Button decreaseSpeedButton = new Button("Decrease speed");
        decreaseSpeedButton.setOnAction(e -> {
            if(speed < 20){
                speed += 2;
            }
        });

        BorderPane westPanel = new BorderPane();
        westPanel.setCenter(decreaseSpeedButton);

        BorderPane eastPanel = new BorderPane();
        eastPanel.setCenter(increaseSpeedButton);

        Button returnButton1 = buttonFactory.buttonCreation(primaryStage, menuScene, "menu return");
        Button returnButton2 = buttonFactory.buttonCreation(primaryStage, menuScene, "menu return");
        eastPanel.setBottom(returnButton1);
        westPanel.setBottom(returnButton2);

        Image backgroundImage = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\fondRocketLeagueThread.jpg ");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        contentPane.setBottom(buttonPane);
        root.setTop(titlePane);
        root.setRight(eastPanel);
        root.setLeft(westPanel);
        root.setCenter(contentPane);
        root.setBackground(new Background(background));

        Scene threadScene = new Scene(root, 1280, 720);
        primaryStage.setScene(threadScene);
        primaryStage.show();

    }
    public void run(){
        while (true){
            try{
                Thread.sleep(speed );
                Platform.runLater(() -> {
                    Rotate rotate = new Rotate();
                    rotate.setAngle(5);
                    rotate.setPivotX(200);
                    rotate.setPivotY(200);
                    pictureRectangle.getTransforms().add(rotate);
                });
            }
            catch (InterruptedException interruptedException){
                throw new RuntimeException(interruptedException);
            }
        }
    }

}
