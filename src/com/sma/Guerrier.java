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
        System.out.println("GRRROOOOARRRRR ! Je suis le Guerrier " + this.messagePersonnage());
    }
}
