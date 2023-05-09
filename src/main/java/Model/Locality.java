package Model;

public class Locality {
    private Integer number;
    private String wording;
    private String country;
    private int postalCode;

    public Locality(Integer number,String wording, String country, int postalCode){
        setNumber(number);
        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }
    public Locality(String wording, String country, int postalCode){
        setCountry(country);
        setPostalCode(postalCode);
        setWording(wording);
    }

    public void setNumber(Integer number){
        this.number = number;
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

    public Integer getNumber() {return number;}


}
