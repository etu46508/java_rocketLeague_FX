package View;

import Model.Ranking;
import Model.Team;
import Model.Tournament;
import View.Utility.ReturnMenuButton;
import View.Utility.TitleOfPage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


public class TreeTournamentPage {
    private Stage primaryStage;
    private Scene tournamentScene;
    private ToggleGroup teamGroup;
    private RadioButton team4, team8, team16;
    private Label zoneTextNbTeam;
    private ComboBox tournamentComboBox;
    private BorderPane root;
    private Button drawButton;

    public TreeTournamentPage (Stage primaryStage, Scene menuScene) throws Exception {
            this.start(primaryStage, menuScene);
    }

    public void start(Stage primaryStage, Scene menuScene) throws Exception {
        this.primaryStage = primaryStage;
        root = new BorderPane();

        // Création titre Page
        TitleOfPage title = new TitleOfPage();
        StackPane titlePane = title.createTitle("Randomizer of tournament tree","secondary page");



        // Création du espace content bouton, message, comboBox
        GridPane contentPane = new GridPane();
        contentPane.setAlignment(Pos.TOP_LEFT);
        contentPane.setVgap(30);
        contentPane.setHgap(30);

        /*
        // Création choix nombre de team
        teamGroup = new ToggleGroup();
        team4 = new RadioButton("4 teams");
        team4.setStyle("-fx-font-size:15");
        team8 = new RadioButton("8 teams");
        team8.setStyle("-fx-font-size:15");
        team16 = new RadioButton("16 teams");
        team16.setStyle("-fx-font-size:15");

        // ajout bouton radio au ToggleGroup
        team4.setToggleGroup(teamGroup);
        team8.setToggleGroup(teamGroup);
        team16.setToggleGroup(teamGroup);
*/
        //RadioButtonListener radioButtonListener = new RadioButtonListener();

        zoneTextNbTeam = new Label();
        zoneTextNbTeam.setStyle("-fx-font-size:15");
        //team4.selectedProperty().addListener(radioButtonListener);
        //team8.selectedProperty().addListener(radioButtonListener);
        //team16.selectedProperty().addListener(radioButtonListener);

        // création comboBox
        tournamentComboBox = new ComboBox<>();

        tournamentComboBox.getSelectionModel().select(0);
        ComboboxListener comboboxListener = new ComboboxListener();
        tournamentComboBox.valueProperty().addListener(comboboxListener);

        // Ajout  au contenu
        //contentPane.add(team4, 2, 2);
        //contentPane.add(team8, 3, 2);
        //contentPane.add(team16, 4, 2);
        //contentPane.add(zoneTextNbTeam, 5, 2);
        contentPane.add(tournamentComboBox,1,4);


        // Button retour au menu
        ReturnMenuButton returnButton = new ReturnMenuButton();
        BorderPane eastPanel = returnButton.returnMenu(primaryStage, menuScene);

        // Button lancer le tirage
        drawButton = new Button("lancer le tirage");
        contentPane.add(drawButton, 2, 4);
        drawButton.setOnAction(event -> {
            try {
                draw((Tournament)tournamentComboBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Ajout du titre et du contenu à la page
        root.setTop(titlePane);
        root.setCenter(contentPane);
        root.setBottom(eastPanel);

        // Création de la scène Menu et affichage de la fenêtre
        tournamentScene = new Scene(root, 1000, 800);
        primaryStage.setScene(tournamentScene);
        primaryStage.show();

        // ajout info comboBox                      // implémentez getFuturTournament(nb Tournament)
        tournamentComboBox.getItems().addAll("Tournament 1", "Tournament 2", "Tournament 3", "Tournament 4", "Tournament 5");

    }

    private javafx.scene.control.Label createLabel(String text, int size) {
        javafx.scene.control.Label label = new javafx.scene.control.Label(text);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, size));
        label.setStyle("-fx-text-fill: black;");
        return label;
    }

    /*private class RadioButtonListener implements ChangeListener<Boolean> {
        @Override
        public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {
            if (team4.isSelected() && newValue) {
                zoneTextNbTeam.setText("=> 4 teams must be selected : ");
            } else if (team8.isSelected() & newValue) {
                zoneTextNbTeam.setText("=> 8 teams must be selected : ");
            } else if (newValue) {
                zoneTextNbTeam.setText("=> 16 teams must be selected : ");
            }

        }
    }*/
    private class ComboboxListener implements ChangeListener<String> {
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
            System.out.println(newValue);
        }
    }


    public void draw (Tournament tournament){
        Ranking[] ranking = tournament.getRanking();
        if(ranking.length == tournament.getNbTeams()){
            GridPane drawPane = new GridPane();
            drawPane.setAlignment(Pos.BOTTOM_LEFT);
            drawPane.setVgap(50);
            drawPane.setHgap(150);
            boolean contre = true;
            int rnd;
            ArrayList<Team> teams = new ArrayList<>();
            for(int iTeam = 0; iTeam <= tournament.getNbTeams(); iTeam++){
                teams.add(ranking[iTeam].getTeam());
            }
            int iTeam = 1;
            while(teams.size() != 0){
                rnd = new Random().nextInt(teams.size());
                Label teamLabel = new Label(teams.get(rnd).getClub().getName());
                if(contre){
                    drawPane.add(teamLabel, 0, iTeam);
                }else{
                    drawPane.add(teamLabel, 1, iTeam);
                }
                teams.remove(rnd);
            }
            root.setBottom(drawPane);
        }else{
            zoneTextNbTeam.setText("Le nombre d'équipe inscrite à ce tournois n'est pas suffisant");
        }
    }
}
