package exo.jeu.de;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JoueurTest {

    @Mock
    De deMock;
    Joueur joueur;


    @BeforeEach
    void setUp() {
        joueur = new Joueur("Cairedine", deMock);
    }

    @Test
    void testLeJoueurAUnNom() throws NoSuchFieldException, IllegalAccessException {
        Field nom = Joueur.class.getDeclaredField("nom");
        nom.setAccessible(true);
        String nomJoueur = (String) nom.get(joueur);
        assertEquals("Cairedine", nomJoueur);
    }

    @Test
    void test2LancersExactement() {
        joueur.lancerSesDes();
        verify(deMock, Mockito.times(2)).lancer();
    }

    @ParameterizedTest
    @CsvSource(value = {"5,2,5", "1,6,6", "4,4,4"})
    void testPlay(int premier, int deuxieme, int expectedResult) {
        when(deMock.lancer()).thenReturn(premier, deuxieme);
        joueur.lancerSesDes();
        int res = joueur.getLastValue();
        assertEquals(expectedResult, res, () -> "Le résultat du lancer ne correspond pas au résultat attendu");

    }

    @AfterEach
    void tearDown() {
        joueur = null;
    }


}