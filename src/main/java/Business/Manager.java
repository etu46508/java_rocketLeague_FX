package Business;

import DataAccess.*;
import Model.*;
import Exception.DataException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {

    // region constructor
    private  final LocalityDAO localityAccess;
    private final ClubDAO clubAccess;
    private final TeamDAO teamAccess;
    private final PlayerDAO playerAccess;
    private final TournamentDAO tournamentAccess;
    private final RankingDAO rankingAccess;


    public Manager() throws SQLException{
        localityAccess = new LocalityDBAccess();
        clubAccess = new ClubDBAccess();
        teamAccess = new TeamDBAccess();
        playerAccess = new PlayerDBAccess();
        tournamentAccess = new TournamentDBAccess();
        rankingAccess = new RankingDBAccess();
    }

    //endregion


    // region Player

    public void addPlayer(Player player) throws Exception{
        playerAccess.addPlayer(player);
    }
    public ArrayList<String> getAllPseudo() throws Exception{
        return playerAccess.getAllPseudo();
    }
    public Player getAPLayer(String playerPseudo) throws Exception{
        return playerAccess.getAPLayer(playerPseudo);
    }
    public ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws SQLException{
        return playerAccess.getPseudoPlayerInTeam(wordingTeam);
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

    //endregion


    // region Locality

    public ArrayList<String> getAllNameLocalities() throws Exception{
        return localityAccess.getAllNameLocalities();
    }
    public Locality getALocationOfATournament(Integer numberOfTournament) throws Exception{
        return localityAccess.getALocationOfATournament(numberOfTournament);
    }

    //endregion


    // region Teams

    public ArrayList<String> getTeamsAvailable(){
        return teamAccess.getTeamsAvailable();
    }
    public ArrayList<String> getWordingFullTeam(){
        return teamAccess.getWordingFullTeam();
    }
    public Integer getTeamNumber (String wordingTeam){
        return teamAccess.getTeamNumber(wordingTeam);
    }
    public String getWordingTeam (Integer serialNumber) {return teamAccess.getWordingTeam(serialNumber);}

    //endregion


    // region Tournament

    public ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception{
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
    public ArrayList<String> getTournamentWonByClub(Integer club)throws Exception{
        return tournamentAccess.getTournamentWonByClub(club);
    }
    public ArrayList<String> getAllFutureTournament() throws Exception{
        return tournamentAccess.getAllFutureTournament();
    }
    public Integer getNbTeamOfTournament(String tournament) throws Exception{
        return tournamentAccess.getNbTeamOfTournament(tournament);
    }

    //endregion


    // region Club

    public ArrayList<String> getAllClubsName() throws Exception{
        return clubAccess.getAllClubs();
    }
    public Integer getSerialNumberOfClub (String club) throws Exception {
        return clubAccess.getSerialNumberOfClub(club);
    }

    //endregion


    // region Ranking

    public ArrayList<Ranking> getAllRankingOfATournament(Integer tournamentNumber) throws Exception{
        return rankingAccess.getAllRankingOfATounament(tournamentNumber);
    }
    public ArrayList<Ranking> getAllRankingOfAPlayer(String pseudoPlayer) throws Exception{
        return  rankingAccess.getAllRankingOfAPlayer(pseudoPlayer);
    }

    //endregion


    //region connection
    public void closeConnection() throws SQLException, DataException {
        new DBAccess().closeConnection();
    }
    //endregion

}
