//region packages & imports
package DataAccess;

import java.util.ArrayList;
//endregion
public interface TeamDAO {

    ArrayList<String> getTeamsAvailable() throws Exception;

    ArrayList<String> getWordingFullTeam() throws Exception;

    Integer getTeamNumber (String wordingTeam) throws Exception;
    String getWordingTeam (Integer serialNumber) throws Exception;

}




