package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.DataException;


public class TeamDBAccess implements TeamDAO{
    private final Connection connection;
    public TeamDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<String> getTeamsAvailable(){
        ArrayList<String> teamsAvailable = new ArrayList<>();
        try{
            String sql = "SELECT team.wordingTeam " +
                    "FROM team " +
                    "LEFT JOIN player ON team.serialNumber = player.team " +
                    "GROUP BY Team.serialNumber " +
                    "HAVING count(player.team) < 3 OR count(player.team) IS NULL ";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                teamsAvailable.add(data.getString(1));
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teamsAvailable;
    }

    public ArrayList<String> getWordingFullTeam(){
        ArrayList<String> teams = new ArrayList<>();
        try{
            String sql = "SELECT team.wordingTeam " +
                    "FROM team  " +
                    "LEFT JOIN player ON team.serialNumber = player.team  " +
                    "GROUP BY Team.serialNumber  " +
                    "HAVING count(player.team) = 3";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                teams.add(data.getString(1));
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }


    public Integer getTeamNumber (String wordingTeam){
        int teamNumber;
        try{
            String sql = "SELECT serialNumber FROM team WHERE wordingTeam = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wordingTeam);
            ResultSet data = statement.executeQuery();
            data.next();
            teamNumber = data.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teamNumber;
    }
}
