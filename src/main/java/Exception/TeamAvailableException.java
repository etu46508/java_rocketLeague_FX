package Exception;

public class TeamAvailableException extends Exception{
    public TeamAvailableException(){}

    @Override
    public String getMessage() {
        return "Error, there is no team with disponibility";
    }
}
