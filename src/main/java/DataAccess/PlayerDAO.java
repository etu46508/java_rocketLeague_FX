package DataAccess;

import Model.Player;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface PlayerDAO {

    public Player getAPLayer(String playerPseudo) throws Exception;
    public ArrayList<Player> getAllPLayer() throws Exception;

    public ArrayList<Player> getPlayerInTeam(int numTeam) throws Exception;

    public void addPlayer(Player player) throws Exception;
    public void deletePlayer(String pseudoPlayer) throws Exception;

    public void updatePlayer(Player player,String pseudoPlayer) throws Exception;
    public void addPlayerToTeam(int numTeam);
    public ArrayList<String> getAllPseudo() throws Exception;

    public Player createPlayer(ResultSet data) throws Exception;



}
