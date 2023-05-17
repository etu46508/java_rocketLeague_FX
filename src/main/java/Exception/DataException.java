package Exception;


public class DataException extends Exception{

    public DataException() {}

    @Override
    public String getMessage() {
        return "Error, database is not connected or is empty";
    }
}
