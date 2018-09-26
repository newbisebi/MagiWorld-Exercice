package com.sma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {
    Joueur joueur = new Joueur(1);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_incorrectLevel_When_creatingPersonnage_Then_raiseException(){
        assertThrows(IncorrectCharacteristicsException.class, ()-> new Mage(110, joueur));
        assertThrows(IncorrectCharacteristicsException.class, ()-> new Mage(-1, joueur));
    }

    @Test
    public void Given_10asLevel_When_creatingPersonage_Then_vieIs50(){
        Personnage warrior = new Guerrier(10, joueur);
        assertEquals(50,warrior.getVie());
    }

    @Test
    public void  Given_excedingIntelligence_When_settingCharacteristics_Then_raiseException(){
        Personnage warrior = new Guerrier(10, joueur);
        warrior.setAgilite(3);
        warrior.setForce(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> warrior.setIntelligence(5));
    }
    @Test
    public void  Given_excedingForce_When_settingCharacteristics_Then_raiseException(){
        Personnage warrior = new Guerrier(10, joueur);
        warrior.setAgilite(3);
        warrior.setIntelligence(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> warrior.setForce(5));
    }
    @Test
    public void  Given_excedingAgilite_When_settingCharacteristics_Then_raiseException(){
        Personnage rodeur = new Rodeur(10, joueur);
        rodeur.setIntelligence(3);
        rodeur.setForce(3);
        assertThrows(IncorrectCharacteristicsException.class, ()-> rodeur.setAgilite(5));
    }
    @Test
    public void Given_Personnage_When_ZeroVitality_Then_Dead(){
        Personnage mage = new Mage(50, joueur);
        mage.setVie(0);
        assertEquals(String.format("Joueur 1 est mort%n"),outContent.toString());
    }
    @Test
    public void Given_negativeAbilities_When_settingAbilities_Then_raiseException(){
        Personnage rodeur = new Rodeur(10, joueur);
        assertThrows(IncorrectCharacteristicsException.class, () -> rodeur.setIntelligence(-1));
        assertThrows(IncorrectCharacteristicsException.class, () -> rodeur.setAgilite(-2));
        assertThrows(IncorrectCharacteristicsException.class, () -> rodeur.setForce(-10));
    }

}