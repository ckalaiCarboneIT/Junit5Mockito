package exo.argent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SommeArgentTest {

    SommeArgent m12CHF;
    SommeArgent m14CHF;
    SommeArgent m14USD;
    SommeArgent sommeIdentiqueA12CHF;
    SommeArgent m15CHF;

    @BeforeEach
    void setUp() {
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
        m15CHF = new SommeArgent(15, "CHF");
        sommeIdentiqueA12CHF = new SommeArgent(12, "CHF");

    }


    @Test
    void add() {
        SommeArgent resultat = m12CHF.add(m14CHF);
        assertEquals(26, resultat.getQuantite(),
                () -> "La quantité d'argent après addition devrait être 25 mais est " + resultat.getQuantite());
        assertEquals("CHF", resultat.getUnite(),
                () -> "L'unité d'argent après addition devrait être EUR mais est " + resultat.getUnite());
    }

    @Test
    void testAddWithDifferentUnitesShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> m14CHF.add(m14USD),
                "Une IllegalArgumentException aurait dû être levée pour des unités différentes");
    }

    @Test
    void additionNeDevraitPasEtreEgaleApresModification() {
        SommeArgent result = m12CHF.add(new SommeArgent(2, "CHF"));
        m14CHF.setQuantite(10);
        assertNotEquals(m14CHF, result, "Les objets devraient être différents après modification.");
    }

    @Test
    void testEquals() {

        assertAll("Testing equals method",
                () -> assertTrue(m12CHF.equals(m12CHF), "Un objet doit être égal à lui-même."),
                () -> assertTrue(m12CHF.equals(sommeIdentiqueA12CHF) && sommeIdentiqueA12CHF.equals(m12CHF), "L'égalité doit être symétrique."),
                () -> {
                    SommeArgent autreSommeIdentiqueA12CHF = new SommeArgent(12, "CHF");
                    assertTrue(m12CHF.equals(sommeIdentiqueA12CHF) && sommeIdentiqueA12CHF.equals(autreSommeIdentiqueA12CHF) && m12CHF.equals(autreSommeIdentiqueA12CHF), "L'égalité doit être transitive.");
                },
                () -> assertFalse(m12CHF.equals(null), "Aucun objet ne doit être égal à null."),
                () -> assertFalse(m12CHF.equals(m14USD), "Des objets avec des unités différentes ne doivent pas être égaux."),
                () -> assertFalse(m12CHF.equals(m15CHF), "Des objets avec des quantités différentes ne doivent pas être égaux.")
        );
    }


    @AfterEach
    void tearDown() {
        m12CHF = null;
        m14CHF = null;
        m14USD = null;
        m15CHF = null;
        sommeIdentiqueA12CHF = null;
    }
}
