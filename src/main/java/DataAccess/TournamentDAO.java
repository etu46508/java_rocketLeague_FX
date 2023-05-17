//region packages & imports
package DataAccess;

import Model.Tournament;

import java.sql.SQLException;
import java.util.ArrayList;

//endregion

public interface TournamentDAO {

    ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception;
    ArrayList<Tournament>  getAllTournament () throws Exception;
    Tournament getTournament (String wordingTournament) throws Exception;
    Integer getTournamentNumber (String wordingTournament) throws Exception;
    ArrayList<String> getTournamentWonByClub(int club) throws Exception;
    ArrayList<String> getAllFutureTournament () throws SQLException;
    Integer getNbTeamOfTournament (String tournament) throws Exception;

}
