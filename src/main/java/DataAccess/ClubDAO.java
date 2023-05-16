package DataAccess;

import java.util.ArrayList;

public interface ClubDAO {
    ArrayList<String> getAllClubs() throws Exception;
    Integer getSerialNumberOfClub(String wording) throws Exception;

}
