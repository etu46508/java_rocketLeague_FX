package DataAccess;

import Model.Club;
import Model.Locality;
import Model.Player;
import Exception.PlayerException;
import Exception.DataException;
import Exception.DeletePlayerException;
import Exception.UpdateException;
import Model.Team;
import java.sql.*;
import java.util.ArrayList;

public class PlayerDBAccess implements PlayerDAO {
    private Connection connection;
    public PlayerDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public Player getAPLayer() throws Exception{

        return null;
    }

    public ArrayList<Player> getAllPLayer() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        try{
            Player player;
            String sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionhsip,"+
                    "loc.number,loc.number, cityName,postalCode,country," +
                    "team, wordingTeam, nameCoach," +
                    "club.serialNumber,name,CEO,creationDate  "+
                    "FROM Player player  " +
                    "INNER JOIN Locality loc on driver.home = loc.cityName " +
                    "INNER JOIN Team team ON player.team = team.number" +
                    "INNER JOIN Club club ON club.serialNumber = team.club" +
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

    public ArrayList<Player> getPlayerInTeam(int numTeam) throws Exception{

        return null;
    }

    @Override


    public void addPlayer(Player player) throws Exception{

    }

    public void deletePlayer(String pseudoPlayer) throws Exception{
        try{
            String sql = "DELETE FROM Player where pseudo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,pseudoPlayer);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new DeletePlayerException();
        }
    }


    public void updatePlayer(Player player,String pseudoPlayer) throws Exception{
        try{
            String sql ="UPDATE Player set pseudo = ?, firstNameLastName = ?, birthdate = ?, nationality = ?, playKeybord = ?, yearWorldchampionhsi = ?,home = ?,team = ? " +
                    "WHERE pseudo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,player.getPseudo());
            statement.setString(2,player.getName());
            statement.setDate(3,new java.sql.Date(player.getBirthday().getTime()));
            statement.setString(4,player.getNationality());
            statement.setByte(5, (byte) (player.isPlayKeyboard()?1:0));
            statement.setInt(6,player.getYearWorldChampion());
            statement.setString(7,player.getHome().getWording());
            statement.setInt(8,player.getActualTeam().getNumber());
            statement.setString(9,pseudoPlayer);

            statement.executeUpdate();

        }catch (SQLException exception){
            throw new UpdateException(pseudoPlayer);
        }

    }
    public void addPlayerToTeam(int numTeam){

    }

    public Player createPlayer(ResultSet data) throws Exception{
        Player player;
        try {
            Date birthdate = data.getDate(3);
            Date creationDate = data.getDate(17);
            player = new Player(data.getString(1),
                    data.getString(2),
                    birthdate,
                    data.getString(4),
                    data.getByte(5),
                    data.getInt(6),
                    new Locality(data.getInt(8),data.getString(7),data.getString(9),data.getInt(10)),
                    new Team(data.getInt(11),data.getString(12),
                            new Club(data.getInt(14),data.getString(15), data.getString(16),creationDate)));

        }catch (SQLException exception){
        throw new SQLException();
    }
        return player;
    }
}
