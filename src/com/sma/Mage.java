package com.sma;

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
        String niveau = fmt(this.getNiveau());//Formattage pour éviter les "50.0"
        String vie = fmt(this.getVie());
        String force = fmt(this.getForce());
        int intelligence = this.getIntelligence();
        String agilite = fmt(this.getAgilite());
        Joueur joueur = this.getJoueur();
        System.out.println("Abracadabra ! Je suis le Mâge " + joueur.infosJoueur() + " niveau " + niveau + " je possède " + vie + " de vitalité, " + force +" de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
    }
}
