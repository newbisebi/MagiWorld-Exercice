package com.sma;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.sma.FormatDouble.fmt;

public class Partie {
    Scanner sc = new Scanner(System.in);

    /**
     * Créé un personnage à partir des indications données par le joueur
     * @param joueur joueur dont on créé le personnage
     * @return personnage avec ses attributs
     */
    public Personnage createPersonnage(Joueur joueur){
        System.out.println("Création du personnage du "+joueur.infosJoueur());

        int classe = askClasse();
        int niveau = askNiveau();

        Personnage personnage = null;
        switch (classe){
            case 1:
                personnage = new Guerrier(niveau, joueur);
                break;
            case 2:
                personnage = new Rodeur(niveau, joueur);
                break;
            case 3:
                personnage = new Mage(niveau, joueur);
                break;
        }
        defForceAttribute(personnage);
        defAgiliteAttribute(personnage);
        defIntelligenceAttribute(personnage);

        return personnage;
    }
    /**
     * Demande à l'utilisateur de choisir une classe
     * Vérifie que la classe est valide (1, 2 ou 3)
     * @return classe choisie
     */
    private int askClasse(){
        boolean classeCorrect = false;
        int classe = 0;
        while (!classeCorrect) {
            try {
                System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2 : Rodeur, 3 : Mage)");
                classe = sc.nextInt();
                if (classe == 1 || classe == 2 || classe == 3) {
                    classeCorrect = true;
                } else {
                    System.out.println("Veuillez choisir entre 1, 2 et 3 !");
                }

            } catch (InputMismatchException e) {
                System.out.println("Veuillez choisir entre 1, 2 et 3 !");
                sc.nextLine();
            }
        }
        return classe;
    }
    /**
     * Demande à l'utilisateur de choisir un niveau
     * Vérifie que le niveau est valide (entier compris entre 1 et 100)
     * @return niveau du personnage
     */
    private int askNiveau(){
        boolean niveauCorrect = false;
        int niveau = 0;
        while (!niveauCorrect){
            try {
                System.out.println("Niveau du personnage ? ");
                niveau = sc.nextInt();
                if (niveau >0 && niveau <=100){
                    niveauCorrect = true;
                } else {
                    System.out.println("Le niveau doit être compris entre 1 et 100");
                }
            } catch (InputMismatchException e){
                System.out.println("Veuillez entrer un nombre entier !");
                sc.nextLine();
            }
        }
        return niveau;
    }

    /**
     * Associe au personnage la force choisir par le joueur
     * Vérifie que la valeur entrée est cohérente
     */
    private void defForceAttribute(Personnage personnage) {
        double pointsAttributs = personnage.getNiveau()
                - personnage.getAgilite()
                - personnage.getForce()
                - personnage.getIntelligence();
        while (true) {
            try {
                System.out.println("Force du personnage ? Vous pouvez attribuer au maximum " + fmt(pointsAttributs) + " points.");
                personnage.setForce(sc.nextInt());
                break;
            } catch (IncorrectCharacteristicsException e) {
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Veuillez entrer un nombre entier !");
                sc.nextLine();
            }
        }
    }
    /**
     * Associe au personnage l'agilité choisir par le joueur
     * Vérifie que la valeur entrée est cohérente
     */
    private void defAgiliteAttribute(Personnage personnage) {
        double pointsAttributs = personnage.getNiveau()
                - personnage.getAgilite()
                - personnage.getForce()
                - personnage.getIntelligence();
        while (true) {
            try {
                System.out.println("Agilité du personnage ? Vous pouvez attribuer au maximum " + fmt(pointsAttributs) + " points.");
                personnage.setAgilite(sc.nextInt());
                break;
            } catch (IncorrectCharacteristicsException e) {
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Veuillez entrer un nombre entier !");
                sc.nextLine();
            }
        }
    }
    /**
     * Associe au personnage l'intelligence choisir par le joueur
     * Vérifie que la valeur entrée est cohérente
     */
    private void defIntelligenceAttribute(Personnage personnage) {
        double pointsAttributs = personnage.getNiveau()
                - personnage.getAgilite()
                - personnage.getForce()
                - personnage.getIntelligence();
        while (true) {
            try {
                System.out.println("Intelligence du personnage ? Vous pouvez attribuer au maximum " + fmt(pointsAttributs) + " points.");
                personnage.setIntelligence(sc.nextInt());
                break;
            } catch (IncorrectCharacteristicsException e) {
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Veuillez entrer un nombre entier !");
                sc.nextLine();
            }
        }
    }

    /**
     * Action lancée au tour d'un joueur : choix entre attaque basique ou attaque spéciale
     * @param perso personnage du joueur
     * @param enemy ennemi visé
     */
    private void tour(Personnage perso, Personnage enemy){
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

    /**
     * Lancement du combat ! enchaine les tours des joueurs jusqu'à ce
     * qu'un des personnages soit mort
     * @param perso1 personnage du joueur 1
     * @param perso2 personnage du joueur 2
     */
    public void combat(Personnage perso1, Personnage perso2){
        while (perso1.getVie()>0 && perso2.getVie()>0){
            tour(perso1, perso2);
            if (perso1.getVie()>0 && perso2.getVie()>0) //Si le joueur 1 est mort, le tour est interrompu (joueur 2 ne joue pas)
                tour(perso2, perso1);
        }
    }
}