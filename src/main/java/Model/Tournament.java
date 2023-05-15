package Model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Tournament {
    private String wording;
    private LocalDate StartDate;
    private Integer tournamentNumber, departureHour;
    private Integer nbTeams;
    private Locality location;
    private String streetAndNumber;
    private Integer nbSpectator;
    private Ranking[] ranking;
    private ArrayList<Ranking> rankings;

    //region constructors
    public Tournament(Integer tournamentNumber,String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSpectator,Locality location){
        setTournamentNumber(tournamentNumber);
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSpectator(nbSpectator);
    }

    public Tournament(String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSpectator,Locality location){
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSpectator(nbSpectator);
    }

    public Tournament(Integer tournamentNumber,String wording, LocalDate startDate, Integer departureHour, Integer nbTeams){
        setTournamentNumber(tournamentNumber);
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
    }

    //endregion


    //region getters and setters

    public void setTournamentNumber(Integer tournamentNumber) {
        this.tournamentNumber = tournamentNumber;
    }
    public Integer getTournamentNumber() {
        return tournamentNumber;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
    public String getWording() {
        return wording;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }
    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setDepartureHour(Integer departureHour) {
        this.departureHour = departureHour;
    }
    public Integer getDepartureHour() {
        return departureHour;
    }

    public void setNbTeams(Integer nbTeams) {
        if(nbTeams > 1){
            this.nbTeams = nbTeams;
        }else {
            this.nbTeams = 8;
        }
    }
    public Integer getNbTeams() {
        return nbTeams;
    }

    public void setNbSpectator(Integer nbSpectator) {
        this.nbSpectator = nbSpectator;
    }
    public Integer getNbSpectator() {
        return nbSpectator;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }
    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setLocation(Locality location) {
        this.location = location;
    }
    public Locality getLocation() {
        return location;
    }

    public Ranking[] getRanking() {
        return ranking;
    }

    public void setRanking(Ranking[] ranking) {
        if(ranking.length == nbTeams){
            this.ranking = ranking;
        }
    }

    //endregion


}
