//region packages & imports
package DataAccess;

import Model.Ranking;
import java.sql.ResultSet;
import java.util.ArrayList;

//endregion

public interface RankingDAO {

    ArrayList<Ranking> getAllRankingOfATounament(Integer tournamentNumber) throws Exception;
    ArrayList<Ranking> getAllRankingOfAPlayer(String pseudoPlayer) throws Exception;
    Ranking createRanking(ResultSet data);
    Ranking getRanking (int team, int tournament) throws Exception;

}
