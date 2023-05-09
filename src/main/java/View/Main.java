package View;

import java.sql.*;
import java.util.ArrayList;

import Controller.Controller;
import Exception.DataException;
import Model.Club;
import Model.Locality;
import Model.Player;
import Model.Team;

public class Main {

    public static void main(String args[]) throws Exception {
        Connection singletonConnexion;
        StringBuilder playersPseudo;
        ArrayList<String> players;
        Controller controller ;
        Player player;
        try {
            controller = new Controller();
            /*
            playersPseudo = new StringBuilder();
            Date birth = new Date(2002,4,5);
            controller.addPlayer(new Player("LeTysme","Leonard robin",birth,"belge",0,2002,new Locality("Andenne","Belgique",5350),new Team(1,"agagg","azgaga",new Club(1,"Vitality","neo",birth))));

            players = controller.getAllPseudo();
            for (String player : players) {
                playersPseudo.append(player);
                */

            String pseudoPlayer = "FlamE";
            player = controller.getAPLayer(pseudoPlayer);

            System.out.println(player.getName());
            }catch (Exception e) {
            throw new RuntimeException(e);
        }


        }
        //System.out.println(playersPseudo.toString());

}

//singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "Boulettedu13");
 //       System.out.println("Succes");
