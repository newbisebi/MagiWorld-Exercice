package com.sma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {
    Joueur joueur = new Joueur(1);
    @Test
    public void Given_incorrectLevel_When_creatingPersonnage_Then_raiseException(){
        assertThrows(IncorrectCharacteristicsException.class, ()-> new Mage(110, joueur));
        assertThrows(IncorrectCharacteristicsException.class, ()-> new Mage(-1, joueur));
    }

    @Test
    public void Given_10asLevel_When_creatingPersonage_Then_vieIs50(){
        Guerrier warrior = new Guerrier(10, joueur);
        assertEquals(50,warrior.getVie());
    }

    @Test
    public void  Given_excedingIntelligence_When_settingCharacteristics_Then_raiseException(){
        Guerrier warrior = new Guerrier(10, joueur);
        warrior.setAgilite(3);
        warrior.setForce(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> warrior.setIntelligence(5));
    }
    @Test
    public void  Given_excedingForce_When_settingCharacteristics_Then_raiseException(){
        Guerrier warrior = new Guerrier(10, joueur);
        warrior.setAgilite(3);
        warrior.setIntelligence(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> warrior.setForce(5));
    }
    @Test
    public void  Given_excedingAgilite_When_settingCharacteristics_Then_raiseException(){
        Rodeur rodeur = new Rodeur(10, joueur);
        rodeur.setIntelligence(3);
        rodeur.setForce(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> rodeur.setAgilite(5));
    }

}