package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage stage) {
        Menu mainPage = new Menu();
        mainPage.start();
    }
    
}