package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Rodeur extends Personnage {
    public Rodeur(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        enemy.setVie(enemy.getVie() - this.getAgilite());
    }

    @Override
    public void specialAttack(Personnage enemy) {
        this.setSpecialAgility(this.getAgilite() + this.getNiveau() / 2, true);
    }

    @Override
    public void infosPersonnage() {
        Map<String, String> characteristics = this.formatCharacteristics();
        Joueur joueur = this.getJoueur();
        System.out.println("Youplaboum ! Je suis le Rôdeur " +
                joueur.infosJoueur() + " niveau " +
                characteristics.get("niveau") + " je possède " +
                characteristics.get("vie") + " de vitalité, " +
                characteristics.get("force") +" de force, " +
                characteristics.get("agilite") + " d'agilité et " +
                characteristics.get("intelligence") + " d'intelligence !");
    }


}


