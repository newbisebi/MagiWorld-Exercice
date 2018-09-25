package com.sma;

import java.util.Map;

import static com.sma.FormatDouble.fmt;

public class Mage extends Personnage {
    public Mage(int niveau, Joueur joueur) {
        super(niveau, joueur);
    }

    @Override
    public void basicAttack(Personnage enemy) {
        double dommages = this.getIntelligence();
        System.out.println(this.getJoueur().infosJoueur() + " utilise Boule de Feu et inflige " + fmt(dommages) + " dommages.");
        enemy.setVie(enemy.getVie()- dommages);
        System.out.println(enemy.getJoueur().infosJoueur() + " perd " + fmt(dommages) + " points de vie");

    }

    @Override
    public void specialAttack(Personnage enemy) {
        double max_vitality = this.getNiveau()*5;
        double new_vitality = this.getVie() + this.getIntelligence()*2;
        double gainVitalite = Math.min(max_vitality, new_vitality) - this.getVie();
        this.setVie(Math.min(max_vitality, new_vitality));
        System.out.println(this.getJoueur().infosJoueur() + " utilise Soin et gagne " + fmt(gainVitalite) + " en vitalité.");
    }

    @Override
    public void infosPersonnage() {
        System.out.println("Abracadabra ! Je suis le Mâge " + messagePersonnage());
    }
}
