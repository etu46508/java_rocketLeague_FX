package Model;

public class Ranking {

    //region constructor
    private Integer position;
    private Integer nbGoalScored;
    private Integer nbGoalConceded;
    private Integer cashPrize;
    private Tournament tournament;
    private Team team;

    public Ranking(Integer position, Integer nbGoalScored, Integer nbGoalConceded, Integer cashPrize,Tournament tournament, Team team){
        setPosition(position);
        setTeam(team);
        setNbGoalScored(nbGoalScored);
        setNbGoalConceded(nbGoalConceded);
        setTournament(tournament);
       setCashPrize(cashPrize);
    }
    //endregion


    //region getters and setters

    public void setPosition(Integer position) {
        if(position > 0){
            this.position = position;
        }else{
            this.position = 0;
        }
    }
    public Integer getPosition() {
        return position;
    }

    public void setNbGoalScored(Integer nbGoalScored) {
        if(nbGoalScored > 0){
            this.nbGoalScored = nbGoalScored;
        }else{
            this.nbGoalScored = 0;
        }
    }
    public Integer getNbGoalScored() {
        return nbGoalScored;
    }

    public void setNbGoalConceded(Integer nbGoalConceded) {
        if(nbGoalConceded > 0){
            this.nbGoalConceded = nbGoalConceded;
        }else{
            this.nbGoalConceded = 0;
        }
    }
    public Integer getNbGoalConceded() {
        return nbGoalConceded;
    }

    public void setCashPrize(Integer cashPrize) {
        if(cashPrize == null || cashPrize < 0){
            this.cashPrize = 0;
        }else{
            this.cashPrize = cashPrize;
        }
    }
    public Integer getCashPrize() {
        return cashPrize;
    }


    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
    public Tournament getTournament() {
        return tournament;
    }

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    //endregion
}
