package View.Utility;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;


public class FormularyPlayerCreation extends Exception{
    private TextField pseudoTextField,prenomTextField, nomTextField,nationalityTextField;
    private Stage formulaireStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox;
    public void openFormulary(Stage primaryStage) {
        GridPane formulaireLayout = new GridPane();
        formulaireLayout.setAlignment(Pos.CENTER);
        formulaireLayout.setHgap(20);
        formulaireLayout.setVgap(20);
        formulaireLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        pseudoTextField = new TextField();
        formulaireLayout.addRow(0, pseudoLabel, pseudoTextField);

        Label prenomLabel = new Label("Surname:");
        prenomTextField = new TextField();
        formulaireLayout.addRow(1, prenomLabel, prenomTextField);

        Label nomLabel = new Label("Name :");
        nomTextField = new TextField();
        formulaireLayout.addRow(2, nomLabel, nomTextField);

        Label nationalityLabel = new Label("Nationality :");
        nationalityTextField = new TextField();
        formulaireLayout.addRow(3, nationalityLabel, nationalityTextField);

        var years = new ArrayList<Integer>();
        for (int year = LocalDate.now().getYear(); year >= 1950; year--) {
            years.add(year);
        }
        var months = new ArrayList<Integer>();
        for (int month = 1; month <= 12; month++) {
            months.add(month);
        }
        var days = new ArrayList<Integer>();
        for (int day = 1; day <= 31; day++) {
            days.add(day);
        }

        // Créer les ComboBox pour l'année, le mois et le jour
        // activation des comboBox

        Label yearLabel = new Label("Year :");
        yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(years);
        formulaireLayout.add(yearLabel,0,4);
        formulaireLayout.add(yearComboBox,1,4);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);
        formulaireLayout.add(monthLabel,2,4);
        formulaireLayout.add(monthComboBox,3,4);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);
        formulaireLayout.add(dayLabel,4,4);
        formulaireLayout.add(dayComboBox,5,4);

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(e -> validerFormulaire());
        formulaireLayout.add(validerButton,0,10);

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formulaireStage.close());
        formulaireLayout.add(returnButton,10,10);

        Scene formulaireScene = new Scene(formulaireLayout);
        formulaireStage = new Stage();
        formulaireStage.setTitle("Formulaire");

        formulaireStage.setScene(formulaireScene);
        formulaireStage.initOwner(primaryStage);
        formulaireStage.show();
    }

    private void validerFormulaire() {
        String pseudo = pseudoTextField.getText();
        String prenom = prenomTextField.getText();
        String nom = nomTextField.getText();
        String nationality = nationalityTextField.getText();
        Integer year = yearComboBox.getValue();
        Integer  month = monthComboBox.getValue();
        Integer  day = dayComboBox.getValue();


        if(!pseudo.matches("[\\w\\d\\s\\S]+") && pseudo != null){
            System.err.println("Erreur : la champ pseudo est vide.");
            pseudoTextField.setStyle("-fx-border-color: red;");
        }
        else if (!prenom.matches("[a-zA-Z]+") && prenomTextField != null) {
            System.err.println("Erreur : Le prénom ne doit contenir que des lettres.");
            prenomTextField.setStyle("-fx-border-color: red;");
        } else if (!nom.matches("[a-zA-Z]+") && nomTextField != null) {
            System.err.println("Erreur : Le nom ne doit contenir que des lettres.");
            nomTextField.setStyle("-fx-border-color: red;" );
        } else if (!nationality.matches("[a-zA-Z]+") && nationalityTextField != null) {
            System.err.println("Erreur : L'adresse e-mail n'est pas valide.");
        }else {
            var dateOfBirth = LocalDate.of(year, month, day);
            System.out.println("Player :"+pseudo+" du nom de :"+nom+" "+prenom+" né le " + dateOfBirth);
        }
    }

    }

