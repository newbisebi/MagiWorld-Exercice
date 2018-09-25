package com.sma;

import java.util.Scanner;

public class Partie {

    Scanner sc = new Scanner(System.in);


    public Personnage createPersonnage(Joueur joueur){
        System.out.println("Création du personnage du "+joueur.infosJoueur());
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2 : Rodeur, 3 : Mage)");
        int choixPerso = sc.nextInt();

        System.out.println("Niveau du personnage ? ");
        int niveauPerso = sc.nextInt();

        System.out.println("Force du personnage ? ");
        int forcePerso = sc.nextInt();

        System.out.println("Agilité du personnage ? ");
        int agilitePerso = sc.nextInt();

        System.out.println("Intelligence du personnage ? ");
        int intelligencePerso = sc.nextInt();

        Personnage personnage = null;
        switch (choixPerso){
            case 1:
                personnage = new Guerrier(niveauPerso, joueur);
                break;
            case 2:
                personnage = new Rodeur(niveauPerso, joueur);
                break;
            case 3:
                personnage = new Mage(niveauPerso, joueur);
                break;
        }
        
        personnage.setForce(forcePerso);
        personnage.setAgilite(agilitePerso);
        personnage.setIntelligence(intelligencePerso);

        return personnage;
    }

    public void tour(Personnage perso, Personnage enemy){
        System.out.println(perso.getJoueur().infosJoueur() +
                " (" + perso.getVie() + " vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
        int action = sc.nextInt();
        switch (action){
            case 1:
                perso.basicAttack(enemy);
                break;
            case 2:
                perso.specialAttack(enemy);
        }
    }

    public void combat(Personnage perso1, Personnage perso2){
        while (perso1.getVie()>0 && perso2.getVie()>0){
            tour(perso1, perso2);
            if (perso1.getVie()>0 && perso2.getVie()>0)
                tour(perso2, perso1);
        }
    }
}