package DataAccess;

import Model.Club;

import java.util.ArrayList;

public interface ClubDAO {
    ArrayList<String> getAllClubs() throws Exception;
    Integer getSerialNumber(String wording) throws Exception;
}
