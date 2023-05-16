//region packages & imports
package Model;

import java.time.LocalDate;

//endregion

public class Club {
    private Integer serialNumber;
    private String name;
    private String CEO;
    private LocalDate creationDate;

    //endregion constructor
    public Club(Integer serialNumber, String name, String CEO, LocalDate date){
        setSerialNumber(serialNumber);
        setName(name);
        setCEO(CEO);
        setCreationDate(date);
    }
    //endregion


    //region getters and setters

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setCEO(String CEO) {this.CEO = CEO;}
    public String getCEO() {return CEO;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
    public LocalDate getCreationDate() {return creationDate;}

    //endregion

}