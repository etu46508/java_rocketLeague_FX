package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.DataException;

public class LocalityDBAccess implements LocalityDAO{

    private final Connection connection;
    public LocalityDBAccess ()throws DataException {
        connection = SingletonConnexion.getInstance();
    }

    public ArrayList<String> getAllNameLocalities() throws Exception{
        ArrayList<String> localities = new ArrayList<String>();
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

}
