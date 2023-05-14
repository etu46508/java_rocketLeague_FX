package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    private Integer number;
    private String wordingTeam;
    private String nameCoach;
    private Club club;
    private ArrayList<Player> playersTeam;


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

    public ArrayList<Player> getPlayersOfTeam() {
        return playersTeam;
    }

    public void setPlayers(Player[] players) {
        Collections.addAll(this.playersTeam, players);
    }


    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("L'équipe ").append(club.getName()).append(" a pour Coach ").append(nameCoach).append("\nLes joureurs actuels sont :\n");
        for(Player player : playersTeam){
            output.append("-").append(player.getPseudo()).append("\n");
        }
        return output.toString();
    }
}
