package com.sma;

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
        int niveau = this.getNiveau();
        String vie = fmt(this.getVie()); //Formattage pour éviter les "250.0"
        String force = fmt(this.getForce());
        int intelligence = this.getIntelligence();
        int agilite = this.getAgilite();
        Joueur joueur = this.getJoueur();
        System.out.println("GRRROOOOARRRRR ! Je suis le Guerrier " + joueur.infosJoueur() + " niveau " + niveau + " je possède " + vie + " de vitalité, " + force +" de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
    }
}
