package Controller;
import Business.Manager;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class Controller {
    private final Manager manager;
    public Controller() throws DataException {
        manager = new Manager();
    }

    public void addPlayer(Player player) throws Exception{
        manager.addPlayer(player);
    }

    public ArrayList<String> getAllPseudo() throws Exception{
        return manager.getAllPseudo();
    }

    public Player getAPLayer(String playerPseudo) throws Exception{
        return manager.getAPLayer(playerPseudo);
    }

    public void deletePlayer(String pseudoPlayer) throws Exception{
        manager.deletePlayer(pseudoPlayer);
    }
}
