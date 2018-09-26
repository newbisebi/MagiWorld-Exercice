package com.sma;

import java.util.HashMap;
import java.util.Map;

import static com.sma.FormatDouble.fmt;

public abstract class Personnage {
    private double niveau;
    private double vie;
    private double force=0;
    private double agilite=0;
    private int intelligence=0;
    private Joueur joueur;
    // TODO ajouter des seuils minimums sur les caractéristiques

    public Personnage(int niveau, Joueur joueur) {
        if (niveau <1 || niveau >100)
            throw new IncorrectCharacteristicsException("Le niveau doit être compris entre 1 et 100");
        else
            this.niveau = niveau;
        this.vie = niveau*5;
        this.joueur = joueur;
    }

    /**
     * Attaque basique créé des dommages à l'adversaire
     */
    public abstract void basicAttack(Personnage enemy);

    /**
     * Attaque spéciale aux effets variés...
     */
    public abstract void specialAttack(Personnage enemy);

    /**
     * Affiche les caractéristiques du personnage et le numéro du joueur
     */
    public abstract void infosPersonnage();



    /**
     * Prépare le message d'information correspondant à chaque personnage
     * Dans chaque classe enfant, on modifie simplement le début pour adapter au type de champion
     * @return message au format string
     */
    public String messagePersonnage (){
        String message = joueur.infosJoueur() + " niveau " +
                fmt(niveau) + " je possède " +
                fmt(vie) + " de vitalité, " +
                fmt(force) +" de force, " +
                fmt(agilite) + " d'agilité et " +
                fmt(intelligence) + " d'intelligence !";
        return message;
    }

    public double getNiveau() {
        return niveau;
    }

    public double getVie() {
        return vie;
    }

    public void setVie(double vie) {
        this.vie = vie;
        if (this.vie <=0)
            System.out.println(this.joueur.infosJoueur() + " est mort");
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        if (force < 0)
            throw new IncorrectCharacteristicsException("Les caractéristiques ne peuvent pas prendre de valeurs négatives");
        else if (this.intelligence + this.agilite + force > this.niveau)
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
        else
            this.force = force;
    }

    public double getAgilite() {
        return agilite;
    }

    public void setAgilite(double agilite) {
        if (agilite < 0)
            throw new IncorrectCharacteristicsException("Les caractéristiques ne peuvent pas prendre de valeurs négatives");
        else if (this.intelligence + this.force + agilite > this.niveau)
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
        else
            this.agilite = agilite;
    }

    /**
     * Méthode spéciale pour le rodeur : il peut modifier son agilité au delà des quotas !
     * C'est son super pouvoir... mais uniquement lorsqu'il utilise une super attaque
     * @param agilite niveau d'agilité
     * @param isRodeurSpecialAttack détermine s'il s'agit bien d'une attaque spéciale. Sinon, le quota doit être respecté
     *                              c'est à dire agilite + force + intelligence <=niveau
     */
    protected void setSpecialAgility(double agilite, boolean isRodeurSpecialAttack){
        if (isRodeurSpecialAttack)
            this.agilite = agilite;
        else
            this.setAgilite(agilite);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence <0)
            throw new IncorrectCharacteristicsException("Les caractéristiques ne peuvent pas prendre de valeurs négatives");
        else if (this.agilite + this.force + intelligence > this.niveau)
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
        else
            this.intelligence = intelligence;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
