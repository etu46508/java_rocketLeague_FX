package Exception;

public class RankingTournamentException extends TournamentException{
    public RankingTournamentException(){}

    @Override
    public String getMessage() {
        return super.getMessage()+" or there is no ranking for this tournament";
    }
}
