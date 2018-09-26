package com.sma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Partie {
    Scanner sc = new Scanner(System.in);

    /**
     * Interroge l'utilisateur sur le choix du personnage et de ses caractéristiques
     * @param joueur joueur dont c'est le tour de jouer
     * @return une map avec les différentes caractéristiques et la valeur correspondante
     */
    protected Map<String, Integer> askChoixPersonnage(Joueur joueur){
        Map<String, Integer> params = new HashMap<>();

        System.out.println("Création du personnage du "+joueur.infosJoueur());
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2 : Rodeur, 3 : Mage)");
        params.put("perso",sc.nextInt());

        System.out.println("Niveau du personnage ? ");
        params.put("niveau",sc.nextInt());

        System.out.println("Force du personnage ? ");
        params.put("force",sc.nextInt());

        System.out.println("Agilité du personnage ? ");
        params.put("agilite",sc.nextInt());

        System.out.println("Intelligence du personnage ? ");
        params.put("intelligence",sc.nextInt());

        return params;
    }

    /**
     * Lance la création d'un personnage en fonction des informations rentrées par le joeur
     * @param joueur joueur dont c'est le tour
     * @return un objet de la classe personnage (un mage, un rodeur ou bien un guerrier)
     */
    public Personnage createPersonnage(Joueur joueur){
        // TODO Gérer les exceptions liées aux valeurs des caractéristiques

        Map<String, Integer> params = askChoixPersonnage(joueur);
        Personnage personnage = null;
        switch (params.get("perso")){
            case 1:
                personnage = new Guerrier(params.get("niveau"), joueur);
                break;
            case 2:
                personnage = new Rodeur(params.get("niveau"), joueur);
                break;
            case 3:
                personnage = new Mage(params.get("niveau"), joueur);
                break;
        }
        
        personnage.setForce(params.get("force"));
        personnage.setAgilite(params.get("agilite"));
        personnage.setIntelligence(params.get("intelligence"));

        return personnage;
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