package View.Utility;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleOfPage {

    public StackPane createTitle(String text,String type){
        StackPane titlePane = new StackPane();
        Label title = new Label(text);

        if(type.equals("menu")){
            titlePane.setPrefHeight(100);
            titlePane.setMinHeight(50);
            titlePane.setMaxHeight(200);
            titlePane.setAlignment(Pos.CENTER);
            titlePane.setStyle("-fx-background-color: grey;-fx-border-color: black ");
            title.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
            title.setStyle("-fx-text-fill: white;");
        }else if(type.equals("secondary page")){
            titlePane.setPrefHeight(100);
            titlePane.setMinHeight(50);
            titlePane.setMaxHeight(200);
            titlePane.setAlignment(Pos.CENTER);
            titlePane.setStyle("-fx-background-color: lightgrey;-fx-border-color: darkgrey ");
            title.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
            title.setStyle("-fx-text-fill: black;");
        } else if (type.equals("player display")) {
            titlePane.setPrefHeight(30);
        }


        return titlePane;
    }

}
