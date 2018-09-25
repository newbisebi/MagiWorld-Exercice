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

    public Personnage(int niveau, Joueur joueur) {
        if (niveau <1 || niveau >100)
            throw new IncorrectCharacteristicsException("Le niveau doit être compris entre 1 et 100");
        else
            this.niveau = niveau;
            this.vie = niveau*5;
            this.joueur = joueur;
    }

    /**
     * Renvoie les caractéristique du personnage dans une MAP sous un format que l'on peut
     * utiliser dans une string (sans décimale, format string)
     * @return une map <clé, valeur au format string>
     */
    public Map<String, String> formatCharacteristics (){
        Map<String, String> characteristics = new HashMap<>();
        characteristics.put("niveau", fmt(this.getNiveau()));
        characteristics.put("vie", fmt(this.getVie()));
        characteristics.put("force", fmt(this.getForce()));
        characteristics.put("intelligence", fmt(this.getIntelligence()));
        characteristics.put("agilite", fmt(this.getAgilite()));
        return characteristics;
    }

    public double getNiveau() {
        return niveau;
    }

    public double getVie() {
        return vie;
    }

    public void setVie(double vie) {
        this.vie = vie;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        if (this.agilite + this.intelligence + force <=this.niveau)
            this.force = force;
        else
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
    }

    public double getAgilite() {
        return agilite;
    }

    public void setAgilite(double agilite) {
        if (this.force + this.intelligence + agilite <=this.niveau)
            this.agilite = agilite;
        else
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
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
        if (this.agilite + this.force + intelligence <=this.niveau)
            this.intelligence = intelligence;
        else
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
