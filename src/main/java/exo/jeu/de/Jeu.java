package exo.jeu.de;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Jeu {

    private Joueur playerOne;
    private Joueur playerTwo;

    public Joueur jouer() {
        int counter = 0;

        while (counter < 5) {
            playerOne.lancerSesDes();
            int lastvalueOfPlayerOne = playerOne.getLastValue();
            playerTwo.lancerSesDes();
            int lastvalueOfPlayerTwo = playerTwo.getLastValue();

            if (lastvalueOfPlayerOne > lastvalueOfPlayerTwo) {
                return playerOne;
            } else if (lastvalueOfPlayerTwo > lastvalueOfPlayerOne) {
                return playerTwo;
            }
            counter++;
        }

        return null;
    }

}
