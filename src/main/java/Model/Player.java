package Model;

import java.time.LocalDate;

public class Player {
    private String pseudo,name,homeName;
    private LocalDate birthday;
    private String nationality;
    private Integer yearWorldChampion,teamNum;
    private int dayOfBirth,monthOfBirth,yearOfBirth;
    private boolean playKeyboard;
    private Locality home;
    private Team actualTeam;


    public Player(String pseudo, String name, LocalDate birthday, String nationality, Integer playKeyboard, Integer yearWorldChampion, Locality home, Team actualTeam){
        setPseudo(pseudo);
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHome(home);
        setActualTeam(actualTeam);
    }
    public Player(String pseudo, String name, LocalDate birthday, String nationality, Integer playKeyboard, Integer yearWorldChampion, String homeName, Integer teamNum){
        setPseudo(pseudo);
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHomeName(homeName);
        setTeamNum(teamNum);
    }



    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        setDayOfBirth(birthday.getDayOfMonth());
        setMonthOfBirth(birthday.getMonthValue());
        setYearOfBirth(birthday.getYear());
    }
    public int getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public int getMonthOfBirth() {
        return monthOfBirth;
    }
    public void setMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getPlayKeyboard(){
        return playKeyboard;
    }
    public boolean isPlayKeyboard() {
        return playKeyboard;
    }
    public void setPlayKeyboard(int bitKeyboard) {
        this.playKeyboard = bitKeyboard == 1;
    }

    public Integer getYearWorldChampion() {
        return yearWorldChampion;
    }
    public void setYearWorldChampion(Integer yearWorldChampion) {
            this.yearWorldChampion = yearWorldChampion;
    }


    public Locality getHome() {
        return home;
    }
    public void setHome(Locality home) {
        this.home = home;
    }
    public String getHomeName() {
        return homeName;
    }
    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public Team getActualTeam() {
        return actualTeam;
    }
    public void setActualTeam(Team actualTeam) {
        this.actualTeam = actualTeam;
    }
    public Integer getTeamNum() {
        return teamNum;
    }
    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }






    @Override
    public String toString() {
        return super.toString();
    }
}
