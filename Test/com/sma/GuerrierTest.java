package com.sma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {
    Joueur joueur = new Joueur(2);
    Joueur otherPlayer = new Joueur(1);
    Personnage enemy = new Mage(50, otherPlayer);
    Guerrier warrior = new Guerrier(50, joueur);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        enemy.setAgilite(15);
        enemy.setForce(15);
        enemy.setIntelligence(20);
        warrior.setAgilite(5);
        warrior.setForce(25);
        warrior.setIntelligence(20);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        enemy = new Mage(50, otherPlayer); // On réinitialise les personnages
        warrior = new Guerrier(50, joueur);
    }

    @Test
    public void Given_guerrierLevel50_When_gettingInfos_Then_printCorrectString(){
        warrior.infosPersonnage();
        assertEquals(String.format("GRRROOOOARRRRR ! Je suis le Guerrier Joueur 2 niveau 50 je possède 250 de vitalité, 25 de force, 5 d'agilité et 20 d'intelligence !%n"), outContent.toString());
    }
    @Test
    public void Given_guerrierForce25_When_basicAttack_Then_enemyLose25Vitality(){
        warrior.basicAttack(enemy);
        assertEquals(225, enemy.getVie());
    }
    @Test
    public void Given_guerrierForce25_When_SpecialAttack_Then_guerrierLose_7v5VitalityAndEnemyLose50Vitality(){
        warrior.specialAttack(enemy);
        assertEquals(200, enemy.getVie());
        assertEquals(237.5, warrior.getVie());

    }

}