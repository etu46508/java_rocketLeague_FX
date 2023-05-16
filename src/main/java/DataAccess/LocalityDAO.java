//region packages & imports
package DataAccess;

import Model.Locality;
import java.util.ArrayList;

//endregion

public interface LocalityDAO {

    ArrayList<String> getAllNameLocalities() throws Exception;
    Locality getALocationOfATournament(Integer numberOfTournament) throws Exception;

}
