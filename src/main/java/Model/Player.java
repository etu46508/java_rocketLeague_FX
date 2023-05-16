//region packages & imports
package Model;

import java.time.LocalDate;
import java.time.Period;
import static java.time.LocalDate.now;

//endregion

public class Player {

    //region constructors
    private String pseudo,name,homeName;
    private LocalDate birthdate;
    private String nationality;
    private Integer yearWorldChampion,teamNum;
    private int dayOfBirth,monthOfBirth,yearOfBirth;
    private boolean playKeyboard;
    private Locality home;
    private Team team;

    public Player(String pseudo, String name, LocalDate birthdate, String nationality, Integer playKeyboard, Integer yearWorldChampion, Locality home, Team team){
        setPseudo(pseudo);
        setName(name);
        setBirthdate(birthdate);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHome(home);
        setTeam(team);
    }
    public Player(String pseudo, String name, LocalDate birthdate, String nationality, Integer playKeyboard, Integer yearWorldChampion, String homeName, Integer teamNum){
        setPseudo(pseudo);
        setName(name);
        setBirthdate(birthdate);
        setNationality(nationality);
        setPlayKeyboard(playKeyboard);
        setYearWorldChampion(yearWorldChampion);
        setHomeName(homeName);
        setTeamNum(teamNum);
    }

    //endregion

    //region getters and setters

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

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate Birthdate) {
        this.birthdate = Birthdate;
        setDayOfBirth(Birthdate.getDayOfMonth());
        setMonthOfBirth(Birthdate.getMonthValue());
        setYearOfBirth(Birthdate.getYear());
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
    public int getAge(){
        return Period.between(birthdate,now()).getYears();
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

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Integer getTeamNum() {
        return teamNum;
    }
    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }

    //endregion

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Player : "+ getPseudo() +"\n");
        output.append("- Surname and name  : "+ getName() +"\n");
        output.append("- Age : "+ getAge() +"\n");
        output.append("- Birthdate : "+ getBirthdate() +"\n");
        output.append("- Nationality : "+ getNationality() +" and resides in "+ getHome().getWording()+"\n");
        if(getYearWorldChampion() != 0){
            output.append("- Last victory in the world championship : "+ getYearWorldChampion() +"\n");
        }
        if(getTeam() != null){
            output.append("- Play with the team : "+ getTeam().getWordingTeam() +" in the club : "+ getTeam().getClub().getName()+"\n");
        }else{
            output.append("- He isn't in a team at the moment  \n");
        }
        if(getPlayKeyboard()){
            output.append("- He is is one of the few keyboard players \n");
        }
        return output.toString();
    }
}
