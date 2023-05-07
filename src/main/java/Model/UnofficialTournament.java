package Model;

import java.time.LocalDate;

public class UnofficialTournament extends Tournament{
    private String organizerName;

    public UnofficialTournament(String organizerName, String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, String streetAndNumber, Ranking[] ranking) {
        super(wording, startDate, departureHours, nbTeams, location, streetAndNumber, ranking);
        setOrganizerName(organizerName);
    }
    public UnofficialTournament(String organizerName, String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, String streetAndNumber, Ranking[] ranking, int nbSeats) {
        super(wording, startDate, departureHours, nbTeams, location, streetAndNumber, nbSeats, ranking);
        setOrganizerName(organizerName);
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
}
