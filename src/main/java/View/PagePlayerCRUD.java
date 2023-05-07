package View;

import View.Utility.ReturnMenuButton;
import View.Utility.TitleOfPage;
import View.Utility.FormularyPlayerCreation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class PagePlayerCRUD  {
    private Stage primaryStage;
    private Scene playerCRUD;
    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        this.primaryStage = primaryStage;
        BorderPane root = new BorderPane();

        // Création titre Page
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Interface CRUD", 40,"page");




        // Création du espace bouton
        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(50);
        contentPane.setHgap(50);

        // Création des boutons CRUD
        Button button1 = createButton("Create a Player");
        Button button2 = createButton("Read a Player");
        Button button3 = createButton("Update a Player");
        Button button4 = createButton("Delete a Player");


        // Ajout des boutons au contenu
        contentPane.add(button1, 0, 0);
        contentPane.add(button2, 0, 1);
        contentPane.add(button3, 0, 2);
        contentPane.add(button4, 0, 3);

        // création emplacement des boutons
        BorderPane centerPanel = new BorderPane();
        centerPanel.setLeft(contentPane);

        // Button retour au menu
        ReturnMenuButton returnButton = new ReturnMenuButton();
        BorderPane eastPanel = returnButton.returnMenu(primaryStage, menuScene);

        // Ajout du titre et du contenu à la page
        root.setTop(titlePane);
        root.setCenter(centerPanel);
        root.setBottom(eastPanel);

        // Création de la scène Menu et affichage de la fenêtre
        playerCRUD = new Scene(root, 1000, 800);
        primaryStage.setScene(playerCRUD);
        primaryStage.show();

        // ajout au bouton
        FormularyPlayerCreation formulary = new FormularyPlayerCreation();
        button1.setOnAction(event -> { formulary.openFormulary(primaryStage);});


    }


    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(200, 100);
        button.setStyle("-fx-background-color: darkgrey; -fx-text-fill: white; -fx-border-color: black; -fx-font-size: 20px");
        return button;
    }


    /*
    private void showFormulary(GridPane contentPane){

        GridPane formulaireLayout = new GridPane();
        formulaireLayout.setAlignment(Pos.CENTER);
        formulaireLayout.setHgap(20);
        formulaireLayout.setVgap(20);
        formulaireLayout.setPadding(new Insets(20));

        Label pseudoLabel = new Label("Pseudo of player:");
        pseudoTextField = new TextField();
        formulaireLayout.addRow(1, pseudoLabel, pseudoTextField);

        Label prenomLabel = new Label("Surname:");
        prenomTextField = new TextField();
        formulaireLayout.addRow(2, prenomLabel, prenomTextField);

        Label nomLabel = new Label("Name :");
        nomTextField = new TextField();
        formulaireLayout.addRow(3, nomLabel, nomTextField);

        Label nationalityLabel = new Label("Adresse e-mail :");
        nationalityTextField = new TextField();
        formulaireLayout.addRow(4, nationalityLabel, nationalityTextField);

        var years = new ArrayList<Integer>();
        for (int year = 1900; year <= LocalDate.now().getYear(); year++) {
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
        formulaireLayout.add(yearLabel,0,5);
        formulaireLayout.add(yearComboBox,1,5);

        Label monthLabel = new Label("Month :");
        monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(months);
        formulaireLayout.add(monthLabel,2,5);
        formulaireLayout.add(monthComboBox,3,5);

        Label dayLabel = new Label("Month :");
        dayComboBox = new ComboBox<>();
        dayComboBox.getItems().addAll(days);
        formulaireLayout.add(dayLabel,4,5);
        formulaireLayout.add(dayComboBox,5,5);


        Button validerButton = new Button("Valider");
        validerButton.setOnAction(e -> validerFormulaire());
        formulaireLayout.add(validerButton,0,10);
        contentPane.add(formulaireLayout,1,0);


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
            System.out.println("Date de naissance sélectionnée: " + dateOfBirth);
        }
    }

*/


}
