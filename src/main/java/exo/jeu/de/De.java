package exo.jeu.de;

import lombok.Data;

import java.util.Random;
@Data
public class De {

    private static final int MAX_VALUE = 6;

    public int lancer() {
        return new Random().nextInt(MAX_VALUE) + 1;
    }
}
