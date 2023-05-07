package Model;

public class Ranking {
    private Tournament tournament;
    private Team team;
    private int position;
    private int nbGoalScored;
    private int nbGoalConceded;
    private int cashPrize;

    public Ranking(Tournament tournament, Team team, int position, int nbGoalConceded, int nbGoalScored){
        setPosition(position);
        setTeam(team);
        setNbGoalScored(nbGoalScored);
        setNbGoalConceded(nbGoalConceded);
        setTournamentWording(tournament);
        cashPrize = 0;
    }
    public Ranking(Tournament tournament, Team team, int position, int nbGoalConceded, int nbGoalScored, int cashPrize){
        setPosition(position);
        setTeam(team);
        setNbGoalScored(nbGoalScored);
        setNbGoalConceded(nbGoalConceded);
        setTournamentWording(tournament);
       setCashPrize(cashPrize);
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public int getNbGoalConceded() {
        return nbGoalConceded;
    }

    public int getNbGoalScored() {
        return nbGoalScored;
    }

    public int getPosition() {
        return position;
    }


    public Team getTeam() {
        return team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setCashPrize(int cashPrize) {
        if(cashPrize > 0){
            this.cashPrize = cashPrize;
        }else{
            this.cashPrize = 0;
        }
    }

    public void setNbGoalConceded(int nbGoalConceded) {
        if(nbGoalConceded > 0){
            this.nbGoalConceded = nbGoalConceded;
        }else{
            this.nbGoalConceded = 0;
        }
    }

    public void setNbGoalScored(int nbGoalScored) {
        if(nbGoalScored > 0){
            this.nbGoalScored = nbGoalScored;
        }else{
            this.nbGoalScored = 0;
        }
    }

    public void setPosition(int position) {
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
