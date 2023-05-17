//region packages & imports
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.DataException;
import Exception.TeamException;
import Exception.TeamFilledException;
import Exception.TeamAvailableException;

//end

public class TeamDBAccess implements TeamDAO{
    private final Connection connection;
    public TeamDBAccess () throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<String> getTeamsAvailable() throws TeamAvailableException {
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
            throw new TeamAvailableException();
        }
        return teamsAvailable;
    }

    public ArrayList<String> getWordingFullTeam() throws TeamFilledException{
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
            throw new TeamFilledException();
        }
        return teams;
    }

    public Integer getTeamNumber(String wordingTeam) throws TeamException {
        int teamNumber;
        try{
            String sql = "SELECT serialNumber FROM team WHERE wordingTeam = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wordingTeam);
            ResultSet data = statement.executeQuery();
            data.next();
            teamNumber = data.getInt(1);
        } catch (SQLException e) {
            throw new TeamException();
        }
        return teamNumber;
    }

    public String getWordingTeam (Integer serialNumber) throws TeamException {
        String wordingTeam;
        try {
            String sql = "SELECT wordingTeam FROM team WHERE serialNumber = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,serialNumber);
            ResultSet data = statement.executeQuery();
            data.next();
            wordingTeam = data.getString(1);
        }catch (SQLException e){
            throw new TeamException();
        }
        return wordingTeam;
    }
}
