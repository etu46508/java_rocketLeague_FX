//region packages & imports
package DataAccess;

import Model.Club;
import Model.Locality;
import Model.Player;
import Exception.PlayerException;
import Exception.DataException;
import Exception.UpdateException;
import Exception.AddPlayerException;
import Model.Team;
import View.Utility.ExceptionDisplay;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//endregion

public class PlayerDBAccess implements PlayerDAO {
    private final Connection connection;
    public PlayerDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public Player getAPLayer(String pseudoPlayer) throws Exception{
        Player player = null;
        try{
            String sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionship, "+
                    "loc.cityName, postalCode, country, " +
                    "team.serialNumber, wordingTeam, nameCoach, " +
                    "club.serialNumber,name ,CEO ,creationDate  "+
                    "FROM Player player  " +
                    "INNER JOIN Locality loc ON player.home = loc.cityName " +
                    "LEFT JOIN Team team ON player.team = team.serialNumber " +
                    "LEFT JOIN Club club ON club.serialNumber = team.club " +
                    "WHERE pseudo = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pseudoPlayer);
            ResultSet data = statement.executeQuery();

            data.next();

            if(data.getString(11) != null){
                player = createPlayer(data);
            }else{
                sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionship, "+
                        "loc.cityName, postalCode, country  " +
                        "FROM Player player  " +
                        "INNER JOIN Locality loc ON player.home = loc.cityName " +
                        "WHERE pseudo = ? AND player.team IS NULL";
                statement = connection.prepareStatement(sql);
                statement.setString(1, pseudoPlayer);
                data = statement.executeQuery();

                data.next();
                player = createPlayerWithoutTeam(data);
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }catch (Exception e){
            throw new Exception(e);
        }
        return player;
    }

    public ArrayList<Player> getAllPLayer() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        try{
            Player player;
            String sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionship, "+
                    "loc.cityName,postalCode,country, " +
                    "team, wordingTeam, nameCoach," +
                    "club.serialNumber,name,CEO,creationDate  "+
                    "FROM Player player  " +
                    "INNER JOIN Locality loc on player.home = loc.cityName " +
                    "LEFT JOIN Team team ON player.team = team.serialNumber " +
                    "LEFT JOIN Club club ON club.serialNumber = team.club " +
                    "order by player.team";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                player = createPlayer(data);
                players.add(player);
            }

        }catch (SQLException exception){
            throw new PlayerException();
        }
        return players;
    }

    public ArrayList<String> getPseudoPlayerInTeam(String wordingTeam) throws SQLException {
        ArrayList<String> playersInTeam = new ArrayList<>();
        try{
            String sql = "Select pseudo FROM Player " +
                    "INNER JOIN team ON player.team = team.serialNumber " +
                    "WHERE wordingTeam = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wordingTeam);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                playersInTeam.add(data.getString(1));
            }
        }catch (SQLException exception) {
            throw new SQLException();
        }
        return playersInTeam;
    }

    public void addPlayer(Player player) throws AddPlayerException {
        try{
            String sql = "INSERT INTO Player(pseudo,firstNameLastName,birthdate,nationality,playKeybord,yearWorldchampionship,home,team )values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = SingletonConnexion.getInstance().prepareStatement(sql);

            statement.setString(1,player.getPseudo());
            statement.setString(2,player.getName());
            statement.setDate(3, java.sql.Date.valueOf(player.getBirthdate()));
            statement.setString(4,player.getNationality());
            statement.setByte(5, (byte) (player.isPlayKeyboard()?1:0));
            if(player.getYearWorldChampion() == null){
                statement.setNull(6,Types.INTEGER);
            }else{
                statement.setInt(6,player.getYearWorldChampion());
            }
                statement.setString(7,player.getHomeName());
            if(player.getTeam() == null){
                statement.setNull(8,Types.INTEGER);
            }else{
                statement.setInt(8,player.getTeamNum());
            }
            statement.executeUpdate();

        }catch (Exception exception){
            new ExceptionDisplay( new AddPlayerException(player));
        }
    }

    public void deletePlayer(String pseudoPlayer) throws Exception{
        try{
            String sql = "DELETE FROM Player where pseudo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,pseudoPlayer);
            statement.executeUpdate();

        }catch (SQLException exception){
            throw new SQLException(exception);
        }
    }

    public void updatePlayer(Player player,String pseudoPlayer) throws Exception{
        try{
            String sql ="UPDATE Player set pseudo = ?, firstNameLastName = ?, birthdate = ?, nationality = ?, playKeybord = ?, yearWorldchampionship = ?,home = ?,team = ? " +
                    "WHERE pseudo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,player.getPseudo());
            statement.setString(2,player.getName());
            statement.setDate(3, java.sql.Date.valueOf(player.getBirthdate()));
            statement.setString(4,player.getNationality());
            statement.setByte(5, (byte) (player.isPlayKeyboard()?1:0));

            if(player.getYearWorldChampion() == null){
                statement.setNull(6,Types.INTEGER);
            }else{
                statement.setInt(6,player.getYearWorldChampion());
            }
            statement.setString(7,player.getHomeName());
            if(player.getTeamNum() == null){
                statement.setNull(8,Types.INTEGER);
            }else{
                statement.setInt(8,player.getTeamNum());
            }
            statement.setString(9,pseudoPlayer);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new UpdateException(pseudoPlayer);
        }
    }

    public void addPlayerToTeam(int numTeam){

    }

    public ArrayList<String> getAllPseudo() throws Exception{
        ArrayList<String> playersPseudo = new ArrayList<>();
        try{
            String sql = "Select pseudo FROM Player ORDER BY pseudo";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                playersPseudo.add(data.getString(1));
            }

        }catch (SQLException exception) {
            throw new SQLException();
        }
        return playersPseudo;
    }

    public ArrayList<Integer> getYearFilledOfWorldChampions(){
        ArrayList<Integer> getYearFilledOfWorldChampions = new ArrayList<>();
        try{
            String sql = "Select yearWorldchampionship " +
                    "FROM Player " +
                    "WHERE yearWorldchampionship IS NOT NULL " +
                    "GROUP BY yearWorldchampionship " +
                    "HAVING count(yearWorldchampionship) < 3 ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                getYearFilledOfWorldChampions.add(data.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getYearFilledOfWorldChampions;
    }

    public Player createPlayer(ResultSet data) throws Exception{
        Player player;
        try {
            LocalDate birthdate = data.getDate(3).toLocalDate();
            LocalDate creationDate = data.getDate(16).toLocalDate();
            player = new Player(data.getString(1),
                    data.getString(2),
                    birthdate,
                    data.getString(4),
                    (int) data.getByte(5),
                    data.getInt(6),
                    new Locality(data.getString(7),data.getInt(8),data.getString(9)),
                    new Team(data.getInt(10),data.getString(11),data.getString(12), new Club(data.getInt(13),data.getString(14), data.getString(15),creationDate)));

        }catch (SQLException exception){
            throw new SQLException();
        }
        return player;
    }

    public Player createPlayerWithoutTeam(ResultSet data) throws Exception{
        Player player;
        try {
            LocalDate birthdate = data.getDate(3).toLocalDate();
            player = new Player(data.getString(1),
                    data.getString(2),
                    birthdate,
                    data.getString(4),
                    (int) data.getByte(5),
                    data.getInt(6),
                    new Locality(data.getString(7),data.getInt(8),data.getString(9)),
                    null);
        }catch (SQLException exception){
            throw new SQLException();
        }
        return player;
    }

}