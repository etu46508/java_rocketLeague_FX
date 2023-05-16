package View.Utility;


import javafx.scene.control.Alert;

public class ExceptionDisplay {

    private Exception exception; // L'exception donnée

    public ExceptionDisplay (Exception exception) {
        this.exception = exception;
        displayExceptionPopup(exception);
    }

    private void displayExceptionPopup(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText("Exception happend !");
        alert.setContentText(exception.getMessage());
        alert.showAndWait();
    }
}
