package Business;

import DataAccess.*;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class Manager {
    private  final LocalityDAO localityAccess;
    private final ClubDAO clubAccess;
    private final TeamDAO teamAccess;
    private final PlayerDAO playerAccess;
    private final TournamentDAO tournamentAccess;
    private final UnofficialTournamentDAO unofficialTournamentAccess;
    private final RankingDAO rankingAccess;

    public Manager() throws DataException{
        localityAccess = new LocalityDBAccess();
        clubAccess = new ClubDBAccess();
        teamAccess = new TeamDBAccess();
        playerAccess = new PlayerDBAccess();
        tournamentAccess = new TournamentDBAccess();
        unofficialTournamentAccess = new UnofficialTournamentDBAccess();
        rankingAccess = new RankingDBAccess();
    }



    public void addPlayer(Player player) throws Exception{
        playerAccess.addPlayer(player);
    }

    public ArrayList<String> getAllPseudo() throws Exception{
        return playerAccess.getAllPseudo();
    }

    public Player getAPLayer(String playerPseudo) throws Exception{
        return playerAccess.getAPLayer(playerPseudo);
    }

}
