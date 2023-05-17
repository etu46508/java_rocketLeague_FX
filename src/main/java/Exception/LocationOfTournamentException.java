package Exception;

public class LocationOfTournamentException extends Exception {
    public LocationOfTournamentException(){}

    public String getMessage() {
        return "Error, the tournament hasn't a location";
    }
}
