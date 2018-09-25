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
        System.out.println("Youplaboum ! Je suis le Rôdeur "  + this.messagePersonnage());
    }


}


