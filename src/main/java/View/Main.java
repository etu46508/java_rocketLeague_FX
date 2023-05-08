package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Exception.DataException;

public class Main {

    public static void main(String args[]) throws Exception {
        Connection singletonConnexion;
        try {
            singletonConnexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketleague", "root", "Boulettedu13");
            System.out.println("Succes");
        } catch (SQLException exception) {
            throw new DataException();
        }
    }

}
