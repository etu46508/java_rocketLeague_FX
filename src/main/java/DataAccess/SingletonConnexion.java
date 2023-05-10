package DataAccess;

import java.sql.*;

import Exception.DataException;
public class SingletonConnexion   {
    private static Connection singletonConnexion;

    private SingletonConnexion()throws DataException {
        try {
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "SecondoOne21");
            System.out.println("Succes");
        } catch (SQLException exception) {
            throw new DataException();
        }
    }


    public static Connection getInstance() throws DataException {
        if(singletonConnexion == null){
            new SingletonConnexion();
        }
        return singletonConnexion;
    }

}
