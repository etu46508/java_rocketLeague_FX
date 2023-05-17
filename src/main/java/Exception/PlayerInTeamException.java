package Exception;

import Model.Player;

public class PlayerInTeamException extends TeamException{

    public PlayerInTeamException(){

    }
    public String getMessage() {
        return super.getMessage()+" or the team has no a player";
    }
}
