package Model;

public class Team {
    private Integer number;
    private String nameCoach;
    private Club club;
    private Player [] players;


    public Team(Integer number, String nameCoach,Club club){
        setNameCoach(nameCoach);
        setclub(club);
        players = new Player[3];
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setClub(Club club) {
        this.club = club;
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
