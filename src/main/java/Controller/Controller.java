package Controller;
import Business.Manager;
import Model.*;
import Exception.DataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class Controller {
    private Manager manager;
    public Controller() throws DataException {
        manager = new Manager();
    }
}
