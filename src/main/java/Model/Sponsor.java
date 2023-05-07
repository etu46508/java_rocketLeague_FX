package Model;

public class Sponsor {
    private String wording;
    private String nameManager;
    private Club clubSponsorised;

    public Sponsor(String wording, String nameManager, Club clubSponsorised){
        setWording(wording);
        setNameManager(nameManager);
        setClubSponsorised(clubSponsorised);
    }


    //region getters & setters
    public String getWording() {return wording;}
    public void setWording(String wording) {this.wording = wording;}
    public String getNameManager() {return nameManager;}
    public void setNameManager(String nameManager) {this.nameManager = nameManager;}
    public Club getClubSponsorised() {return clubSponsorised;}
    public void setClubSponsorised(Club clubSponsorised) {this.clubSponsorised = clubSponsorised;}
    //endregion



}
