package Exception;

public class TeamFilledException extends Exception{
    public TeamFilledException(){}

    @Override
    public String getMessage() {
        return "Error, there is no team with 3 players";
    }
}
