package Exception;

public class PlayerRankingException extends PlayerException{

    public PlayerRankingException(){}

    @Override
    public String getMessage() {
        return super.getMessage()+" or this player has never played in a tournament";
    }
}
