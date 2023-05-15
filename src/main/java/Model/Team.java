package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    private Integer number;
    private String wordingTeam;
    private String nameCoach;
    private Club club;
    private ArrayList<Player> playersTeam;

    //region constructors
    public Team(Integer number, String wordingTeam,String nameCoach,Club club){
        setNumber(number);
        setWordingTeam(wordingTeam);
        setClub(club);
        setNameCoach(nameCoach);
        playersTeam = new ArrayList<>();
    }
    public Team(Integer number, String wordingTeam,String nameCoach,Club club,Player... players){
        setNumber(number);
        setWordingTeam(wordingTeam);
        setClub(club);
        setNameCoach(nameCoach);
        setPlayers(players);
    }
    //endregion


    //region getters and setters

    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getNumber() {
        return number;
    }

    public void setWordingTeam(String wordingTeam) {
        this.wordingTeam = wordingTeam;
    }
    public String getWordingTeam() {
        return wordingTeam;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }
    public String getNameCoach() {
        return nameCoach;
    }

    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }

    public ArrayList<Player> getPlayersOfTeam() {
        return playersTeam;
    }
    public void setPlayers(Player[] players) {
        Collections.addAll(this.playersTeam, players);
    }

    //endregion


    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("The team ").append(club.getName()).append(" has for coach ").append(nameCoach).append("\n the players are :\n");
        for(Player player : playersTeam){
            output.append("-").append(player.getPseudo()).append("\n");
        }
        return output.toString();
    }
}
