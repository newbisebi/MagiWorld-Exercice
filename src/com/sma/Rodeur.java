package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Rodeur extends Personnage {
    public Rodeur(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        double dommages = this.getAgilite();
        System.out.println(getJoueur().infosJoueur() + " utilise Tir à l'Arc et inflige " + fmt(dommages) + " dommages.");
        System.out.println(enemy.getJoueur().infosJoueur() + " perd " + fmt(dommages) + " points de vie");
        enemy.setVie(enemy.getVie() - dommages);
    }

    @Override
    public void specialAttack(Personnage enemy) {
        this.setSpecialAgility(getAgilite() + getNiveau() / 2, true);
        System.out.println(this.getJoueur().infosJoueur() +" utilise Concentration et gagne "+ fmt((getNiveau()/2)) +" en agilité.");
    }

    @Override
    public void infosPersonnage() {
        System.out.println("Youplaboum ! Je suis le Rôdeur "  + messagePersonnage());
    }


}


