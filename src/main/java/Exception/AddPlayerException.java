package Exception;

import Model.Player;

public class AddPlayerException extends Exception {
    private Player player;
    public AddPlayerException(Player player){
        this.player = player;
    }

    @Override
    public String getMessage() {
        return "Error, the player "+player.getPseudo()+" already exist. ";
    }
}
