package Model;

public class Locality {

    private String wording;
    private String country;
    private Integer postalCode;

    //region constructor
    public Locality(String wording,Integer postalCode,String country){
        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }
    //endregion

    //region getters and setters
    public void setWording(String wording) {
        this.wording = wording;
    }
    public String getWording() {
        return wording;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    public Integer getPostalCode() {
        return postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }

    //endregion








}
