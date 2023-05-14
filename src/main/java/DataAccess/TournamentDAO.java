package DataAccess;

import Model.Tournament;

import java.util.ArrayList;

public interface TournamentDAO {

    public ArrayList<String>  getTournementOfAMonth (Integer numMonth) throws Exception;
    public ArrayList<Tournament>  getAllTournament () throws Exception;

    public Tournament getTournament (String wordingTournament) throws Exception;

}
