package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Player {
    private String pseudo,name,homeName;
    private Date birthday;
    private String nationality;
    private Integer yearWorldChampion,teamNum;
    private int dayOfBirth,monthOfBirth,yearOfBirth;
    private boolean playKeyboard;
    private Locality home;
    private Team actualTeam;


    public Player(String pseudo, String name, Date birthday, String nationality, Integer playKeyboard, Integer yearWorldChampion, Locality home, Team actualTeam){
        setPseudo(pseudo);
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHome(home);
        setActualTeam(actualTeam);
    }
    public Player(String pseudo, String name, Date birthday, String nationality, Integer playKeyboard, Integer yearWorldChampion, String homeName, Integer teamNum){
        setPseudo(pseudo);
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHomeName(homeName);
        setTeamNum(teamNum);
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
        setDayOfBirth(birthday.getDay());
        setMonthOfBirth(birthday.getMonth());
        setYearOfBirth(birthday.getYear());
    }

    public void setDayOfBirth(Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
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

    public void setPlayKeyboard(int bitKeyboard) {
        if(bitKeyboard == 1){
            this.playKeyboard = true;
        }
        this.playKeyboard = false;
    }

    public Boolean getPlayKeyboard(){
        return playKeyboard;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setYearWorldChampion(Integer yearWorldChampion) {
        this.yearWorldChampion = yearWorldChampion;
    }

    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }

    public Integer getTeamNum() {
        return teamNum;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomeName() {
        return homeName;
    }
}
