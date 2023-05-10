package View;

import java.sql.*;
import java.util.ArrayList;

import Controller.Controller;
import Exception.DataException;
import Model.Club;
import Model.Locality;
import Model.Player;
import Model.Team;
import View.Utility.FormularyPlayerCreation;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
/*
    public static void main(String args[]) throws Exception {
        Connection singletonConnexion;
        StringBuilder playersPseudo;
        ArrayList<String> players;
        Controller controller;
        //Player player;
        try {
            controller = new Controller();

            playersPseudo = new StringBuilder();

            players = controller.getAllPseudo();
            for (String player : players) {
                playersPseudo.append(player);
            }



            Date birth = new Date(2002, 4, 5);
            controller.addPlayer(new Player("LeTysme", "Leonard robin", birth, "belge", 0, 2002, "Paris",1));



            String pseudoPlayer = "FlamE";
            System.out.println(pseudoPlayer);
            player = controller.getAPLayer(pseudoPlayer);

            System.out.println(player.getName());


            // controller.deletePlayer("LeTysme");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    */


    @Override
    public void start(Stage stage) throws Exception {
        FormularyPlayerCreation form =  new FormularyPlayerCreation();
        Stage primaryStage = new Stage();
        form.openFormularyUpdate(primaryStage,"FlamE");

    }
    public static void main(String[] args) {
        launch(args);
    }
}



        //System.out.println(playersPseudo.toString());



//singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "Boulettedu13");
 //       System.out.println("Succes");
