//region packages & imports
package DataAccess;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exception.DataException;

//endregion

public class ClubDBAccess implements ClubDAO{
    private final Connection connection;
    public ClubDBAccess () throws SQLException {
        connection = SingletonConnexion.getInstance();
    }

    @Override
    public ArrayList<String> getAllClubs() throws Exception {
        ArrayList<String> clubs = new ArrayList<>();
        try{
            String sql = "SELECT name FROM Club";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                clubs.add(data.getString(1));
            }

        }catch (SQLException exception) {
            throw new SQLException();
        }
        return clubs;
    }

    public Integer getSerialNumberOfClub(String wording) throws Exception{
        int serialNumber;
        try {
            String sql = "SELECT serialNumber "+
                    "FROM club "+
                    "WHERE name = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wording);
            ResultSet data = statement.executeQuery();
            data.next();
            serialNumber = data.getInt(1);
        }catch (SQLException e){
            throw new SQLException();
        }
        return serialNumber;
    }

}
