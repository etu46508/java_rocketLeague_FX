package Exception;


public class DataException extends Exception{
    private String message;

    public DataException() {
        this.message = getMessage();
       //ExceptionDisplay display = new ExceptionDisplay(message);
    }


    @Override
    public String getMessage() {
        return "Erreur, la base de donnée n'est pas connectée ou est vide";
    }


}
