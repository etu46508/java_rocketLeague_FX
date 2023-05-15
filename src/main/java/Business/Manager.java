package Business;

import DataAccess.*;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
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

    public void updatePlayer(Player player,String pseudoPlayer) throws Exception{
        playerAccess.updatePlayer(player,pseudoPlayer);
    }

    public void deletePlayer(String pseudoPlayer) throws Exception{
        playerAccess.deletePlayer(pseudoPlayer);
    }
    public ArrayList<Integer> getYearFilledOfWorldChampions() throws Exception{
        return playerAccess.getYearFilledOfWorldChampions();
    }


    public ArrayList<String> getAllNameLocalities() throws Exception{
        return localityAccess.getAllNameLocalities();
    }



    public ArrayList<String> getTeamsAvailable(){
        return teamAccess.getTeamsAvailable();
    }

    public Integer getTeamNumber (String wordingTeam){
        return teamAccess.getTeamNumber(wordingTeam);
    }



    public ArrayList<String>  getTournementOfAMonth (Integer numMonth) throws Exception{
        return tournamentAccess.getTournamentOfAMonth(numMonth);
    }

    public Tournament getTournament (String wordingTournament) throws Exception{
        return tournamentAccess.getTournament(wordingTournament);
    }

    public Integer getTournamentNumber (String wordingTournament) throws Exception{
        return tournamentAccess.getTournamentNumber(wordingTournament);
    }

    public ArrayList<Tournament>  getAllTournament () throws Exception{
        return tournamentAccess.getAllTournament();
    }


    public ArrayList<Ranking> getAllRankingOfATounament(Integer tournamentNumber) throws Exception{
        return rankingAccess.getAllRankingOfATounament(tournamentNumber);
    }

    public ArrayList<String> getAllClubsName() throws Exception{
        return clubAccess.getAllClubs();
    }

    public ArrayList<String> getTournamentWonByClub(Integer club)throws Exception{
        return tournamentAccess.getTournamentWonByClub(club);
    }

    public Integer getSerialNumber (String club) throws Exception {
        return clubAccess.getSerialNumber(club);
    }
}
