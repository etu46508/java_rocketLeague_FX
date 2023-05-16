//region packages & imports
package DataAccess;

import java.sql.*;
//endregion

public class SingletonConnexion   {
    private static Connection singletonConnexion;

    private SingletonConnexion() throws SQLException {
        try {
            //singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "B@tterie!147");
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "Boulettedu13");
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    public static Connection getInstance() throws SQLException {
        if(singletonConnexion == null){
            new SingletonConnexion();
        }
        return singletonConnexion;
    }

}
