package View.Utility;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MovementThread extends Thread{
    private BorderPane root;
    private Rectangle pictureRectangle;

    public MovementThread (BorderPane root){
        this.root = root;
        pictureRectangle = new Rectangle(100,100);
        Image picture = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\balleRocketLeague.png");
        pictureRectangle.setFill(new ImagePattern(picture));
        root.setBottom(pictureRectangle);
    }

    public void run(){
        while (true){
            try{
                Thread.sleep(50);
                Rotate rotate = new Rotate();
                rotate.setAngle(10);
                rotate.setPivotX(50);
                rotate.setPivotY(50);
                pictureRectangle.getTransforms().add(rotate);
            }
            catch (InterruptedException interruptedException){
                throw new RuntimeException(interruptedException);
            }
        }
    }
}