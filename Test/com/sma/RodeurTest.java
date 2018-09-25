package com.sma;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RodeurTest {
    Joueur joueur = new Joueur(1);
    Personnage rodeur = new Rodeur(40, joueur);
    Joueur otherPlayer = new Joueur(2);
    Personnage enemy = new Guerrier(50, otherPlayer);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        rodeur.setAgilite(15);
        rodeur.setForce(5);
        rodeur.setIntelligence(20);
        enemy.setAgilite(5);
        enemy.setForce(35);
        enemy.setIntelligence(10);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_level40Rodeur_When_gettingInfos_Then_printCorrectString(){
        rodeur.infosPersonnage();
        assertEquals(String.format("Youplaboum ! Je suis le Rôdeur Joueur 1 niveau 40 je possède 200 de vitalité, 5 de force, 15 d'agilité et 20 d'intelligence !%n"), outContent.toString());
    }

    @Test
    public void Given_rodeurAgilite15_When_basicAttack_Then_enemyLose5Vitality(){
        rodeur.basicAttack(enemy);
        assertEquals(235, enemy.getVie());
    }
    @Test
    public void Given_rodeurLevel40_When_SpecialAttack_Then_rodeurGains20Agilite(){
        rodeur.specialAttack(enemy);
        assertEquals(35, rodeur.getAgilite());
    }


}