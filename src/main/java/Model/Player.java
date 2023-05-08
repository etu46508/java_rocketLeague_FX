package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Player {
    private String pseudo;
    private String name;
    private Date birthday;
    private String nationality;
    private Integer yearWorldChampion;
    private boolean playKeyboard;
    private Locality home;
    private Team actualTeam;


    public Player(String pseudo, String name, Date birthday, String nationality, int playKeyboard, Integer yearWorldChampion, Locality home, Team actualTeam){
        setPseudo(pseudo);
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHome(home);
        setActualTeam(actualTeam);
    }



    public boolean isPlayKeyboard() {
        return playKeyboard;
    }


    public Date getBirthday() {
        return birthday;
    }

    public Locality getHome() {
        return home;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Integer getYearWorldChampion() {
        return yearWorldChampion;
    }

    public Team getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(Team actualTeam) {
        this.actualTeam = actualTeam;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHome(Locality home) {
        this.home = home;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPlayKeyboard(int playKeyboard) {
        if(playKeyboard == 1){
            this.playKeyboard = true;
        }
        this.playKeyboard = false;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setYearWorldChampion(Integer yearWorldChampion) {
        this.yearWorldChampion = yearWorldChampion;
    }

}
