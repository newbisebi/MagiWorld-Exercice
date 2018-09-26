package com.sma;

public class Joueur {
    private int joueurId;
    Personnage perso = null;


    public Joueur(int joueurId) {
        this.joueurId = joueurId;
    }

    public String infosJoueur(){
        return "Joueur " + joueurId;
    }
}

