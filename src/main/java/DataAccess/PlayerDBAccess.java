package DataAccess;

import Model.Club;
import Model.Locality;
import Model.Player;
import Exception.PlayerException;
import Exception.DataException;
import Exception.DeletePlayerException;
import Exception.UpdateException;
import Exception.AddPlayerException;
import Model.Team;
import java.sql.*;
import java.util.ArrayList;

public class PlayerDBAccess implements PlayerDAO {
    private final Connection connection;
    public PlayerDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public Player getAPLayer(String playerPseudo) throws Exception{
        Player player = null;
        try{

            String sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionhsip,"+
                    "loc.number, cityName,postalCode,country," +
                    "team, wordingTeam, nameCoach," +
                    "club.serialNumber,name,CEO,creationDate  "+
                    "FROM Player player  " +
                    "INNER JOIN Locality loc on player.home = loc.cityName " +
                    "INNER JOIN Team team ON player.team = team.number " +
                    "INNER JOIN Club club ON club.serialNumber = team.club " +
                    "WHERE pseudo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, playerPseudo);

            ResultSet data = statement.executeQuery();

            data.next();
            player = createPlayer(data);

        }catch (SQLException e){
            throw new Exception();
        }catch (Exception e){
            throw new PlayerException();
        }
        return player;
    }


    public ArrayList<Player> getAllPLayer() throws Exception{
        ArrayList<Player> players = new ArrayList<>();
        try{
            Player player;
            String sql = "SELECT pseudo, firstNameLastName, birthdate, nationality, playKeybord, yearWorldchampionhsip, "+
                    "loc.number, cityName,postalCode,country, " +
                    "team, wordingTeam, nameCoach," +
                    "club.serialNumber,name,CEO,creationDate  "+
                    "FROM Player player  " +
                    "INNER JOIN Locality loc on player.home = loc.cityName " +
                    "INNER JOIN Team team ON player.team = team.number " +
                    "INNER JOIN Club club ON club.serialNumber = team.club " +
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




    public void addPlayer(Player player) throws AddPlayerException {
        try{
            String sql = "INSERT INTO Player(pseudo,firstNameLastName,birthdate,nationality,playKeybord,yearWorldchampionhsi,home,team )values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = SingletonConnexion.getInstance().prepareStatement(sql);

            statement.setString(1,player.getPseudo());
            statement.setString(2,player.getName());
            statement.setDate(3,new java.sql.Date(player.getBirthday().getDate()));
            statement.setString(4,player.getNationality());
            statement.setByte(5, (byte) (player.isPlayKeyboard()?1:0));
            if(player.getYearWorldChampion() == null){
                statement.setNull(6,Types.DECIMAL);
            }else{
                statement.setInt(6,player.getYearWorldChampion());
            }
            if(player.getHome() == null){
                statement.setNull(7,Types.VARCHAR);
            }else{
                statement.setString(7,player.getHome().getWording());
            }
            if(player.getActualTeam() == null){
                statement.setNull(8,Types.INTEGER);
            }else{
                statement.setInt(8,player.getActualTeam().getNumber());
            }




            statement.executeUpdate();
            System.out.println("Player ajouté SAH");
        }catch (Exception exception){
            throw new AddPlayerException(player);

        }
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
                    (int) data.getByte(5),
                    data.getInt(6),
                    new Locality(data.getInt(7),data.getString(8),data.getInt(9),data.getString(10)),
                    new Team(data.getInt(11),data.getString(12),data.getString(13), new Club(data.getInt(14),data.getString(15), data.getString(16),creationDate)));

        }catch (SQLException exception){
            throw new SQLException();
        }
        return player;
    }

    public ArrayList<String> getAllPseudo() throws Exception{
        ArrayList<String> playersPseudo = new ArrayList<String>();

        try{
            String sql = "Select pseudo FROM Player";
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
}