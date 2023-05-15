package Model;

public class Ranking {
    private Tournament tournament;
    private Team team;
    private Integer position;
    private Integer nbGoalScored;
    private Integer nbGoalConceded;
    private Integer cashPrize;

    public Ranking(Integer position, Integer nbGoalConceded, Integer nbGoalScored,Tournament tournament, Team team){
        setPosition(position);
        setTeam(team);
        setNbGoalScored(nbGoalScored);
        setNbGoalConceded(nbGoalConceded);
        setTournamentWording(tournament);
        cashPrize = 0;
    }
    public Ranking(Integer position, Integer nbGoalConceded, Integer nbGoalScored, Integer cashPrize,Tournament tournament, Team team){
        setPosition(position);
        setTeam(team);
        setNbGoalScored(nbGoalScored);
        setNbGoalConceded(nbGoalConceded);
        setTournamentWording(tournament);
       setCashPrize(cashPrize);
    }

    public Integer getCashPrize() {
        return cashPrize;
    }

    public Integer getNbGoalConceded() {
        return nbGoalConceded;
    }

    public Integer getNbGoalScored() {
        return nbGoalScored;
    }

    public Integer getPosition() {
        return position;
    }


    public Team getTeam() {
        return team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setCashPrize(Integer cashPrize) {
        if(cashPrize > 0){
            this.cashPrize = cashPrize;
        }else{
            this.cashPrize = 0;
        }
    }

    public void setNbGoalConceded(Integer nbGoalConceded) {
        if(nbGoalConceded > 0){
            this.nbGoalConceded = nbGoalConceded;
        }else{
            this.nbGoalConceded = 0;
        }
    }

    public void setNbGoalScored(Integer nbGoalScored) {
        if(nbGoalScored > 0){
            this.nbGoalScored = nbGoalScored;
        }else{
            this.nbGoalScored = 0;
        }
    }

    public void setPosition(Integer position) {
        if(position > 0){
            this.position = position;
        }else{
            this.position = 0;
        }
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public void setTournamentWording(Tournament tournament) {
        this.tournament = tournament;
    }

}
