package Model;

public class Locality {

    private String wording;
    private String country;
    private int postalCode;

    public Locality(String wording,int postalCode,String country){

        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }



    public void setWording(String wording) {
        this.wording = wording;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
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


}
