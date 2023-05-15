package DataAccess;

import Model.Ranking;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface RankingDAO {

    ArrayList<Ranking> getAllRankingOfATounament(Integer tournamentNumber) throws Exception;
    Ranking createRanking(ResultSet data);
}
