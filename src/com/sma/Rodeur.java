package com.sma;

import static com.sma.FormatDouble.fmt;

public class Rodeur extends Personnage{
    public Rodeur(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        enemy.setVie(enemy.getVie() - this.getAgilite());
    }

    @Override
    public void specialAttack(Personnage enemy) {
        this.setAgilite(this.getNiveau()/2);

    }

    @Override
    public void infosPersonnage() {
        int niveau = this.getNiveau();
        String vie = fmt(this.getVie());
        String force = fmt(this.getForce());
        int intelligence = this.getIntelligence();
        int agilite = this.getAgilite();
        Joueur joueur = this.getJoueur();
        System.out.println("Youplaboum ! Je suis le Rôdeur " + joueur.infosJoueur() + " niveau " + niveau + " je possède " + vie + " de vitalité, " + force +" de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence !");
    }
}
