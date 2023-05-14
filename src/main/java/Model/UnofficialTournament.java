package Model;

import java.time.LocalDate;

public class UnofficialTournament extends Tournament{
    private String organizerName;

    public UnofficialTournament(String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSeats,Locality location,String organizerName) {
        super(wording, startDate, departureHour, nbTeams, streetAndNumber,nbSeats,location);
        setOrganizerName(organizerName);
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}
