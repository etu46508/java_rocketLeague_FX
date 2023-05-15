package DataAccess;

import java.util.ArrayList;

public interface TeamDAO {

    ArrayList<String> getTeamsAvailable();

    Integer getTeamNumber (String wordingTeam);
}




