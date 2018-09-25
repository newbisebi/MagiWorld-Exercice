package com.sma;

public class Joueur {
    private int joueurId;

    public Joueur(int joueurId) {
        this.joueurId = joueurId;
    }

    public String infosJoueur(){
        return "Joueur " + joueurId;
    }
}

