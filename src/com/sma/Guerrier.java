package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Guerrier extends Personnage  {
    public Guerrier(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        double dommages = this.getForce();
        System.out.println(getJoueur().infosJoueur() + " utilise Coup d'Épée et inflige " + fmt(dommages) + " dommages.");
        enemy.setVie(enemy.getVie()- dommages);
        System.out.println(enemy.getJoueur().infosJoueur() + " perd " + fmt(dommages) + " points de vie");
    }

    @Override
    public void specialAttack(Personnage enemy) {
        double dommages = this.getForce()*2;
        System.out.println(getJoueur().infosJoueur() + " utilise Coup de Rage et inflige " + fmt(dommages) + " dommages.");
        enemy.setVie(enemy.getVie() - this.getForce() * 2);
        setVie(this.getVie() - (this.getForce()/2));
        System.out.println(enemy.getJoueur().infosJoueur() + " perd " + fmt(dommages) + " points de vie");
        System.out.println(this.getJoueur().infosJoueur() + " perd " + fmt((this.getForce()/2)) + " points de vie");
    }

    @Override
    public void infosPersonnage() {
        System.out.println("GRRROOOOARRRRR ! Je suis le Guerrier " + messagePersonnage());
    }
}
