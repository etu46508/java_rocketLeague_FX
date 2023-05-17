package Exception;

public class PlayerException extends Exception {
    public PlayerException(){}

    @Override
    public String getMessage() {
        return "Error, the player does not exist in the database ";
    }
}
