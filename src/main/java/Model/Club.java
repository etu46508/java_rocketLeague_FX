package Model;

import java.util.Date;

public class Club {
    private String name;
    private String CEO;
    private Date creationDate;

    public Club(String name, String CEO, Date date){
        setName(name);
        setCEO(CEO);
        setCreationDate(date);
    }

    //region getters & setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCEO() {return CEO;}
    public void setCEO(String CEO) {this.CEO = CEO;}
    public Date getCreationDate() {return creationDate;}
    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}
    //endregion

}