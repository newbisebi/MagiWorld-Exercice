package com.sma;

public abstract class Personnage {
    private int niveau;
    private double vie;
    private double force=0;
    private int agilite=0;
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

    public int getNiveau() {
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

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        if (this.force + this.intelligence + agilite <=this.niveau)
            this.agilite = agilite;
        else
            throw new IncorrectCharacteristicsException("Le total de vos points d'abilités ne peut pas excéder votre niveau !");
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
