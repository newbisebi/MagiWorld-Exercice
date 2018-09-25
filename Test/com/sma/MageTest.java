package com.sma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Joueur joueur = new Joueur(1);
    Mage warrior = new Mage(10, joueur);
    Joueur otherPlayer = new Joueur(2);
    Personnage enemy = new Rodeur(100, otherPlayer);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        warrior.setAgilite(8);
        warrior.setForce(0);
        warrior.setIntelligence(2);
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
        warrior.infosPersonnage();
        assertEquals(String.format("Abracadabra ! Je suis le Mâge Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 8 d'agilité et 2 d'intelligence !%n"), outContent.toString());
    }
}