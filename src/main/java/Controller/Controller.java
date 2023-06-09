package Controller;

import Business.Manager;
import Model.*;
import Exception.DataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    // region constructor
    private final Manager manager;
    public Controller() throws SQLException, DataException {
        manager = new Manager();
    }

    //endregion


    // region Player
    public void addPlayer(Player player) throws Exception{
        manager.addPlayer(player);
    }
    public ArrayList<String> getAllPseudo() throws Exception{
        return manager.getAllPseudo();
    }
    public Player getAPLayer(String playerPseudo) throws Exception{
        return manager.getAPLayer(playerPseudo);
    }
    public ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws Exception {
        return manager.getPseudoPlayerInTeam(wordingTeam);
    }
    public void updatePlayer(Player player,String pseudoPlayer) throws Exception{
        manager.updatePlayer(player,pseudoPlayer);
    }
    public void deletePlayer(String pseudoPlayer) throws Exception{
        manager.deletePlayer(pseudoPlayer);
    }
    public ArrayList<Integer> getYearFilledOfWorldChampions() throws Exception{
        return manager.getYearFilledOfWorldChampions();
    }

    //endregion


    // region Locality

    public ArrayList<String> getAllNameLocalities() throws Exception{
        return manager.getAllNameLocalities();
    }
    public Locality getALocationOfATournament(Integer numberOfTournament) throws Exception{
        return manager.getALocationOfATournament(numberOfTournament);
    }

    //endregion


    // region Team

    public ArrayList<String> getTeamAvailable() throws Exception {
        return manager.getTeamsAvailable();
    }
    public ArrayList<String> getWordingFullTeam() throws Exception {
        return manager.getWordingFullTeam();
    }
    public Integer getTeamNumber (String wordingTeam) throws Exception {
        return manager.getTeamNumber(wordingTeam);
    }
    public String getWordingTeam (Integer serialNumber) throws Exception {return manager.getWordingTeam(serialNumber);}

    //endregion


    // region Tournament

    public ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception{
        return manager.getTournamentOfAMonth(numMonth);
    }
    public Tournament getTournament (String wordingTournament) throws Exception{
        return manager.getTournament(wordingTournament);
    }
    public Integer getTournamentNumber (String wordingTournament) throws Exception{
        return manager.getTournamentNumber(wordingTournament);
    }
    public ArrayList<Tournament> getAllTournament () throws Exception{
        return manager.getAllTournament();
    }
    public ArrayList<String> getAllFutureTournament() throws Exception{
        return manager.getAllFutureTournament();
    }
    public Integer getNbTeamOfTournament(String tournament) throws Exception{
        return manager.getNbTeamOfTournament(tournament);
    }
    public ArrayList<String> getTournamentWonByClub(Integer club) throws Exception{
        return manager.getTournamentWonByClub(club);
    }

    //endregion


    // region Ranking

    public ArrayList<Ranking> getAllRankingOfATournament(Integer tournamentNumber) throws Exception{
        return manager.getAllRankingOfATournament(tournamentNumber);
    }
    public ArrayList<Ranking> getAllRankingOfAPlayer(String pseudoPlayer) throws Exception{
        return  manager.getAllRankingOfAPlayer(pseudoPlayer);
    }
    public Ranking getRanking (int team, int tournament) throws Exception{
        return manager.getRanking(team,tournament);
    }
    //endregion


    // region Club

    public ArrayList<String> getAllClubName() throws Exception{
        return manager.getAllClubsName();
    }
    public Integer getSerialNumberOfClub(String club) throws Exception{
        return manager.getSerialNumberOfClub(club);
    }
    public ArrayList<Ranking> getVictoryOfAClub (Integer serialNumberClub, LocalDate date) throws Exception{
        return manager.getVictoryOfAClub(serialNumberClub,date);
    }

    //endregion

    //region connection
    public void closeConnection() throws DataException, SQLException {
        manager.closeConnection();
    }
    //endregion


}
