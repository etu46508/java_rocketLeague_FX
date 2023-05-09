package Controller;
import Business.Manager;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class Controller {
    private Manager manager;
    public Controller() throws DataException {
        manager = new Manager();
    }

    public void addPlayer(Player player) throws Exception{
        manager.addPlayer(player);
    }

    public ArrayList<String> getAllPseudo() throws Exception{
        ArrayList<String> playerPseudo = manager.getAllPseudo();
        return playerPseudo;
    }

    public Player getAPLayer(String playerPseudo) throws Exception{
        Player player = manager.getAPLayer(playerPseudo);
        return player;
    }
}
