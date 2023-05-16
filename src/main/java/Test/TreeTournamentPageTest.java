package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreeTournamentPageTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void start() {
    }

    @Test
    void draw() {
    }
}

/*
code de chat gpt pour exemple
class TreeTournamentPageTest {

    private TreeTournamentPage treeTournamentPage;

    @BeforeEach
    void setUp() throws Exception {
        // Initialisation avant chaque test
        Stage primaryStage = new Stage();
        Scene menuScene = new Scene(new javafx.scene.layout.Pane(), 800, 600);
        treeTournamentPage = new TreeTournamentPage(primaryStage, menuScene);
    }

    @Test
    void testDrawButtonEnabledWhenComboBoxSelected() {
        // Récupération de la ComboBox et du bouton de dessin
        ComboBox<String> tournamentComboBox = treeTournamentPage.getTournamentComboBox();
        Button drawButton = treeTournamentPage.getDrawButton();

        // Vérification que le bouton de dessin est initialement désactivé
        assertTrue(drawButton.isDisabled());

        // Sélection d'un élément dans la ComboBox
        tournamentComboBox.getSelectionModel().select("Tournament 1");

        // Vérification que le bouton de dessin est maintenant activé
        assertFalse(drawButton.isDisabled());
    }

    @Test
    void testDrawButtonDisabledWhenComboBoxNotSelected() {
        // Récupération de la ComboBox et du bouton de dessin
        ComboBox<String> tournamentComboBox = treeTournamentPage.getTournamentComboBox();
        Button drawButton = treeTournamentPage.getDrawButton();

        // Vérification que le bouton de dessin est initialement désactivé
        assertTrue(drawButton.isDisabled());

        // Vérification que le bouton de dessin reste désactivé si aucun élément n'est sélectionné dans la ComboBox
        assertTrue(drawButton.isDisabled());
    }
}
 */