package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Guerrier extends Personnage  {
    public Guerrier(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        enemy.setVie(enemy.getVie()- this.getForce());
    }

    @Override
    public void specialAttack(Personnage enemy) {
        enemy.setVie(enemy.getVie() - this.getForce() * 2);
        this.setVie(this.getVie() - (this.getForce()/2));
    }

    @Override
    public void infosPersonnage() {
        Map<String, String> characteristics = this.formatCharacteristics();
        Joueur joueur = this.getJoueur();
        System.out.println("GRRROOOOARRRRR ! Je suis le Guerrier " +
                joueur.infosJoueur() + " niveau " +
                characteristics.get("niveau") + " je possède " +
                characteristics.get("vie") + " de vitalité, " +
                characteristics.get("force") +" de force, " +
                characteristics.get("agilite") + " d'agilité et " +
                characteristics.get("intelligence") + " d'intelligence !");
    }
}
