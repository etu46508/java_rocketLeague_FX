package Exception;

public class TeamException extends Exception{

    public TeamException(){}

    @Override
    public String getMessage() {
        return "Error, this team doesn't exist ";
    }
}
