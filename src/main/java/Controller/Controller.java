package Controller;

import Business.Manager;
import Model.*;
import Exception.DataException;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    private final Manager manager;
    public Controller() throws DataException {
        manager = new Manager();
    }

    public void addPlayer(Player player) throws Exception{
        manager.addPlayer(player);
    }

    public ArrayList<String> getAllPseudo() throws Exception{
        return manager.getAllPseudo();
    }

    public Player getAPLayer(String playerPseudo) throws Exception{
        return manager.getAPLayer(playerPseudo);
    }
    public ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws SQLException {
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


    public ArrayList<String> getAllNameLocalities() throws Exception{
        return manager.getAllNameLocalities();
    }
    public Locality getALocationOfATournament(Integer numberOfTournament) throws Exception{
        return manager.getALocationOfATournament(numberOfTournament);
    }


    public ArrayList<String> getTeamAvailable(){
        return manager.getTeamsAvailable();
    }
    public ArrayList<String> getWordingFullTeam(){
        return manager.getWordingFullTeam();
    }
    public Integer getTeamNumber (String wordingTeam){
        return manager.getTeamNumber(wordingTeam);
    }
    public String getWordingTeam (Integer serialNumber){return manager.getWordingTeam(serialNumber);}


    public ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception{
        return manager.getTournementOfAMonth(numMonth);
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


    public ArrayList<Ranking> getAllRankingOfATounament(Integer tournamentNumber) throws Exception{
        return manager.getAllRankingOfATournament(tournamentNumber);
    }
    public ArrayList<Ranking> getAllRankingOfAPlayer(String pseudoPlayer) throws Exception{
        return  manager.getAllRankingOfAPlayer(pseudoPlayer);
    }
    public ArrayList<String> getAllClubName() throws Exception{
        return manager.getAllClubsName();
    }

    public ArrayList<String> getTournamentWonByClub(Integer club) throws Exception{
        return manager.getTournamentWonByClub(club);
    }

    public Integer getSerialNumber(String club) throws Exception{
        return manager.getSerialNumber(club);
    }
}
