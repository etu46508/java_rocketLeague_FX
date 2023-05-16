//region packages & imports
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.DataException;
import Model.Locality;

//endregion

public class LocalityDBAccess implements LocalityDAO{

    private final Connection connection;
    public LocalityDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<String> getAllNameLocalities() throws Exception{
        ArrayList<String> localities = new ArrayList<>();
        try{
            String sql = "SELECT cityName FROM Locality";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                localities.add(data.getString(1));
            }

        }catch (SQLException exception) {
            throw new SQLException();
        }
        return localities;
    }

    public Locality getALocationOfATournament(Integer numberOfTournament) throws Exception{
        Locality location = null;
        try{
            String sql = "SELECT cityName, postalCode, country " +
                    "FROM locality " +
                    "INNER JOIN Tournament tournament on locality.cityName = tournament.location " +
                    "WHERE tournament.number = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,numberOfTournament);
            ResultSet data = statement.executeQuery();

            if(data.next()){
                location = new Locality(data.getString(1),data.getInt(2),data.getString(3));
            }
        }catch (SQLException exception) {
            throw new SQLException();
        }
        return location;
    }

}
