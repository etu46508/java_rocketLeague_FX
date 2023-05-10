package Controller;
import Business.Manager;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;

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

    public void updatePlayer(Player player,String pseudoPlayer) throws Exception{
        manager.updatePlayer(player,pseudoPlayer);
    }
    public void deletePlayer(String pseudoPlayer) throws Exception{
        manager.deletePlayer(pseudoPlayer);
    }


    public ArrayList<String> getAllNameLocalities() throws Exception{
        return manager.getAllNameLocalities();

    }


}
