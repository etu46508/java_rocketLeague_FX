package View.Utility;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleOfPage {

    public StackPane createTitle(String text,int size,String type){
        StackPane titlePane = new StackPane();

        titlePane.setPrefHeight(100);
        titlePane.setMinHeight(50);
        titlePane.setMaxHeight(200);
        titlePane.setAlignment(Pos.CENTER);

        Label title = new javafx.scene.control.Label(text);
        if(type.equals("menu")){
            titlePane.setStyle("-fx-background-color: grey;-fx-border-color: black ");
            title.setFont(Font.font("Verdana", FontWeight.BOLD, size));
            title.setStyle("-fx-text-fill: white;");
        } else{
            titlePane.setStyle("-fx-background-color: lightgrey;-fx-border-color: darkgrey ");
            title.setFont(Font.font("Verdana", FontWeight.BOLD, size));
            title.setStyle("-fx-text-fill: black;");
        }

        titlePane.getChildren().add(title);

        return titlePane;
    }

}
