package DataAccess;

import java.util.ArrayList;

public interface TeamDAO {

    ArrayList<String> getTeamsAvailable();

    ArrayList<String> getWordingFullTeam();

    Integer getTeamNumber (String wordingTeam);
    String getWordingTeam (Integer serialNumber);
}




