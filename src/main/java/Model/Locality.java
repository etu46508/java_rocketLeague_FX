package Model;

public class Locality {
    private String wording;
    private String country;
    private int postalCode;

    public Locality(String wording, String country, int postalCode){
        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public String getWording() {
        return wording;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
