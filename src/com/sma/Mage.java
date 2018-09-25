package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Mage extends Personnage {
    public Mage(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {

    }

    @Override
    public void specialAttack(Personnage enemy) {

    }

    @Override
    public void infosPersonnage() {
        System.out.println("Abracadabra ! Je suis le Mâge " + messagePersonnage());
    }
}
