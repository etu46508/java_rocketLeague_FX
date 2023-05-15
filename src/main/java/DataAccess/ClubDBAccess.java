package DataAccess;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.DataException;

public class ClubDBAccess implements ClubDAO{
    private final Connection connection;

    public ClubDBAccess () throws DataException{
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

    public Integer getSerialNumber (String wording) throws Exception{
        Integer serialNumber;
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
