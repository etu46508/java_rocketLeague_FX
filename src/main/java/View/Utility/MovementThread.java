package View.Utility;


import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class MovementThread extends Thread{
    private Rectangle pictureRectangle;

    public MovementThread (BorderPane root){
        pictureRectangle = new Rectangle(100,100);
        Image picture = new Image("C:\\Users\\Robin\\OneDrive\\Documents\\GitHub\\java_rocketLeague_FX\\src\\images\\balleRocketLeague.png");
        // Image picture = new Image("C:\\Users\\merlin\\Desktop\\iesn\\bloc 2\\java\\ProjetJavaFxV0\\ProjetJavaFxV0\\src\\images\\balleRocketLeague.png");
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