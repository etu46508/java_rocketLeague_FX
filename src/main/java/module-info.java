module View {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.junit.jupiter.api;


    opens View to javafx.fxml;
    exports View;
    exports View.Utility;
    opens View.Utility to javafx.fxml;
}