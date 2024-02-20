package exo.jeu.de;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JeuTest {

    @Mock
    private Joueur playerOne;

    @Mock
    private Joueur playerTwo;

    private Jeu jeu;

    @BeforeEach
    void setUp() {
        jeu = new Jeu(playerOne, playerTwo);
    }

    @AfterEach
    void tearDown() {
        jeu = null;
    }

    @Test
    void playerOneWin() {
        when(playerOne.getLastValue()).thenReturn(6);
        when(playerTwo.getLastValue()).thenReturn(1);
        Joueur winner = jeu.jouer();
        assertEquals(playerOne, winner, "playerOne devrait être le gagnant");
    }

    @Test
    void playertwoWin() {
        when(playerOne.getLastValue()).thenReturn(1);
        when(playerTwo.getLastValue()).thenReturn(6);
        Joueur winner = jeu.jouer();
        assertEquals(playerTwo, winner, "playerTwo devrait être le gagnant");
    }

    @Test
    void equalityResult() {

        when(playerOne.getLastValue()).thenReturn(4);
        when(playerTwo.getLastValue()).thenReturn(4);

        Joueur winner = jeu.jouer();
        verify(playerOne, times(5)).lancerSesDes();
        verify(playerTwo, times(5)).lancerSesDes();
        assertNull(winner, () -> "Le résultat devrait être une égalité (null)");

    }

}