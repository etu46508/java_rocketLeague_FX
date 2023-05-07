package View.Utility;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;


public class FormularyPlayerCreation {
    private TextField pseudoTextField,surnameTextField, nameTextField,nationalityTextField;
    private Stage formularyStage;
    private ComboBox<Integer> yearComboBox,monthComboBox,dayComboBox;
    private CheckBox keybordButton;
    private Integer keybordBit;
    public void openFormulary(Stage primaryStage) {
        GridPane formularyLayout = new GridPane();
        formularyLayout.setAlignment(Pos.CENTER);
        formularyLayout.setHgap(20);
        formularyLayout.setVgap(20);
        formularyLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo :");
        pseudoTextField = new TextField();
        formularyLayout.addRow(0, pseudoLabel, pseudoTextField);

        Label surnameLabel = new Label("Surname:");
        surnameTextField = new TextField();
        formularyLayout.addRow(1, surnameLabel, surnameTextField);

        Label nameLabel = new Label("Name :");
        nameTextField = new TextField();
        formularyLayout.addRow(2, nameLabel, nameTextField);

        Label nationalityLabel = new Label("Nationality :");
        nationalityTextField = new TextField();
        formularyLayout.addRow(3, nationalityLabel, nationalityTextField);

        var years = new ArrayList<Integer>();
        for (int year = LocalDate.now().getYear()-16; year >= 1950; year--) {
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
        formularyLayout.add(yearLabel,0,4);
        formularyLayout.add(yearComboBox,1,4);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);
        formularyLayout.add(monthLabel,2,4);
        formularyLayout.add(monthComboBox,3,4);

        Label dayLabel = new Label("Day :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);
        formularyLayout.add(dayLabel,4,4);
        formularyLayout.add(dayComboBox,5,4);

        Label playWithKaybord = new Label("Play with keybord : ");
        keybordButton = new CheckBox();
        formularyLayout.add(playWithKaybord,0,5);
        formularyLayout.add(keybordButton,1,5);


        Button validerButton = new Button("Valider");
        validerButton.setOnAction(e -> validerformulary());
        formularyLayout.add(validerButton,0,10);

        Button returnButton = new Button("Return");
        returnButton.setOnAction(e -> formularyStage.close());
        formularyLayout.add(returnButton,10,10);

        Scene formularyScene = new Scene(formularyLayout);
        formularyStage = new Stage();
        formularyStage.setTitle("formulary");
        formularyStage.initModality(Modality.APPLICATION_MODAL);

        formularyStage.setScene(formularyScene);
        formularyStage.initOwner(primaryStage);
        formularyStage.showAndWait();
    }

    private void validerformulary() {
        pseudoTextField.setStyle("-fx-border-color: transparent;");
        surnameTextField.setStyle("-fx-border-color: transparent;");
        nameTextField.setStyle("-fx-border-color: transparent;" );
        nationalityTextField.setStyle("-fx-border-color: transparent;" );
        String pseudo = pseudoTextField.getText();
        String surname = surnameTextField.getText();
        String name = nameTextField.getText();
        String nationality = nationalityTextField.getText();
        Integer year = yearComboBox.getValue();
        Integer  month = monthComboBox.getValue();
        Integer  day = dayComboBox.getValue();

        StringBuilder fieldEmpty = new StringBuilder();
        Boolean formularyError = false;

        if(keybordButton.isSelected()){
            keybordBit = 1;
        }else{
            keybordBit = 0;
        }
        if(!pseudo.matches("[\\w\\d\\s\\S]+") && pseudo != null){
            fieldEmpty.append("Error : the pseudo field isn't valid.\n");
            pseudoTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!surname.matches("[a-zA-Z]+") && surnameTextField != null) {
            fieldEmpty.append("Error : the surname field isn't valid.\n");
            surnameTextField.setStyle("-fx-border-color: red;");
            formularyError = true;
        }
        if (!name.matches("[a-zA-Z]+") && nameTextField != null) {
            fieldEmpty.append("Error : the name field isn't valid.\n");
            nameTextField.setStyle("-fx-border-color: red;" );
            formularyError = true;
        }
        if (!nationality.matches("[a-zA-Z]+") && nationalityTextField != null) {
            fieldEmpty.append("Error : the nationalityfield isn't valid.\n");
            nationalityTextField.setStyle("-fx-border-color: red;" );
            formularyError = true;
        }
        if(year == null || month == null || day == null){
            fieldEmpty.append("Error : the birthdate isn't valid.\n");
            formularyError = true;
        }
        if(!formularyError){
            var dateOfBirth = LocalDate.of(year, month, day);
            System.out.println("Player : "+pseudo+" du name de :"+name+" "+surname+" né le " + dateOfBirth +(keybordBit ==1? " et est un joueur Clavier Souris":""));
            formularyStage.close();
        }else{
            System.out.println(fieldEmpty.toString());
        }

    }

    private class CheckBoxListener implements ChangeListener<Integer>{
        @Override
        public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
            if(keybordButton.isSelected()){
                keybordBit = 1;
            }else{
                keybordBit = 0;
            }
        }
    }

    }

