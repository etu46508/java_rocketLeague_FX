package DataAccess;

import java.sql.*;

import Exception.DataException;
import View.Utility.ExceptionDisplay;

public class SingletonConnexion   {
    private static Connection singletonConnexion;

    private SingletonConnexion() throws DataException {
        try {
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "B@tterie!147");
            //singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "Boulettedu13");
        } catch (SQLException exception) {
            new ExceptionDisplay(exception);
        }
    }


    public static Connection getInstance() throws DataException {
        if(singletonConnexion == null){
            new SingletonConnexion();
        }
        return singletonConnexion;
    }

}
