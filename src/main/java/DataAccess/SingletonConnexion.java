package DataAccess;

import java.sql.*;

import Exception.DataException;

public class SingletonConnexion   {
    private static Connection singletonConnexion;

    private SingletonConnexion() throws DataException {
        try {
            // changer en fonction en fonction de l'utilisateur
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root","Boulettedu13");
            //singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root","B@tterie!147");
        } catch (SQLException exception) {
            throw new DataException();
        }
    }


    public static Connection getInstance() throws DataException{
        if(singletonConnexion == null){
            new SingletonConnexion();
        }
        return singletonConnexion;
    }

}
