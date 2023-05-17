package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Teste extends Application {

    private Spinner<Integer> daySpinner;
    private Spinner<Integer> monthSpinner;
    private Spinner<Integer> yearSpinner;

    @Override
    public void start(Stage primaryStage) {
        daySpinner = new Spinner<>();
        monthSpinner = new Spinner<>();
        yearSpinner = new Spinner<>();

        // Créer une fabrique de valeurs pour les spinners
        SpinnerValueFactory<Integer> dayValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 31);
        SpinnerValueFactory<Integer> monthValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
        SpinnerValueFactory<Integer> yearValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1900, 2100);

        daySpinner.setValueFactory(dayValueFactory);
        monthSpinner.setValueFactory(monthValueFactory);
        yearSpinner.setValueFactory(yearValueFactory);

        Button showDateButton = new Button("Afficher la date");
        showDateButton.setOnAction(event -> {
            int day = daySpinner.getValue();
            int month = monthSpinner.getValue();
            int year = yearSpinner.getValue();
            System.out.println("Date sélectionnée : " + day + "/" + month + "/" + year);
        });

        VBox vbox = new VBox(daySpinner, monthSpinner, yearSpinner, showDateButton);
        vbox.setSpacing(10);

        primaryStage.setScene(new Scene(vbox, 200, 150));
        primaryStage.setTitle("Date Spinner Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}