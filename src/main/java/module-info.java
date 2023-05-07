module view.projetjavafxv0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.projetjavafxv0 to javafx.fxml;
    exports view.projetjavafxv0;
}