package Model;

import java.time.LocalDate;


public class Club {
    private Integer serialNumber;
    private String name;
    private String CEO;
    private LocalDate creationDate;

    public Club(Integer serialNumber, String name, String CEO, LocalDate date){
        setSerialNumber(serialNumber);
        setName(name);
        setCEO(CEO);
        setCreationDate(date);
    }

    //region getters & setters

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCEO() {return CEO;}
    public void setCEO(String CEO) {this.CEO = CEO;}
    public LocalDate getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
    //endregion

}