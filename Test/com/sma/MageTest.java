package com.sma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Joueur joueur = new Joueur(1);
    Personnage mage = new Mage(10, joueur);
    Joueur otherPlayer = new Joueur(2);
    Personnage enemy = new Rodeur(100, otherPlayer);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        mage.setAgilite(8);
        mage.setForce(0);
        mage.setIntelligence(2);
        enemy.setAgilite(50);
        enemy.setForce(30);
        enemy.setIntelligence(20);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_level10Mage_When_gettingInfos_Then_printCorrectString(){
        mage.infosPersonnage();
        assertEquals(String.format("Abracadabra ! Je suis le Mâge Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 8 d'agilité et 2 d'intelligence !%n"), outContent.toString());
    }
    @Test
    public void Given_mageIntelligence2_When_basicAttack_Then_enemyLose2Vitality(){
        mage.basicAttack(enemy);
        assertEquals(498, enemy.getVie());
        assertEquals(String.format("Joueur 1 utilise Boule de Feu et inflige 2 dommages.%n" +
                "Joueur 2 perd 2 points de vie%n"), outContent.toString());
    }
    @Test
    public void Given_mageIntelligence2WhoLost10Vitality_When_SpecialAttack_Then_mageGains4Vitality(){
        mage.setVie(40); //ON considère que le mage a précédemment perdu de la vitalité
        mage.specialAttack(enemy);
        assertEquals(44, mage.getVie());
        assertEquals(String.format("Joueur 1 utilise Soin et gagne 4 en vitalité.%n"), outContent.toString());
    }
    @Test
    public void Given_mageWhoLost1Vitality_When_SpecialAttack_Then_Gains1Vitality(){
        mage.setVie(49); //ON considère que le mage a précédemment perdu de la vitalité
        mage.specialAttack(enemy);
        assertEquals(50, mage.getVie());
        assertEquals(String.format("Joueur 1 utilise Soin et gagne 1 en vitalité.%n"), outContent.toString());
    }

}