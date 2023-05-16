//region packages & imports
package DataAccess;

import Model.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//endregion

public class TournamentDBAccess implements TournamentDAO{
    private final Connection connection;
    public TournamentDBAccess ()throws SQLException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<String> getTournamentOfAMonth(Integer numMonth) throws Exception{
        ArrayList<String> tournaments = new ArrayList<>();
        try{
            String sql = "SELECT tournament.wordingTournament " +
                    "FROM tournament " +
                    "INNER JOIN ranking ON tournament.number = ranking.tournament " +
                    "WHERE MONTH(tournament.date) = ? " +
                    "GROUP BY tournament.number " +
                    "having COUNT(*) = MAX(tournament.nbTeam) ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, numMonth);

            ResultSet data = statement.executeQuery();

            while(data.next()){
                tournaments.add(data.getString(1));
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }
        return tournaments;
    }

    public ArrayList<Tournament>  getAllTournament () throws Exception{
        ArrayList<Tournament> tournaments = new ArrayList<>();
        Tournament tournament;
        try{
            String sql = "SELECT wordingTournament, date, departureHoure, nbTeam, streetAndNumber, numberSpectator, " +
                    "loc.cityName,postalCode,country " +
                    "FROM Tournament tournament " +
                    "LEFT JOIN Locality loc ON tournament.location = loc.cityName";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                tournament = createTournament(data);
                tournaments.add(tournament);
            }

        }catch (SQLException e){
            throw new SQLException(e);
        }
        return tournaments;
    }

    public Tournament getTournament (String wordingTournament) throws Exception{
        Tournament tournament;
        try{
            String sql = "SELECT wordingTournament, date, departureHour, nbTeam, streetAndNumber, numberSpectator, " +
                    "loc.cityName,postalCode,country " +
                    "FROM Tournament tournament " +
                    "LEFT JOIN Locality loc ON tournament.location = loc.cityName "+
                    "WHERE wordingTournament = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wordingTournament);
            ResultSet data = statement.executeQuery();
            data.next();
            tournament = createTournament(data);

        }catch (SQLException e){
            throw new SQLException(e);
        }
        return tournament;
    }

    public Integer getTournamentNumber (String wordingTournament) throws Exception{
        int tournamentNumber;
        try{
            String sql = "SELECT number "+
                    "FROM Tournament tournament " +
                    "WHERE wordingTournament = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wordingTournament);
            ResultSet data = statement.executeQuery();
            data.next();
            tournamentNumber = data.getInt(1);

        }catch (SQLException e){
            throw new SQLException(e);
        }
        return tournamentNumber;
    }

    private Tournament createTournament(ResultSet data) throws Exception{
        Tournament  tournament;
        try {
            LocalDate date = data.getDate(2).toLocalDate();
            tournament = new Tournament (data.getString(1),
                    date,
                    data.getInt(3),
                    data.getInt(4),
                    data.getString(5),
                    data.getInt(6),
                    new Locality(data.getString(7),data.getInt(8),data.getString(9)));
        }catch (SQLException exception){
            throw new SQLException();
        }
        return tournament;
    }

    public ArrayList<String> getTournamentWonByClub (int club) throws Exception{
        ArrayList<String> tournaments = new ArrayList<>();
        try {
            String sql = "SELECT wordingTournament, date " +
                    "FROM tournament " +
                    "INNER JOIN ranking r on (tournament.number = r.tournament) " +
                    "WHERE (r.position = 1 AND r.team = ?) ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,club);
            ResultSet data = statement.executeQuery();
            data.next();
            while(data.next()){
                String tournamentName = data.getString("wordingTournament");
                String tournamentDate = data.getString("date");
                String tournamentInfo = tournamentName + "|" + tournamentDate;
                tournaments.add(tournamentInfo);
            }

        }catch (SQLException e){
            throw new SQLException(e);
        }
        return tournaments;
    }

    public ArrayList<String> getAllFutureTournament () throws SQLException {
        ArrayList<String> tournaments = new ArrayList<>();
        try{
            String sql = "SELECT wordingTournament " +
                    "FROM Tournament tournament " +
                    "WHERE tournament.date > CURDATE() ";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                tournaments.add(data.getString(1));
            }
        }catch (SQLException e){
            throw new SQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tournaments;
    }

    public Integer getNbTeamOfTournament (String tournament) throws SQLException{
        int nbTeam;
        try {
            String sql = "SELECT nbTeam "+
                    "FROM Tournament tournament " +
                    "WHERE tournament.wordingTournament = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,tournament);
            ResultSet data = statement.executeQuery();
            data.next();
            nbTeam = data.getInt(1);
        }catch (SQLException e){
            throw new SQLException(e);
        }
        return nbTeam;
    }

}
