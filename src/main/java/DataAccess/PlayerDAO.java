package DataAccess;

import Model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PlayerDAO {

    Player getAPLayer(String playerPseudo) throws Exception;
    ArrayList<Player> getAllPLayer() throws Exception;
    ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws SQLException;
    void addPlayer(Player player) throws Exception;
    void deletePlayer(String pseudoPlayer) throws Exception;

    void updatePlayer(Player player,String pseudoPlayer) throws Exception;
    void addPlayerToTeam(int numTeam);
    ArrayList<String> getAllPseudo() throws Exception;
    ArrayList<Integer> getYearFilledOfWorldChampions() throws Exception;
    Player createPlayer(ResultSet data) throws Exception;



}
