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
        Map<String, String> characteristics = this.formatCharacteristics();
        Joueur joueur = this.getJoueur();
        System.out.println("Abracadabra ! Je suis le Mâge " +
                joueur.infosJoueur() + " niveau " +
                characteristics.get("niveau") + " je possède " +
                characteristics.get("vie") + " de vitalité, " +
                characteristics.get("force") +" de force, " +
                characteristics.get("agilite") + " d'agilité et " +
                characteristics.get("intelligence") + " d'intelligence !");    }
}
