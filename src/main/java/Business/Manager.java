package Business;

import DataAccess.*;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class Manager {
    private LocalityDAO localityAccess;
    private ClubDAO clubAccess;
    private TeamDAO teamAccess;
    private PlayerDAO playerAccess;
    private TournamentDAO tournamentAccess;
    private UnofficialTournamentDAO unofficialTournamentAccess;
    private RankingDAO rankingAccess;

    public Manager() throws DataException{
        localityAccess = new LocalityDBAccess();
        clubAccess = new ClubDBAccess();
        teamAccess = new TeamDBAccess();
        playerAccess = new PlayerDBAccess();
        tournamentAccess = new TournamentDBAccess();
        unofficialTournamentAccess = new UnofficialTournamentDBAccess();
        rankingAccess = new RankingDBAccess();
    }
}
