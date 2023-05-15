package Model;

public class Locality {

    private String wording;
    private String country;
    private Integer postalCode;

    public Locality(String wording,Integer postalCode,String country){
        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }


    public Integer getPostalCode() {
        return postalCode;
    }
    public void setWording(String wording) {
        this.wording = wording;
    }


    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }


    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    public String getWording() {
        return wording;
    }






}
