//region packages & imports
package View.Utility;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

//endregion

public class MovementThread extends Thread{
    private final Rectangle pictureRectangle;

    public MovementThread (BorderPane root){
        pictureRectangle = new Rectangle(200,200);
        Image picture = new Image("https://github.com/etu46508/java_rocketLeague_FX/blob/master/src/images/balleRocketLeague.png?raw=true");
        pictureRectangle.setFill(new ImagePattern(picture));
        root.setLeft(pictureRectangle);
    }

    public void run(){
        while (true){
            try{
                Thread.sleep(30);
                Rotate rotate = new Rotate();
                rotate.setAngle(10);
                rotate.setPivotX(100);
                rotate.setPivotY(100);
                pictureRectangle.getTransforms().add(rotate);
            }
            catch (InterruptedException interruptedException){
                throw new RuntimeException(interruptedException);
            }
        }
    }
}