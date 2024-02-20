package exo.argent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class SommeArgent {

    private int quantite;
    private String unite;

    public SommeArgent add(SommeArgent m) {
        if (!(this.unite.equals(m.getUnite()))) {
            throw new IllegalArgumentException("Les unités doivent être identiques pour additionner les sommes");
        }
        return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
    }
}
