package exo.jeu.de;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Joueur {
    private String nom;
    private De de;
    private int lastValue;

    public Joueur(String nom, De de) {
        this.nom = nom;
        this.de = de;
    }

    public int lancerSesDes() {
        int lancer1 = de.lancer();
        int lancer2 = de.lancer();
        this.lastValue = Math.max(lancer1, lancer2);
        return  lastValue;
    }
}
