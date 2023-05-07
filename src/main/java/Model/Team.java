package Model;

public class Team {
    private String initialsClub;
    private String nameCoach;
    private Club club;
    private Player [] players;

    public Team(Club club, String nameCoach, boolean is2v2){
        setclub(club);
        setNameCoach(nameCoach);
        setInitialsClub(is2v2);
        if(is2v2){
            players = new Player[2];
        }else{
            players = new Player[3];
        }
    }
    public Team(Club club, String nameCoach, boolean is2v2, Player[] player){
        setclub(club);
        setNameCoach(nameCoach);
        setInitialsClub(is2v2);
        setPlayers(player);
    }


    public String getInitialsClub() {
        return initialsClub;
    }

    public Club getclub() {
        return club;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setInitialsClub(boolean is2v2) {
        initialsClub = club + (is2v2 ? "2v2" : "3v3");
    }

    public void setclub(Club club) {
        this.club = club;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("L'équipe ").append(club.getName()).append(" a pour Coach ").append(nameCoach).append("\nLes joureurs actuels sont :\n");
        for(Player player : players){
            output.append("-").append(player.getPseudo()).append("\n");
        }
        return output.toString();
    }
}
