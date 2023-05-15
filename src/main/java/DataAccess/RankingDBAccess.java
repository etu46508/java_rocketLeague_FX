package DataAccess;

import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import Exception.DataException;

public class RankingDBAccess implements RankingDAO{

    private final Connection connection;
    public RankingDBAccess () throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<Ranking> getAllRankingOfATounament(Integer tournamentNumber) throws Exception{
        ArrayList<Ranking> rankings = new ArrayList<>();
        try{
            Ranking ranking;
            String sql = "SELECT position, nbGoalScored, nbGoalConceded, cashPrize, " +
                    " tournament.number, wordingTournament, date, departureHour, nbTeam, " +
                    " team.serialNumber, wordingTeam, nameCoach, " +
                    " club.serialNumber , name , CEO, creationDate " +
                    " FROM Ranking ranking " +
                    " INNER JOIN Tournament tournament on ranking.tournament =  tournament.number " +
                    " INNER JOIN Team team on ranking.team =  team.serialNumber " +
                    " INNER JOIN Club club on team.club = club.serialNumber " +
                    " WHERE ranking.tournament = ? " +
                    " ORDER BY position ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,tournamentNumber);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                ranking = createRanking(data);
                rankings.add(ranking);
            }

        }catch (SQLException exception){
            throw new SQLException(exception);

        }
        return rankings;
    }

    public ArrayList<Ranking> getAllRankingOfAPlayer(String pseudoPlayer) throws Exception{
        ArrayList<Ranking> rankings = new ArrayList<>();
        try{
            Ranking ranking;
            String sql = "SELECT position, nbGoalScored, nbGoalConceded, cashPrize, " +
                    " tournament.number, wordingTournament, date, departureHour, nbTeam, " +
                    " team.serialNumber, wordingTeam, nameCoach, " +
                    " club.serialNumber , name , CEO, creationDate " +
                    " FROM Ranking ranking " +
                    " INNER JOIN Tournament tournament on ranking.tournament =  tournament.number " +
                    " INNER JOIN Team team on ranking.team =  team.serialNumber " +
                    " INNER JOIN Club club on team.club = club.serialNumber " +
                    " INNER JOIN Player player on team.serialNumber = player.team " +
                    " LEFT JOIN Locality locality on tournament.location = locality.cityName " +
                    " WHERE player.pseudo = ?" +
                    " ORDER BY tournament.date";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,pseudoPlayer);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                ranking = createRanking(data);
                rankings.add(ranking);
            }

        }catch (SQLException exception){
            throw new SQLException(exception);

        }
        return rankings;
    }



    public Ranking createRanking(ResultSet data){
        Ranking ranking;
        try {
            LocalDate tournamentDate = data.getDate(7).toLocalDate();
            LocalDate clubCreationDate = data.getDate(16).toLocalDate();
            ranking = new Ranking(data.getInt(1),
                    data.getInt(2),
                    data.getInt(3),
                    data.getInt(4),
                    new Tournament(data.getInt(5),
                            data.getString(6),tournamentDate,
                            data.getInt(8),
                            data.getInt(9)),
                    new Team(data.getInt(10),
                                    data.getString(11),
                                    data.getString(12),
                                    new Club(data.getInt(13),
                                            data.getString(14),data.getString(15),clubCreationDate)));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ranking;
    }
}
