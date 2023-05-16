package Model;

public class Sponsor {

    //region constructor
    private String wording;
    private String nameManager;
    private Club clubSponsored;

    public Sponsor(String wording, String nameManager, Club clubSponsored){
        setWording(wording);
        setNameManager(nameManager);
        setClubSponsored(clubSponsored);
    }

    //endregion

    //region getters & setters

    public void setWording(String wording) {this.wording = wording;}
    public String getWording() {return wording;}

    public void setNameManager(String nameManager) {this.nameManager = nameManager;}
    public String getNameManager() {return nameManager;}

    public void setClubSponsored(Club clubSponsored) {this.clubSponsored = clubSponsored;}
    public Club getClubSponsored() {return clubSponsored;}

    //endregion



}
