package Model;

import java.time.LocalDate;

public class Player {
    private String pseudo;
    private String name;
    private LocalDate birthday;
    private String nationality;
    private String yearWorldChampion;
    private boolean playKeyboard;
    private String streetAndNumber;
    private Locality home;
    private Team actualTeam;

    public Player(String pseudo, String name, LocalDate birthday, String nationality, boolean playKeyboard, String streetAndNumber, Locality home, Team actualTeam){
        setBirthday(birthday);
        setHome(home);
        setName(name);
        setPseudo(pseudo);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setStreetAndNumber(streetAndNumber);
        setActualTeam(actualTeam);
        yearWorldChampion = "";
    }
    public Player(String pseudo, String name, LocalDate birthday, String nationality, boolean playKeyboard, String yearWorldChampion, String streetAndNumber, Locality home, Team actualTeam){
        setBirthday(birthday);
        setHome(home);
        setName(name);
        setPseudo(pseudo);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setStreetAndNumber(streetAndNumber);
        setActualTeam(actualTeam);
        setYearWorldChampion(yearWorldChampion);
    }

    public boolean isPlayKeyboard() {
        return playKeyboard;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public LocalDate getBirthday() {
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

    public String getYearWorldChampion() {
        return yearWorldChampion;
    }

    public Team getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(Team actualTeam) {
        this.actualTeam = actualTeam;
    }

    public void setBirthday(LocalDate birthday) {
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

    public void setPlayKeyboard(boolean playKeyboard) {
        this.playKeyboard = playKeyboard;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setYearWorldChampion(String yearWorldChampion) {
        this.yearWorldChampion = yearWorldChampion;
    }

}
