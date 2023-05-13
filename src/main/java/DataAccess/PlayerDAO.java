package DataAccess;

import Model.Player;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface PlayerDAO {

    Player getAPLayer(String playerPseudo) throws Exception;
    ArrayList<Player> getAllPLayer() throws Exception;

    ArrayList<Player> getPlayerInTeam(int numTeam) throws Exception;

    void addPlayer(Player player) throws Exception;
    void deletePlayer(String pseudoPlayer) throws Exception;

    void updatePlayer(Player player,String pseudoPlayer) throws Exception;
    void addPlayerToTeam(int numTeam);
    ArrayList<String> getAllPseudo() throws Exception;
    ArrayList<Integer> getYearFilledOfWorldChampions() throws Exception;
    Player createPlayer(ResultSet data) throws Exception;



}
