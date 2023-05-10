package DataAccess;

import Model.Player;

import java.util.ArrayList;

public interface LocalityDAO {

    ArrayList<String> getAllNameLocalities() throws Exception;
}
