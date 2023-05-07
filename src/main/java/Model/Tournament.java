package Model;

import java.time.LocalDate;

public class Tournament {
    private String wording;
    private LocalDate StartDate;
    private LocalDate departureHours;
    private int nbTeams;
    private Locality location;
    private String streetAndNumber;
    private int nbSeats;
    private Ranking [] ranking;

    public Tournament(String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, String streetAndNumber, Ranking[] ranking){
        setWording(wording);
        setDepartureHours(departureHours);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setRanking(ranking);
        nbSeats = -1;
    }

    public Tournament(String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, String streetAndNumber, int nbSeats, Ranking[] ranking){
        setWording(wording);
        setDepartureHours(departureHours);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSeats(nbSeats);
        setRanking(ranking);
    }

    public Tournament(String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, String streetAndNumber, int nbSeats){
        setWording(wording);
        setDepartureHours(departureHours);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSeats(nbSeats);
        ranking = new Ranking[nbTeams];
    }

    public Tournament(String wording, LocalDate startDate, LocalDate departureHours, int nbTeams, Locality location, int nbSeats){
        setWording(wording);
        setDepartureHours(departureHours);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setNbSeats(nbSeats);
        setLocation(location);
        streetAndNumber = "";
    }

    public int getNbTeams() {
        return nbTeams;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public LocalDate getDepartureHours() {
        return departureHours;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public Locality getLocation() {
        return location;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getWording() {
        return wording;
    }

    public Ranking[] getRanking() {
        return ranking;
    }

    public void setRanking(Ranking[] ranking) {
        if(ranking.length == nbTeams){
            this.ranking = ranking;
        }
    }

    public void setDepartureHours(LocalDate departureHours) {
        this.departureHours = departureHours;
    }

    public void setLocation(Locality location) {
        this.location = location;
    }

    public void setNbTeams(int nbTeams) {
        if(nbTeams > 1){
            this.nbTeams = nbTeams;
        }else {
            this.nbTeams = 0;
        }
    }

    public void setNbSeats(int nbSeats) {
        if(nbSeats > 1){
            this.nbSeats = nbSeats;
        }else {
            this.nbSeats = 0;
        }
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

}
