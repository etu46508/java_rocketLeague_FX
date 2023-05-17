package Exception;


public class DataException extends Exception{
    private String message;

    public DataException() {
        this.message = getMessage();
    }

    @Override
    public String getMessage() {
        return "Error, database is not connected or is empty";
    }
}
