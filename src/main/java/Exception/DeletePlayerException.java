package Exception;

public class DeletePlayerException extends Exception {
    public DeletePlayerException(){}

    public String getMessage() {
        return "Error, the deletion of the selected player cannot be performed.";
    }

}
