//region packages & imports
package View.Utility;

import javafx.scene.control.Alert;

//endregion

public class ExceptionDisplay {

    public ExceptionDisplay (Exception exception) {
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
