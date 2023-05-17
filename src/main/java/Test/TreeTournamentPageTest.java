package Test;

import Controller.Controller;
import Model.Ranking;
import View.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class TreeTournamentPageTest {
    private TreeTournamentPage treeTournamentPage;
    private Button drawButton;
    private ComboBox<String> tournamentComboBox;
    private ArrayList<Ranking> rankings;
    private Controller controller;
    private GridPane drawPane;

    @BeforeEach
    void setUp() throws Exception {
        Stage primaryStage = new Stage();
        Scene menuScene = new Scene(new javafx.scene.layout.Pane(), 800, 600);
        treeTournamentPage = new TreeTournamentPage(primaryStage, menuScene);
        controller = new Controller();
        drawButton = treeTournamentPage.getDrawButton();
        tournamentComboBox = treeTournamentPage.getTournamentComboBox();
        rankings.add(controller.getRanking(1,112));
        rankings.add(controller.getRanking(2,112));
        rankings.add(controller.getRanking(3,112));
        rankings.add(controller.getRanking(5,112));
        rankings.add(controller.getRanking(6,112));
        rankings.add(controller.getRanking(7,112));
        rankings.add(controller.getRanking(8,112));
        rankings.add(controller.getRanking(9,112));
        drawPane = (GridPane) treeTournamentPage.getRoot().getLeft();
    }

    @Test
    void start() {
        //initialement set a disable
        assertTrue(drawButton.isDisabled());

        //selection du premier élément puis test si enable
        tournamentComboBox.getSelectionModel().selectFirst();
        assertFalse(drawButton.isDisabled());
    }

    @Test
    void draw() throws Exception{
            // Appel de la méthode draw() avec des équipes complètes
            treeTournamentPage.draw("RLCS Final Saison 6");//correspondant a 112

            // Vérification du résultat attendu
            assertEquals(8, treeTournamentPage.getRoot().getChildren().size());
            assertTrue(treeTournamentPage.getRoot().getLeft() instanceof GridPane);

            //re vérifie la taille du résultat attendu
            assertEquals(8, drawPane.getChildren().size());
            // Vérifie les équipes dans le drawPane
            assertNotNull(drawPane.lookup("Les abeilles"));
            assertNotNull(drawPane.lookup("BDS"));


            // enleve le dernier élément
            rankings.remove(7);
            //appel avec une équipe manquante
            treeTournamentPage.draw("RLCS Final Saison 6");
            // Vérification du résultat attendu
            assertEquals("The number of teams isn't complete", treeTournamentPage.getZoneTextInfo().getText());
    }
}
