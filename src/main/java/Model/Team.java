package Model;

public class Team {
    private Integer number;
    private String wordingTeam;
    private String nameCoach;
    private Club club;
    private Player [] players;


    public Team(Integer number, String wordingTeam,String nameCoach,Club club){
        setNumber(number);
        setWordingTeam(wordingTeam);
        setClub(club);
        setNameCoach(nameCoach);
        players = new Player[3];
    }

    public void setWordingTeam(String wordingTeam) {
        this.wordingTeam = wordingTeam;
    }

    public String getWordingTeam() {
        return wordingTeam;
    }

    public Club getClub() {
        return club;
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


    public String getNameCoach() {
        return nameCoach;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
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
