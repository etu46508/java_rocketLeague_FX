//region packages & imports
package DataAccess;

import Model.Player;
import java.sql.ResultSet;
import java.util.ArrayList;

//endregion

public interface PlayerDAO {

    Player getAPLayer(String playerPseudo) throws Exception;
    ArrayList<Player> getAllPLayer() throws Exception;
    ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws Exception;
    void addPlayer(Player player) throws Exception;
    void deletePlayer(String pseudoPlayer) throws Exception;
    void updatePlayer(Player player,String pseudoPlayer) throws Exception;
    ArrayList<String> getAllPseudo() throws Exception;
    ArrayList<Integer> getYearFilledOfWorldChampions() throws Exception;
    Player createPlayer(ResultSet data) throws Exception;



}
