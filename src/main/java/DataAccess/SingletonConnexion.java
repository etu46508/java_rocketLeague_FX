package DataAccess;

import java.sql.*;

import Exception.DataException;
public class SingletonConnexion   {
    private static Connection singletonConnexion;

    private SingletonConnexion() throws SQLException {
        try {
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root","SecondoOne21");
            //singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root","Boulettedu13");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static Connection getInstance() throws DataException, SQLException {
        if(singletonConnexion == null){
            new SingletonConnexion();
        }
        return singletonConnexion;
    }

}
