package com.sma;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Partie partie = new Partie();

        Joueur joueur1 = new Joueur(1);
        Joueur joueur2 = new Joueur(2);

        Personnage perso1 = partie.createPersonnage(joueur1);
        perso1.infosPersonnage();
        Personnage perso2 = partie.createPersonnage(joueur2);
        perso2.infosPersonnage();
        
        partie.combat(perso1, perso2);
    }
}
