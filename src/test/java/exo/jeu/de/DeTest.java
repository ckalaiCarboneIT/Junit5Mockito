package exo.jeu.de;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeTest {

    @Mock
    private De de;

    @Test
    public void testlancer() {

        when(de.lancer()).thenReturn(1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 1000; i++) {
            int resultat = de.lancer();
            assertTrue(resultat >= 1 && resultat <= 6);
        }
    }

}