package Exception;

public class UpdateException extends Exception{
    private String player;
    public UpdateException(String pseudo) {
        this.player = pseudo;
    }

    @Override
    public String getMessage() {
        return "Error updating player : " + player+".";
    }
}
