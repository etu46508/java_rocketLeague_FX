package Model;

import java.time.LocalDate;


public class Tournament {
    private String wording;
    private LocalDate StartDate;
    private Integer tournamentNumber, departureHour;
    private int nbTeams;
    private Locality location;
    private String streetAndNumber;
    private int nbSeats;
    private Ranking [] ranking;

    public Tournament(Integer tournamentNumber,String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSeats,Locality location){
        setTournamentNumber(tournamentNumber);
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSeats(nbSeats);
    }

    public Tournament(String wording, LocalDate startDate, Integer departureHour, Integer nbTeams, String streetAndNumber,Integer nbSeats,Locality location){
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
        setLocation(location);
        setStreetAndNumber(streetAndNumber);
        setNbSeats(nbSeats);
    }
    public Tournament(Integer tournamentNumber,String wording, LocalDate startDate, Integer departureHour, Integer nbTeams){
        setTournamentNumber(tournamentNumber);
        setWording(wording);
        setDepartureHour(departureHour);
        setStartDate(startDate);
        setNbTeams(nbTeams);
    }


    public Integer getTournamentNumber() {
        return tournamentNumber;
    }

    public void setTournamentNumber(Integer tournamentNumber) {
        this.tournamentNumber = tournamentNumber;
    }

    public int getNbTeams() {
        return nbTeams;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public Integer getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Integer departureHour) {
        this.departureHour = departureHour;
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
