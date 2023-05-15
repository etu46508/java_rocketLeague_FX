package DataAccess;

import Model.Tournament;

import java.util.ArrayList;

public interface TournamentDAO {

    ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception;
    ArrayList<Tournament>  getAllTournament () throws Exception;

    Tournament getTournament (String wordingTournament) throws Exception;
    Integer getTournamentNumber (String wordingTournament) throws Exception;


}
