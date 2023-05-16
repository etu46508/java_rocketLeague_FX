//region packages & imports
package Model;

import java.time.LocalDate;

//endregion

public class UnofficialTournament extends Tournament{
    private String organizerName;

    //region constructors
    public UnofficialTournament(String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSeats,Locality location,String organizerName) {
        super(wording, startDate, departureHour, nbTeams, streetAndNumber,nbSeats,location);
        setOrganizerName(organizerName);
    }
    //endregion

    //region getters and setters

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
    public String getOrganizerName() {
        return organizerName;
    }

    //endregion

}
