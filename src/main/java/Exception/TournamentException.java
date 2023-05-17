package Exception;

public class TournamentException extends Exception{

    public TournamentException(){}

    @Override
    public String getMessage() {
        return "Error, this tournament does not exist in the data base ";
    }
}
